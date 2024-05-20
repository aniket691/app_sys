<!DOCTYPE html>
<html>
<head>
<title>Appointment Confirmation</title>
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

.confirmation-message {
	background-color: #e7f3fe;
	border: 1px solid #b3d7ff;
	color: #31708f;
	padding: 15px;
	margin: 20px 0;
	border-radius: 5px;
	width: 60%;
	text-align: center;
}

.button-container {
	margin-top: 20px;
}

.button {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 4px;
}
</style>
</head>
<body>
	<h1>Appointment Confirmation</h1>
	<div class="confirmation-message">
		<%
		Boolean appointmentStatus = (Boolean) request.getAttribute("appointmentStatus");
		if (appointmentStatus != null && appointmentStatus) {
			out.println("Your appointment has been successfully booked!");
		} else {
			out.println("There was an error booking your appointment. Please try again.");
		}
		%>
	</div>
	<div class="button-container">
		<a href="appointments" class="button">Back to Home</a>
	</div>
</body>
</html>
