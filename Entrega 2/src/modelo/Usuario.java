package modelo;

public class Usuario {
	private String nombre;
	private String Id;
	protected String Password;
	protected static PropertyManagamentSystem PMS;
	
	public Usuario(String name, String id, String correo, String password, String rol, PropertyManagamentSystem pms) {
		this.nombre = name;
		this.Id = id;
		this.Password = password;
		PMS = pms;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getId() {
		return Id;
	}
	
}
