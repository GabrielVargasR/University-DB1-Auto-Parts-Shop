DELIMITER //

DROP PROCEDURE IF EXISTS InsertOrganizacion//
CREATE PROCEDURE InsertOrganizacion (
	IN pCedula DECIMAL(10, 0),
    IN pTelefono DECIMAL(8,0),
    IN pNombreContacto VARCHAR(40),
    IN pTelefonoContacto DECIMAL(8,0),
    IN pCargoContacto VARCHAR(25),
    IN pIdCliente INT
)
BEGIN
	
    DECLARE cont DECIMAL(8, 0);
    
    SELECT c.telefono
		INTO cont
        FROM contacto as c
        WHERE c.telefono = pTelefonoContacto;
        
	IF (cont IS NULL) THEN
		CALL InsertContacto(pNombreContacto, pTelefonoContacto, pCargoContacto);
	END IF;
    
	INSERT INTO organizacion(cedula, id_cliente, tel_contacto) VALUES (pCedula, pIdCliente, pTelefonoContacto);
    CALL InsertTelOrganizacion(pCedula, pTelefono);
END //

DELIMITER ;