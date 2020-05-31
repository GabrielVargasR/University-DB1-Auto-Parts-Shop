DELIMITER //

CREATE PROCEDURE ReadPartesAuto(
	IN pModelo VARCHAR(15),
    IN pAño DECIMAL(4, 0)
)

BEGIN
	SELECT v.id, v.nombre, v.marcaP
    FROM vParteAuto as v
	WHERE v.modelo = pModelo AND
		  v.año = pAño;
END //

DELIMITER ;