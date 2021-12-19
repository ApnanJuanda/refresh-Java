import java.util.Scanner;

public class AplikasiTodoList {
	public static String[] model = new String[10];
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		viewShowTodoList();
	}
	
	
	/*Input number command*/
	public static String input(String info) {
		System.out.print(info);
		String data = scanner.nextLine();
		return data;
	}
	
	/*Test method input number command*/
	public static void testInput() {
		var name = input("Nama: ");
		System.out.println("Hai " + name);
	}
	
	/*Show to TodoList*/
	public static void showTodoList() {
		System.out.println("/*---TODO LIST---*/");
		for (int i = 0; i < model.length; i++) {
			var todo = model[i];
			var no = i + 1;
			
			if(todo != null) {
				System.out.println(no + ". " + todo);
			}
		}
	}
	
	public static void testShowTodoList() {
		model[0] = "Belajar Java Dasar";
		model[1] = "Belajar Aplikasi TodoList";
		model[2] =  null;
		model[3] = "apaan tuh";
		showTodoList();
	}
	
	/*add to TodoList*/
	public static void addTodoList(String todo) {
		//Case model was full -> resize model
		//Check full or not 
		boolean isFull = true;
		for (int i = 0; i < model.length; i++) {
			if(model[i] == null) {
				isFull = false;
				break;
			}
		}
		
		//if full so we resize array
		if(isFull) {
			var temp = model;
			model = new String[model.length*2];
			
			//fill temp to new model
			for (int i = 0; i < temp.length; i++) {
				model[i] = temp[i];
			}
		}
		
		//Case model has index null
		for (int i = 0; i < model.length; i++) {
			if(model[i] == null) {
				model[i] = todo;
				break;
			}
		}
	}
	
	public static void testAddTodoList() {
		for (int i = 0; i < 25; i++) {
			addTodoList("Contoh todo ke- " + i);
		}
		showTodoList();
	}
	
	/*delete a TodoList*/
	public static boolean removeTodoList(Integer number) {
		if((number-1) >= model.length) {
			return false;
		}else if(model[number - 1] == null) {
			return false;
		}else {
			model[number - 1] = null;
			for (int i = (number - 1); i < model.length; i++) {
				if(i == model.length - 1) {
					model[i] = null;
				}else {
					model[i] = model[i+1];
				}
			}
			return true;
		}		
	}
	
	public static void testRemoveTodoList() {
		addTodoList("satu");
		addTodoList("dua");
		addTodoList("tiga");
		addTodoList("empat");
		addTodoList("lima");
		
		var result = removeTodoList(20);
		System.out.println(result);
		
		result = removeTodoList(7);
		System.out.println(result);
		
		result = removeTodoList(2);
		System.out.println(result);
		
		showTodoList();
	}
	
	/*Update Data TodoList*/
	public static void updateTodoList(int number, String update) {
		if(!update.isEmpty()) {
			model[number-1] = update;
			System.out.println("Succes to Update");
		}else {
			System.out.println("You can not fill the todo with null");
		}
	}
	
	/*test Update Data TodoList*/
	public static void testUpdateTodoList() {
		addTodoList("pertama");
		addTodoList("kedua");
		addTodoList("ketiga");
		showTodoList();
		updateTodoList(0, null);
		showTodoList();
	}
	
	/*view show TodoList*/
	public static void viewShowTodoList() {
		while(true) {
			showTodoList();
			System.out.println("Menu: ");
			System.out.println("1. Add Data");
			System.out.println("2. Delete Data");
			System.out.println("3. Update Data");
			System.out.println("X. Exit");
			
			String input = input("choosing: ");
			if(input.equals("1")) {
				viewAddTodoList();
			}else if(input.equals("2")) {
				viewRemoveTodoList();
			}else if(input.equals("3")) {
				viewUpdateTodoList();
			}else if(input.equals("X")) {
				break;
			}
			else {
				System.out.println("Sorry you type wrong number");
			}
		}
		
	}
	
	/*test view show TodoList*/
	public static void testViewShowTodoList() {
		addTodoList("Satu");
		addTodoList("Dua");
		addTodoList("Tiga");
		addTodoList("Empat");
		addTodoList("Lima");
		viewShowTodoList();
	}
	
	/*View add to TodoList*/
	public static void viewAddTodoList() {
		System.out.println("Add Todo");
		String todo = input("Todo(x if you want cancel):");
		if(todo.equals("x")) {
			//cancel, back to viewShowTodoList
		}else {
			addTodoList(todo);
		}
	}
	
	/*test View add to TodoList*/
	public static void testViewAddTodoList() {
		addTodoList("satu");
		addTodoList("dua");
		
		viewAddTodoList();
		showTodoList();
	}
	
	/*View remove a TodoList*/
	public static void viewRemoveTodoList() {
		System.out.println("Remove Todo");
		var number = input("Which one Number(x if you want cancel): ");
		if(number.equals("x")) {
			//cancel, back to viewShowTodoList
		}else {
			boolean success = removeTodoList(Integer.valueOf(number));
			if(!success) {
				System.out.println("Fail to remove todo");
			}else {
				System.out.println("Remove Todo was success");
			}
		}
	}
	
	public static void testViewRemoveTodoList() {
		addTodoList("satu");
		addTodoList("dua");
		addTodoList("tiga");
		showTodoList();
		viewRemoveTodoList();
		showTodoList();
	}
	
	/*View Update a Todo*/
	public static void viewUpdateTodoList() {
		System.out.println("Update Todo");
		var number = input("Which one number to Update(x if you want cancel):");
		if(number.equals("x")) {
			//cancel, back to viewShowTodoList
		}else {
			if(Integer.valueOf(number) >= model.length && !number.isEmpty()) {
				System.out.println("The Number is not correct");
			}else {
				var update = input("Update Todo: ");
				updateTodoList(Integer.valueOf(number), update);
			}
		}
	}
	
	/*test View Update a Todo*/
	public static void testViewUpdateTodoList() {
		addTodoList("pertama");
		addTodoList("kedua");
		addTodoList("ketiga");
		showTodoList();
		viewUpdateTodoList();
		showTodoList();
	}
	
}	
