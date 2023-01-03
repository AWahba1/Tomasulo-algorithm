
public class LoadBuffer {
	
	String name;
	boolean busy=false;
	InstructionType instructionType=InstructionType.LOAD;
	int effectiveAddress;
	int timeRemaining;
    int destinationIndex;
    double destinationValue;
    
    public LoadBuffer(String name)
    {
    	this.name=name;
    }
    
    public static boolean addBuffer(Instruction instruction, LoadBuffer[] loadBuffers, Register[]regFile, int latency)
    {	
    	for (int i=0; i<loadBuffers.length;i++)
		{	
			LoadBuffer loadBuffer=loadBuffers[i];
			if (!loadBuffer.busy)
			{		
				loadBuffer.busy=true;
				loadBuffer.effectiveAddress=instruction.effectiveAddress;
				loadBuffer.destinationIndex=instruction.destination;
				loadBuffer.timeRemaining=latency;
				
				Main.issuedStation=loadBuffer.name;
				
				// set reg file
				regFile[instruction.destination].Q=loadBuffer.name;
				
				return true;
				
			}
		}
    	
    	return false;
    }
    
    public void emptyBuffer()
    {
    	this.busy=false;
    	this.effectiveAddress=0;
    	this.timeRemaining=0;
    	this.destinationIndex=0;
    	this.destinationValue=0;
    }
    
    public String toString()
    {
    	return timeRemaining +" | "+name + " | " +busy+" | "+ effectiveAddress+" | ";
    }

}
