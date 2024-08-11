```mermaid
erDiagram
    CLIENTS {
        Integer id PK
        varchar(12) nif 
        varchar(30) name
        varchar(30) last_Name 
        varchar(30) email 
        varchar(30) dir_Line_1 
        varchar(30) dir_Line_2 
        varchar(20) phoneNumber 
    }

    PROVIDERS {
        Integer id PK
        varchar(12) cif 
        varchar(30) name
        varchar(30) last_Name 
        varchar(30) email 
        varchar(30) dir_Line_1 
        varchar(30) dir_Line_2 
        varchar(20) phoneNumber 
    }

    BILLS {
        bigint id PK
        bigint entity_id FK
        varchar(10) entity_type "CLIENT or PROVIDER"
        bigint order_id FK
        float total_amount
        varchar(30) link_Bill_Image
        date bill_Date
    }

    MOVEMENTS {
        bigint id PK
        bigint bill_id FK
        varchar(30) concept
        float amount
        date date
        varchar(10) type "INCOME or EXPENSE"
    }

    ORDERS {
        bigint id PK
        Integer cliente_id FK
        date order_Date
        varchar(10) estado
        varchar(30) dirLine1
        varchar(30) dirline2
    }

    PRODUCTS {
        int id PK
        varchar(30) nombre
        varchar(50) descripcion
        float precio
        int cantidad
    }

    SIZES {
        bigint id PK
        varchar(2) name
        int product_id FK
        int amount
    }

    ORDER_LINE {
        bigint id PK
        int cantidad
        decimal precio_unitario
        bigint ORDERS_id FK
        bigint PRODUCTSo_id FK
    }

    CLIENTS ||--o{ ORDERS : "realiza"
    PROVIDERS ||--o{ BILLS : "emite"
    CLIENTS ||--o{ BILLS : "recibe"
    ORDERS ||--|| BILLS : "reflejan"
    ORDERS ||--|{ ORDER_LINE : "contienen"
    PRODUCTS ||--|{ SIZES : "se divide"
    ORDER_LINE }o--|| PRODUCTS : "incluyen"
    BILLS ||--|| MOVEMENTS : "refleja"
