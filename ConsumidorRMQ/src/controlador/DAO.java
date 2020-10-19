package controlador;

public class DAO {

	public int insertarCategoria(String nombrecategoria) {
		try {
			Conexion conexion = new Conexion();
			String query = "INSERT INTO categoria (nombrecategoria) VALUES ('" + nombrecategoria
					+ "') on conflict (nombrecategoria) do update set nombrecategoria = '" + nombrecategoria + "'";
			conexion.ejecutar(query);
			conexion.desconectar();
			conexion.ejecutarRetorno(
					"SELECT idcategoria from categoria WHERE nombrecategoria = '" + nombrecategoria + "'");
			conexion.resultadoDB.next();
			int id = conexion.resultadoDB.getInt("idcategoria");
			conexion.resultadoDB.close();
			conexion.desconectar();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

	public boolean insertarTienda(int idtienda, String nombretienda) {
		try {
			Conexion conexion = new Conexion();
			String query = "INSERT INTO tienda (idtienda, nombretienda) VALUES (" + idtienda + ", '" + nombretienda
					+ "') on conflict(idtienda) do update set nombretienda = '" + nombretienda + "'";
			conexion.ejecutar(query);
			conexion.desconectar();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertarProducto(String idproducto, String nombreproducto, int idcategoria) {
		try {
			Conexion conexion = new Conexion();
			String query = "INSERT INTO producto (idproducto,nombreproducto,idcategoria) VALUES (" + idproducto + ", '"
					+ nombreproducto + "', " + idcategoria
					+ ") on conflict(idproducto) do update set nombreproducto = '" + nombreproducto + "', idcategoria="
					+ idcategoria + "";
			conexion.ejecutar(query);
			conexion.desconectar();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertarProductoTienda(String producto_idproducto, int tienda_idtienda, double precioproducto) {
		try {
			Conexion conexion = new Conexion();
			String query = "INSERT INTO producto_tienda (producto_idproducto, tienda_idtienda, precioproducto) VALUES ("
					+ producto_idproducto + ", '" + tienda_idtienda + "', " + precioproducto
					+ ") on conflict(producto_idproducto,tienda_idtienda) do update set precioproducto = "
					+ precioproducto + "";
			conexion.ejecutar(query);
			conexion.desconectar();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
