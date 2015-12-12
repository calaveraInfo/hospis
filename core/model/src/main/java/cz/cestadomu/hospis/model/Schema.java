package cz.cestadomu.hospis.model;

public class Schema {
	public static final String CREDENTIALS = "/schema/credentials.xsd";
	public static final String GREETING_SCHEMA = "/schema/greeting.xsd";

	public static String classpath(String schema) {
		return "classpath:" + schema;
	}
}
