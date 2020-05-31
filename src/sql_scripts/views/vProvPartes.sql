CREATE VIEW vProvPartes AS
	SELECT p.id, p.nombre, m.nombre AS marcaP, pv.id AS idProv, pv.nombre AS nombreProv, pv.direccion, pv.ciudad, pv.contacto, GetTelProveedor(pv.id) AS telefono
    FROM parte AS p, proveedor AS pv, marca_parte AS m
    WHERE p.marca = m.id AND
		  (p.id, pv.id) IN (SELECT pp.id_parte, pp.id_proveedor
							FROM provee_parte AS pp);
                            