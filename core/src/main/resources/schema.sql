CREATE TABLE IF NOT EXISTS category_table (
    id int NOT NULL AUTO_INCREMENT,
    category varchar(255) NOT NULL,
    time_stamp varchar(255),
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS product_table (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    code varchar(255),
    description varchar(255),
    photo LONGBLOB,
    date bigint,
    company varchar(255),
    time_stamp varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product_categories_table (
    id int NOT NULL AUTO_INCREMENT,
    product_id int NOT NULL,
    categories TEXT,
    time_stamp varchar(255),
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES product_table(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS stock_table (
    id int NOT NULL AUTO_INCREMENT,
    product_id int NOT NULL,
    date bigint,
    date_of_payment bigint,
    validity bigint,
    quantity int,
    purchase_price float,
    sale_price float,
    is_paid boolean,
    time_stamp varchar(255),
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES product_table (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS customer_table (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    photo LONGBLOB,
    email varchar(255),
    address varchar(255),
    phone_number varchar(255),
    time_stamp varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sale_table (
    id int NOT NULL AUTO_INCREMENT,
    product_id int NOT NULL,
    stock_id int NOT NULL,
    customer_id int NOT NULL,
    quantity int,
    purchase_price float,
    sale_price float,
    delivery_price float,
    date_of_sale bigint,
    date_of_payment bigint,
    shipping_date bigint,
    delivery_date bigint,
    is_ordered_by_customer boolean,
    is_paid_by_customer boolean,
    delivered boolean,
    canceled boolean,
    time_stamp varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS catalog_table (
    id int NOT NULL AUTO_INCREMENT,
    product_id int NOT NULL,
    title TEXT,
    description TEXT,
    discount int,
    price float,
    time_stamp varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
    id int NOT NULL AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	photo LONGBLOB,
	role VARCHAR(50) NOT NULL,
	enabled TINYINT(4) NOT NULL DEFAULT 1,
	time_stamp varchar(255),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS version (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    time_stamp varchar(255),
    PRIMARY KEY (id)
);
