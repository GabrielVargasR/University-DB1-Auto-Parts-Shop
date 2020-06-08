DELIMITER //

DROP PROCEDURE IF EXISTS CreateDetalle//
CREATE PROCEDURE CreateDetalle(
	IN pConsOrden INT,
    IN pIdParte INT, 
    IN pIdProveedor INT, 
    IN pCantidad SMALLINT,
    OUT estado INT
)

BEGIN
	DECLARE id_proveedor INT;
    
    SELECT p.id_proveedor
    INTO id_proveedor
    FROM provee_parte as p
    WHERE p.id_parte = pIdParte AND p.id_proveedor = pIdProveedor;
    
	IF (id_proveedor IS NOT NULL) THEN
		INSERT INTO detalle_orden(consecutivo_orden, id_parte, id_proveedor, cantidad) VALUES (pConsOrden, pIdParte, pIdProveedor, pCantidad);
        SET estado = 0;
	ELSE
		SET estado = 1;
    END IF;
END //

DELIMITER ;