<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%
// Invalidate the session if it exists
if (session != null) {
	session.invalidate();
}
// Redirect to the login page
response.sendRedirect("login.jsp"); // Change "login.html" to the actual login page URL
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Logout</title>
<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f8ff;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
}

.container {
	text-align: center;
	margin-top: 20px;
}

h1 {
	color: #333;
}

a {
	color: #007bff;
}

a:hover {
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Logged Out</h1>
		<p>You have successfully logged out.</p>
		<a href="login.jsp" class="btn btn-primary">Go to Login Page</a>
	</div>
	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
