-- table product 
create table product(
    id int primary key not null, 
    product_name varchar(50),
    price numeric(10,2), 
    creation_datetime timestamp
); 

-- table product_category
create table product_category(
    id int primary key not null, 
    product_category_name varchar(50),
    product_id int, 
    constraint fk_product foreign key (product_id) references product(id)
);