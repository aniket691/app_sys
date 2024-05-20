package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DBUtilsTest {

	private Connection connection;

	@Before
	public void setUp() {
		// This method will be executed before each test case
	}

	@After
	public void tearDown() throws SQLException {
		// This method will be executed after each test case
		if (connection != null && !connection.isClosed()) {
			DBUtils.closeConnection();
		}
	}

	@Test
	public void testOpenConnection() {
		try {
			connection = DBUtils.openConnection();
			assertNotNull("Connection should not be null", connection);
			assertFalse("Connection should be open", connection.isClosed());
		} catch (SQLException e) {
			fail("Opening connection failed: " + e.getMessage());
		}
	}

	@Test
	public void testCloseConnection() {
		try {
			connection = DBUtils.openConnection();
			assertNotNull("Connection should not be null", connection);
			DBUtils.closeConnection();
			assertTrue("Connection should be closed", connection.isClosed());
		} catch (SQLException e) {
			fail("Closing connection failed: " + e.getMessage());
		}
	}
}
