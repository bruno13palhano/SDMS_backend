CREATE TABLE IF NOT EXISTS category_table (
    id int NOT NULL AUTO_INCREMENT,
    category varchar(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS product_table (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    code varchar(255),
    description varchar(255),
    photo varbinary(255),
    date bigint,
    company varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product_categories_table (
    id int NOT NULL AUTO_INCREMENT,
    product_id int NOT NULL,
    categories TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES product_table(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS stock_order_table (
)
--CREATE TABLE IF NOT EXISTS stock_order_table (
--
--);