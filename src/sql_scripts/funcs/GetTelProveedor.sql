DELIMITER //

CREATE FUNCTION GetTelProveedor(
	idProv INT
)
RETURNS DECIMAL(8,0)
DETERMINISTIC

BEGIN
	DECLARE telefono DECIMAL(8,0);
    
	SELECT t.telefono
	INTO telefono
	FROM telefonos_proveedor AS t
	WHERE t.id_proveedor = idProv
	LIMIT 1;
	
	RETURN(telefono);
END //    
    
DELIMITER ;