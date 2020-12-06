create database bdlibertas;
use bdlibertas;

create table medicamentos (
	id int not null auto_increment,
    nome varchar(50) not null,
    marca varchar (30) not null ,
    quantidade int not null,
    data_fabricacao date not null,
    data_validade  date not null,
    preco double,
    primary key (id)
);
    