package oops;

public class MAIN {

	public static void main(String[] args) {
	
		Cat mycat = new Cat();
		
		mycat.meow();
		mycat.name = "";
		
	//	Cat.meow();   // this is non static , so error if we change method to static no issue
		
			 
	//	Cat.meow(); 
		//STATICNONSTATIC  Cannot make a static reference to the non-static method meow() from the type STATICNONSTATIC
	System.out.println(Cat.getCatCount());
	
//	System.out.println(	s.setTotalcats(5));
	Cat.getCatCount();  

	System.out.println(Cat.Maxlives1);
	
	
	// static methods through class and method 
	}

}
