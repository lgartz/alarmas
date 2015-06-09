package co.com.system;


public class UserContext {

	private String user;

	/**
	 * Método encargado de establecer el valor del atributo user.
	 * 
	 * @return La información almacenada en el atributo <code>user</code>.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Método encargado de establecer el valor del atributo user.
	 * 
	 * @param user
	 *            , Contiene la información que se asignará al atributo
	 *            <code>user</code>.
	 */
	public void setUser(String user) {
		this.user = user;
	}
}
