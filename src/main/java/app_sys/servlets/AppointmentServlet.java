package app_sys.servlets;

import app_sys.dao.AppointmentDAO;
import app_sys.models.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/appointments")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AppointmentDAO appointmentDAO;

	public void init() {
		appointmentDAO = new AppointmentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Appointment> appointments = appointmentDAO.selectAllAppointments();
		request.setAttribute("appointments", appointments);
		System.out.println(appointments);
		request.getRequestDispatcher("appointments.jsp").forward(request, response);
	}
}

