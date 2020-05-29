DELIMITER //

CREATE PROCEDURE InsertPersona (
	IN pCedula DECIMAL(9, 0),
    IN pTelefono DECIMAL(8,0),
    IN pIdCliente INT
)
BEGIN
	INSERT INTO persona(cedula, telefono, id_cliente) VALUES (pCedula, pTelefono, pIdCliente);
END //

DELIMITER ;