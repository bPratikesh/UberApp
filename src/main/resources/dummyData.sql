INSERT INTO app_user(name, email, password) VALUES
('Pratikesh Borade', 'pratikeshb2@gmail.com', 'password'),
('Rahul Sharma', 'rahul.sharma@example.com', 'password123'),
('Priya Singh', 'priya.singh@example.com', 'securepass'),
('Amit Patel', 'amit.patel@example.com', 'mypassword'),
('Neha Gupta', 'neha.gupta@example.com', 'pass1234'),
('Vikram Rao', 'vikram.rao@example.com', 'password567'),
('Anita Menon', 'anita.menon@example.com', 'secure123'),
('Rohit Mehta', 'rohit.mehta@example.com', 'password890'),
('Sonal Joshi', 'sonal.joshi@example.com', 'pass4567'),
('Deepak Kumar', 'deepak.kumar@example.com', 'mypassword123'),
('Pooja Reddy', 'pooja.reddy@example.com', 'securepass1'),
('Arjun Desai', 'arjun.desai@example.com', 'password111'),
('Ritika Verma', 'ritika.verma@example.com', 'pass7890'),
('Karan Malhotra', 'karan.malhotra@example.com', 'mypassword234'),
('Sneha Iyer', 'sneha.iyer@example.com', 'securepass2'),
('Siddharth Naik', 'siddharth.naik@example.com', 'password222'),
('Aishwarya Pillai', 'aishwarya.pillai@example.com', 'pass5678'),
('Manish Kapoor', 'manish.kapoor@example.com', 'mypassword345'),
('Komal Bhatia', 'komal.bhatia@example.com', 'securepass3'),
('Tarun Chauhan', 'tarun.chauhan@example.com', 'password333'),
('Meera Kulkarni', 'meera.kulkarni@example.com', 'pass6789');


INSERT INTO user_roles(user_id, roles) VALUES
(1, 'RIDER'),
(2, 'RIDER'),
(2, 'DRIVER'),
(3, 'RIDER'),
(3, 'DRIVER'),
(4, 'RIDER'),
(4, 'DRIVER'),
(5, 'RIDER'),
(5, 'DRIVER'),
(6, 'RIDER'),
(6, 'DRIVER'),
(7, 'RIDER'),
(7, 'DRIVER'),
(8, 'RIDER'),
(8, 'DRIVER'),
(9, 'RIDER'),
(9, 'DRIVER'),
(10, 'RIDER'),
(10, 'DRIVER'),
(11, 'RIDER'),
(11, 'DRIVER'),
(12, 'RIDER'),
(12, 'DRIVER'),
(13, 'RIDER'),
(13, 'DRIVER'),
(14, 'RIDER'),
(14, 'DRIVER'),
(15, 'RIDER'),
(15, 'DRIVER'),
(16, 'RIDER'),
(16, 'DRIVER'),
(17, 'RIDER'),
(17, 'DRIVER'),
(18, 'RIDER'),
(18, 'DRIVER'),
(19, 'RIDER'),
(19, 'DRIVER'),
(20, 'RIDER'),
(20, 'DRIVER');



INSERT INTO rider(user_id, rating) VALUES
(1, 4.9);


INSERT INTO driver(user_id, rating, available, current_location) VALUES
(2, 4.7, true, ST_GeomFromText('POINT(73.1150 19.0130)', 4326)),
(3, 4.5, true, ST_GeomFromText('POINT(73.1152 19.0132)', 4326)),
(4, 4.6, true, ST_GeomFromText('POINT(73.1148 19.0136)', 4326)),
(5, 4.8, true, ST_GeomFromText('POINT(73.1151 19.0129)', 4326)),
(6, 4.9, true, ST_GeomFromText('POINT(73.1149 19.0133)', 4326)),
(7, 4.4, true, ST_GeomFromText('POINT(73.1153 19.0134)', 4326)),
(8, 4.3, true, ST_GeomFromText('POINT(73.1154 19.0131)', 4326)),
(9, 4.5, true, ST_GeomFromText('POINT(73.1155 19.0135)', 4326)),
(10, 4.6, true, ST_GeomFromText('POINT(73.1156 19.0132)', 4326)),
(11, 4.7, true, ST_GeomFromText('POINT(73.1157 19.0133)', 4326)),
(12, 4.8, true, ST_GeomFromText('POINT(73.1158 19.0134)', 4326)),
(13, 4.9, true, ST_GeomFromText('POINT(73.1159 19.0131)', 4326)),
(14, 4.4, true, ST_GeomFromText('POINT(73.1160 19.0132)', 4326)),
(15, 4.3, true, ST_GeomFromText('POINT(73.1161 19.0133)', 4326)),
(16, 4.5, true, ST_GeomFromText('POINT(73.1162 19.0134)', 4326)),
(17, 4.6, true, ST_GeomFromText('POINT(73.1163 19.0130)', 4326)),
(18, 4.7, true, ST_GeomFromText('POINT(73.1164 19.0132)', 4326)),
(19, 4.8, true, ST_GeomFromText('POINT(73.1165 19.0131)', 4326)),
(20, 4.9, true, ST_GeomFromText('POINT(73.1166 19.0133)', 4326));


INSERT INTO wallet (user_id, balance) VALUES
(1,100),
(2,500);




