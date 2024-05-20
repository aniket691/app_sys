package app_sys.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app_sys.dao.AppointmentDAO;
import app_sys.models.Appointment;

/**
 * Servlet implementation class CreateAppointmentServlet
 */
@WebServlet("/CreateAppointmentServlet")
public class CreateAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AppointmentDAO appointmentDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAppointmentServlet() {
		super();
		// TODO Auto-generated constructor stub
		appointmentDAO = new AppointmentDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("p_email");
		String name = request.getParameter("doctor_name");
		String specialization = request.getParameter("specialization");
		String date = request.getParameter("app_date");
		String time = request.getParameter("app_time");

		int pid = appointmentDAO.getPatientIdByEmail(email);
		int did = appointmentDAO.getDoctorIdByNameAndSpecialization(name, specialization);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date app_date = null;
		try {
			app_date = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Parse the time string into a LocalTime object
		LocalTime localTime = LocalTime.parse(time);
		// Convert LocalTime to Time using valueOf method
		Time sqlTime = Time.valueOf(localTime);

		boolean flag = appointmentDAO.createAppointment(new Appointment(0, pid, did, app_date, sqlTime));
		request.setAttribute("appointmentStatus", flag);
		request.getRequestDispatcher("confirmation.jsp").forward(request, response);

	}

}
