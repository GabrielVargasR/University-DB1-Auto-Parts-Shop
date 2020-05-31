CREATE VIEW vClientePersona AS
	SELECT c.id, p.cedula, c.nombre, p.telefono, c.direccion, c.ciudad, c.estado
    FROM (cliente AS c INNER JOIN persona AS p ON c.id = p.id_cliente)