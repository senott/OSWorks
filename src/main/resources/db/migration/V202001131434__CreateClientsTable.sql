create table clients (
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(255) not null,
    phone varchar(20) not null,

    primary key(id)
);