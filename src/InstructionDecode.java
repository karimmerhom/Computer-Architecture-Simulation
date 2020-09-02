import javax.sound.midi.ControllerEventListener;

public class InstructionDecode {
	static boolean controlRegDst;
	static boolean controlBranch;
	static boolean controlMemRead;
	static boolean controlMemtoReg;
	static boolean controlJump;
	static boolean controlMemWrite;
	static boolean controlALUSrc;
	static boolean controlRegWrite;

	static boolean useALU;
	static boolean useMem;
	static boolean useWB;

	static String opCode;
	static String readRegister1;
	static String readRegister2;
	static String writeRegister;

	static String signExtend;
	static String func;
	static String readData1;
	static String readData2;
	static String readData3;
	static String ALUOP;

	static String currInstruction;
	static int pcInt;
	static String nextpC;

	public static void InstDecode() {

		System.out.println();
		System.out.println("---------------------Starting decoding now---------------------");

		String instruction = currInstruction;

		opCode = instruction.substring(0, 4);

		ContUnit(opCode);
		String immValue;

		readRegister1 = instruction.substring(8, 12);

		readRegister2 = instruction.substring(12, 16);

		writeRegister = instruction.substring(4, 8);
		if (controlJump) {
			immValue = instruction.substring(4, 16);

		} else {
			immValue = instruction.substring(8, 16);

		}

		signExtend = SignExtend(immValue);//

		readData1 = RegisterFile.getRegister(readRegister1);
		readData2 = RegisterFile.getRegister(readRegister2);
		readData3 = RegisterFile.getRegister(writeRegister);
		System.out.println(
				"Loading Register no: " + (int) Long.parseLong(readRegister1, 2) + " ,with address: " + readRegister1);
		System.out.println("ReadData1 = " + readData1);
		System.out.println(
				"Loading Register no: " + (int) Long.parseLong(readRegister2, 2) + " ,with address: " + readRegister2);
		System.out.println("ReadData2 = " + readData2);
		System.out.println("SignExtend = " + signExtend + " ,with value of: "
				+ (int) Long.parseLong(Engine.to32Bits(signExtend), 2));
		System.out.println("The program counter after decoding is " + pcInt);

		DecodeExecutePipe.getDecode(controlRegDst, controlBranch, controlMemRead, controlMemtoReg, controlJump,
				controlMemWrite, controlALUSrc, controlRegWrite,

				opCode, readRegister1, readRegister2, writeRegister,

				useALU, useMem, useWB,

				signExtend, func, readData1, readData2, readData3, ALUOP);
	}

	public static String SignExtend(String sixteenbit) {

		String thirtyTwoBit = sixteenbit;
		for (int n = thirtyTwoBit.length(); n < 16; n++) {
			if (thirtyTwoBit.startsWith("0")) {
				thirtyTwoBit = "0" + thirtyTwoBit;
			} else {
				thirtyTwoBit = "1" + thirtyTwoBit;
			}
		}
		return thirtyTwoBit;
	}

	public static String ContUnit(String opCode) {
		System.out.println("Control Unit:");
		
		if (opCode.equals("0000")) {// add
			useALU = true;
			useMem = false;
			useWB = true;
			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = false;
			controlRegWrite = true;
			controlJump = false;
		} else if (opCode.equals("0001")) {// SUB
			useALU = true;
			useMem = false;
			useWB = true;
			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = false;
			controlRegWrite = true;
			controlJump = false;
		} else if (opCode.equals("0010")) {// MUL
			useALU = true;
			useMem = false;
			useWB = true;
			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = false;
			controlRegWrite = true;
			controlJump = false;
		} else if (opCode.equals("0011")) {// OR
			useALU = true;
			useMem = false;
			useWB = true;

			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = false;
			controlRegWrite = true;
			controlJump = false;
		} else if (opCode.equals("0100")) {// ADDI
			useALU = true;
			useMem = false;
			useWB = true;

			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = true;
			controlRegWrite = true;
			controlJump = false;
		} else if (opCode.equals("0101")) {// AND IM
			useALU = true;
			useMem = false;
			useWB = true;

			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = true;
			controlRegWrite = true;
			controlJump = false;
		} else if (opCode.equals("0110")) { // SLL
			useALU = true;
			useMem = false;
			useWB = true;
			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = true;
			controlRegWrite = true;
			controlJump = false;
		} else if (opCode.equals("0111")) { // SLR

			useALU = true;
			useMem = false;
			useWB = true;

			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = true;
			controlRegWrite = true;
			controlJump = false;
		}

		else if (opCode.equals("1010")) {// BEQ
			controlRegDst = true;
			controlBranch = true;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = false;
			controlRegWrite = false;
			controlJump = false;
		} else if (opCode.equals("1011")) {// BLT
			controlRegDst = true;
			controlBranch = true;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = false;
			controlRegWrite = false;
			controlJump = false;
		} else if (opCode.equals("1100")) {// store

			useALU = false;
			useMem = true;
			useWB = false;
			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = true;
			controlALUSrc = false;
			controlRegWrite = false;
			controlJump = false;
		} else if (opCode.equals("1101")) {// load
			useALU = false;
			useMem = true;
			useWB = true;
			controlRegDst = true;
			controlBranch = false;
			controlMemRead = true;
			controlMemtoReg = true;
			controlMemWrite = false;
			controlALUSrc = false;
			controlRegWrite = true;
			controlJump = false;
		} else if (opCode.equals("1110")) {// slti
			useALU = true;
			useMem = false;
			useWB = true;
			controlRegDst = true;
			controlBranch = false;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = true;
			controlRegWrite = true;
			controlJump = false;
		} else if (opCode.equals("1111")) {// jump
			useALU = false;
			useMem = false;
			useWB = false;
			controlRegDst = false;
			controlBranch = true;
			controlMemRead = false;
			controlMemtoReg = false;
			controlMemWrite = false;
			controlALUSrc = false;
			controlRegWrite = false;
			controlJump = true;
		}
		InstructionFetch.controlBranch=controlBranch;
		InstructionFetch.controlJump=controlJump;

		System.out.println("useALU: "+useALU+" | "+"useMem: "+useMem+" | "+"useWB: "+useWB+" | "
		+"controlRegDst: "+controlRegDst+" | "+"controlBranch: "+controlBranch+" | "
				+"controlMemRead: "+controlMemRead+" | "+"controlMemtoReg: "+controlMemtoReg+" | "
		+"controlMemWrite: "+controlMemWrite+" | "+"controlALUSrc: "+controlALUSrc+" | "
				+"controlRegWrite: "+controlRegWrite+" | "+ "controlJump: "+controlJump);

		return ALUOP;
	}

}
