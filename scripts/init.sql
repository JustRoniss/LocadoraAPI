CREATE TABLE IF NOT EXISTS filme (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    diretor VARCHAR(255) NOT NULL,
    ano_de_lancamento DATE NOT NULL,
    valor_diaria  DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS serie (
     id UUID PRIMARY KEY,
     nome VARCHAR(255) NOT NULL,
     diretor VARCHAR(255) NOT NULL,
     ano_de_lancamento DATE NOT NULL,
     valor_diaria  DECIMAL(10, 2) NOT NULL
)

