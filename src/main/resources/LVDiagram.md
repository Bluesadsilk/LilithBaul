# Diagrama Entidad-Relación (ERD) en Mermaid LilithVault

```mermaid
erDiagram
    CLIENTE {
        Integer id
        varchar(9) nif
        varchar nombre
        varchar apellido
        varchar email
        varchar dirLine1
        varchar dirLine2
        varchar telefono
    }

    ORDERS {
        bigint id PK
        date fecha
        decimal total
        bigint cliente_id
    }

    PRODUCTS {
        int id
        varchar nombre
        text descripcion
        decimal precio
        int cantidad
        varchar(4) talla
    }

    ORDER_LINE {
        bigint id
        int cantidad
        decimal precio_unitario
        bigint ORDERS_id
        bigint PRODUCTSo_id
    }

     BILLS  {
        bigint id
        int cantidad
        decimal precio_unitario
        bigint ORDERS_id
        bigint PRODUCTSo_id
    }

    CLIENTE ||--o{ ORDERS : "realiza"
    ORDERS ||--|{ ORDER_LINE : "contiene"
    ORDER_LINE }o--|| PRODUCTS : "incluye"
