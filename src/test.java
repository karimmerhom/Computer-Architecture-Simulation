
public class test {
	public static void main(String [] args){
		String instruction = "10000000001";
		String x =ExecuteClass.srl(instruction,3);

		System.out.println(instruction.substring(0,1).equals("1"));
		System.out.println(Engine.to32Bits(Engine.to16Bits(Integer.toBinaryString(2))));
		
	}

}
