DELIMITER //
DROP PROCEDURE IF EXISTS ReadOrganizaciones;
CREATE PROCEDURE ReadOrganizaciones()
BEGIN
	SELECT v.id, v.cedula, v.nombre, v.telefono, v.direccion, v.ciudad, v.estado, v.tel_contacto
    FROM vclienteorganizacion AS v;
END //

DELIMITER ;