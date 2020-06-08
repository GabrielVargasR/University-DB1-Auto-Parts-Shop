package model;

public interface IConstants {
	public static String DB_CONNECTION_URL = "jdbc:sqlserver://localhost:1433;databaseName=Progra1;user=SA;password=<Progra1Bases1>";
	public static int PERSONA = 0;
	public static int ORGANIZACION = 1;
	public static String[] ESTADOS = {"ACTIVO", "INACTIVO", "SUSPENDIDO"};
	public static double IVA = 0.13;
}
