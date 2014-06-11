
public class Contactos {
	private int id;
	private String nombre;
	private int numero;
	private String apellidos;
	private String direccion;
	// private int liga;

	public Contactos() {
		// TODO Auto-generated constructor stub

	id=0;	
	nombre="";
	numero=0;
	apellidos="";
	direccion="";
	}
	
	public Contactos(String nombre, int numero,int ID) {
		id=ID;
		nombre=nombre;
		numero=numero;
	}
		
	
	public void setid(int id){
		this.id=id;
	}
	//public void setliga(int liga){
	//	this.liga=liga;
	//}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public void setNumero(int numero){
		this.numero=numero;
	}
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}
	public void setDireccion(String direccion){
		this.direccion=direccion;
	}
	

	public int getid(){
		return id;
	}
	//public int getliga(){
	//	return liga;
	//}

	public String getNombre(){
		return nombre;
	}
	public int getNumero(){
		return numero;
	}
	public String getApellidos(){
		return apellidos;
	}
	public String getDireccion(){
		return direccion;
	}
	
	//Falta por crear
	//El método toString para que aparezca en el comboBox
	public String toString(){
		return this.nombre;
	}
}
