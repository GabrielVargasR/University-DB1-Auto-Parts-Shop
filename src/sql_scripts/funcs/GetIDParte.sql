DELIMITER //

DROP FUNCTION IF EXISTS GetIDParte//
CREATE FUNCTION GetIDParte(
	pNombre VARCHAR(30),
    pMarca VARCHAR(50)
)
	RETURNS INT
    DETERMINISTIC
    
    BEGIN
		DECLARE id_marca, id_parte INT;
        
        SELECT m.id
        INTO id_marca
        FROM marca_parte as m
        WHERE m.nombre = pMarca;
        
        SELECT p.id
		INTO id_parte
        FROM parte as p
        WHERE p.nombre = pNombre AND p.marca = id_marca;
        
        RETURN(id_parte);
    END//
DELIMITER ;