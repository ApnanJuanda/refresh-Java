
public class ParentApp {
	public static void main(String[] args) {
		Child child = new Child();
		child.name = "Apnan";
		child.doIt();
		System.out.println(child.name);
		
		//Convert to Parent
		Parent parent = (Parent) child;
		parent.name = "Juanda";
		parent.doIt();
		System.out.println(parent.name);
	}
}
