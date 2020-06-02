DELIMITER //

CREATE PROCEDURE InsertTelOrganizacion (
	IN pCedula DECIMAL(10, 0),
    IN pTelefono DECIMAL(8,0)
)
BEGIN
	INSERT INTO telefonos_organizacion(cedula_juridica, telefono) VALUES (pCedula, pTelefono);
END //

DELIMITER ;