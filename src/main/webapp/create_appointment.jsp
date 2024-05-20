<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Page</title>
<style>

body {
	font-family: Arial, sans-serif;
	background-color: #f0f2f5;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.registration-container {
	background-color: #fff;
	padding: 40px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 400px;
}

.registration-container h2 {
	margin-bottom: 20px;
	color: #333;
	text-align: center;
}

.registration-container .form-group {
	margin-bottom: 20px;
}

.registration-container .form-group label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
	color: #555;
}

.registration-container .form-group input[type="text"],
	.registration-container .form-group input[type="password"],
	.registration-container .form-group input[type="email"],
	.registration-container .form-group input[type="number"],
	.registration-container .form-group input[type="date"] {
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.registration-container button {
	width: 100%;
	padding: 12px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 4px;
	font-size: 16px;
	cursor: pointer;
}

.registration-container button:hover {
	background-color: #0056b3;
}

.registration-container .login-link {
	display: block;
	text-align: center;
	margin-top: 20px;
	color: #007bff;
	text-decoration: none;
}

.registration-container .login-link:hover {
	text-decoration: underline;
}
</style>
</head>
<body>

	<div class="registration-container">
		<h2>Add Appointment</h2>
		<form action="CreateAppointmentServlet" method="POST">
			<div class="form-group">
			
				<label for="email">Patients Email</label> <input type="email"
					id="email" name="p_email" placeholder="Email" required>
			</div>
			<div class="form-group">
				<label for="password">Doctor Name</label> <input type="text"
					id="password" name="doctor_name" placeholder="Name" required>
			</div>
			<div class="form-group">
				<label for="reg_amt">Specialization</label> <input type="text"
					id="reg_amt" name="specialization" placeholder="Specialization"
					required>
			</div>
			<div class="form-group">
				<label for="reg_date">Date</label> <input type="date" id="reg_date"
					name="app_date" required>
			</div>
			<div class="form-group">
				<label for="role">Time</label> <input type="time" id="role"
					name="app_time" placeholder="Time" required>
			</div>
			<button type="submit">Book</button>
		</form>
	</div>

</body>
</html>
