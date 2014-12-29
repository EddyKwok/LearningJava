public class ToDoListTester
{
	public static void main(String[] args)
	{
		ToDoList toDoList = new ToDoList(6);
		toDoList.add(new ToDo("#1", "Do Laundry."));
		toDoList.add(new ToDo("#2", "Buy groceries."));
		toDoList.add(new ToDo("#3", "Vacuum apartment."));
		toDoList.add(new ToDo("#4", "Write report."));
		toDoList.add(new ToDo("#5", "Wash car."));
		toDoList.add(new ToDo("#6", "Learning Java."));
		Iterator iter = toDoList.iterator();
		while (iter.hasMoreElements())
			System.out.println(iter.nextElement());
	}
}
