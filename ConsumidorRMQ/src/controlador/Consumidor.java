package controlador;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumidor {

	private final static String NOMBRE_COLA = "tienda";
	
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel ;
	private Lector l;
	
	public Consumidor(String host) {
		l = new Lector();
		factory = new ConnectionFactory();
		factory.setHost(host);
		
		try {
			connection = factory.newConnection();

			channel = connection.createChannel();
			
			channel.queueDeclare(NOMBRE_COLA, false, false, false, null);
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void consumir() {
		try {
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				String message = new String(delivery.getBody(), "UTF-8");
				ObjectMapper objectMapper = new ObjectMapper();
				String[] inventarioList = objectMapper.readValue(message, String[].class);
				
				l.leerArchivos(inventarioList);
			};
			channel.basicConsume(NOMBRE_COLA, true, deliverCallback, consumerTag -> {
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
