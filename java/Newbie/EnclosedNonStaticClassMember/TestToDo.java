/**
 * <code>Listing 4-8.</code> Creating a list of ToDo Instances and iterating over this list.
 * 
 */

public class TestToDo
{
    public static void main(String[] args)
    {
        ToDoList toDoList = new ToDoList();
        toDoList.add(new ToDo("#1", "Do laundry."));
        toDoList.add(new ToDo("#2", "Buy groceries."));
        toDoList.add(new ToDo("#3", "Vacuum matress"));
        toDoList.add(new ToDo("#4", "Write report."));
        toDoList.add(new ToDo("#5", "Learn java programming."));
        while (toDoList.hasMoreElements())
            System.out.println(toDoList.nextElement());
    }
}