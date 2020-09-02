import java.util.Currency;

public class InstructionFetch {
	
	static String curInstruction;
	
	static int pcInt;
	static String nextpC;
	
	static boolean controlBranch;
	static boolean ALUZero;
	static boolean controlJump;
	

	public static String InstFetch(String pCAddress){
		
		System.out.println("---------------------Fetching instruction---------------------");

		String curInstruction = InstructionMemory.getInstruction(pCAddress);
		
		if(curInstruction==null){
			return curInstruction;
		}
		else{
			System.out.println("Instruction successfully fetched");
		}
		
		ProgCounter(pCAddress);
		FetchDecodePipe.getFetch(curInstruction, pcInt, nextpC);
		return curInstruction;
		
	}
	
	public static void ProgCounter(String pCAddress){

		
		if((controlBranch && ALUZero) || (controlBranch &&controlJump)){
			System.out.println("--------------A JUMP HAS OCCURRED--------------");
			pcInt = Integer.parseInt(pCAddress,2);
			String branch;
			if(InstructionDecode.controlJump){
				 branch=InstructionDecode.signExtend;

			}else{
			 branch=InstructionDecode.readData3;
			}//
			
			int branchpCInt = Integer.parseInt(branch,2);
			pcInt++;
			
			System.out.println("The PC regularly incremented by 1 is:" + pcInt);
			pcInt=branchpCInt+pcInt;
			
			System.out.println("The PC after jump is:" + pcInt);
			
			nextpC=(Integer.toBinaryString(pcInt));
			for(int n=nextpC.length(); n<32; n++) {
			                        nextpC = "0" + nextpC;
			}
			if(InstructionMemory.getInstruction(nextpC)==null){
				System.out.println("This location of the jump DOES NOT EXIST");
				
			}
			System.out.println();

		}
		else{
			pcInt = Integer.parseInt(pCAddress,2);
			pcInt++;
			
			nextpC=(Integer.toBinaryString(pcInt));
			for(int n=nextpC.length(); n<32; n++) {
			                        nextpC = "0" + nextpC;
			}
		}
		
		InstructionMemory.pC=nextpC;
		InstructionMemory.pCInt=pcInt;
		
	}

}
