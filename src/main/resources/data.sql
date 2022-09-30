INSERT INTO address (id, city, state, street, zip) values (1001, 'Miami', 'FL', '4505 Sabal Palm Rd', '33137');
INSERT INTO address (id, city, state, street, zip) values (1002, 'Miami', 'FL', '4901 SW 98th Avenue Rd', '33165');
INSERT INTO address (id, city, state, street, zip) values (1003, 'San Francisco', 'CA', '4438 17th St', '94114');

INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id) values (1001, 999, 3, 0, 0, 1, 1001);

INSERT INTO picture (id, aws_url, type, property_id) values (1001, 'https://waa-project.s3.amazonaws.com/1664543431763-1.jpg', 1, 1001);
INSERT INTO picture (id, aws_url, type, property_id) values (1002, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 0, 1001);
INSERT INTO picture (id, aws_url, type, property_id) values (1003, 'https://waa-project.s3.amazonaws.com/1664547737669-3.jpg', 0, 1001);
INSERT INTO picture (id, aws_url, type, property_id) values (1004, 'https://waa-project.s3.amazonaws.com/1664547767171-4.jpg', 0, 1001);
INSERT INTO picture (id, aws_url, type, property_id) values (1005, 'https://waa-project.s3.amazonaws.com/1664547800085-5.jpg', 0, 1001);
