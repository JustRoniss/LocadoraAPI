CREATE TABLE IF NOT EXISTS titulo (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255) NOT NULL,
    diretor VARCHAR(255) NOT NULL,
    ano_de_lancamento DATE NOT NULL,
    valor_diaria DECIMAL(10, 2) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    disponivel BOOLEAN NOT NULL,
    aluguel_id UUID,
    CONSTRAINT fk_aluguel FOREIGN KEY (aluguel_id) REFERENCES aluguel(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS aluguel (
    id UUID PRIMARY KEY,
    nome_cliente varchar(255) NOT NULL,
    id_titulo UUID NOT NULL,
    data_locacao DATE NOT NULL,
    data_devolucao DATE NOT NULL,
    valor_total DECIMAL(10, 2),
    CONSTRAINT fk_titulo FOREIGN KEY(id_titulo) REFERENCES titulo(id)
);



