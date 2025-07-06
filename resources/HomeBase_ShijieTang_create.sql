
-- HomeBase_Team01_create.sql
CREATE DATABASE IF NOT EXISTS HomeBaseDB;
USE HomeBaseDB;

CREATE TABLE Seller (
    seller_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(100)
);

CREATE TABLE Agent (
    agent_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(100),
    phone_number VARCHAR(20),
    number_of_homes INT
);

CREATE TABLE Home (
    home_id VARCHAR(10) PRIMARY KEY,
    address VARCHAR(100),
    bedrooms INT,
    bathrooms INT,
    size_sqft INT,
    lot_size INT,
    property_type VARCHAR(20),
    price INT
);


CREATE TABLE Client (
    client_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(100),
    phone_number VARCHAR(20),
    pref_property_type VARCHAR(20),
    price_range VARCHAR(20),
    pref_bedrooms INT,
    pref_bathrooms INT
);

CREATE TABLE Viewing (
    viewing_id VARCHAR(10) PRIMARY KEY,
    home_id VARCHAR(10),
    agent_id VARCHAR(20),
    seller_id VARCHAR(20)
    client_id VARCHAR(10),
    view_date DATE
    FOREIGN KEY (home_id) REFERENCES Home(home_id) ON DELETE CASCADE,
    FOREIGN KEY (agent_id) REFERENCES Agent(agent_id) ON DELETE CASCADE, 
    FOREIGN KEY (seller_id) REFERENCES Seller(seller_id) ON DELETE CASCADE,
    FOREIGN KEY (client_id) REFERENCES Client(client_id) ON DELETE CASCADE
);
