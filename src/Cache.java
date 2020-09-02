public class Cache {
	
	static boolean[] valid = new boolean[8];
	static int[] tag = new int[8];
	static String[] Cdata = new String[8];
	static String [] memory = DataMemory.dataList ;
	public static int miss=0;
	public static int hit=0;
	
	public static String readData(int memAdd){
		
		int tagA= memAdd/8;
		int index = memAdd%8;
		
		if(valid[index]){
			if(tag[index]==(tagA)){
				
				System.out.println("It was found in the cache");
				hit++;

				return Cdata[index];
			}
			else{
				tag[index]= tagA;
			//	int value = Integer.parseInt(memory[memAdd]);
				Cdata[index] = memory[memAdd];
				miss++;
				return memory[memAdd];
			}
		}
		else{
			tag[index]=tagA;
		//	int value = Integer.parseInt(memory[memAdd]);
			Cdata[index] =memory[memAdd] ;
			System.out.println("It wasn't found in the cache due to valid = false");
			miss++;
			valid[index]= true;
			return memory[memAdd];
			
		}
		
	}
	
	
//	public static void main(String [] args){
//		Cache x = new Cache();
//		String add = "00000000000000100";
//    	DataMemory.dataList[4]="dlmsvmad;1";
//	 String aaa =x.readData(Integer.parseInt(add,2));
//	 String aa =x.readData(Integer.parseInt(add,2));
//	 System.out.println(aaa);
//	 System.out.println(aa);
//	 System.out.println(hit);
//	 System.out.println(miss);
//
////	 DataMemory.dataList[8]="1";
//
////	x.readData(8);
//	 
////	 System.out.println(hit);
////	 System.out.println(miss);
//	 
//	}
	

}