CREATE TABLE service_orders (
    id bigint not null auto_increment,
    client_id bigint not null,
    description text not null,
    price decimal(10, 2) not null,
    status varchar(20) not null,
    open_date datetime not null,
    close_date datetime,

    primary key (id)
);

ALTER TABLE service_orders ADD CONSTRAINT service_orders_client_fk
FOREIGN KEY (client_id) REFERENCES clients (id);