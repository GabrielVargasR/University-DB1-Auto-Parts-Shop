DELIMITER //

CREATE PROCEDURE UpdateOrganizacion(
	IN pCedula DECIMAL(10,0),
	IN pNombre VARCHAR(80),
    IN pDireccion VARCHAR(100),
    IN pCiudad VARCHAR(20),
    IN pTelefono DECIMAL(8,0), 
    IN pTelContacto DECIMAL(8,0)
)

BEGIN
	DECLARE idOrg INT;
    
    SELECT o.id_cliente
    INTO idOrg
    FROM organizacion as o
    WHERE o.cedula = pCedula;
    
    CALL UpdateCliente(idOrg, pNombre, pDireccion, pCiudad);

	UPDATE organizacion
    SET tel_contacto = pTelContacto
    WHERE cedula = pCedula;
    
    INSERT IGNORE INTO telefonos_organizacion (cedula_juridica, telefono) VALUES(pCedula, pTelefono);
END //

DELIMITER ;