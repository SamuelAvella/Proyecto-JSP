<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="members.AuthService"%>
<%@page import="members.User"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    String dbuser = "avella";
    String dbpassword = "12345678";

    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/gym", dbuser, dbpassword);
    AuthService auth = new AuthService(pool.getConnection());
    User user = auth.register(username, email, password);
    response.sendRedirect("login.jsp");
%>