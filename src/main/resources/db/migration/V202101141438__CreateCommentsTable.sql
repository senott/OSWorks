CREATE TABLE comments (
    id bigint not null auto_increment,
    service_order_id bigint not null,
    description text not null,
    sent_date datetime not null,

    primary key (id)
);

ALTER TABLE comments ADD CONSTRAINT comments_service_orders_fk
FOREIGN KEY (service_order_id) REFERENCES service_orders (id);