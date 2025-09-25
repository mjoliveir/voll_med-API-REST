CREATE TABLE pacientes(
    id bigint not null auto_increment,
    nome VARCHAR(100) not null,
    telefone varchar(15) not null unique,
    cpf varchar(11) not null unique,
    email varchar(20) unique,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    primary key(id)
);