INSERT INTO
    categories (categoryName)
VALUES
    category_name ("Rings");

SET @categoryIdRings = LAST_INSERT_ID();

INSERT INTO CATEGORIES (categoryName) VALUES ('Necklaces');

SET @categoryIdNecklaces = LAST_INSERT_ID();

INSERT INTO CATEGORIES (categoryName) VALUES ('Bracelets');

SET @categoryIdBracelets = LAST_INSERT_ID();