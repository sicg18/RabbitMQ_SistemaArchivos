package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {


	protected String driver = "org.postgresql.Driver"; // nombre del driver
	protected String connectString = "jdbc:postgresql://localhost:5432/venta"; // ubicacion de la base de datos, para
																				// postgres esta es por defecto
	protected String user = "postgres"; // usuario de la base de datos
	protected String password = "1234"; // password de la base de datos
	protected Connection conexionDB; // variable que permite la conexion
	protected Statement sentenciaSQL; // permite la ejecucion de sentencias SQL
	protected ResultSet resultadoDB;// almacena el resultado de una consulta

	/**
	 * Permite la conexion de la base de datos
	 */

	public void conectar() {
		try {
			Class.forName(driver); // se carga el driver en memoria
			conexionDB = DriverManager.getConnection(connectString, user, password);// conexion a la base de datos
			sentenciaSQL = conexionDB.createStatement();// variable que permite ejecutar las sentencias SQL
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Desconecta la conexion de la base de datos
	 */
	public void desconectar() {
		try {
			sentenciaSQL.close(); // cierra la consulta
			conexionDB.close();// cierra conexion
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void ejecutar(String sentencia) {
		try {
			conectar(); // conecta la bd
			sentenciaSQL.executeUpdate(sentencia); // ejecuta una sentencia en la bd
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ejecutarRetorno(String sentencia) {
		try {
			conectar();
			resultadoDB = sentenciaSQL.executeQuery(sentencia);
		//	desconectar();
		} catch (Exception e) {
			e.printStackTrace();
			desconectar();
		}
	}
}

