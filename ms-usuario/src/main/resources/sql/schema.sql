CREATE TABLE IF NOT EXISTS Endereco
(
    idEndereco
    SERIAL,
    estado
    varchar
(
    30
),
    cidade varchar
(
    30
),
    rua varchar
(
    29
),
    numCasa int,
    PRIMARY KEY
(
    idEndereco
)
    );

CREATE TABLE IF NOT EXISTS Usuario
(
    cpf
    varchar
(
    11
),
    nome varchar
(
    255
),
    idEndereco int,
    saldoPontos float,
    email citext not null unique,
    senha varchar
(
    255
),
    tipo TINYTEXT,
    PRIMARY KEY
(
    cpf
),
    FOREIGN KEY
(
    idEndereco
) REFERENCES Endereco
(
    idEndereco
)
    );

CREATE TABLE IF NOT EXISTS Compra
(
    idCompra
    SERIAL,
    cpf
    varchar
(
    11
),
    valor float,
    qtdPontos int,
    dtCompra date,
    PRIMARY KEY
(
    idCompra
),
    FOREIGN KEY
(
    cpf
) REFERENCES Usuario
(
    cpf
)
    );
CREATE TABLE IF NOT EXISTS Historico
(
    idTransacoes
    SERIAL,
    cpf
    varchar
(
    11
),
    descricao varchar
(
    255
),
    tipoTransacao varchar
(
    255
),
    dtTransacao date,
    valor float,
    PRIMARY KEY
(
    idTransacoes
),
    FOREIGN KEY
(
    cpf
) REFERENCES Usuario
(
    cpf
)
    );