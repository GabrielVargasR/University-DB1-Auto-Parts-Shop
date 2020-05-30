CREATE VIEW vClienteOrganizacion AS
	SELECT c.id, o.cedula, c.nombre, GetTelefono(o.cedula) AS telefono, c.direccion, c.ciudad, c.estado, o.tel_contacto
    FROM (cliente AS c INNER JOIN organizacion AS o ON c.id = o.id_cliente);