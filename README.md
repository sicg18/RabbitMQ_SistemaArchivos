# RabbitMQ_SistemaArchivos

## Ejecución:

- Inicialmente ejecutar el docker-compose que contiene rabbit y su configuración (Este docker-compose es el mismo usado en clase, también fue subido al repositorio en caso tal de ser necesitado)

-- Ejecutar docker-compose: docker-compose up.


- Ejecución del proyecto productorRMQ

-- **Trabajado en Windows, en las rutas para el archivo(Main) / ó \\ adecuar según sistema operativo.**

-- El proyecto debe contar con las librerias necesarias, las cuales se encuentran en la carpeta recursos.Libreria, todas las librerías deben estar en el classpath del proyecto, paso seguido se ejecuta con la clase main la cual cuenta con la ruta del archivo csv del cual saldrán los registros que irán por bloques a la cola en este caso en la carpeta recursos.Csv_Archivo se encuentran diferentes archivos con diferentes tamaños por defecto uno de 10 registros, después de seleccionar el archivo con el cual se quiera ejecutar, se cuenta con el tamaño de bloques que se desea tener, si en caso tal se dejan por defecto tanto el archivo csv y el tamaño del bloque, sólo un bloque iría a la cola (10/10=1, 10/5=2...), al ejecutar el proyecto los registros irán a la cola.

- Ejecución del proyecto consumidorRMQ

-- Ejecutar el script de la base de datos, este se encuentra en recursos.Bd_Script **IMPORTANTE: Crear siempre la clave unica de nombrecategoria para el correcto funcionamiento de la aplicación**.

-- **Trabajado en Windows, en las rutas(Conexión y Main) / ó \\ adecuar según sistema operativo.**

-- El proyecto debe contar con las librerias necesarias, las cuales se encuentran en la carpeta recursos.Libreria, todas las librerías deben estar en el classpath del proyecto,
cambiar la información de la clase conexión en la variable connectString poner el nombre de la base de datos jdbc:postgresql://localhost:[Puerto]//[Nombre_BD], en la variable user, insertar el nombre del usuario al igual que la contraseña, insertar la contraseña del usuario, paso seguido se ejecuta la clase Main donde el consumidor, consumirá lo almacenado en la cola de rabbit y el lector se encargará de dividir la información y almacenarla en la tabla correspondiente (Tal como se hizo en el primer proyecto, sólo que la información ya se encuentra en rabbbit).

## Información:

- IDE Eclipse (Entorno usado en el primer proyecto)
- Java (No se uso sprint boot)

#### Extra:

- Velocidad de procesamiento, es relativa a la cantidad de registros que se consumirán.

- Consulta para listar todos los registros con sus características
SELECT p.idproducto,p.nombreproducto,pt.precioproducto,c.nombrecategoria,t.idtienda,t.nombretienda from categoria c join producto p on c.idcategoria = p.idcategoria join producto_tienda pt on pt.producto_idproducto = p.idproducto join tienda t on t.idtienda = pt.tienda_idtienda;



