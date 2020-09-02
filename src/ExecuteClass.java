
import java.util.Scanner;

public class ExecuteClass {
	static boolean controlRegDst;
	static boolean controlBranch;
	static boolean controlMemRead;
	static boolean controlMemtoReg;
	static boolean controlJump;
	static boolean controlMemWrite;
	static boolean controlALUSrc;
	static boolean controlRegWrite;

	static String opCode;
	static String readRegister1;
	static String readRegister2;
	static String writeRegister;

	static boolean useALU;
	static boolean useMem;
	static boolean useWB;

	static String signExtend;
	static String readData1;
	static String readData2;
	static String readData3;

	static String ALUOP;
	static String Operand1;
	static String Operand2;
	static String Op;

	static boolean ALUZero;
	static String ALUresult;

	public static String Execute() {

		Op = opCode;

		Operand1 = readData1;

		if (controlALUSrc) {
			Operand1 = readData3;
			Operand2 = signExtend;

		} else {
			Operand2 = readData2;
		}

		System.out.println();
		System.out.println("---------------------Begin ALU operation (Execute)---------------------");
		System.out.println("Input");
		System.out.println("1st Operand: " + Operand1);
		System.out.println("2nd Operand: " + Operand2);
		System.out.println("Operation: " + Op);
		System.out.println();

		System.out.println("ALUresult");
		int Operand1Int = (int) Long.parseLong(Engine.to32Bits(Operand1), 2);
		int Operand2Int = (int) Long.parseLong(Engine.to32Bits(Operand2), 2);
		int ALUresultInt;

		switch (Op) {
		case "0010":
			System.out.println("Operation Name: MULT");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));
			ALUresultInt = Operand1Int * Operand2Int;

			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));
			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));

			if (ALUresultInt == 0) {
				ALUZero = true;
				System.out.println("Z-Flag Value: " + ALUZero);
			} else {
				ALUZero = false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}
			// code block
			break;
		case "0011":
			System.out.println("Operation Name: OR");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));

			ALUresultInt = Operand1Int | Operand2Int;

			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));
			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));

			if (ALUresultInt == 0) {
				ALUZero = true;
				System.out.println("Z-Flag Value: " + ALUZero);
			} else {
				ALUZero = false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;
		case "0000":
			System.out.println("Operation Name: add");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));
			ALUresultInt = Operand1Int + Operand2Int;
			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));
			if (ALUresultInt == 0) {
				ALUZero = true;
				System.out.println("Z-Flag Value: " + ALUZero);
			} else {
				ALUZero = false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;
		case "0100":
			System.out.println("Operation Name: addi");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));
			ALUresultInt = Operand1Int + Operand2Int;
			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));
			if (ALUresultInt == 0) {
				ALUZero = true;
				System.out.println("Z-Flag Value: " + ALUZero);
			} else {
				ALUZero = false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;
		case "0001":
			System.out.println("Operation Name: sub");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));
			ALUresultInt = Operand1Int - Operand2Int;

			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));
			if (ALUresultInt == 0) {
				ALUZero = true;
				System.out.println("Z-Flag Value: " + ALUZero);
			} else {
				ALUZero = false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;
		case "0101":
			System.out.println("Operation Name: ANDI");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));
			ALUresultInt = Operand1Int & Operand2Int;
			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));
			if (ALUresultInt == 0) {
				ALUZero = true;
				System.out.println("Z-Flag Value: " + ALUZero);
			} else {
				ALUZero = false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}
			break;

		case "0110":
			System.out.println("Operation Name: SLL");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));

			ALUresult = sll(Operand1, Operand2Int);

			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));

			ALUZero = false;
			System.out.println("Z-Flag Value: " + ALUZero);

			// code block
			break;

		case "0111":
			System.out.println("Operation Name: SRL");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));

			ALUresult = srl(Operand1, Operand2Int);

			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));

			ALUZero = false;
			System.out.println("Z-Flag Value: " + ALUZero);

			// code block
			break;
		case "1010":
			System.out.println("Operation Name: BEQ");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));

			if (Operand1Int == Operand2Int) {
				ALUresultInt = 1;
				ALUZero = true;
			} else {
				ALUresultInt = 0;
				ALUZero = false;
			}
			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult + " ,with value of: " + ALUZero);

			// code block
			break;
		case "1011":
			System.out.println("Operation Name: BLT");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));

			if (Operand1Int < Operand2Int) {
				ALUresultInt = 1;
				ALUZero = true;
			} else {
				ALUresultInt = 0;
				ALUZero = false;
			}
			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult + " ,with value of: " + ALUZero);

			// code block
			break;

		// code block
		case "1110":
			System.out.println("Operation Name: slti");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));

			if (Operand1Int < Operand2Int) {
				ALUresultInt = 1;
			} else {
				ALUresultInt = 0;
			}
			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));
			if (ALUresultInt == 0) {
				ALUZero = true;
				System.out.println("Z-Flag Value: " + ALUZero);
			} else {
				ALUZero = false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;
		case "1100":
			System.out.println("Operation Name: add(Store)");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));
			ALUresultInt = Operand1Int + Operand2Int;
			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));
			if (ALUresultInt == 0) {
				ALUZero = true;
				System.out.println("Z-Flag Value: " + ALUZero);
			} else {
				ALUZero = false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;
		case "1101":
			System.out.println("Operation Name: add(load)");
			System.out.println("1st Operand: " + Operand1 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand1), 2));
			System.out.println("2nd Operand: " + Operand2 + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(Operand2), 2));
			ALUresultInt = Operand1Int + Operand2Int;
			ALUresult = Engine.to16Bits(Integer.toBinaryString(ALUresultInt));

			System.out.println("ALUresult: " + ALUresult + " ,with value of: "
					+ (int) Long.parseLong(Engine.to32Bits(ALUresult), 2));
			if (ALUresultInt == 0) {
				ALUZero = true;
				System.out.println("Z-Flag Value: " + ALUZero);
			} else {
				ALUZero = false;
				System.out.println("Z-Flag Value: " + ALUZero);
			}

			// code block
			break;

		default:
			System.out.println("This operation does not exist");
		}
		InstructionFetch.ALUZero=ALUZero;
		System.out.println();
		ExecuteMemPipe.getExecute(ALUresult, readData1, readData2, readData3,

				controlMemRead, controlMemWrite, controlRegWrite, controlMemtoReg, useMem, useWB,

				writeRegister);
		return ALUresult;

	}

	static String sll(String operand12, int operand2Int) {
		String newR = Engine.to16Bits(operand12);
		for (int n = 0; n < operand2Int; n++) {
			newR = newR + "0";

		}
		return newR.substring(newR.length() - 16, newR.length());
	}

	static String srl(String operand12, int operand2Int) {
		String newR = Engine.to16Bits(operand12);
		for (int n = 0; n < operand2Int; n++) {
			newR = "0" + newR;

		}
		return newR.substring(0, 16);
	}

//	@SuppressWarnings("resource")
//	public static void main(String[] args) {
//		
//		int Operand1;
//		int Operand2;
//		String Op;
//		
//		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//		
//	    System.out.println("Enter operation string");
//	    Op = myObj.nextLine();  // Read user input
//	    
//		System.out.println("Enter 1st operand in decimal");
//	    Operand1 = myObj.nextInt();  // Read user input
//	    
//	    System.out.println("Enter 2nd operand in decimal");
//	    Operand2 = myObj.nextInt();  // Read user input
//
//	    
//	    ALUEvaluator(Op, Operand1, Operand2);
//		
//		
//		//Test Cases
//		
////		//AND
////		Operand1=5;
////		Operand2=13;
////		Op="0000";
////		ALUEvaluator(Op, Operand1, Operand2);
////
////		
////		//OR
////		Operand1=9;
////		Operand2=25;
////		Op="0001";
////		ALUEvaluator(Op, Operand1, Operand2);
////		
////		//NOR
////		Operand1=8;
////		Operand2=8;
////		Op="1100";
////		ALUEvaluator(Op, Operand1, Operand2);
////		
////		//add
////		Operand1=8;
////		Operand2=8;
////		Op="0010";
////		ALUEvaluator(Op, Operand1, Operand2);
////		
////		//slt
////		Operand1=9;
////		Operand2=12;
////		Op="0111";
////		ALUEvaluator(Op, Operand1, Operand2);
////	    	    
////		//sub
////		Operand1=27;
////		Operand2=18;
////		Op="0110";
////		ALUEvaluator(Op, Operand1, Operand2);
//	   
//
//	}

}
