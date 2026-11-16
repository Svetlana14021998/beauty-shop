create table procedures(
    id bigserial,
    procedure_type varchar(100),
    procedure_name varchar (150),
    price integer,
    duration integer,
    photo_name varchar(50),
    primary key (id)
);