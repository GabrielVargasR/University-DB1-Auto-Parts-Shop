DELIMITER //

CREATE PROCEDURE CreateDetalle(
	IN pConsOrden INT,
    IN pIdParte INT, 
    IN pIdProveedor INT, 
    IN pCantidad SMALLINT
)

BEGIN
	INSERT INTO detalle_orden(consecutivo_orden, id_parte, id_proveedor, cantidad) VALUES (pConsOrden, pIdParte, pIdProveedor, pCantidad);
END //

DELIMITER ;