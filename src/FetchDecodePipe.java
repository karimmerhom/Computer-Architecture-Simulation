

public class FetchDecodePipe {

	static String currInstruction;
	static int pcInt;
	static String nextpC;

	public static void getFetch(String curInstruction, int pcInt, String nextpC) {
		FetchDecodePipe.currInstruction =curInstruction;
		FetchDecodePipe.pcInt = pcInt;
		FetchDecodePipe.nextpC = nextpC;
	}

	public static void transferDecode() {
		InstructionDecode.currInstruction = currInstruction;
		InstructionDecode.pcInt = pcInt;
		InstructionDecode.nextpC = nextpC;
	}
}
