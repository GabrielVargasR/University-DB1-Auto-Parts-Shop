DELIMITER //

CREATE PROCEDURE InsertContacto (
	IN pNombre VARCHAR(40),
    IN pTelefono DECIMAL(8,0),
    IN pCargo VARCHAR(25)
)
BEGIN
	INSERT INTO contacto(nombre, telefono, cargo) VALUES (pNombre, pTelefono, pCargo);
END //

DELIMITER ;