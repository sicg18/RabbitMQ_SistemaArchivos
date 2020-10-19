package controlador;


import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Convertidor {


	private int tamano_bloque = 1;

	private int residuo = 0;

	private String[] lista;

	public Convertidor(int tamano_bloque, String[] lista) {
		residuo = (int) Math.floor(lista.length % tamano_bloque);
		this.tamano_bloque = tamano_bloque;
		this.lista = lista;
	}

	public void dividirRegistro() {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			
		    int chunks = lista.length / tamano_bloque;
		    int remaining = lista.length % tamano_bloque;
			
			for (int c = 0; c < chunks; c++) {
				var p = new Productor(Arrays.copyOfRange(lista, c * tamano_bloque, (c + 1) * tamano_bloque));
				p.encolador(channel);
			}
			if (remaining > 0) {
				var p = new Productor(Arrays.copyOfRange(lista, lista.length-residuo, lista.length));
				p.encolador(channel);
			}
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
