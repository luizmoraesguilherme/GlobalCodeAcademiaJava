package br.com.globalcode.aj4.dao;

/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.globalcode.util.GlobalcodeException;

public class ConnectionManager {

	// Informacoes para conexao com banco de dados. Verificar antes de conectar
	// com outro banco.
	private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DATABASE = "aj";
	private static final String IP = "192.168.0.1";
	private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/"
			+ DATABASE;
	private static final String USER = "aj";
	private static final String PASSWORD = "aj";

	public static Connection getConexao() throws GlobalcodeException {
		Connection conn = null;
		try {
			Class.forName(STR_DRIVER);
			conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
			System.out.println("[ConnectionManager]: Obtendo conexao");
			return conn;
		} catch (ClassNotFoundException e) {
			String errorMsg = "Driver nao encontrado";
			throw new GlobalcodeException(errorMsg, e);
		} catch (SQLException e) {
			String errorMsg = "Erro ao obter a conexao";
			throw new GlobalcodeException(errorMsg, e);
		}
	}

	public static void closeAll(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null || stmt != null) {
				closeAll(conn, stmt);
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt) {
		try {
			if (conn != null) {
				closeAll(conn);
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
