/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {

	private Connection connection;
	private String user;
	private String password;
	private String server;
	private int numPort;
	
	
	public ConexaoBD(String server, int numPort, String user, String password) {
		
		this.server = server;
		this.numPort = numPort;
		this.user = user;
		this.password = password;
	}
	
	public void connect(String database) throws SQLException, InstantiationException, IllegalAccessException {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            }
		String url = "jdbc:mysql://" + server + ":" + numPort + "/" + database;
		this.connection = DriverManager.getConnection(url, user, password);
	}
	
	public Statement get() throws SQLException {
		return this.connection.createStatement();
	}
	
	public void close() throws SQLException {
		connection.close();
	}
}
