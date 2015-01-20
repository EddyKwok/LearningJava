public class TestEnum
{
	public enum Level
	{
		LOW     (1),
		MEDIUM  (2),
		HIGH    (3);
		
		private final int levelCode;
		
		Level(int levelCode)
		{
		    this.levelCode = levelCode;
		}
		
		public int getLevelCode()
		{
		    return this.levelCode;
		}
	}

	public static void main(String[] args)
	{
		for (Level level : Level.values())
		{
		    System.out.println(level + " : " + level.getLevelCode());
		}
	}
}
