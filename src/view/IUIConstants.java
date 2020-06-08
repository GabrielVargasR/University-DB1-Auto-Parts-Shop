package view;

public interface IUIConstants {
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 800;
	
	public static final int PANEL_WIDTH = 1000;
	public static final int PANEL_HEIGHT = 600;
	public static final int PANEL_X = 0;
	public static final int PANEL_Y = 0;
	
	public static final int MESSAGE_LABEL_WIDTH = 1000;
	public static final int MESSAGE_LABEL_HEIGHT = 40;
	public static final int MESSAGE_LABEL_X = 0;
	public static final int MESSAGE_LABEL_Y = 700;
	
	public static final String WINDOW_NAME = "Proyecto 1 Bases de Datos 1 - Gabriel Vargas";
	
	// Menu names
	public static final String CLIENTS_MENU_TITLE = "Clientes";
	public static final String PARTS_MENU_TITLE = "Partes";
	public static final String ORDERS_MENU_TITLE = "Órdenes";
	
	public static final String NEW_CLIENT_ITEM_TEXT = "Agregar";
	public static final String MOD_CLIENT_ITEM_TEXT = "Modificar";
	public static final String SUSPEND_CLIENT_ITEM_TEXT = "Suspender/Activar";
	public static final String LIST_CLIENTS_ITEM_TEXT = "Listar";
	
	public static final String NEW_PART_ITEM_TEXT = "Insertar nueva";
	public static final String DELETE_PART_ITEM_TEXT = "Borrar";
	public static final String ADD_PROVIDER_ITEM_TEXT = "Asociar proveedor";
	public static final String ADD_CAR_TYPE_ITEM_TEXT = "Asociar con carro";
	public static final String UPDATE_PRICE_ITEM_TEXT = "Actualizar precio";
	public static final String LIST_CAR_PARTS_ITEM_TEXT = "Listar parte de carro";
	
	public static final String LOCATE_PROVIDER_ITEM_TEXT = "Localizar proveedores";
	public static final String NEW_ORDER_ITEM_TEXT = "Insertar nueva";
	public static final String PROVIDER_DATA_ITEM_TEXT = "Asociar compra de partes";
	public static final String ORDER_INFO = "Información orden";
	
	//New clients Panel constants
	public static final String[] TIPOS_CLIENTE = {"", "Persona", "Organización"};
	public static final String TIPO_LABEL = "Tipo de cliente:";
	public static final String NOMBRE_LABEL = "Nombre:";
	
	// Client List constants
	public static final String[] CLIENTS = {"ID", "Cédula", "Nombre", "Teléfono", "Dirección", "Ciudad", "Estado", "Contacto"};
	public static final String[] LOCATE_PROVIDERS = {"ID", "Nombre", "Dirección", "Ciudad", "Teléfono", "Contacto"};
	public static final String[] PARTES_AUTOS = {"ID", "Nombre", "Marca"};
	public static final String[] ORDEN_COLUMNS = {"Cedula Cliente", "Fecha", "Monto", "IVA", "Total"};
	
	
	public static String PERSONA = "0";
	public static String ORGANIZACION = "1"; 
}
