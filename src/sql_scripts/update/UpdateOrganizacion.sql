DELIMITER //

DROP PROCEDURE IF EXISTS UpdateOrganizacion//
CREATE PROCEDURE UpdateOrganizacion(
	IN pCedula DECIMAL(10,0),
	IN pNombre VARCHAR(80),
    IN pDireccion VARCHAR(100),
    IN pCiudad VARCHAR(20),
    IN pTelefono DECIMAL(8,0), 
    IN pNombreContacto VARCHAR(40),
    IN pTelefonoContacto DECIMAL(8,0),
    IN pCargoContacto VARCHAR(25)
)

BEGIN
	DECLARE idOrg INT;
    
    SELECT o.id_cliente
    INTO idOrg
    FROM organizacion as o
    WHERE o.cedula = pCedula;
    
    CALL UpdateCliente(idOrg, pNombre, pDireccion, pCiudad);
	INSERT IGNORE INTO contacto(nombre, telefono, cargo) VALUES (pNombreContacto, pTelefonoContacto, pCargoContacto);
    
	UPDATE organizacion
    SET tel_contacto = pTelefonoContacto
    WHERE cedula = pCedula;
    
    CALL UpdateContacto(pNombreContacto, pTelefonoContacto, pCargoContacto);
    
    INSERT IGNORE INTO telefonos_organizacion (cedula_juridica, telefono) VALUES(pCedula, pTelefono);
END //

DELIMITER ;