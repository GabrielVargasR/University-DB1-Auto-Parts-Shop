DELIMITER //

DROP PROCEDURE IF EXISTS CreateDetalle//
CREATE PROCEDURE CreateDetalle(
	IN pConsOrden INT,
    IN pNombreParte VARCHAR(30),
    IN pMarcaParte VARCHAR(50),
    IN pNombreProveedor VARCHAR(50), 
    IN pCantidad SMALLINT,
    OUT estado INT
)

BEGIN
    
    DECLARE var_id_parte, var_id_proveedor, prov_check INT;
    
    SET var_id_parte = GetIDParte(pNombreParte, pMarcaParte);
    SET var_id_proveedor = GetIDProveedor(pNombreProveedor);
    
    SELECT p.id_proveedor
    INTO prov_check
    FROM provee_parte as p
    WHERE p.id_parte = var_id_parte AND p.id_proveedor = var_id_proveedor;
    
	IF (prov_check IS NOT NULL) THEN
		INSERT INTO detalle_orden(consecutivo_orden, id_parte, id_proveedor, cantidad) VALUES (pConsOrden, var_id_parte, var_id_proveedor, pCantidad);
        SET estado = 0;
	ELSE
		SET estado = 1;
    END IF;
END //

DELIMITER ;