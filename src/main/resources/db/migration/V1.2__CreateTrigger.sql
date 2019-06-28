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
    