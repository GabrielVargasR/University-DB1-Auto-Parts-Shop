DELIMITER //

CREATE FUNCTION GetTelefono(
	cedJuridica DECIMAL(10, 0)
)
	RETURNS DECIMAL(8,0)
    DETERMINISTIC
    
    BEGIN
		DECLARE telefono DECIMAL(8,0);
    
		SELECT t.telefono
        INTO telefono
        FROM telefonos_organizacion AS t
        WHERE t.cedula_juridica = cedJuridica
        LIMIT 1;
        
        RETURN(telefono);
    END //

DELIMITER ;