import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import javax.swing.JComboBox;


public class BD {
	Connection conexion = null; //maneja la conexión
	Statement instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados
	private JComboBox<Contactos> box;
	

	public BD(JComboBox box) {
		// TODO Auto-generated constructor stub
				crearconexion();
				this.box=box;
	}

		public void crearconexion (){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ficha3","root","");

		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch
	}

		public void leerContactos (){
			try{
			// crea objeto Statement para consultar la base de datos
						instruccion = (Statement) conexion.createStatement();
						// consulta la base de datos
						conjuntoResultados = instruccion.executeQuery("SELECT nombre,numero,iD FROM contactos");
						//Mostrar por pantalla
						while (conjuntoResultados.next())
						{
						   System.out.println("id="+conjuntoResultados.getObject("ID")+
						      ", nombre="+conjuntoResultados.getObject("nombre"));
						   Contactos con=new Contactos((String)conjuntoResultados.getObject("nombre"),
								   							(int)conjuntoResultados.getObject("numero"),
								   							(int)conjuntoResultados.getObject("ID"));


						   box.addItem(con);
						}
						conjuntoResultados.close();	

				}
			catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();}
			}
		public int insertarContacto (String nombre, int numero){
			// crea objeto Statement para consultar la base de datos
			try {
				instruccion = (Statement) conexion.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// insercion en base de datos
			try {
				String sql="INSERT INTO `ficha3`.`contactos` (`nombre`, `numero`) VALUES ("
						+ 													"'"+nombre+"', '"+numero+"');";
				instruccion.executeUpdate(sql);

				//PARA GUARDAR EL ID
				sql = "SELECT * FROM contactos ORDER BY ID DESC LIMIT 1";
				conjuntoResultados = instruccion.executeQuery(sql);
				int ID=-1;
				//Mostrar por pantalla
				while (conjuntoResultados.next())
				{
					ID=(int)conjuntoResultados.getObject("ID");
				}
				conjuntoResultados.close();	
				return ID;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
				}
			}

	
	
}
