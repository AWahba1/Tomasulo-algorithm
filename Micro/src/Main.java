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

	// Reg File
	static Register[] regFile;
	
	// Memory
	static double [] memory;
	static int memorySize;
	
	// Bus
	static double busValue;
	static String busTag="";
	
	static int clockCycle=1;
	
	// to issue issue & execute in different cycles
	public static String issuedStation=null;
	
	// for tracing purposes
	static Queue<String>instructionsAssembly;
	static String issuedInstruction=null;
	static Queue<String>logs;
	
	public static void fillInstructionQueue() throws FileNotFoundException
	{
		File prog = new File("code.txt");
		Scanner reader = new Scanner(prog);
		instructionQueue=new LinkedList<Instruction>();
		instructionsAssembly=new LinkedList<String>();
		
		while (reader.hasNextLine()) {
			String instruction = reader.nextLine();
			instructionsAssembly.add(instruction);
			String instrType=instruction.split(" ")[0];
			String operandsString=instruction.substring(instrType.length());
			operandsString=operandsString.replaceAll("\s", "");
			

			//String[] instArray = instruction.split(" ");
			//String [] operands=instArray[1].trim().split(","); // 3 law ALU, 2 law Store aw load
			String []operands=operandsString.split(",");
			for (int i=0 ;i<operands.length;i++)
				operands[i]=operands[i].trim();
			
			
			Instruction instr=null;
			switch(instrType)
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
		
		if (isIssued) {
			instructionQueue.poll();
			issuedInstruction=instructionsAssembly.poll();
			
		};
			
}
	
	public static void ExecuteALUInstruction(ReservationStation[] reservationStations)
	{	
	
		for (int i=0; i<reservationStations.length;i++)
		{	
			// execute add stations
			ReservationStation reservationStation=reservationStations[i];
			if (reservationStation.busy )
			{	
				// get values available in the bus
				if (reservationStation.Qj==busTag )
				{
					reservationStation.Qj=null;
					reservationStation.Vj=busValue;
				}
				if (reservationStation.Qk==busTag )
				{
					reservationStation.Qk=null;
					reservationStation.Vk=busValue;
					
				}
				
				// if both operands are ready
				if (reservationStation.Qj==null && reservationStation.Qk==null && reservationStation.name!=issuedStation)
				{
					int timeRemaining=reservationStation.timeRemaining;
					
					if (timeRemaining==1)
					{
						reservationStation.destinationValue=getExecutionResult(reservationStation);
						reservationStation.timeRemaining--;
						logs.add("Station "+reservationStation.name +" finished execution and output is "+reservationStation.destinationValue);
					}
					else if (timeRemaining>1) // timeRem >1
					{	
						reservationStation.timeRemaining--;
						logs.add("Station "+reservationStation.name +" is currently executing");
					}
					else {
						reservationStation.timeRemaining--;
						//logs.add("Station "+reservationStation.name +" is waiting for write back");
					}
				}
			} // end if

		}
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
						if (timeRemaining==1)
						{	
							loadBuffer.destinationValue=memory[loadBuffer.effectiveAddress];
							loadBuffer.timeRemaining--;
							logs.add("Buffer "+loadBuffer.name +" finished execution and output is "+loadBuffer.destinationValue);	
						}
						else if (timeRemaining>1) // timeRem >1
						{
							loadBuffer.timeRemaining--;
							logs.add("Buffer "+loadBuffer.name +" is currently executing");

						}
						else
						{
							loadBuffer.timeRemaining--;
							//logs.add("Buffer "+loadBuffer.name +" is waiting for write back");
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
				}
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
							storeBuffer.emptyBuffer();
							logs.add("Buffer "+storeBuffer.name+" is now emptied out");

						}
						if (timeRemaining==1)
						{	
							memory[storeBuffer.effectiveAddress]=storeBuffer.V;
							storeBuffer.timeRemaining--;
							logs.add("Buffer "+storeBuffer.name +" finished execution and has saved in the memory location "+storeBuffer.effectiveAddress+" value= "+storeBuffer.V);

						}
						else if (timeRemaining>1) // timeRem >1
						{
							storeBuffer.timeRemaining--;
							logs.add("Buffer "+storeBuffer.name +" is currently executing");
						}
//						else
//						{
//							storeBuffer.emptyBuffer();
//						}
				} 
			}// end if
			
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
		// Assuming a random approach if 2 or more write back in the same cycle
		
		ReservationStation stationToWB=null;
		LoadBuffer bufferToWB=null;
		int minArrivalTime=Integer.MAX_VALUE;
		// write back reservation stations
		for (int i=0; i<addReservationStations.length;i++)
		{	
			// execute add stations
			ReservationStation reservationStation=addReservationStations[i];
			if (reservationStation.busy && reservationStation.timeRemaining<0 && reservationStation.arrivalTime<minArrivalTime)
			{	
				minArrivalTime=reservationStation.arrivalTime;
				stationToWB=reservationStation;

			} // end if

		}
		
		// write back MUL reservation stations
		for (int i=0; i<mulReservationStations.length;i++)
		{	
			// execute add stations
			ReservationStation reservationStation=mulReservationStations[i];
			if (reservationStation.busy && reservationStation.timeRemaining<0 && reservationStation.arrivalTime<minArrivalTime)
			{	
				minArrivalTime=reservationStation.arrivalTime;
				stationToWB=reservationStation;

			} // end if

		}
		
		// write back load buffers
		for (int i=0; i<loadBuffers.length;i++)
		{		
			
			// execute add stations
			LoadBuffer loadBuffer=loadBuffers[i];
			if (loadBuffer.busy && loadBuffer.timeRemaining<0 && loadBuffer.arrivalTime<minArrivalTime)
			{	
				minArrivalTime=loadBuffer.arrivalTime;
				bufferToWB=loadBuffer;
				

			} // end if

		}
		
		if (bufferToWB!=null && bufferToWB.arrivalTime==minArrivalTime)
		{
			busValue=bufferToWB.destinationValue;
			busTag=bufferToWB.name;
			if (regFile[bufferToWB.destinationIndex].Q==busTag)
			{
				regFile[bufferToWB.destinationIndex].value=busValue;
				regFile[bufferToWB.destinationIndex].Q=null;
				
			}
			bufferToWB.emptyBuffer();
			logs.add("Load Buffer "+bufferToWB.name+" has written "+busValue+" on the bus and is emptied out");
		}
		else if(stationToWB!=null && stationToWB.arrivalTime==minArrivalTime)
		{
			busValue=stationToWB.destinationValue;
			busTag=stationToWB.name;
			if (regFile[stationToWB.destinationIndex].Q==busTag)
			{
				regFile[stationToWB.destinationIndex].value=busValue;
				regFile[stationToWB.destinationIndex].Q=null;
			}
			stationToWB.emptyReservationStation();
			logs.add("Station "+stationToWB.name+" has written "+busValue+" on the bus and is emptied out");
		}
		
		updateStations();
		
		
			
	}
	
	
	public static void updateStations()
	{	
		// update add stations
		for (int i=0; i<addReservationStations.length;i++)
		{	
			ReservationStation reservationStation=addReservationStations[i];
			if (reservationStation.busy )
			{	
				// get values available in the bus
				if (reservationStation.Qj==busTag )
				{
					reservationStation.Qj=null;
					reservationStation.Vj=busValue;
				}
				if (reservationStation.Qk==busTag )
				{
					reservationStation.Qk=null;
					reservationStation.Vk=busValue;
					
				}
			}
	}
		
		// update mul stations
				for (int i=0; i<mulReservationStations.length;i++)
				{	
					ReservationStation reservationStation=mulReservationStations[i];
					if (reservationStation.busy )
					{	
						// get values available in the bus
						if (reservationStation.Qj==busTag )
						{
							reservationStation.Qj=null;
							reservationStation.Vj=busValue;
						}
						if (reservationStation.Qk==busTag )
						{
							reservationStation.Qk=null;
							reservationStation.Vk=busValue;
							
						}
					}
			}
				//update store
				for (int i=0; i<storeBuffers.length;i++)
				{
					StoreBuffer storeBuffer=storeBuffers[i];
					if (storeBuffer.busy)
					{
						// get values available in the bus
						if (storeBuffer.Q==busTag)
						{
							storeBuffer.Q=null;
							storeBuffer.V=busValue;
						}
						if (storeBuffer.Q==busTag)
						{
							storeBuffer.Q=null;
							storeBuffer.V=busValue;
						}
					}
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
		
		System.out.println("Enter latency ADD: ");
		latencyADD=s.nextInt();
		System.out.println("Enter latency SUB: ");
		latencySUB=s.nextInt();
		System.out.println("Enter latency MUL: ");
		latencyMUL=s.nextInt();
		System.out.println("Enter latency DIV: ");
		latencyDIV=s.nextInt();
		System.out.println("Enter latency LOAD: ");
		latencyLOAD=s.nextInt();
		System.out.println("Enter latency STORE: ");
		latencySTORE=s.nextInt();
		
		System.out.println("Enter Number of ADD Reservation Stations");
		addReservationSize=s.nextInt();
		System.out.println("Enter Number of MUL Reservation Stations");
		mulReservationSize=s.nextInt();
		System.out.println("Enter Number of LOAD Buffers");
		loadBufferSize=s.nextInt();
		System.out.println("Enter Number of Store Buffers");
		storeBufferSize=s.nextInt();
		
		System.out.println("Enter Memory Size");
		memorySize=s.nextInt();
		
//		latencyADD=3;
//		latencySUB=3;
//		latencyMUL=4;
//		latencyDIV=5;
//		latencyLOAD=5;
//		latencySTORE=1;
		
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
		memory=new double[memorySize];
		for (int i=0; i<memory.length;i++)
			memory[i]=i;
		
		
		//memory[100]=15;
		
		
		while (!isFinished())
		{	
			logs=new LinkedList<>();
			
			System.out.println("Clock Cycle "+clockCycle);
			System.out.println("------------------------------------");
			System.out.println("------------------------------------");
			System.out.println();
			
			issuedStation=null; // to allow execution in different cycle than issue
			issuedInstruction=null; // for tracing only
			IssueInstruction();
			
			ExecuteALUInstruction(addReservationStations);
			ExecuteALUInstruction(mulReservationStations);
			ExecuteLoadInstruction(loadBuffers);
			ExecuteStoreInstruction(storeBuffers);
			
			WriteBack();

			//tracing
			
			System.out.println("Instruction Queue");
			System.out.println("------------------------------------");
			System.out.println(instructionsAssembly);
			System.out.println(issuedInstruction!=null?issuedInstruction +" is issued at station/buffer "+issuedStation :"No instructions issued in this cycle");
			System.out.println();
			
			System.out.println("Add Reservation Station");
			System.out.println("------------------------------------");
			System.out.println("Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk");
			for (ReservationStation station:addReservationStations)
				System.out.println(station);
			System.out.println();
			
			System.out.println("MUL Reservation Station");
			System.out.println("------------------------------------");
			System.out.println("Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk");
			for (ReservationStation station:mulReservationStations)
				System.out.println(station);
			
			System.out.println();
			
			System.out.println("Load Buffers");
			System.out.println("------------------------------------");
			System.out.println("Time| name | Busy  | effectiveAddress");
			for (LoadBuffer buffer:loadBuffers)
				System.out.println(buffer);		
			System.out.println();
			
			System.out.println("Store Buffers");
			System.out.println("------------------------------------");
			System.out.println("Time| name | Busy  |  V  |  Q   | effectiveAddress");
			for (StoreBuffer buffer:storeBuffers)
				System.out.println(buffer);
			System.out.println();
			
			System.out.println("Register File");
			System.out.println("------------------------------------");
			System.out.println(Arrays.toString(regFile));			
			System.out.println();
			
			//System.out.println(memory[50]);
			
			System.out.println("Logs");
			System.out.println("------------------------------------");
			for (String log:logs)
			{
				System.out.println(log);
			}
			System.out.println();
			
			
			clockCycle++;
		}
		
		
		
	}
	
}
