package model;

import java.sql.*;

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
	public String insertarCliente(int pTipo, String pNombre, String pDireccion, String pCiudad, int pCedula, int pTelefono, int pTelContacto){
		String query = "{CALL InsertClient(?, ?, ?, ?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setString(1, pNombre);
			stmt.setString(2, pDireccion);
			stmt.setString(3, pCiudad);
			stmt.registerOutParameter(4, Types.INTEGER);
			
			stmt.execute();

			int idCliente = stmt.getInt(4);
			String message;

			if (pTipo == 0){
				message = this.insertarPersona(idCliente, pCedula, pTelefono);
			} else {
				message = this.insertarOrganizacion(idCliente, pCedula, pTelefono, pTelContacto);
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

	private String insertarPersona(int pIdCliente, int pCedula, int pTelefono){
		String query = "{CALL InsertPersona(?, ?, ?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setInt(1, pCedula);
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

	private String insertarOrganizacion(int pIdCliente, int pCedula, int pTelefono, int pTelContacto){
		String query = "{CALL InsertOrganizacion(?, ?, ?, ?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			stmt.setInt(1, pCedula);
			stmt.setInt(2, pTelefono);
			stmt.setInt(3, pTelContacto);
			stmt.setInt(4, pIdCliente);

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
			return "Hubo un problema insertando el cliente. Intente otra vez.";
        }
	}

	public String crearOrden(int pCedula, int pTipo, Date pFecha){
		String query = "{CALL InsertOrden(?,?,?)}";

		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); CallableStatement stmt = con.prepareCall(query);) {

			if (pTipo == 0){
				stmt.setNull(1, Types.INTEGER);
				stmt.setInt(2, pCedula);
			} else {
				stmt.setInt(1, pCedula);
				stmt.setNull(2, Types.INTEGER);
			}

			if (pFecha != null) {
				stmt.setDate(3, pFecha);
			} else stmt.setNull(3, Types.DATE);

			stmt.executeUpdate();
			stmt.close();
        	con.close();
			return "Agregada con éxito";
        }
        catch (SQLException e) {
			e.printStackTrace();
			return "Hubo un problema insertando el cliente. Intente otra vez.";
        }
	}

	// -------------------------------- READ -------------------------------- 
	public String[][] listarClientes(){
		return null;
	}

	public String[][] listarPartesAuto(){
		return null;
	}

	public String[][] listarProveedores(){
		return null;
	}

	public String[] getCliente(){
		return null;
	}

	// -------------------------------- UPDATE -------------------------------- 
	public String modificarCliente(){
		return null;
	}

	public String suspenderCliente(){
		return null;
	}

	public String asociarProveedorParte(){
		return null;
	}

	public String asociarAutoParte(){
		return null;
	}

	public String actualizarPrecioProv(){
		return null;
	}

	public String asociarDetalleOrden(){
		return null;
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
			return "Hubo un problema insertando el cliente. Intente otra vez.";
        }
	}
	
	public static void main(String[] args) {
		DataBaseCommunicator dbc = new DataBaseCommunicator();
		//dbc.insertarCliente(0, "Gabriel Vargas", "1.5 km norte", "San Rafael", 112345678, 71234567, 0);
		//System.out.println(dbc.insertarCliente(1, "Taller Vargas", "3 km sur", "Pavas", 1234567890, 22154321, 88151234));
		//dbc.insertarParte("Parrilla 5GX", "Goyo", "International Spare Parts");
		// dbc.crearOrden(112345678, 0, null);
		// dbc.insertarParte("Motor 100CC", "Goyo", "International Spare Parts");
		// System.out.println(dbc.borrarParte("Motor 100CC", "Goyo"));
	}
}

