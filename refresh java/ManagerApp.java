
public class ManagerApp {
	public static void main(String[] args) {
		//Create Object from Class Child
		VicePresident vicePresident = new VicePresident("Apnan");
		vicePresident.sayHello("Budi");
	
		System.out.println("Salary: " + vicePresident.salary());
		System.out.println("Salary Before: " + vicePresident.salaryParent());
		
		System.out.println("");
		Manager manager = new Manager("Juanda");
		manager.sayHello("Budi");
		System.out.println("Salary: " + manager.salary());	
	
	}
}
