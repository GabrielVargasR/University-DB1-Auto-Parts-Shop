DELIMITER //

	CREATE FUNCTION GetIDProveedor(
		pNombre VARCHAR(50)
    )
		RETURNS INT
        DETERMINISTIC
        
        BEGIN
			DECLARE id_proveedor INT;
            
			SELECT p.id
            INTO id_proveedor
            FROM proveedor as p
            WHERE p.nombre = pNombre;
            
            RETURN(id_proveedor);
        END//
DELIMITER ;