import java.util.ArrayList;

public class InstructionMemory {
	static String pC = "0";
	static int pCInt = 0;
	private static ArrayList<String> pInstructions;

	public InstructionMemory() {
		pC = "00000000000000000000000000000000";
	}

	public static String getInstruction(String pCAddress) {
		pCInt = Integer.parseInt(pCAddress, 2);
		if (pCInt >= pInstructions.size()) {
			return null;
		} else {
			return pInstructions.get(pCInt);
		}
	}

	public static void loadInstructions(ArrayList<String> Instructions) {
		pInstructions = new ArrayList<String>();

		for (int i = 0; i < Instructions.size(); i++) {
			if (Instructions.get(i).length() == 16)
				pInstructions.add(Instructions.get(i));
			else {
				System.out.println("Wrong Instruction length at index " + i);
				System.out.println("The program will now end");
				return;
			}
		}

		System.out.println("Intructions are now loaded to the instruction memory");
		boolean done = false;
		

	}
	public static void begin() {
		int cc = 1; // current clock cycle
		int tcc = pInstructions.size() +4; // total clock cycles

		while (cc <= tcc ) {
			System.out.println("Clock Cycle: "+cc);
			System.out.println("The PC is " + pCInt);

			if (cc >= 1) {
				
				if(cc<=tcc)
				if (cc >= 5) {
					MemWritePipe.transferWrite();

					WriteBackClass.WriteBack();
				}
				if(cc<=tcc-1)
				if (cc >= 4) {
					ExecuteMemPipe.transferMem();

					MemoryAccess.memAccess();
				}
				if(cc<=tcc-2)
				if (cc >= 3) {
					DecodeExecutePipe.transferExecute();
					ExecuteClass.Execute();
				}
				if(cc<=tcc-3)
				if (cc >= 2) {
					FetchDecodePipe.transferDecode();
					InstructionDecode.InstDecode();
				}
				if(cc<=tcc-4){
					InstructionFetch.InstFetch(pC);
				}
			
				
			}

			cc++; // incrementing clock cycle
		}
	}

	public static String to16Bits(String old) {

		String thirtyTwoBit = old;
		for (int n = thirtyTwoBit.length(); n < 16; n++) {
			thirtyTwoBit = "0" + thirtyTwoBit;

		}
		return thirtyTwoBit.substring(thirtyTwoBit.length() - 16, thirtyTwoBit.length());
	}

	public static String to32Bits(String old) {

		String thirtyTwoBit = old;
		for (int n = thirtyTwoBit.length(); n < 32; n++) {
			if (thirtyTwoBit.substring(0, 1).equals("0")) {
				thirtyTwoBit = "0" + thirtyTwoBit;
			} else {
				thirtyTwoBit = "1" + thirtyTwoBit;
			}
		}
		return thirtyTwoBit;
	}

}
