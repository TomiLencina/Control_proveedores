*** Proyecto desarrollado para el final de la materia APP MOVILES ***

A continuacion presentare mi trabajo construido en Andoid Studio con java, utilizando SQLite como base de datos.

El sistema desarrollado esta pensando para ser la parte que gestiona las compras a proveedores dentro de una empresa, 
el principal objetivo es que solo los usuarios autorizados puedan realizar pedidos a proveedores y que estos queden en curso para posteriormente concretar la compra.

De esta forma se tendra control de los pedidos solicitados, los pedidos seran agrupados por rubro, por orden de llegada y seran almacenados en 
la base de datos.
Para que luego cuando el pedido lo recepte el area correspondiente y aprueben la compra, se concrete el pedido.

En este desarrollo veremos la vista del login el cual sera la primer pantalla de la app, en caso de no estar registrado tambien estara disponible la opcion para registrar a un nuevo usuario.
Una vez logeado los users estos tendran acceso a un MENU para poder Actualizar,Eliminar su cuenta. Desde el menu tambien se podra REGISTRAR a un nuevo usuario, o cerrar la sesion.
Ademas dentro del menu se podra observar una lista con todas las cuentas que iniciaron sesion para coordinar una compra.

Una vez logeado el usuario vera la vista de INICIO desde la cual se podra solicitar compras a proveedores, completando los campos "Rurbo,Proyecto,Producto,Cantidad" es necesario completar todos
los campos para poder completar la misma de lo contrario no se podra agendar el pedido...
Dentro de esta misma vista tambien el usuario podra observar sus pedidos en curso que aun no han sido aprobados. En caso de necesitar eliminar o actualizar un pedido lo prodra realizar.



Es una app sencilla la cual permite hacer CRUD en sus dos tablas, que son "Usuario" y "Proveedores". 
La tabla usuario registrara la informacion de la cuenta, la cual permitira realizar el crud por medio del menu de la app.
La tabla proveedores se ira completando cada vez que se agregue un pedido, tambien se podra ver los pedidos, eliminar o actualizar.
Cabe aclarar que cada usuario tendra acceso unicamente a ver/actualizar o eliminar solo sus propios pedidos, ya que el sistema por medio del ID del usuario filtra esta info por cliente.
A diferencia del historial de sesiones activas que todos los user podran ver esta informacion.

Archivo zip:


