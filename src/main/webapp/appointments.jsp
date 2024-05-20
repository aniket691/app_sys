<%@page import="java.util.List"%>
<%@page import="app_sys.models.Appointment"%>
<%
List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
%>
<!DOCTYPE html>
<html>
<head>
<title>Appointments</title>
<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f8ff;
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
	align-items: center;
}

h1 {
	color: #333;
	margin-top: 20px;
}

table {
	width: 80%;
	margin: 20px 0;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:hover {
	background-color: #f5f5f5;
}

form {
	display: inline;
}

input[type="submit"] {
	background-color: #f44336;
	color: white;
	border: none;
	padding: 8px 16px;
	cursor: pointer;
	border-radius: 4px;
}

input[type="submit"]:hover {
	background-color: #d32f2f;
}
</style>
</head>
<body>
	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light w-100">
		<a class="navbar-brand" href="#">Appointment System</a>
		<div class="collapse navbar-collapse justify-content-end">
			<form action="logout.jsp" method="post" class="form-inline">
				<button class="btn btn-outline-danger" type="submit">Logout</button>
			</form>
		</div>
	</nav>
	<div class="container mt-5">
		<h1>Upcoming Appointments</h1>
		<div class="d-flex justify-content-between mb-3">
			<h2>Your Appointments</h2>
			<form action="create_appointment.jsp" method="get">
				<button class="btn btn-primary" type="submit">Book
					Appointment</button>
			</form>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Patient ID</th>
					<th>Doctor ID</th>
					<th>Date</th>
					<th>Time</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (appointments != null) {
					for (Appointment appointment : appointments) {
				%>
				<tr>
					<td><%=appointment.getId()%></td>
					<td><%=appointment.getPatientId()%></td>
					<td><%=appointment.getDoctorId()%></td>
					<td><%=appointment.getDate()%></td>
					<td><%=appointment.getTime()%></td>
					<td>
						<form action="CancelAppointment" method="post">
							<%-- Store appointment ID in session --%>
							<%
							session.setAttribute("appointmentId", appointment.getId());
							%>
							<input type="submit" value="Cancel" class="btn btn-danger">
						</form>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="5" class="text-center">No appointments found.</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
