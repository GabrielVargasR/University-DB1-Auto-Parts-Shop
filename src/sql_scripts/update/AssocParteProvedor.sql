DELIMITER //

DROP PROCEDURE IF EXISTS AssocParteProvedor//
CREATE PROCEDURE AssocParteProvedor(
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
	
	INSERT INTO provee_parte(id_parte, id_proveedor, precio_proveedor, porcentaje_ganancia) VALUES (var_id_parte, var_id_proveedor, pPrecioProv, pPorcentaje);
END //
DELIMITER ;