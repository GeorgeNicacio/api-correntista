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

-- PROCEDURE -----------------------------
CREATE PROCEDURE _sp_ListarMovimentacao(
    @data_inicio AS datetime
    ,@data_fim AS datetime
    ,@tipo_movimentacao AS CHAR(1)
)
AS
BEGIN
    SELECT
        *
    FROM 
        movimentacao
    WHERE
        DataCriacao >= @data_inicio AND
        DataCriacao <= @data_fim    AND
        TipoMovimentacao = @tipo_movimentacao
    ORDER BY
        DataCriacao;
END;

-- GATILHO (TRIGGER) -----------------------------
CREATE TRIGGER TR_Update_SaldoFinanceiro ON movimentacao
    FOR INSERT
AS
BEGIN    
 declare @idCorrentista CHAR(1)
 declare @valor float

 IF ( (SELECT tipoMovimentacao FROM Inserted) = 'C' )
            BEGIN
                
                select @idCorrentista = idCorrentista from inserted
                select @valor = valor from inserted
                
                UPDATE correntista SET saldoFinanceiro =(saldoFinanceiro + @valor)  
                WHERE idCorrentista = @idCorrentista
            END
  ELSE
           BEGIN
                
                select @idCorrentista = idCorrentista from inserted
                select @valor = valor from inserted
                
                UPDATE correntista SET saldoFinanceiro =(saldoFinanceiro - @valor)  
                WHERE idCorrentista = @idCorrentista
            END
END;  
    