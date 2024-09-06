INSERT INTO categories (categoryName) VALUES ("Rings");

INSERT INTO categories (category_name) VALUES ('Necklaces');

INSERT INTO categories (category_name) VALUES ('Pendants');

INSERT INTO
    subcategories (category_id, subcategory_name)
VALUES (1, 'Gold Rings');

INSERT INTO
    subcategories (category_id, subcategory_name)
VALUES (1, 'Silver Rings');

INSERT INTO
    subcategories (category_id, subcategory_name)
VALUES (2, 'Gold Necklaces');

INSERT INTO
    subcategories (category_id, subcategory_name)
VALUES (2, 'Silver Necklaces');

INSERT INTO
    subcategories (category_id, subcategory_name)
VALUES (3, 'Gold Pendants');

INSERT INTO
    subcategories (category_id, subcategory_name)
VALUES (3, 'Silver Pendants');

INSERT INTO
    products (
        product_description,
        product_name,
        category_id,
        subcategory_id,
        product_image_link
    )
VALUES (
        'un anillo de Oro',
        'Anillo de Oro',
        1,
        1,
        'https://m.media-amazon.com/images/I/61sub4Q9y4L._AC_SY395_.jpg'
    );

INSERT INTO
    products (
        product_description,
        product_name,
        category_id,
        subcategory_id,
        product_image_link
    )
VALUES (
        'un anillo de Plata',
        'Anillo de Plata',
        1,
        2,
        'https://cdn-media.glamira.com/media/product/newgeneration/view/1/sku/GWD210000/alloycolour/white/width/w4/profile/prA/surface/polished.jpg'
    );

INSERT INTO
    products (
        product_description,
        product_name,
        category_id,
        subcategory_id,
        product_image_link
    )
VALUES (
        'un Collar de Oro',
        'Collar de Oro',
        2,
        3,
        'https://m.media-amazon.com/images/I/610o36uJiIL._AC_SY395_.jpg'
    );

INSERT INTO
    products (
        product_description,
        product_name,
        category_id,
        subcategory_id,
        product_image_link
    )
VALUES (
        'un Collar de Plata',
        'Collar de Plata',
        2,
        4,
        'https://m.media-amazon.com/images/I/71-zZxtxwwL._AC_SX522_.jpg'
    );

INSERT INTO
    products (
        product_description,
        product_name,
        category_id,
        subcategory_id,
        product_image_link
    )
VALUES (
        'un Pendiente de Oro',
        'Pendiente de Oro',
        3,
        5,
        'https://lepetitemarie.com/cdn/shop/files/pendientes-glase-pendientes-lepetitemarie-386384.jpg?v=1720346565&width=1000'
    );

INSERT INTO
    products (
        product_description,
        product_name,
        category_id,
        subcategory_id,
        product_image_link
    )
VALUES (
        'un Pendiente de Plata',
        'Pendiente de Plata',
        3,
        6,
        'https://lepetitemarie.com/cdn/shop/files/E1041S.jpg?v=1715828159&width=1000'
    );

SET @categoryIdRings = LAST_INSERT_ID();

SET @categoryIdNecklaces = LAST_INSERT_ID();

SET @categoryIdPendants = LAST_INSERT_ID();