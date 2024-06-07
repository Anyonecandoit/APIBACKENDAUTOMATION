package oops;

public class Cat {

	
	
	
static	String name;
	int age;
	int livesRemaining;   // by default all these varibles are static in nature 
	
	
	//but 
	public static final  int Maxlives1 = 2;   // change to public will work in main class and final makes not to update this feild 
	private static final  int Maxlives = 2 ; //  --final    // to acess this in main method getter should be created    // cant be changed
	private static int catCount = 0 ;   // to update this we need to use getters and setters , to acess outside of this class 
	
	
	
	public Cat() {
		
		catCount++;0
		livesRemaining = Maxlives1; 
		
	}
	
	//public static void meow() {  
		
		// if i make static  eroor will gone 
		
		public  void meow() {  
		System.out.println("meow");
		
	}
		
		
		public static int getCatCount() {
			
		// all are static feilds 
			// but if you make or add any non static feilds it fails 
			
			//System.out.println(age);
			
			return catCount;
		}
		
		
}
