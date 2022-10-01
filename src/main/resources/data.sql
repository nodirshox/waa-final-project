/* ADMIN AND OWNER */
INSERT INTO users (id, created_at, email, name, type) values (1001, current_timestamp, 'admin@gmail.com', 'Admin', 0);
INSERT INTO users (id, created_at, email, name, type) values (1002, current_timestamp, 'owner@gmail.com', 'Owner', 1);

/* 10 CUSTOMERS */
INSERT INTO users (id, created_at, email, name, type) values (2001, current_timestamp, 'customer@gmail.com', 'Customer', 2);
INSERT INTO users (id, created_at, email, name, type) values (2002, current_timestamp, 'customer2@gmail.com', 'Customer2', 2);
INSERT INTO users (id, created_at, email, name, type) values (2003, current_timestamp, 'customer3@gmail.com', 'Customer3', 2);
INSERT INTO users (id, created_at, email, name, type) values (2004, current_timestamp, 'customer4@gmail.com', 'Customer4', 2);
INSERT INTO users (id, created_at, email, name, type) values (2005, current_timestamp, 'customer5@gmail.com', 'Customer5', 2);
INSERT INTO users (id, created_at, email, name, type) values (2006, current_timestamp, 'customer6@gmail.com', 'Customer6', 2);
INSERT INTO users (id, created_at, email, name, type) values (2007, current_timestamp, 'customer7@gmail.com', 'Customer7', 2);
INSERT INTO users (id, created_at, email, name, type) values (2008, current_timestamp, 'customer8@gmail.com', 'Customer8', 2);
INSERT INTO users (id, created_at, email, name, type) values (2009, current_timestamp, 'customer9@gmail.com', 'Customer9', 2);
INSERT INTO users (id, created_at, email, name, type) values (2010, current_timestamp, 'customer10@gmail.com', 'Customer10', 2);

/* ADDRESS */
INSERT INTO address (id, city, state, street, zip) values (1001, 'Miami', 'FL', '4505 Sabal Palm Rd', '33137');
INSERT INTO address (id, city, state, street, zip) values (1002, 'Miami', 'FL', '4901 SW 98th Avenue Rd', '33165');
INSERT INTO address (id, city, state, street, zip) values (1003, 'San Francisco', 'CA', '4438 17th St', '94114');

/* PROPERTY */
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (1001, 999, 3, 0, 0, 1, 1001, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (1002, 699, 2, 1, 1, 0, 1002, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (1003, 599, 4, 2, 2, 1, 1003, 1002);

/* 10 RENTED PROPERTIES */
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2001, 599, 4, 2, 0, 0, 1001, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2002, 699, 3, 2, 1, 1, 1002, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2003, 299, 1, 2, 2, 0, 1003, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2004, 599, 4, 2, 0, 0, 1001, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2005, 699, 3, 2, 1, 1, 1002, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2006, 299, 1, 2, 2, 0, 1003, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2007, 599, 4, 2, 0, 0, 1001, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2008, 699, 3, 2, 1, 1, 1002, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2009, 299, 1, 2, 2, 0, 1003, 1002);
INSERT INTO property (id, price, number_of_rooms, status, type, listing_Type, address_id, owner_id) values (2010, 299, 1, 2, 2, 0, 1003, 1002);

/* PICTURES */
INSERT INTO picture (id, aws_url, type, property_id) values (1001, 'https://waa-project.s3.amazonaws.com/1664543431763-1.jpg', 1, 1001);
INSERT INTO picture (id, aws_url, type, property_id) values (1002, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 0, 1001);
INSERT INTO picture (id, aws_url, type, property_id) values (1003, 'https://waa-project.s3.amazonaws.com/1664547737669-3.jpg', 0, 1001);
INSERT INTO picture (id, aws_url, type, property_id) values (1004, 'https://waa-project.s3.amazonaws.com/1664547767171-4.jpg', 0, 1001);
INSERT INTO picture (id, aws_url, type, property_id) values (1005, 'https://waa-project.s3.amazonaws.com/1664547800085-5.jpg', 0, 1001);

INSERT INTO picture (id, aws_url, type, property_id) values (1006, 'https://waa-project.s3.amazonaws.com/1664547767171-4.jpg', 1, 1002);
INSERT INTO picture (id, aws_url, type, property_id) values (1007, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 0, 1002);
INSERT INTO picture (id, aws_url, type, property_id) values (1008, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 1, 1003);

INSERT INTO picture (id, aws_url, type, property_id) values (1009, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 1, 2001);
INSERT INTO picture (id, aws_url, type, property_id) values (1010, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 1, 2002);
INSERT INTO picture (id, aws_url, type, property_id) values (1011, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 1, 2003);
INSERT INTO picture (id, aws_url, type, property_id) values (1012, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 1, 2004);
INSERT INTO picture (id, aws_url, type, property_id) values (1013, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 1, 2005);
INSERT INTO picture (id, aws_url, type, property_id) values (1014, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 1, 2006);
INSERT INTO picture (id, aws_url, type, property_id) values (1015, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 1, 2007);
INSERT INTO picture (id, aws_url, type, property_id) values (1016, 'https://waa-project.s3.amazonaws.com/1664543468022-2.jpg', 1, 2008);

/* USER FAVOURITES PROPERTIES */
INSERT INTO users_favourite_properties(users_id, favourite_properties_id) values (2001, 1002);
INSERT INTO users_favourite_properties(users_id, favourite_properties_id) values (2001, 1003);
