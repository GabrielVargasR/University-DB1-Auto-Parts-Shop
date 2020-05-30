DELIMITER //

CREATE PROCEDURE UpdatePreciosProveedor(
	IN pIdParte       INT,
    IN pIdProveedor   INT,
    IN pPrecioProv    DECIMAL(12,2),
    IN pPrecioCliente DECIMAL(12,2)
)

BEGIN
	UPDATE provee_parte
    SET precio_proveedor = pPrecioProv, precio_cliente = pPrecioCliente
    WHERE id_parte = pIdParte AND id_proveedor = pIdProveedor;
END //
DELIMITER ;