
public class Instruction {
	
	InstructionType type;
//	int arrivalTime;
	int source1;
	int source2;
	int destination;
	int effectiveAddress;
	
	
	
	public Instruction(InstructionType type, int destination, int source1, int source2, int effectiveAddress)
	{
		this.destination=destination;
		this.source1=source1;
		this.source2=source2;
		this.effectiveAddress=effectiveAddress;
		this.type=type;
	}
	
	public String toString()
	{
		return "Destination: "+this.destination+"\n"+
				"Type: "+this.type+"\n"+
				"Source 1: "+ this.source1+"\n"+
				"Source 2: "+ this.source2+"\n"+
				"Effective Address: "+ this.effectiveAddress+"\n";
	}

}
