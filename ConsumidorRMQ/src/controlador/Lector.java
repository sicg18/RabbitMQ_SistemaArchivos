package controlador;

public class Lector{


	public Lector() {
	}


	public  void leerArchivos(String lista[]) {
		try {
			for (String registro : lista) {
				DAO rp = new DAO();
				String[] campos = registro.split(",");
				int id = rp.insertarCategoria(campos[3]);
				rp.insertarTienda(Integer.parseInt(campos[5]), campos[6]);
				rp.insertarProducto(campos[0], campos[1], id); 
				rp.insertarProductoTienda(campos[0], Integer.parseInt(campos[5]), Double.parseDouble(campos[2]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
