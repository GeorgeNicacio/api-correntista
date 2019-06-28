-- TABLES -----------------------------
CREATE TABLE correntista (
    idCorrentista integer NOT NULL IDENTITY(1, 1),
    nome varchar(255),
    dataCriacao datetime DEFAULT GETDATE(),
    saldoFinanceiro float
    PRIMARY KEY CLUSTERED (idCorrentista)
);

CREATE TABLE movimentacao (
    idMovimentacao  integer NOT NULL IDENTITY(1, 1),
    tipoMovimentacao CHAR(1),
    dataCriacao datetime DEFAULT GETDATE(),
    valor float,
    idCorrentista  integer NOT NULL ,
    CONSTRAINT PK_mov PRIMARY KEY NONCLUSTERED (idMovimentacao),
    CONSTRAINT FK_Correntista_Movimentacao FOREIGN KEY (idCorrentista)     
    REFERENCES correntista (idCorrentista)     
    ON DELETE CASCADE    
    ON UPDATE CASCADE    
);

    