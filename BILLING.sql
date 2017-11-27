-- USE billing;
CREATE TABLE IF NOT EXISTS customer(
	id INT(6),
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(20),
    email_id VARCHAR(30),
    phone_number INT(10) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE IF NOT EXISTS company(
	id INT(4),
    name VARCHAR(30) NOT NULL,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE IF NOT EXISTS supplier(
	id INT(4),
    name VARCHAR(30) NOT NULL,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE IF NOT EXISTS product(
	id INT(4) PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    type VARCHAR(20) NOT NULL,
    company_id INT(4) NOT NULL,
    FOREIGN KEY(company_id) REFERENCES company(id)
);
CREATE TABLE IF NOT EXISTS item(
	id INT(7) PRIMARY KEY,
	product_id INT(4) NOT NULL,
	quantity INT(4) NOT NULL,
	quantity_parameter VARCHAR(4) NOT NULL,
	price INT(10) NOT NULL,
	supplier_id INT(4) NOT NULL,
	company_id INT(4) NOT NULL,
	FOREIGN KEY(product_id) REFERENCES product(id),
    FOREIGN KEY(supplier_id) REFERENCES supplier(id),
    FOREIGN KEY(company_id) REFERENCES company(id)
);
CREATE TABLE IF NOT EXISTS cutomer_bill_mapping(
	bill_id INT(10) PRIMARY KEY,
    customer_id INT(6) NOT NULL,
    time DATETIME NOT NULL,
    FOREIGN KEY(customer_id) REFERENCES customer(id)
);
CREATE TABLE IF NOT EXISTS billing_details(
	bill_id INT(10) NOT NULL,
    item_id INT(7) NOT NULL,
    quantity INT(3) NOT NULL,
    FOREIGN KEY(bill_id) REFERENCES cutomer_bill_mapping(bill_id),
    FOREIGN KEY(item_id) REFERENCES item(id),
    PRIMARY KEY(bill_id, item_id)
);