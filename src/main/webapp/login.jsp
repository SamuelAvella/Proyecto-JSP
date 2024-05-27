<%-- login.jsp --%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="members.AuthService"%>
<%@page import="members.User"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String dbuser = "avella";

        String dbpassword = "12345678";

        ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/gym", dbuser, dbpassword);
        AuthService auth = new AuthService(pool.getConnection());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = auth.login(username, password);
        if(user!=null){
            session.setAttribute("user", user);
            response.sendRedirect("home.jsp");
        }
        else
            response.sendRedirect("index.jsp?error=Usuario o contraseña no valido");
    %>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>