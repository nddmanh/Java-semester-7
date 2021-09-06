INSERT INTO book(name, author, price) VALUES ("toi thay hoa vang tren co xanh","manh", 1000); 
INSERT INTO bookitem (bookid, name, quantity, price, publisher, discount) VALUES (LAST_INSERT_ID(), "toi thay hoa vang tren co xanh" , 123, 1200, "kim dong", "20%");

INSERT INTO book(name, author, price) VALUES ("thang nam ruc ro","To Hoai", 1100); 
INSERT INTO bookitem (bookid, name, quantity, price, publisher, discount) VALUES (LAST_INSERT_ID(), "thang nam ruc ro" , 100, 1400, "kim dong", "30%");

INSERT INTO book(name, author, price) VALUES ("de men phieu luu ky","To Hoai", 1900); 
INSERT INTO bookitem (bookid, name, quantity, price, publisher, discount) VALUES (LAST_INSERT_ID(), "thang nam ruc ro" , 100, 2400, "kim dong", "10%");