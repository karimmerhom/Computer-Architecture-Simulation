

public class ExecuteMemPipe {

	static String ALUresult;
	static String readData1;
	static String readData2;
	static String readData3;

	static boolean controlMemRead;
	static boolean controlMemWrite;
	static boolean controlRegWrite;
	static boolean controlMemtoReg;
	static boolean useMem;
	static boolean useWB;

	static String writeRegister;

	public static void getExecute(String ALUresult, String readData1, String readData2, String readData3,

			boolean controlMemRead, boolean controlMemWrite, boolean controlRegWrite, boolean controlMemtoReg,
			boolean useMem, boolean useWB,

			String writeRegister) {
		ExecuteMemPipe.ALUresult = ALUresult;
		ExecuteMemPipe.readData1 = readData1;
		ExecuteMemPipe.readData2 = readData2;
		ExecuteMemPipe.readData3 = readData3;

		ExecuteMemPipe.controlMemRead = controlMemRead;
		ExecuteMemPipe.controlMemWrite = controlMemWrite;
		ExecuteMemPipe.controlRegWrite = controlRegWrite;
		ExecuteMemPipe.controlMemtoReg = controlMemtoReg;
		ExecuteMemPipe.useMem = useMem;
		ExecuteMemPipe.useWB = useWB;

		ExecuteMemPipe.writeRegister = writeRegister;
	}

	public static void transferMem() {
		MemoryAccess.ALUresult = ALUresult;
		MemoryAccess.readData1 = readData1;
		MemoryAccess.readData2 = readData2;
		MemoryAccess.readData3 = readData3;

		MemoryAccess.controlMemRead = controlMemRead;
		MemoryAccess.controlMemWrite = controlMemWrite;
		MemoryAccess.controlRegWrite = controlRegWrite;
		MemoryAccess.controlMemtoReg = controlMemtoReg;
		MemoryAccess.useMem = useMem;
		MemoryAccess.useWB = useWB;

		MemoryAccess.writeRegister = writeRegister;
	}
}
