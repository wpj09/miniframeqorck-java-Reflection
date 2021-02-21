package br.posse.ueg.si.p4.java.reflection.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static String status = "Conexão não estabelecida...";

    public ConnectionFactory() {

    }

    public static Properties loadPropertiesFile() throws Exception {
        Properties prop = new Properties();
        File f = new File("jdbc.properties");
        InputStream in = new FileInputStream(f.getAbsolutePath());
        prop.load(in);
        in.close();
        return prop;
    }

    public static java.sql.Connection getConexaoMySQL() throws Exception {

        java.sql.Connection connection = null;

        try {
            Properties prop = loadPropertiesFile();
            String driverName = prop.getProperty("mysqljdbc.driver");
            Class.forName(driverName);
            String serverName = prop.getProperty("mysqljdbc.nameServer");
            String mydatabase = prop.getProperty("mysqljdbc.db");
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = prop.getProperty("mysqljdbc.username");
            String password = prop.getProperty("mysqljdbc.password");
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("Conectado com sucesso!");
            } else {
                status = ("Não foi possivel realizar conexão");
            }
            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean FecharConexao() throws Exception {
        try {
            ConnectionFactory.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao() throws Exception {
        FecharConexao();
        return ConnectionFactory.getConexaoMySQL();
    }

}
