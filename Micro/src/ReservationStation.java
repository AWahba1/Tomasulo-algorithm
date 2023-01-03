
public class ReservationStation {
	String name;
	boolean busy=false;
	InstructionType instructionType=null;
	double Vj;
	double Vk;
	String Qj=null;
	String Qk=null;
	double A;
	int timeRemaining;
    int destinationIndex;
    double destinationValue;
    int arrivalTime;
    
    public ReservationStation(String name)
    {
    	this.name=name;
    }
    
    public static boolean addStation(Instruction instruction, ReservationStation[] reservationStations, Register[]regFile, int latency)
    {	
    	for (int i=0; i<reservationStations.length;i++)
		{	
			ReservationStation adderStation=reservationStations[i];
			if (!adderStation.busy )
			{		
				adderStation.busy=true;
				adderStation.instructionType=instruction.type;
				adderStation.destinationIndex=instruction.destination;
				adderStation.timeRemaining=latency;
				adderStation.arrivalTime=Main.clockCycle;
				
				Main.issuedStation=adderStation.name;
				
				int source1Index=instruction.source1;
				int source2Index=instruction.source2;
				int destinationIndex=instruction.destination;
//				System.out.println("Source1 "+source1Index+" Source2 "+source2Index);
				
				adderStation.Vj=regFile[source1Index].Q==null?regFile[source1Index].value:0;
				adderStation.Qj=regFile[source1Index].Q==null?null:regFile[source1Index].Q;
				
				adderStation.Vk=regFile[source2Index].Q==null?regFile[source2Index].value:0;
				adderStation.Qk=regFile[source2Index].Q==null?null:regFile[source2Index].Q;
					
//				System.out.println("Source 1 "+regFile[source1Index].Q);
//				System.out.println("Source1 value "+regFile[source1Index].Vj+" Source2 value "+regFile[source2Index].Q);
//				System.out.println("Vj "+adderStation.Vj+" Qj "+adderStation.Qj);
//				System.out.println("Vk "+adderStation.Vk+" Qk "+adderStation.Qk);
				
				// set reg file
				regFile[destinationIndex].Q=adderStation.name;
				
				return true;
				
			}
		}
    	
    	return false;
    }
    
    public void emptyReservationStation()
	{
		this.busy=false;
		this.instructionType=null;
		this.Vj=0;
		this.Vk=0;
		this.Qj=null;
		this.Qk=null;
		this.timeRemaining=0;
		this.destinationIndex=0;
		this.destinationValue=0;
		this.arrivalTime=0;
	}

    public String toString()
    {	
    	String extraSpace=this.busy?" ":"";
    	return timeRemaining +"   |  "+name + "  | " + instructionType +extraSpace+ " | "+busy+extraSpace+" | "+ Vj+" | "+Vk+" | "+Qj+" | "+Qk+" | ";
    }
}
