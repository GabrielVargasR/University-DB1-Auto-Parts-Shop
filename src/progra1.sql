DROP DATABASE IF EXISTS progra1;
CREATE DATABASE progra1;

USE progra1;

CREATE TABLE cliente (
	id DECIMAL(9) NOT NULL,
	nombre VARCHAR(40),
    direccion VARCHAR(100),
    ciudad VARCHAR(20),
    estado DECIMAL(1) NOT NULL DEFAULT 0,
    
    PRIMARY KEY(id)
);

CREATE TABLE persona (
	cedula decimal(9) NOT NULL,
    telefono VARCHAR(8),
    id_cliente DECIMAL(9) NOT NULL,
    
    PRIMARY KEY(cedula),
    CONSTRAINT fk_id_persona FOREIGN KEY(id_cliente) REFERENCES cliente(id)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE contacto (
	nombre VARCHAR(40),
    telefono DECIMAL(8) NOT NULL,
    cargo VARCHAR(25),
    
    PRIMARY KEY(telefono)
);

CREATE TABLE organizacion (
	cedula DECIMAL(10) NOT NULL, 
    id_cliente DECIMAL(9) NOT NULL, 
    tel_contacto DECIMAL(8) NOT NULL,
    
    PRIMARY KEY(cedula),
    UNIQUE (id_cliente),
    CONSTRAINT fk_id_cliente_organizacion FOREIGN KEY(id_cliente) REFERENCES cliente(id)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_contacto_organizacion FOREIGN KEY(tel_contacto) REFERENCES contacto(telefono)
		ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE telefonos_organizacion (
	cedula_juridica DECIMAL(10) NOT NULL,
    telefono DECIMAL(8) NOT NULL,
    
    PRIMARY KEY(cedula_juridica, telefono),
    UNIQUE(telefono),
    CONSTRAINT fk_cedula_tel_org FOREIGN KEY(cedula_juridica) REFERENCES organizacion(cedula)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE fabricante_automovil (
	id DECIMAL(6) NOT NULL,
    nombre VARCHAR(15) NOT NULL,
    
    PRIMARY KEY(id),
    UNIQUE(nombre)
);

CREATE TABLE automovil (
	id DECIMAL(8) NOT NULL,
    modelo VARCHAR(15) NOT NULL,
    año DECIMAL(4) NOT NULL,
    detalle VARCHAR(20),
    id_fabricante DECIMAL(6) NOT NULL,
    
    PRIMARY KEY(id),
    UNIQUE(modelo, año),
    CONSTRAINT fk_fabricante_auto FOREIGN KEY(id_fabricante) REFERENCES fabricante_automovil(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

CREATE TABLE fabricante_parte (
	id DECIMAL(8) NOT NULL,
    nombre VARCHAR(15) NOT NULL,
    
    PRIMARY KEY(id),
    UNIQUE(nombre)
);

CREATE TABLE parte (
	id DECIMAL(8) NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    marca VARCHAR(15) NOT NULL,
    id_automovil DECIMAL(8) NOT NULL, 
    id_fabricante_parte DECIMAL(8) NOT NULL, 
    
    PRIMARY KEY(id),
    UNIQUE (nombre, marca),
    CONSTRAINT fk_automovil_parte FOREIGN KEY(id_automovil) REFERENCES automovil(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
    CONSTRAINT fk_fabricante_parte_parte FOREIGN KEY(id_fabricante_parte) REFERENCES fabricante_parte(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

CREATE TABLE orden (
	consecutivo DECIMAL (10) NOT NULL,
    fecha DATETIME NOT NULL,
    monto DECIMAL (12, 2) NOT NULL DEFAULT(0),
    id_cliente DECIMAL(9) NOT NULL,
    
    PRIMARY KEY(consecutivo),
    UNIQUE(fecha, monto, id_cliente),
    CONSTRAINT fk_id_cliente_orden FOREIGN KEY(id_cliente) REFERENCES cliente(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

CREATE TABLE proveedor (
	id DECIMAL(10) NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    ciudad VARCHAR(20),
    contacto VARCHAR(40),
    
    PRIMARY KEY(id),
    UNIQUE(nombre, direccion)
);

CREATE TABLE telefonos_proveedor (
	id_proveedor DECIMAL(10) NOT NULL,
    telefono DECIMAL(8) NOT NULL,
    
    PRIMARY KEY(id_proveedor, telefono),
    UNIQUE(telefono),
    CONSTRAINT fk_id_proveedor_tel_prov FOREIGN KEY(id_proveedor) REFERENCES proveedor(id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE detalle_orden (
	consecutivo_detalle DECIMAL(15) NOT NULL,
    consecutivo_orden DECIMAL(10) NOT NULL,
    id_proveedor DECIMAL(10) NOT NULL,
    id_parte DECIMAL(8) NOT NULL,
    cantidad SMALLINT DEFAULT(1),
    
    PRIMARY KEY(consecutivo_detalle, consecutivo_orden),
    UNIQUE(consecutivo_orden, id_parte, id_proveedor),
    CONSTRAINT fk_cons_orden_detalle FOREIGN KEY(consecutivo_orden) REFERENCES orden(consecutivo)
		ON DELETE RESTRICT
        ON UPDATE RESTRICT,
    CONSTRAINT fk_id_proveedor_detalle FOREIGN KEY(id_proveedor) REFERENCES proveedor(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_id_parte_detalle FOREIGN KEY(id_parte) REFERENCES parte(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE provee_parte (
	id_parte DECIMAL(8) NOT NULL,
    id_proveedor DECIMAL(8) NOT NULL,
    precio_proveedor DECIMAL(12, 2) NOT NULL,
    precio_cliente DECIMAL(12, 2) NOT NULL,
    
    PRIMARY KEY(id_parte, id_proveedor),
    CONSTRAINT fk_parte_prov_parte FOREIGN KEY(id_parte) references parte(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_proveedor_prov_parte FOREIGN KEY(id_proveedor) references proveedor(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE provee (
	id_proveedor DECIMAL(8) NOT NULL,
    consecutivo_detalle DECIMAL(15) NOT NULL,
    consecutivo_orden DECIMAL(10) NOT NULL,
    
    PRIMARY KEY(id_proveedor, consecutivo_detalle),
    CONSTRAINT fk_proveedor_provee FOREIGN KEY(id_proveedor) references proveedor(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_orden_provee FOREIGN KEY(consecutivo_detalle, consecutivo_orden) 
		references detalle_orden(consecutivo_detalle, consecutivo_orden)
			ON DELETE RESTRICT
			ON UPDATE RESTRICT
);