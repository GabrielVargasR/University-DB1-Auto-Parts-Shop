DELIMITER //

CREATE PROCEDURE AssocParteProvedor(
	IN pIdParte       INT,
    IN pIdProveedor   INT,
    IN pPrecioProv    DECIMAL(12,2),
    IN pPrecioCliente DECIMAL(12,2)
)

BEGIN
	INSERT INTO provee_parte(id_parte, id_proveedor, precio_proveedor, precio_cliente) VALUES (pIdParte, pIdProveedor, pPrecioProv, pPrecioCliente);
END //
DELIMITER ;