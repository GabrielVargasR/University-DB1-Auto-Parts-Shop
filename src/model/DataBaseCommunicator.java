package model;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseCommunicator implements IConstants{
	
	private String connectionUrl;
	private String userName;
	private String password;
	
	public DataBaseCommunicator() {
		this.connectionUrl = "jdbc:mysql://localhost:3306/progra1";
		this.userName = "root";
		this.password = "vmDTNoK1&b";
	}

	// -------------------------------- CREATE -------------------------------- 
	public String insertarCliente(int pTipo, String pNombre, String pDireccion, String pCiudad, long pCedula, int pTelefono, String pNombreContacto, int pTelContacto, String pCargoContacto){
		String query = "{CALL InsertClient(?, ?, ?, ?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setString(1, pNombre);
			stmt.setString(2, pDireccion);
			stmt.setString(3, pCiudad);
			stmt.registerOutParameter(4, Types.INTEGER);
			
			stmt.execute();

			int idCliente = stmt.getInt(4);
			String message;

			if (pTipo == IConstants.PERSONA){
				message = this.insertarPersona(idCliente, pCedula, pTelefono);
			} else {
				message = this.insertarOrganizacion(idCliente, pCedula, pTelefono, pNombreContacto, pTelContacto, pCargoContacto);
			}

			stmt.close();
        	con.close();
            return message;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema con la base de datos. Intente otra vez.";
        }
	}

	private String insertarPersona(int pIdCliente, long pCedula, int pTelefono){
		String query = "{CALL InsertPersona(?, ?, ?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setLong(1, pCedula);
			stmt.setInt(2, pTelefono);
			stmt.setInt(3, pIdCliente);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Agregado con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema insertando el cliente. Intente otra vez.";
        }
	}

	private String insertarOrganizacion(int pIdCliente, long pCedula, int pTelefono, String pNombreContacto, int pTelContacto, String pCargoContacto){
		String query = "{CALL InsertOrganizacion(?, ?, ?, ?, ?, ?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setLong(1, pCedula);
			stmt.setInt(2, pTelefono);
			stmt.setString(3, pNombreContacto);
			stmt.setInt(4, pTelContacto);
			stmt.setString(5, pCargoContacto);
			stmt.setInt(6, pIdCliente);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Agregado con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema insertando el cliente. Intente otra vez.";
        }
	}

	public String insertarParte(String pNombre, String pMarca, String pNombreFacricante){
		String query = "{CALL InsertParte(?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setString(1, pNombre);
			stmt.setString(2, pMarca);
			stmt.setString(3, pNombreFacricante);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Agregada con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema insertando la parte. Intente otra vez.";
        }
	}

	public String crearOrden(int pCedula, int pTipo, Timestamp pFecha){
		String query = "{CALL InsertOrden(?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			if (pTipo == IConstants.PERSONA){
				stmt.setNull(1, Types.INTEGER);
				stmt.setInt(2, pCedula);
			} else {
				stmt.setInt(1, pCedula);
				stmt.setNull(2, Types.INTEGER);
			}

			if (pFecha != null) {
				stmt.setTimestamp(3, pFecha);
			} else stmt.setNull(3, Types.DATE);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Agregada con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema creando la orden. Intente otra vez.";
        }
	}

	// -------------------------------- READ -------------------------------- 
	public ArrayList<String[]> listarClientes(){
		ArrayList<String[]> clientes = new ArrayList<String[]>();
		clientes.addAll(this.listarPersonas());
		clientes.addAll(this.listarOrganizacion());
		return clientes;
	}

	private ArrayList<String[]> listarPersonas(){
		String query = "{CALL ReadPersonas()}";
		ResultSet rs;
		ArrayList<String[]> personas = new ArrayList<String[]>();

        try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

            rs = stmt.executeQuery();
            while (rs.next()) {
				int id = rs.getInt("id");
				long cedula = rs.getLong("cedula");
				String nombre = rs.getString("nombre");
				long telefono = rs.getLong("telefono");
				String direccion = rs.getString("direccion");
				String ciudad = rs.getString("ciudad");
				int estado = rs.getInt("estado");

                personas.add(new String[] {Integer.toString(id), Long.toString(cedula), nombre, Long.toString(telefono), direccion, ciudad, ESTADOS[estado], "n/a"});
			}

			return personas;
        } catch (SQLException ex) {
			System.out.println(ex.getMessage());
			personas.add(new String[] {"Problema conectándose a la base de datos"});
			return personas;
        }
	}

	private ArrayList<String[]> listarOrganizacion(){
		String query = "{CALL ReadOrganizaciones()}";
		ResultSet rs;
		ArrayList<String[]> organizaciones = new ArrayList<String[]>();

        try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

            rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				long cedula = rs.getLong("cedula");
				String nombre = rs.getString("nombre");
				long telefono = rs.getLong("telefono");
				String direccion = rs.getString("direccion");
				String ciudad = rs.getString("ciudad");
				int estado = rs.getInt("estado");
				long telContacto = rs.getLong("tel_contacto");

				organizaciones.add(new String[] {Integer.toString(id), Long.toString(cedula), nombre, Long.toString(telefono), 
												direccion, ciudad, ESTADOS[estado], Long.toString(telContacto)});
			}

			return organizaciones;
        } catch (SQLException ex) {
			System.out.println(ex.getMessage());
			organizaciones.add(new String[] {"Problema conectándose a la base de datos"});
			return organizaciones;
        }
	}

	public ArrayList<String[]> listarPartesAuto(String pModelo, int pAño){
		String query = "{CALL ReadPartesAuto(?,?)}";
		ResultSet rs;
		ArrayList<String[]> partes = new ArrayList<String[]>();

        try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setString(1, pModelo);
            stmt.setInt(2, pAño);

            rs = stmt.executeQuery();
            while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String marca = rs.getString("marcaP");
                partes.add(new String[] {Integer.toString(id), nombre, marca});
			}

			return partes;
        } catch (SQLException ex) {
			System.out.println(ex.getMessage());
			partes.add(new String[] {"Problema conectándose a la base de datos"});
			return partes;
        }
	}

	public ArrayList<String[]> listarProveedores(String pNombre, String pMarca){
		String query = "{CALL ReadProveedores(?,?)}";
		ResultSet rs;
		ArrayList<String[]> proveedores = new ArrayList<String[]>();

        try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setString(1, pNombre);
            stmt.setString(2, pMarca);

            rs = stmt.executeQuery();
            while (rs.next()) {
				int idProveedor = rs.getInt("idProv");
				String nombreProveedor = rs.getString("nombreProv");
				String direccion = rs.getString("direccion");
				String ciudad = rs.getString("ciudad");
				int telefono = rs.getInt("telefono");
				String nombreContacto = rs.getString("contacto");

                proveedores.add(new String[] {Integer.toString(idProveedor), nombreProveedor, direccion, ciudad, Integer.toString(telefono), nombreContacto});
			}

			return proveedores;
        } catch (SQLException ex) {
			System.out.println(ex.getMessage());
			proveedores.add(new String[] {"Problema conectándose a la base de datos"});
			return proveedores;
        }
	}

	public String[] leerOrden(int pConsecutivo){
		String query = "{CALL ReadOrden(?)}";
		ResultSet rs;
		int monto = 0;
		String nombre = "";
		java.util.Date fecha = new java.util.Date();

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setInt(1, pConsecutivo);

            rs = stmt.executeQuery();
            while (rs.next()) {
				if (nombre == "") nombre = rs.getString("nombre");
				fecha = rs.getDate("fecha");
				monto += ((rs.getInt("porcentaje") + 1)*rs.getInt("precio")*rs.getInt("cantidad"));
			}
			return new String[] {nombre, fecha.toString(), Integer.toString(monto)};

        } catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return new String[] {"Orden no encontrada"};
        }
	}

	// -------------------------------- UPDATE -------------------------------- 
	public String modificarCliente(int pTipo, String pNombre, String pDireccion, String pCiudad, long pCedula, int pTelefono, String pNombreContacto, int pTelContacto, String pCargoContacto){
		if (pTipo == IConstants.PERSONA){
			return this.modificarPersona(pNombre, pDireccion, pCiudad, pCedula, pTelefono);
		} else{
			return this.modificarOrganizacion(pNombre, pDireccion, pCiudad, pCedula, pTelefono, pNombreContacto, pTelContacto, pCargoContacto);
		}
	}

	private String modificarPersona(String pNombre, String pDireccion, String pCiudad, long pCedula, int pTelefono){
		String query = "{CALL UpdatePersona(?,?,?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setLong(1, pCedula);
			stmt.setString(2, pNombre);
			stmt.setString(3, pDireccion);
			stmt.setString(4, pCiudad);
			stmt.setInt(5, pTelefono);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Modificado con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema modificando el cliente. Intente otra vez.";
        }
	}

	private String modificarOrganizacion(String pNombre, String pDireccion, String pCiudad, long pCedula, int pTelefono, String pNombreContacto, int pTelContacto, String pCargoContacto){
		String query = "{CALL UpdateOrganizacion(?,?,?,?,?,?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setLong(1, pCedula);
			stmt.setString(2, pNombre);
			stmt.setString(3, pDireccion);
			stmt.setString(4, pCiudad);
			stmt.setInt(5, pTelefono);
			stmt.setString(6, pNombreContacto);
			stmt.setInt(7, pTelContacto);
			stmt.setString(8, pCargoContacto);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Modificado con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema modificando el cliente. Intente otra vez.";
        }
	}

	public String suspenderCliente(int pTipo, int pCedula, int pCedulaJ){
		String query = "{CALL SuspendCliente(?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			if (pTipo == IConstants.PERSONA){
				stmt.setInt(1, pCedula);
				stmt.setNull(2, Types.INTEGER);
			} else{
				stmt.setNull(1, Types.INTEGER);
				stmt.setInt(2, pCedulaJ);
			}
			

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Cliente suspendido";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema suspendiendo al cliente. Intente otra vez.";
        }
	}

	public String activarCliente(int pTipo, int pCedula, int pCedulaJ){
		String query = "{CALL ActivarCliente(?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			if (pTipo == IConstants.PERSONA){
				stmt.setInt(1, pCedula);
				stmt.setNull(2, Types.INTEGER);
			} else{
				stmt.setNull(1, Types.INTEGER);
				stmt.setInt(2, pCedulaJ);
			}
			

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Cliente activado";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema activando al cliente. Intente otra vez.";
        }
	}

	public String asociarProveedorParte(String pNombreParte, String pMarcaParte, String pNombreProveedor, float pPrecioProv, float pPorcentajeGanancia){
		String query = "{CALL AssocParteProvedor(?,?,?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setString(1, pNombreParte);
			stmt.setString(2, pMarcaParte);
			stmt.setString(3, pNombreProveedor);
			stmt.setFloat(4, pPrecioProv);
			stmt.setFloat(5, pPorcentajeGanancia);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Asociados con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema asociando el proveedor. Intente otra vez.";
        }
	}

	public String asociarAutoParte(String pNombreParte, String pMarcaParte, String pModeloAuto, int pAnnoAuto){
		String query = "{CALL AssocParteAuto(?,?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setString(1, pNombreParte);
			stmt.setString(2, pMarcaParte);
			stmt.setString(3, pModeloAuto);
			stmt.setInt(4, pAnnoAuto);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Asociados con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema asociando el auto. Intente otra vez.";
        }
	}

	public String actualizarPrecioProv(String pNombreParte, String pMarcaParte, String pNombreProveedor, float pPrecioProv, float pPorcentajeGanancia){
		String query = "{CALL UpdatePreciosProveedor(?,?,?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setString(1, pNombreParte);
			stmt.setString(2, pMarcaParte);
			stmt.setString(3, pNombreProveedor);
			stmt.setFloat(4, pPrecioProv);
			stmt.setFloat(5, pPorcentajeGanancia);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Actualizado con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema actualizando los precios. Intente otra vez.";
        }
	}

	public String asociarDetalleOrden(int pConsOrden, int pIdParte, int pIdProveedor, int cantidad){
		String query = "{CALL CreateDetalle(?,?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setInt(1, pConsOrden);
			stmt.setInt(2, pIdParte);
			stmt.setInt(3, pIdProveedor);
			stmt.setInt(4, cantidad);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Agregada con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema agregando el detalle. Intente otra vez.";
        }
	}
	
	// -------------------------------- DELETE -------------------------------- 
	public String borrarParte(String pNombre, String pMarca){
		String query = "{CALL DeleteParte(?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setString(1, pNombre);
			stmt.setString(2, pMarca);

			stmt.registerOutParameter(3, Types.VARCHAR);

			stmt.execute();

			String mensaje = stmt.getString(3);

			stmt.close();
        	con.close();
			return mensaje;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema borrando la parte. Intente otra vez.";
        }
	}
	
	// public static void main(String[] args) {
	// 	DataBaseCommunicator dbc = new DataBaseCommunicator();
	// 	dbc.insertarCliente(0, "Gabriel Vargas", "1.5 km norte", "San Rafael", 112345678, 71234567, 0);
	// 	System.out.println(dbc.insertarCliente(1, "Taller Vargas", "3 km sur", "Pavas", 1234567890, 22154321, 88151234));
	// 	dbc.insertarParte("Parrilla 5GX", "Goyo", "International Spare Parts");
	// 	dbc.crearOrden(112345678, 0, null);
	// 	dbc.insertarParte("Motor 100CC", "Goyo", "International Spare Parts");
	// 	System.out.println(dbc.borrarParte("Motor 100CC", "Goyo"));
	// 	dbc.listarClientes();

	// 	dbc.insertarCliente(0, "Daniel Sánchez", "Calle 25", "San Miguel", 198765432, 61236541, 0);
	// 	dbc.insertarCliente(1, "Talleres Zúñiga", "A042", "Curidabat", 1212121212, 28851441, 88151234);

	// 	dbc.modificarCliente(0, "Daniel Sánchez", "Calle 25", "San Miguel", 198765432, 81888888, 0);
	// 	dbc.modificarCliente(1, "Talleres Zúñiga", "300 metros norte del cementerio", "Curidabat", 1212121212, 28851441, 88151234);
	// 	dbc.suspenderCliente(IConstants.PERSONA, 198765432, 0);
	// 	dbc.suspenderCliente(IConstants.ORGANIZACION, 0, 1212121212);
	// 	dbc.asociarProveedorParte(1, 9, 50000, 70000);
	// 	dbc.asociarAutoParte(3, 13);
	// 	dbc.actualizarPrecioProv(1, 9, 50000, 80000);
	// 	dbc.asociarDetalleOrden(1, 1, 9, 5);

	// 	for(String[] parte :  dbc.listarPartesAuto("Prius", 2011)){
	// 		System.out.println(parte[0] + " " + parte[1] + " " + parte[2]);
	// 	}

	// 	for(String [] prov : dbc.listarProveedores("Parrilla 5GX", "Goyo")){
	// 		System.out.println(prov[0]+" "+prov[1]+" "+prov[2]+" "+prov[3]+" "+prov[4]+" "+prov[5]);
	// 	}

	// 	for(String [] cliente : dbc.listarClientes()){
	// 		System.out.println(cliente[0]+" "+cliente[1]+" "+cliente[2]+" "+cliente[3]+" "+cliente[4]+" "+cliente[5]+" "+cliente[6]+" "+cliente[7]);
	// 	}
	// }
}

