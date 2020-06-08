DELIMITER //

DROP FUNCTION IF EXISTS GetIDAuto//
CREATE FUNCTION GetIDAuto (
	pModelo VARCHAR(15),
    pAnno DECIMAL(4,0)
)
	RETURNS INT
    DETERMINISTIC
    
    BEGIN
		DECLARE id_auto INT;
        
        SELECT a.id
        INTO id_auto
        FROM automovil as a
        WHERE a.modelo = pModelo AND a.año = pAnno;
        
        RETURN(id_auto);
    END //
DELIMITER ;