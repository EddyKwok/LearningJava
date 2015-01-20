/**
 * <code>Listing 4-6.</code> Implementing to-do Items as name-description pairs
 * 
 */

public class ToDo
{
    private String name;
    private String desc;
    
    public ToDo(String name, String desc)
    {
        this.name = name;
        this.desc = desc;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDesc()
    {
        return desc;
    }
    
    public String toString()
    {
        return "Name = " + getName() + ", Desc = " + getDesc();
    }
}