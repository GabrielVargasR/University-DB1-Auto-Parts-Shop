DELIMITER //

CREATE PROCEDURE InsertParte (
	IN pNombre VARCHAR(30),
    IN pMarca VARCHAR(50),
    IN pNombreFabricante VARCHAR(50)
)

BEGIN
	DECLARE vId_fabricante, vId_marca INT;
            
	SELECT f.id
		INTO vId_fabricante
        FROM fabricante_parte as f
        WHERE f.nombre = pNombreFabricante
		LIMIT 1;
	
    SELECT m.id
		INTO vId_marca
        FROM marca_parte as m
        WHERE m.nombre = pMarca
		LIMIT 1;
        
	INSERT INTO parte (nombre, marca, id_fabricante_parte) VALUES (pNombre, vId_marca, vId_fabricante);

END //

DELIMITER ;
