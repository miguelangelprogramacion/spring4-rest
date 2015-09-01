/**
 * 
 */
package world.we.deserve.exception;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
public class NihilistNotFoundException extends RuntimeException{
	private int nihilistId;

	/**
	 * @param nihilistId
	 */
	public NihilistNotFoundException(int nihilistId) {
		super();
		this.nihilistId = nihilistId;
	}

	/**
	 * @return the nihilistId
	 */
	public int getNihilistId() {
		return nihilistId;
	}

	/**
	 * @param nihilistId the nihilistId to set
	 */
	public void setNihilistId(int nihilistId) {
		this.nihilistId = nihilistId;
	}	
}
