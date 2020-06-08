DELIMITER //

DROP PROCEDURE IF EXISTS UpdateContacto//
CREATE PROCEDURE UpdateContacto(
	IN pNombreContacto VARCHAR(40),
    IN pTelefonoContacto DECIMAL(8,0),
    IN pCargoContacto VARCHAR(25)
    )
	BEGIN
		UPDATE contacto
        SET nombre = pNombreContacto, cargo = pCargoContacto
        WHERE telefono = pTelefonoContacto;
    END//
DELIMITER ;