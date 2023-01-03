import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {
	
	static Queue<Instruction> instructionQueue;
	static int latencyADD, latencySUB, latencyMUL, latencyDIV, latencyLOAD, latencySTORE;
	// Stations & Buffers
	static ReservationStation[] addReservationStations, mulReservationStations;
	static LoadBuffer[] loadBuffers;
	static StoreBuffer[] storeBuffers;
	static int addReservationSize=3, mulReservationSize=2,loadBufferSize=2, storeBufferSize=2;
	//static Queue<String> finishedStations;
	
	// Reg File
	static Register[] regFile;
	
	// Memory
	static double [] memory;
	
	// Bus
	static double busValue;
	static String busTag="";
	
	static int clockCycle=1;
	
	public static String issuedStation=null;
	
	public static void fillInstructionQueue() throws FileNotFoundException
	{
		File prog = new File("code.txt");
		Scanner reader = new Scanner(prog);
		instructionQueue=new LinkedList<Instruction>();
		
		while (reader.hasNextLine()) {
			String instruction = reader.nextLine();
			String[] instArray = instruction.trim().split(" ");
			String [] operands=instArray[1].split(","); // 3 law ALU, 2 law Store aw load
			
			for (int i=0 ;i<operands.length;i++)
				operands[i]=operands[i].trim();
			
			
			Instruction instr=null;
			switch(instArray[0])
			{
			case "ADD.D":instr=new Instruction(InstructionType.ADD,Integer.parseInt(operands[0].substring(1)), Integer.parseInt(operands[1].substring(1)),
					Integer.parseInt(operands[2].substring(1)), 0); break;
			
			case "SUB.D":instr=new Instruction(InstructionType.SUB,Integer.parseInt(operands[0].substring(1)), Integer.parseInt(operands[1].substring(1)),
					Integer.parseInt(operands[2].substring(1)), 0);break;
			
			case "MUL.D":instr=new Instruction(InstructionType.MUL,Integer.parseInt(operands[0].substring(1)), Integer.parseInt(operands[1].substring(1)),
					Integer.parseInt(operands[2].substring(1)), 0);break;
			
			case "DIV.D":instr=new Instruction(InstructionType.DIV,Integer.parseInt(operands[0].substring(1)), Integer.parseInt(operands[1].substring(1)),
					Integer.parseInt(operands[2].substring(1)), 0);break;
			
			case "L.D":instr=new Instruction(InstructionType.LOAD,Integer.parseInt(operands[0].substring(1)),0,
					0, Integer.parseInt(operands[1]));break;
			
			case "S.D":instr=new Instruction(InstructionType.STORE,0,Integer.parseInt(operands[0].substring(1)),
					0, Integer.parseInt(operands[1]));break;
			
			}
			
			instructionQueue.add(instr);
			//System.out.println(instructionQueue.size());
				
		}
	}

	public static void IssueInstruction()
	{	
		if (instructionQueue.isEmpty()) return;
		Instruction instruction=instructionQueue.peek();
		
		InstructionType instructionType=instruction.type;
		boolean isIssued=false;
		switch(instructionType)
		{
		case ADD:
		{	
			isIssued|=ReservationStation.addStation(instruction,addReservationStations,regFile, latencyADD);
			
//			System.out.println(Arrays.toString(addReservationStations));
			break;
		}
		case SUB:{
			isIssued|=ReservationStation.addStation(instruction,addReservationStations,regFile, latencySUB);
			break;
		}
		
		case MUL:
		{	
			isIssued|=ReservationStation.addStation(instruction,mulReservationStations,regFile, latencyMUL);
			break;
		}
		case DIV :{
			isIssued|=ReservationStation.addStation(instruction,mulReservationStations,regFile, latencyDIV);
			break;
		}
			
		case LOAD:{
			isIssued|=LoadBuffer.addBuffer(instruction, loadBuffers, regFile, latencyLOAD);
			break;
		}
		
		case STORE:{
			isIssued|=StoreBuffer.addBuffer(instruction, storeBuffers, regFile, latencySTORE);
			break;
		}
	}
		
		if (isIssued) instructionQueue.poll();
			
}
	
	public static void ExecuteALUInstruction(ReservationStation[] reservationStations)
	{	
		
//		System.out.println("Da5el 3al execute "+reservationStations[0]);
//		System.out.println("Reservation size "+reservationStations.length);
		for (int i=0; i<reservationStations.length;i++)
		{	
			// execute add stations
			ReservationStation reservationStation=reservationStations[i];
//			System.out.println("Reservation size "+reservationStations.busy);
			if (reservationStation.busy )
			{	
				// get values available in the bus
				if (reservationStation.Qj==busTag)
				{
					reservationStation.Qj=null;
					reservationStation.Vj=busValue;
				}
				if (reservationStation.Qk==busTag)
				{
					reservationStation.Qk=null;
					reservationStation.Vk=busValue;
				}
				
//				System.out.println("Qj "+reservationStation.Qj+" Qk "+reservationStation.Qk);
				// if both operands are ready
				if (reservationStation.Qj==null && reservationStation.Qk==null && reservationStation.name!=issuedStation )
				{
					int timeRemaining=reservationStation.timeRemaining;
					if (timeRemaining==0)
					{
						reservationStation.destinationValue=getExecutionResult(reservationStation);
						reservationStation.timeRemaining--;
						
//						finishedStations.add(reservationStation.name);
						
						//System.out.println("Inside Exercise");
						//System.out.println(Arrays.toString(reservationStations));

					}
					else // timeRem >1
					{	
//						System.out.println("Time Remaining before "+reservationStation.timeRemaining);
						reservationStation.timeRemaining--;
//						System.out.println("Time Remaining After "+reservationStation.timeRemaining);
					}
				}
			} // end if

		}
//		System.out.println("5areg men execute "+reservationStations[0]);
	}
		

	
	public static void ExecuteLoadInstruction(LoadBuffer[] loadBuffers)
	{
		for (int i=0; i<loadBuffers.length;i++)
		{	
			// execute add stations
			LoadBuffer loadBuffer=loadBuffers[i];
			if (loadBuffer.busy)
			{	
				// if both operands are ready
					if (loadBuffer.name!=issuedStation)
					{
						int timeRemaining=loadBuffer.timeRemaining;
						if (timeRemaining==0)
						{	
							loadBuffer.destinationValue=memory[loadBuffer.destinationIndex];
							loadBuffer.timeRemaining--;
							
//							finishedStations.add(loadBuffer.name);
						}
						else // timeRem >1
						{
							loadBuffer.timeRemaining--;
						}
					}
			} // end if

		}
	}
	
	public static void ExecuteStoreInstruction(StoreBuffer[] storeBuffers)
	{
		for (int i=0; i<storeBuffers.length;i++)
		{	
			// execute add stations
			StoreBuffer storeBuffer=storeBuffers[i];
			if (storeBuffer.busy)
			{	
				// get values available in the bus
				if (storeBuffer.Q==busTag)
				{
					storeBuffer.Q=null;
					storeBuffer.V=busValue;
				
				if (storeBuffer.Q==busTag)
				{
					storeBuffer.Q=null;
					storeBuffer.V=busValue;
				}
				
				if (storeBuffer.Q==null && storeBuffer.name!=issuedStation)
				{
					// if both operands are ready
						int timeRemaining=storeBuffer.timeRemaining;
						if (timeRemaining==0)
						{	
							memory[storeBuffer.effectiveAddress]=storeBuffer.V;
							storeBuffer.timeRemaining--;
							
//							finishedStations.add(storeBuffer.name);
						}
						else // timeRem >1
						{
							storeBuffer.timeRemaining--;
						}
				} 
			}// end if
			
			}
		}
	}
	
	public static double getExecutionResult(ReservationStation reservationStation)
	{	
		double executionResult=0;
		double source1=reservationStation.Vj;
		double source2=reservationStation.Vk;

		switch(reservationStation.instructionType)
		{
			case ADD: executionResult=source1+source2;break;
			case SUB: executionResult=source1-source2;break;
			case MUL: executionResult=source1*source2;break;
			case DIV: executionResult=source1/source2;break;
			
		}
		
		return executionResult;
	}
	
	public static void WriteBack()
	{	
		// Assuming a random approach if 2 or more write back in the same cycle\
		
		// write back reservation stations
		for (int i=0; i<addReservationStations.length;i++)
		{	
			// execute add stations
			ReservationStation reservationStation=addReservationStations[i];
			if (reservationStation.busy && reservationStation.timeRemaining<0 )
			{	
				busValue=reservationStation.destinationValue;
				busTag=reservationStation.name;
				if (regFile[reservationStation.destinationIndex].Q==busTag)
				{
					regFile[reservationStation.destinationIndex].value=busValue;
					regFile[reservationStation.destinationIndex].Q=null;
				}
				reservationStation.emptyReservationStation();
				return;

			} // end if

		}
		
		// write back MUL reservation stations
		for (int i=0; i<mulReservationStations.length;i++)
		{	
			// execute add stations
			ReservationStation reservationStation=mulReservationStations[i];
			if (reservationStation.busy && reservationStation.timeRemaining<0)
			{	
				busValue=reservationStation.destinationValue;
				busTag=reservationStation.name;
				if (regFile[reservationStation.destinationIndex].Q==busTag)
				{
					regFile[reservationStation.destinationIndex].value=busValue;
					regFile[reservationStation.destinationIndex].Q=null;
				}
				reservationStation.emptyReservationStation();
				return;

			} // end if

		}
		
		// write back load buffers
		for (int i=0; i<loadBuffers.length;i++)
		{	
			// execute add stations
			LoadBuffer loadBuffer=loadBuffers[i];
			if (loadBuffer.busy && loadBuffer.timeRemaining<0)
			{	
				busValue=loadBuffer.destinationValue;
				busTag=loadBuffer.name;
				if (regFile[loadBuffer.destinationIndex].Q==busTag)
				{
					regFile[loadBuffer.destinationIndex].value=busValue;
					regFile[loadBuffer.destinationIndex].Q=null;
				}
				loadBuffer.emptyBuffer();
				return;

			} // end if

		}
			
	}
	
	
	public static boolean isFinished()
	{
		boolean isStillRemaining=false;
		for (int i=0; i<addReservationStations.length;i++)
			isStillRemaining|=addReservationStations[i].busy;
		
		for (int i=0; i<mulReservationStations.length;i++)
			isStillRemaining|=mulReservationStations[i].busy;
		
		for (int i=0; i<loadBuffers.length;i++)
			isStillRemaining|=loadBuffers[i].busy;
		
		for (int i=0; i<storeBuffers.length;i++)
			isStillRemaining|=storeBuffers[i].busy;
		
		return !isStillRemaining && instructionQueue.isEmpty();
	}

	
	public static void main (String[]args) throws FileNotFoundException
	{	
		Scanner s=new Scanner(System.in);
		fillInstructionQueue();
		
		
		
//		System.out.println("Enter latency ADD: ");
//		latencyADD=s.nextInt();
//		System.out.println("Enter latency SUB: ");
//		latencySUB=s.nextInt();
//		System.out.println("Enter latency MUL: ");
//		latencyMUL=s.nextInt();
//		System.out.println("Enter latency DIV: ");
//		latencyDIV=s.nextInt();
//		System.out.println("Enter latency LOAD: ");
//		latencyLOAD=s.nextInt();
//		System.out.println("Enter latency STORE: ");
//		latencySTORE=s.nextInt();
		
		latencyADD=3;
		latencySUB=3;
		latencyMUL=4;
		latencyDIV=5;
		latencyLOAD=5;
		latencySTORE=6;
		
		//initializing reservation stations & buffers
		addReservationStations=new ReservationStation[addReservationSize];
		mulReservationStations=new ReservationStation[mulReservationSize];
		loadBuffers=new LoadBuffer[loadBufferSize];
		storeBuffers=new StoreBuffer[storeBufferSize];
		
		for (int i=0; i<addReservationSize;i++)
			addReservationStations[i]=new ReservationStation("A"+i);
		for (int i=0; i<mulReservationSize;i++)
			mulReservationStations[i]=new ReservationStation("M"+i);
		for (int i=0; i<loadBufferSize;i++)
			loadBuffers[i]=new LoadBuffer("L"+i);
		for (int i=0; i<loadBufferSize;i++)
			storeBuffers[i]=new StoreBuffer("S"+i);
		
		// Initializing register file
		regFile=new Register[32];
		for (int i=0; i<32;i++)
			regFile[i]=new Register("F"+i,i);
		
		// Memory
		memory=new double[10000];
		
		
		while (!isFinished())
		{	
			System.out.println("Clock Cycle "+clockCycle);
			System.out.println("------------------------------------");
			
			issuedStation=null;
			IssueInstruction();
			
			ExecuteALUInstruction(addReservationStations);
			ExecuteALUInstruction(mulReservationStations);
			ExecuteLoadInstruction(loadBuffers);
			ExecuteStoreInstruction(storeBuffers);
			
			WriteBack();

			//tracing
			
			System.out.println("Add Reservation Station");
			System.out.println("------------------------------------");
			System.out.println("Time Remaining | name | Type | Busy | Vj | Vk | Qj | Qk");
			for (ReservationStation station:addReservationStations)
				System.out.println(station);
			
			System.out.println("MUL Reservation Station");
			System.out.println("------------------------------------");
			System.out.println("Time Remaining | name | Type | Busy | Vj | Vk | Qj | Qk");
			for (ReservationStation station:mulReservationStations)
				System.out.println(station);
			
			System.out.println("Load Buffers");
			System.out.println("------------------------------------");
			System.out.println("Time Remaining | name | busy | effectiveAddress");
			for (LoadBuffer buffer:loadBuffers)
				System.out.println(buffer);
			
			System.out.println("Store Buffers");
			System.out.println("------------------------------------");
			System.out.println("Time Remaining | name | busy | V| Q | effectiveAddress");
			for (StoreBuffer buffer:storeBuffers)
				System.out.println(buffer);
			
			System.out.println("Register File");
			System.out.println("------------------------------------");
			System.out.println(Arrays.toString(regFile));
			
			
			
			clockCycle++;
		}
		
		
		
	}
	
}
