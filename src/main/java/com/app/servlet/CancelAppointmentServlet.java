package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app_sys.dao.AppointmentDAO;

@WebServlet("/CancelAppointment")
public class CancelAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the appointment ID from the request
		HttpSession session = request.getSession();
		Integer appointmentId = (Integer) session.getAttribute("appointmentId");
		System.out.println(appointmentId);
		// Validate the appointment ID
		if (appointmentId != null) {
			try {
				// Create an instance of AppointmentDAO to interact with the database
				AppointmentDAO appointmentDAO = new AppointmentDAO();
				// Cancel the appointment
				appointmentDAO.cancelAppointment(appointmentId);
			} catch (Exception e) {
				// Handle any exceptions (e.g., log the error, set an error message in the
				// request)
				e.printStackTrace();
			}
		}
		// Redirect back to the appointments page
		response.sendRedirect("appointments");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
