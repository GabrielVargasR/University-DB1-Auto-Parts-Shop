DELIMITER //

CREATE PROCEDURE ReadPersonas()
BEGIN
	SELECT v.id, v.cedula, v.nombre, v.telefono, v.direccion, v.ciudad, v.estado
    FROM vClientePersona AS v;
END //

DELIMITER ;