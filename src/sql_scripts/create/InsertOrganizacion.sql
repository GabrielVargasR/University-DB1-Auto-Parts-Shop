DELIMITER //

CREATE PROCEDURE InsertOrganizacion (
	IN pCedula DECIMAL(10, 0),
    IN pTelefono DECIMAL(8,0),
    IN pIdCliente INT
)
BEGIN
	INSERT INTO organizacion(cedula, id_cliente, tel_contacto) VALUES (pCedula, pIdCliente, pCargo);
END //

DELIMITER ;