<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
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

.login-container {
	background-color: #fff;
	padding: 40px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 400px;
}

.login-container h2 {
	margin-bottom: 20px;
	color: #333;
	text-align: center;
}

.login-container .form-group {
	margin-bottom: 20px;
}

.login-container .form-group label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
	color: #555;
}

.login-container .form-group input[type="text"], .login-container .form-group input[type="password"]
	{
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.login-container button {
	width: 100%;
	padding: 12px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 4px;
	font-size: 16px;
	cursor: pointer;
}

.login-container button:hover {
	background-color: #0056b3;
}

.login-container .register-link {
	display: block;
	text-align: center;
	margin-top: 20px;
	color: #007bff;
	text-decoration: none;
}

.login-container .register-link:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>Login</h2>
		<form action="LoginServlet" method="POST">
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					id="username" name="username" placeholder="Username" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					id="password" name="password" placeholder="Password" required>
			</div>
			<button type="submit">Login</button>
			<a href="register.jsp" class="register-link">Don't have an
				account? Register here</a>
		</form>
	</div>
</body>
</html>
