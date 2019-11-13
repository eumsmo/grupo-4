package utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost/";
	private final static String USUARIO = "root";
	private final static String SENHA = "";

	public static Connection getConnection(String database) {
		Properties prop = loadProperties();
		String driver, url, usuario, senha;

		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		usuario = prop.getProperty("usuario");
		senha = prop.getProperty("senha");

		try {
			Class.forName(driver);
			return DriverManager.getConnection(url + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false", usuario,
					senha);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver não encontrado: " + e);
			return null;
		} catch (SQLException e) {
			System.err.println("Falha ao conectar ao banco de dados: " + e);
			return null;
		}
	}

	private static Properties loadProperties() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream("config/bd.properties");
		Properties properties = new Properties();

		if (stream != null) {
			try {
				properties.load(stream);
			} catch (IOException ex) {
				System.err.println("Falha ao carregar configurações do BD, usando os valores padrão...");
			}
		}

		properties.putIfAbsent("driver", DRIVER);
		properties.putIfAbsent("url", URL);
		properties.putIfAbsent("usuario", USUARIO);
		properties.putIfAbsent("senha", SENHA);

		return properties;
	}

	public static Connection getDiario() {
		return getConnection("diario");
	}

	public static Connection getBiblioteca() {
		return getConnection("biblioteca");
	}

}
