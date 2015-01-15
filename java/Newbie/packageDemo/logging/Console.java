/**
 * Listing 4-18. Logging messages to the console.
 * Presents the package-private Console class.
 */

package logging;

class Console implements Logger
{
	private String dstName;
	Console(String dstName)
	{
		this.dstName = dstName;
	}
	public boolean connect()
	{
		return true;
	}
	public boolean disconnect()
	{
		return true;
	}
	public boolean log(String msg)
	{
		System.out.println(msg);
		return true;
	}
}
