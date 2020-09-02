

public class MemWritePipe {
	static String ALUresult;
	static boolean controlRegWrite;
	static boolean controlMemtoReg;
	static boolean useWB;
	static String writeRegister;
	static String ReadData;
	
	public static void getMemory(
			 String ALUresult,
			 boolean controlRegWrite,
			 boolean controlMemtoReg,
			 boolean useWB,
			 String writeRegister,
			 String ReadData) {
		MemWritePipe.ALUresult=ALUresult;
		MemWritePipe.controlRegWrite=controlRegWrite;
		MemWritePipe.controlMemtoReg=controlMemtoReg;
		MemWritePipe.useWB=useWB;
		MemWritePipe.writeRegister=writeRegister;
		MemWritePipe.ReadData=ReadData;
	}
	public static void transferWrite() {
		WriteBackClass.ALUresult=ALUresult;
		WriteBackClass.controlRegWrite=controlRegWrite;
		WriteBackClass.controlMemtoReg=controlMemtoReg;
		WriteBackClass.useWB=useWB;
		WriteBackClass.writeRegister=writeRegister;
		WriteBackClass.ReadData=ReadData;
	}
	
}
