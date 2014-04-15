package br.com.tarefas.jdbc.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import br.com.tarefas.jdbc.ConnectionFactory;

public class ConnectionFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetConnection() {
		Connection conn = new ConnectionFactory().getConnection();
		assertNotNull(conn);
	}

}
