
class Manager extends Employee {
	String company;
	
	public Manager(String name) {
		super(name);
	}
	
	public Manager(String name, String company) {
		super(name);
		this.company = company;
	}
	
	void sayHello(String name) {
		System.out.println("Hello " + name + " My name is Manager " + this.name);
	}
	
	String salary() {
		return "Rp 10.000.000";
	}
}

class VicePresident extends Manager {
	//Call Contructor Parent 
	public VicePresident(String name) {
		super(name);
	}
	
	void sayHello(String name) {
		System.out.println("Hello " + name + " My name is VP " + this.name);
	}
	
	String salary() {
		return "Rp 100.000.000";
	}
	
	String salaryParent() {
		return super.salary();
	}
}
