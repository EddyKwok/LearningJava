/**
 * Listing 4-17. Obtaining a logger for logging messages to a specific destination.
 * Presents the LoggerFactory abstract class.
 *
 * newLogger() returns a Logger for logging mesages to an appropriate destination.
 * It uses the variable arguments feature to optionally accept an extra String
 * argument for those destination types that require the argument. For example,
 * FILE requires a filename.
 */

package logging;

public abstract class LoggerFactory
{
	public final static int CONSOLE = 0;
	public final static int FILE = 1;
	
	public static Logger newLogger(int dstType, String...dstName)
	{
		switch (dstType)
		{
			case CONSOLE: return new Console(dstName.length == 0 ? null
																 : dstName[0]);
			case FILE   : return new File(dstName.length == 0 ? null
															  : dstName[0]);
			default     : return null;
		}
	}
}
