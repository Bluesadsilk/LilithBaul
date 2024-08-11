# Diagrama Entidad-Relación (ERD) en Mermaid LilithVault

```mermaid
erDiagram
    CLIENTS {
        Integer id
        varchar(12) nif 
        varchar(30) \_name\_ 
        varchar(30) lastName 
        varchar(30) email 
        varchar(30) dirLine1 
        varchar(30) dirLine2 
        varchar(20) phoneNumber 
    }

    ORDERS {
        bigint id PK
        date fecha
        decimal total
        Integer cliente_id
    }

    PRODUCTS {
        int id PK
        varchar(30) nombre
        varchar(50) descripcion
        float precio
        int cantidad
    }

    SIZES{
        bigint id
        varchar(2) name
        int product_id FK
        int amount

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

    CLIENTS ||--o{ ORDERS : "realiza"
    ORDERS ||--|{ ORDER_LINE : "contiene"
    ORDER_LINE }o--|| PRODUCTS : "incluye"
