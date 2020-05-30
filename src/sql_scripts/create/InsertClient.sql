DELIMITER //

DROP PROCEDURE IF EXISTS InsertClient //
CREATE PROCEDURE InsertClient(
	IN pNombre VARCHAR(80),
    IN pDireccion VARCHAR(100),
    IN pCiudad VARCHAR(20),
    OUT ID INT
)
BEGIN
	INSERT INTO cliente(nombre, direccion, ciudad) VALUES (pNombre, pDireccion, pCiudad);
    SELECT c.id
		INTO ID
		FROM cliente as c
        WHERE c.nombre = pNombre AND 
			  c.direccion = pDireccion AND
              c.ciudad = pCiudad
		LIMIT 1;
END //

DELIMITER ;