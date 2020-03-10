use test;

create table province(
                         id int auto_increment key,
                         name varchar(20)
);

create table city(
                     id int auto_increment key,
                     name varchar(20),
                     pid int,
                     constraint fk_city_prov foreign key(pid) references province(id)
);

