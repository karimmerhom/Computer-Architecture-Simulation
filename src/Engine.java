import java.util.ArrayList;


public class Engine {
	
	public static String to16Bits(String old){
		
		String thirtyTwoBit = old;
		for(int n=thirtyTwoBit.length(); n<16; n++) {
				thirtyTwoBit = "0" + thirtyTwoBit;
			
		}
		return thirtyTwoBit.substring(thirtyTwoBit.length()-16,thirtyTwoBit.length());
	}
	
	public static String to32Bits(String old){
		
		String thirtyTwoBit = old;
		for(int n=thirtyTwoBit.length(); n<32; n++) {
			if(thirtyTwoBit.substring(0,1).equals("0")){
				thirtyTwoBit = "0" + thirtyTwoBit;
			}else{
				thirtyTwoBit = "1" + thirtyTwoBit;
			}
		}
		return thirtyTwoBit;
	}
	
	public static void main(String[]Args){
		

		ArrayList<String> instructions = new ArrayList<String>();

		// add
		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(10));
		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(5));
		instructions.add("0000001100100001");

//		sub
		RegisterFile.arrRegister[4] = to16Bits(Integer.toBinaryString(-2));
		RegisterFile.arrRegister[5] = to16Bits(Integer.toBinaryString(10));
		instructions.add("0001011001000101");

//		mult
		RegisterFile.arrRegister[4] = to16Bits(Integer.toBinaryString(-2));
		RegisterFile.arrRegister[5] = to16Bits(Integer.toBinaryString(10));
		instructions.add("0010011001000101");
		
		// jump
		instructions.add("1111000000000011");
//		or
		RegisterFile.arrRegister[4] = "0000000000000000";
		RegisterFile.arrRegister[5] = "1010101010101010";
		instructions.add("0011011001000101");

//		addi
		RegisterFile.arrRegister[6] = to16Bits(Integer.toBinaryString(10));
		instructions.add("0100011000000101");

//		andi
		RegisterFile.arrRegister[6] = "0101010101010101";
		instructions.add("0101011011111111");

//		SLL
		RegisterFile.arrRegister[6] = "0000000000000001";
		instructions.add("0110011000000011");

//		SLR
		RegisterFile.arrRegister[6] = "0000000000100000";
		instructions.add("0111011000000011");

		// load
		DataMemory.dataList[4] = "1111";
		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(1));
		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(3));
		instructions.add("1101001100010010");

//		//store
		RegisterFile.arrRegister[6] = to16Bits(Integer.toBinaryString(20));
		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(1));
		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(3));
		instructions.add("1100001100010010");

		// beq
		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(5));
		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(20));
		RegisterFile.arrRegister[3] = to16Bits(Integer.toBinaryString(20));
		instructions.add("1010000100100011");

		// BLT
		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(5));
		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(1));
		RegisterFile.arrRegister[3] = to16Bits(Integer.toBinaryString(2));
		instructions.add("1011000100100011");

		// jump
		instructions.add("1111000000000011");

		// error instruction
//		instructions.add("10101000000000000000000000000001");

		InstructionMemory.loadInstructions(instructions); // this method runs the data path (loads and executes all
															// instructions)
		InstructionMemory.begin();

	}

}
