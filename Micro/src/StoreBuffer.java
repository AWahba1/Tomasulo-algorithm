
public class StoreBuffer {
	
	String name;
	boolean busy=false;
	InstructionType instructionType=InstructionType.STORE;
	int effectiveAddress;
	int timeRemaining;
    double V;
    String Q=null;
    
    public StoreBuffer(String name)
    {
    	this.name=name;
    }
    
    public static boolean addBuffer(Instruction instruction, StoreBuffer[] storeBuffers, Register[]regFile, int latency)
    {	
    	for (int i=0; i<storeBuffers.length;i++)
		{	
			StoreBuffer storeBuffer=storeBuffers[i];
			if (!storeBuffer.busy)
			{		
				storeBuffer.busy=true;
				storeBuffer.effectiveAddress=instruction.effectiveAddress;
				storeBuffer.timeRemaining=latency;
				
				Main.issuedStation=storeBuffer.name;
				
				int source1Index=instruction.source1;
				
				storeBuffer.V=regFile[source1Index].Q==null?regFile[source1Index].value:0;
				storeBuffer.Q=regFile[source1Index].Q==null?null:regFile[source1Index].Q;
				
				
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
    	this.V=0;
    	this.Q=null;
    }
    
    public String toString()
    {
    	return timeRemaining +" | "+name + " | " + " | "+busy+" | "+ V+" | "+ Q+" | "+ effectiveAddress+" | ";
    }
}
