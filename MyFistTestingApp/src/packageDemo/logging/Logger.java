/**
 * Listing 4-16. Describing objects that log messages via the Logger interface.
 * Each of the connect(), disconnect(), and log() methods returns true upon success,
 * and false upon failure.
 */

package logging;

public interface Logger
{
	boolean connect();
	boolean disconnect();
	boolean log(String msg);
}
