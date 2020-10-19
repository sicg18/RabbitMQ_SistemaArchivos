# RabbitMQ_SistemaArchivos

## Ejecuci�n:

- Inicialmente ejecutar el docker-compose que contiene rabbit y su configuraci�n (Este docker-compose es el mismo usado en clase, tambi�n fue subido al repositorio en caso tal de ser necesitado)

-- Ejecutar docker-compose: docker-compose up.


- Ejecuci�n del proyecto productorRMQ

-- **Trabajado en Windows, en las rutas para el archivo(Main) / � \\ adecuar seg�n sistema operativo.**

-- El proyecto debe contar con las librerias necesarias, las cuales se encuentran en la carpeta recursos.Libreria, todas las librer�as deben estar en el classpath del proyecto, paso seguido se ejecuta con la clase main la cual cuenta con la ruta del archivo csv del cual saldr�n los registros que ir�n por bloques a la cola en este caso en la carpeta recursos.Csv_Archivo se encuentran diferentes archivos con diferentes tama�os por defecto uno de 10 registros, despu�s de seleccionar el archivo con el cual se quiera ejecutar, se cuenta con el tama�o de bloques que se desea tener, si en caso tal se dejan por defecto tanto el archivo csv y el tama�o del bloque, s�lo un bloque ir�a a la cola (10/10=1, 10/5=2...), al ejecutar el proyecto los registros ir�n a la cola.

- Ejecuci�n del proyecto consumidorRMQ

-- Ejecutar el script de la base de datos, este se encuentra en recursos.Bd_Script **IMPORTANTE: Crear siempre la clave unica de nombrecategoria para el correcto funcionamiento de la aplicaci�n**.

-- **Trabajado en Windows, en las rutas(Conexi�n y Main) / � \\ adecuar seg�n sistema operativo.**

-- El proyecto debe contar con las librerias necesarias, las cuales se encuentran en la carpeta recursos.Libreria, todas las librer�as deben estar en el classpath del proyecto,
cambiar la informaci�n de la clase conexi�n en la variable connectString poner el nombre de la base de datos jdbc:postgresql://localhost:[Puerto]//[Nombre_BD], en la variable user, insertar el nombre del usuario al igual que la contrase�a, insertar la contrase�a del usuario, paso seguido se ejecuta la clase Main donde el consumidor, consumir� lo almacenado en la cola de rabbit y el lector se encargar� de dividir la informaci�n y almacenarla en la tabla correspondiente (Tal como se hizo en el primer proyecto, s�lo que la informaci�n ya se encuentra en rabbbit).

## Informaci�n:

- IDE Eclipse (Entorno usado en el primer proyecto)
- Java (No se uso sprint boot)

#### Extra:

- Velocidad de procesamiento, es relativa a la cantidad de registros que se consumir�n.

- Consulta para listar todos los registros con sus caracter�sticas
SELECT p.idproducto,p.nombreproducto,pt.precioproducto,c.nombrecategoria,t.idtienda,t.nombretienda from categoria c join producto p on c.idcategoria = p.idcategoria join producto_tienda pt on pt.producto_idproducto = p.idproducto join tienda t on t.idtienda = pt.tienda_idtienda;



