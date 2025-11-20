-- Create database for our project
CREATE DATABASE presyong_ka_piyu;
USE presyong_ka_piyu;

-- ============================================
-- USER LOGIN TABLE
-- ============================================
CREATE TABLE user_login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(15) UNIQUE,   -- Username must be unique para iwas duplicate user
    password_ VARCHAR(255) NOT NULL  -- For future hashing, mas mataas length
);

-- ============================================
-- SHOPS TABLE
-- ============================================
CREATE TABLE shops (
    shop_id INT AUTO_INCREMENT PRIMARY KEY,
    shop_name VARCHAR(100) NOT NULL UNIQUE  -- Unique shop names para walang duplicate
);

-- ============================================
-- MENU ITEMS TABLE
-- ============================================
CREATE TABLE menu_items (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL CHECK (price > 0), -- Prevent negative values
    location VARCHAR(100),
    shop_id INT NOT NULL,
    
    FOREIGN KEY (shop_id) REFERENCES shops(shop_id)
    ON DELETE CASCADE     -- If shop is deleted, delete menu of that shop
    ON UPDATE CASCADE      -- If shop_id changes, update menu too
);

-- ============================================
-- SAMPLE DATA INSERTS
-- ============================================
INSERT INTO user_login (username, password_)
VALUES 
('Conel', 'pogiako123'),
('Ortega', 'pogiako123'),
('Sumague', 'pogiako123'),
('Beltran', 'pogiako123');

INSERT INTO shops (shop_name)
VALUES 
('Pastilan ni Kuya Tilpas'),
('Siomai ni Ger'),
('Pares ni Kumares');

INSERT INTO menu_items (item_name, price, shop_id, location)
VALUES
('CHICKEN PASTIL', 35, 1, 'Sa Harap ng Gate 2'),
('SPICY CHICKEN PASTIL', 40, 1, 'Sa Harap ng Gate 2'),
('PORK SIOMAI (4pcs.)', 20, 2, 'Sa tabi ng Gate 2'),
('BEEF SIOMAI (4pcs.)', 25, 2, 'Sa tabi ng Gate 2'),
('BEEF PARES (no rice)', 25, 3, 'Sa kabilang kanto'),
('BEEF PARES (with rice)', 35, 3, 'Sa kabilang kanto');

-- ============================================
-- SIMPLE LOGIN QUERY (For backend use)
-- DO NOT USE DIRECTLY WITH USER INPUT (vulnerable to SQL injection)
-- ============================================
SELECT * 
FROM user_login 
WHERE username = '(username)' 
AND password_ = '(password)';

-- ============================================
-- SELECT MENU PER SHOP (Example lng)
-- ============================================
SELECT 
    m.item_id,
    m.item_name,
    m.price,
    m.location,
    s.shop_name
FROM menu_items m
JOIN shops s ON m.shop_id = s.shop_id
WHERE m.shop_id = 3;

-- ============================================
-- DELETE RECORD TESTING 
-- ============================================
-- DELETE one specific menu item
DELETE FROM menu_items WHERE item_id = 1;

-- DELETE a shop + all its menu items (because of CASCADE)
DELETE FROM shops WHERE shop_id = 2;

-- DELETE a user
DELETE FROM user_login WHERE username = 'Beltran';

-- ============================================
-- DROP TABLES (last resort)(tanggalin na pala toh nakakatakot eh) 
-- ============================================