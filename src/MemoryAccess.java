public class MemoryAccess {

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

	static String Address;
	static String WriteData;

	static String ReadData;

	public static void memAccess() {

		System.out.println("------------------------Performing Memory Access------------------------");

		Address = ALUresult;
		WriteData = readData3;

		if(controlMemRead){
			ReadData=Cache.readData(Integer.parseInt(Address,2));
			System.out.println("Reading Data from memory no: "+ Integer.parseInt(Address, 2) +" with address: " + Address);
			System.out.println("The Data read is: " + ReadData);

		} else if (controlMemWrite) {

			System.out.println("Writing the Data: " + WriteData + " ,at memory no: " + Integer.parseInt(Address, 2)
					+ " with address: " + Address);

			DataMemory.setData(WriteData, Address);
			Cache.readData(Integer.parseInt(Address,2));

		} else {
			System.out.println("No memory access occured");
		}
		MemWritePipe.getMemory(ALUresult, controlRegWrite, controlMemtoReg, useWB, writeRegister, ReadData);
		System.out.println();

	}

}
