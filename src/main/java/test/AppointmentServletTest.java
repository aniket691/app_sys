package test;

import app_sys.dao.AppointmentDAO;
import app_sys.models.Appointment;
import app_sys.servlets.AppointmentServlet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AppointmentServletTest {

	private AppointmentServlet servlet;
	private AppointmentDAO appointmentDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher requestDispatcher;

	@Before
	public void setUp() {
		servlet = new AppointmentServlet();
		appointmentDAO = mock(AppointmentDAO.class);
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		requestDispatcher = mock(RequestDispatcher.class);

		servlet.init();
		servlet.appointmentDAO = appointmentDAO; // Inject the mock DAO
	}

	@Test
	public void testDoGet() throws ServletException, IOException {
//		List<Appointment> mockAppointments = new ArrayList<>();
//		mockAppointments.add(new Appointment(1, 1, 1, Date.valueOf("2024-05-20"), Time.valueOf("09:00:00")));
//
//		when(appointmentDAO.selectAllAppointments()).thenReturn(mockAppointments);
//		when(request.getRequestDispatcher("appointments.jsp")).thenReturn(requestDispatcher);
//
////		servlet.doGet(request, response);
//
//		verify(request).setAttribute(eq("appointments"), anyList());
//		ArgumentCaptor<List> captor = ArgumentCaptor.forClass(List.class);
//		verify(request).setAttribute(eq("appointments"), captor.capture());
//		List<Appointment> capturedAppointments = captor.getValue();
//		assertEquals(mockAppointments, capturedAppointments);
//
//		verify(requestDispatcher).forward(request, response);
	}
}
