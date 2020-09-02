

public class WriteBackClass {
	static boolean controlRegWrite;
	static boolean controlMemtoReg;
	static boolean useWB;
	static String writeRegister;
	
	static String ALUresult;
	static String ReadData;
	
	static String WriteData;
	public static void WriteBack(){
		
		System.out.println("------------------------Performing Write Back------------------------");

		
		String WriteLocation= writeRegister;
		
		if(controlRegWrite){
		if(controlMemtoReg){
			System.out.println("Setting Register no: " + Integer.parseInt(WriteLocation,2) + " ,with address: "+ WriteLocation + " with the Read Data: " + ReadData + " from the memory");
			RegisterFile.setRegister(ReadData, WriteLocation);
			
		}else{
			System.out.println("Setting Register no: " + Integer.parseInt(WriteLocation,2) + " ,with address: "+ WriteLocation + " with the ALU result: " + ALUresult + " from ALU");
			RegisterFile.setRegister(ALUresult, WriteLocation);
		}
		}
		else{
			 System.out.println("No write back occured");

		}
		System.out.println();
		
		
	}

}
