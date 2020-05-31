DELIMITER //

CREATE PROCEDURE ReadProveedores(
	IN pNombreParte VARCHAR(30),
    IN pMarcaParte VARCHAR(30)
)

BEGIN
	SELECT v.idProv, v.nombreProv, v.direccion, v.ciudad, v.telefono, v.contacto
    FROM vProvPartes AS v
    WHERE v.nombre = pNombreParte AND
		  v.marcaP = pMarcaParte;
END //

DELIMITER ;