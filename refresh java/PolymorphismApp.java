
public class PolymorphismApp {
	public static void main(String[] args) {
		Employee employee = new Employee("Apnan");
		employee.sayHello("Budi");
		
		employee = new Manager("Apnan");
		employee.sayHello("Budi");
		
		employee = new VicePresident("Apnan");
		employee.sayHello("Budi");
		
		sayHello(new Employee("Zaimunar"));
		sayHello(new Manager("Yusnidar"));
		sayHello(new VicePresident("Mirza"));
		
	}
	
	static void sayHello(Employee employee) {
		if(employee instanceof VicePresident) {
			VicePresident vicePresident = (VicePresident) employee;
			System.out.println("Hello VP: " + vicePresident.name);
		}else if(employee instanceof Manager) {
			Manager manager = (Manager) employee;
			System.out.println("Hello Manager: " + manager.name);
		}else {
			System.out.println("Hello Employee: " + employee.name);
		}
	}
	
	//if not exist polymorpish we must declarace each sayHello
	/*static void sayHello(Manager manager) {
		System.out.println("Hello " + manager.name);
	}static void sayHello(VicePresident vicePresident) {
		System.out.println("Hello " + vicePresident.name);
	}*/
	
}
