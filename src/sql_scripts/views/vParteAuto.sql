CREATE VIEW vParteAuto AS
	SELECT p.id, p.nombre, m.nombre AS marcaP, a.modelo, a.año
    FROM automovil AS a, parte AS p, marca_parte as m
    WHERE p.marca = m.id AND
		  (a.id, p.id) IN (SELECT id_auto, id_parte
						   FROM parteautomovil);