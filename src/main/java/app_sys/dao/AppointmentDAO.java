package app_sys.dao;

import app_sys.models.Appointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/iacsd_mar24";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Dalal691*";

	private static final String SELECT_ALL_APPOINTMENTS = "SELECT * FROM appointments";
	private static final String INSERT_APPOINTMENT = "INSERT INTO appointments (patient_id, doctor_id, date, time) VALUES (?, ?, ?, ?)";
	private static final String SELECT_PATIENT_ID_BY_EMAIL = "SELECT id FROM Patients WHERE email = ?";
	private static final String SELECT_DOCTOR_ID_BY_NAME_AND_SPECIALIZATION = "SELECT id FROM Doctors WHERE name = ? AND specialization = ?";
	private static final String CANCEL_APPOINTMENT = "DELETE FROM appointments WHERE id = ?";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public List<Appointment> selectAllAppointments() {
		List<Appointment> appointments = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPOINTMENTS)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
//				int id = rs.getInt("id");
				int id = rs.getInt("id");
				int patientId = rs.getInt("patient_id");
				int doctorId = rs.getInt("doctor_id");
				Date date = rs.getDate("date");
				Time time = rs.getTime("time");
				appointments.add(new Appointment(id, patientId, doctorId, date, time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointments;
	}

	public boolean createAppointment(Appointment appointment) {
		boolean success = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT)) {
			preparedStatement.setInt(1, appointment.getPatientId());
			preparedStatement.setInt(2, appointment.getDoctorId());
			preparedStatement.setDate(3, new java.sql.Date(appointment.getDate().getTime()));
			preparedStatement.setTime(4, appointment.getTime());

			int rowsInserted = preparedStatement.executeUpdate();
			success = rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public int getPatientIdByEmail(String email) {
		int patientId = -1; // Initialize with a default value indicating failure
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_ID_BY_EMAIL)) {
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				patientId = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patientId;
	}

	public int getDoctorIdByNameAndSpecialization(String doctorName, String doctorSpecialization) {
		int doctorId = -1; // Initialize with a default value indicating failure
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(SELECT_DOCTOR_ID_BY_NAME_AND_SPECIALIZATION)) {
			preparedStatement.setString(1, doctorName);
			preparedStatement.setString(2, doctorSpecialization);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				doctorId = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctorId;
	}

	public void cancelAppointment(int appointmentId) throws SQLException {
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(CANCEL_APPOINTMENT)) {
			pstmt.setInt(1, appointmentId);
			pstmt.executeUpdate();
		}
	}

}
