insert into customer_entity (id,id_customer,first_name,last_name) values (1,1000,'Jean','DUPONT');
insert into customer_entity (id,id_customer,first_name,last_name) values (2,1001,'Pierre','LEMAITRE');

insert into product_entity (id,num_product,name,price) values (1,1000,'Tasse',100);
insert into product_entity (id,num_product,name,price) values (2,1001,'Assiette',200);
insert into product_entity (id,num_product,name,price) values (3,1002,'Couteau',33);

insert into order_entity (id,num_order,date_order,customer_entity_id) values (1,1000,'2022-04-11 10:00:00',1);
insert into order_entity (id,num_order,date_order,customer_entity_id) values (2,1001,'2022-04-17 10:00:00',2);
insert into order_entity (id,num_order,date_order,customer_entity_id) values (3,1002,'2024-06-11 10:00:00',1);

insert into order_product_entity (id_order_product,order_entity_id,quantity,product_id) values (1,1,2,1);
insert into order_product_entity (id_order_product,order_entity_id,quantity,product_id) values (2,1,3,3);
insert into order_product_entity (id_order_product,order_entity_id,quantity,product_id) values (3,2,4,3);
insert into order_product_entity (id_order_product,order_entity_id,quantity,product_id) values (4,3,5,3);
