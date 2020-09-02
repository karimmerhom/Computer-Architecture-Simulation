

public class DecodeExecutePipe {
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
	static String func;
	static String readData1;
	static String readData2;
	static String readData3;
	static String ALUOP;

	public static void getDecode(boolean controlRegDst, boolean controlBranch, boolean controlMemRead,
			boolean controlMemtoReg, boolean controlJump, boolean controlMemWrite, boolean controlALUSrc,
			boolean controlRegWrite,

			String opCode, String readRegister1, String readRegister2, String writeRegister,

			boolean useALU, boolean useMem, boolean useWB,

			String signExtend, String func, String readData1, String readData2, String readData3, String ALUOP) {
		DecodeExecutePipe.controlRegDst = controlRegDst;
		DecodeExecutePipe.controlBranch = controlBranch;
		DecodeExecutePipe.controlMemRead = controlMemRead;
		DecodeExecutePipe.controlMemtoReg = controlMemtoReg;
		DecodeExecutePipe.controlJump = controlJump;
		DecodeExecutePipe.controlMemWrite = controlMemWrite;
		DecodeExecutePipe.controlALUSrc = controlALUSrc;
		DecodeExecutePipe.controlRegWrite = controlRegWrite;

		DecodeExecutePipe.opCode = opCode;
		DecodeExecutePipe.readRegister1 = readRegister1;
		DecodeExecutePipe.readRegister2 = readRegister2;
		DecodeExecutePipe.writeRegister = writeRegister;

		DecodeExecutePipe.useALU = useALU;
		DecodeExecutePipe.useMem = useMem;
		DecodeExecutePipe.useWB = useWB;

		DecodeExecutePipe.signExtend = signExtend;
		DecodeExecutePipe.readData1 = readData1;
		DecodeExecutePipe.readData2 = readData2;
		DecodeExecutePipe.readData3 = readData3;
		DecodeExecutePipe.ALUOP = ALUOP;
	}

	public static void transferExecute() {

		ExecuteClass.controlRegDst = controlRegDst;
		ExecuteClass.controlBranch = controlBranch;
		ExecuteClass.controlMemRead = controlMemRead;
		ExecuteClass.controlMemtoReg = controlMemtoReg;
		ExecuteClass.controlJump = controlJump;
		ExecuteClass.controlMemWrite = controlMemWrite;
		ExecuteClass.controlALUSrc = controlALUSrc;
		ExecuteClass.controlRegWrite = controlRegWrite;

		ExecuteClass.opCode = opCode;
		ExecuteClass.readRegister1 = readRegister1;
		ExecuteClass.readRegister2 = readRegister2;
		ExecuteClass.writeRegister = writeRegister;

		ExecuteClass.useALU = useALU;
		ExecuteClass.useMem = useMem;
		ExecuteClass.useWB = useWB;

		ExecuteClass.signExtend = signExtend;
		ExecuteClass.readData1 = readData1;
		ExecuteClass.readData2 = readData2;
		ExecuteClass.readData3 = readData3;
		ExecuteClass.ALUOP = ALUOP;

	}
}
