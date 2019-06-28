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
