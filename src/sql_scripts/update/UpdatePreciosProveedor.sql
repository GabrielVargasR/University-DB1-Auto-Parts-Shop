DELIMITER //

DROP PROCEDURE IF EXISTS UpdatePreciosProveedor//
CREATE PROCEDURE UpdatePreciosProveedor(
	IN pNombreParte      VARCHAR(30),
    IN pMarcaParte       VARCHAR(50),
    IN pNombreProveedor  VARCHAR(50),
    IN pPrecioProv       DECIMAL(12,2),
    IN pPorcentaje    DECIMAL(3,2)
)

BEGIN
	DECLARE var_id_parte, var_id_proveedor INT;
	SET var_id_parte = GetIDParte(pNombreParte, pMarcaParte);
    SET var_id_proveedor = GetIDProveedor(pNombreProveedor);

	UPDATE provee_parte
    SET precio_proveedor = pPrecioProv, porcentaje_ganancia = pPorcentaje
    WHERE id_parte = var_id_parte AND id_proveedor = var_id_proveedor;
END //
DELIMITER ;