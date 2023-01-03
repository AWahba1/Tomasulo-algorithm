
public class Register {
	String name;
	double value;
	String Q=null;

	public Register(String name, int value)
	{
		this.name=name;
		this.value=value;
	}
	
	public String toString()
	{
		return "("+name+"= "+value+", "+Q+")";
	}
}
