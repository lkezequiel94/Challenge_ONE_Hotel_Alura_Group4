package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConexionBase {

	public DataSource datasource;
	
	public ConexionBase() {
		ComboPooledDataSource comboPool = new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost/AluraHotel");
		comboPool.setUser("root");
		comboPool.setPassword("root");
		
		this.datasource = comboPool;
	}

	public Connection conectarBase() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			System.out.println("Hubo un error");
			throw new RuntimeException();
		}
	}

	public Connection recuperarConexion() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	}
