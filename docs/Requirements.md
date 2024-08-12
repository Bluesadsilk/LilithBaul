# Contexto y Requisitos

El cliente El Baul de Lilith(PYME) necesita que desarrollen una aplicación interna para el control de su tienda de bisutería artesanal. Sus principales canales de venta son Instagram y la venta física en mercadillos. En un futuro cercano desea añadir dos e-commerce, uno en Etsy y otro en su página Web (Wordpress) a través de un plugin de WooCommerce. Necesita de una aplicación que le permita gestionar su inventario interno y que más adelante se conecte con una API que desarrollara en su WooCommerce y a través de la API de Etsy. También quiere tener una pequeña BBDD con los datos de sus clientes y proveedores, que a su vez también permita guardar las facturas de ambos para poder mantener un control de ingresos y gastos y su balance, lo que le facilitará los trámites trimestrales con Hacienda. En un futuro cercano con la implementación de las tiendas online y cuando se le haga un pedido via Instagram necesitará gestionar los pedidos y envios a través de la aplicación derivando en varios estados de pedidos. A su vez cuando se ejecute una venta ya sea en etsy o en la woocommerce se ha de actualizar el inventario de la base de datos, y por consecuencia crear un pedido y una factura del pedido a nombre del cliente.

La aplicación se usará principalmente en móvil y Macbook, por lo que la primera versión de la App se desarrollará en nativo.

A tener en cuenta:

1. La Api de Etsy solo permite 10k querys diarias por cliente.


# Funcionalidades:

## 1. Gestión de inventario.

    El inventario se basa en productos. Los productos son de una talla obligatoriamente. Las tallas son fijas (S,M,L,XL o Talla Unica). Los productos se clasifican internamente por una id. Los Atributos de los productos son: ID, nombre, precio, cantidad, link(imagen), categoria y talla. Los productos se dividen en categorias que constaran de una ID interna y un nombre.

    - Añadir producto.
    - Editar producto.
    - Borrar producto.
    - Crear categoria.
    - Editar categoria.
    - Borrar categoria.
    - Consultar los productos.

    ??? Crear una tabla intermedia con los ID de los productos de etsy para que se correspondan con los locales.

## 2. Control de facturas.

        Nuestro cliente desea poder subir al servidor donde se aloja el contenedor también los pdfs de las facturas ya sean de proveedores o de clientes. Por lo que se guardarán en la base de datos con los siguientes atributos: Id factura, Tipo Factura, Fecha de la factura, precio-amount, link del pdf-imagen y clave ajena del id de cliente o proveedor.

        - Añadir factura de proveedor
        - Las facturas de clientes deben añadirse automáticamente una vez se genere el pedido.
        - Descargar factura por diferentes criterios (proveedorID, clienteID, fecha anual,trimestral, mensual y semanal).
        - Eliminar facturas.
  
        ??? Las facturas tienen una especialización por la cual
         se identifican como facturas de proveedores o facturas a
          clientes.
        Dependiendo de su tipo afectan al balance de forma negativa o positiva. Por lo que es necesario la creación de una tabla de Balance o Movimientos donde se guardará la id del movimiento el tipo y el amount.

## 3. Base de Datos de Clientes y Proveedores.

        Se desean guardar los datos de proveedores y clientes para facilitar la tributación y tener un control geográfico de los pedidos que se realizan. Los atributos de los clientes son clientId, NIF, Nombre, Apellido, Linea Dirección 1, Linea Dirección 2, email, número de teléfono. Para los proveedores el NIF se sutituirá por CIF y el clientID por providerID.

        - Añadir cliente.
        - Editar cliente.
        - Eliminar cliente.
        - Añadir proveedor.
        - Editar proveedor.
        - Eliminar proveedor.
        - Consultar proveedores.
        - Consultar clientes.
       
         ??? Se creará un cliente de nombre Varios para poder 
         ejecutar cualquier pedido sin necesidad de registrarlo, 
         por lo que los movimientos que se realicen en efectivo 
         en mercadillos o espacios físicos podrán asociarse a 
         movimientos de caja facilitando la tributación de estos.

## 5. Gestión de Pedidos.

        El cliente desea poder gestionar los pedidos para facilitar su elaboración y envio.
        Los pedidos cuentas con los siguientes atributos: orderId, fechaPedido, Linea Dir 1, Linea Dir 2, clientId, Nif, Name, LastName.

        - Crear pedido.
        - Empezar pedido.(Activa el pedido para ponerlo en proceso)
        - Gestionar pedido.(Una vez el pedido esta empezado pasara al siguiente estado con esta funcionalidad)
        - Finalizar pedido.
        - Consultar pedidos pendientes.
        - Consultar pedidos en proceso
        - Consultar pedidos finalizados.
  
        ??? Estados del pedido (Pedido Confirmado {PC}, pedido en proceso {PP}, Recogida Pendiente {RP}, Pedido Enviado {PE}, Pedido Recibido {PR});

## 6. Movimientos de Caja.

        Durante los mercadillos o spot de venta físicos se desea que la aplicación pueda actuar como POS (Point Of Sale)
        por lo que nuestro cliente podrá desde esta funcionalidad crear el pedido en estado finalizado y la factura del cliente a nombre de varios en el momento. Si desea cobrar con tarjeta se hará con un servicio externo ajeno con una TPV portátil y si factura en efectivo ninguno de estas dos modalidase serán necesario especeficiarlas.

        Los movimientos de caja no se registrarán como tal por lo que se reflejarán como movimientos a través de una factuara por lo que no es necesario crear una tabla de movimientos de caja.

        - Crear pedido local o movimiento de caja.
        - Cobrar pedido.

    ??? Posibilidad de crear algun tipo de cierre de caja o registar los movimientos del dia para poder efectuarlo.

## 7. Conexión con WooCommerce y Etsy´s Place. 

        Poder automatizar la gestión de pedidos y el inventario a través de la conexión con estas APIs.

      - Automatizar los cambios del inventario, ya sea por venta local u online a través de nuestra API actualice en las demás plataformas.
      - Creación de pedidos automática y notificación a través de email y alerta nativa.
      - Creación de clientes y facturas automáticas al recibir el pedido.

## 8. Data Analysis.

        Se desea añadir algún tipo de tecnológia sea o similar a 
        Microsoft PowerBi que le permitan al cliente obtener los 
        datos necesarios para mejorar la calidad de su servicio y 
        enfoque al  realizar estudios de mercados con estos datos.
