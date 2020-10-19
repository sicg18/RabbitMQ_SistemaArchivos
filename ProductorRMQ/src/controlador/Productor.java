package controlador;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

public class Productor {
	
	private final static String NOMBRE_COLA = "tienda";
	
    private String[] registros;
	
	public Productor() {
		
	}
	
    public Productor(String[] registros) {
    	this.registros = registros;
    }
	
    
    public void encolador(Channel channel)  {
    	ObjectMapper objectMapper = new ObjectMapper();
    	
		try {
			String bloque = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(registros);
				
			
				channel.queueDeclare(NOMBRE_COLA, false, false, false, null);
				channel.basicPublish("", NOMBRE_COLA, null, bloque.getBytes());

		} catch (IOException e) {
				e.printStackTrace();
		}
    }
    
}
