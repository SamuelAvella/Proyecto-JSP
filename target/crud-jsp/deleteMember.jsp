<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="members.MemberService"%>
<%@page import="members.Member"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    long codigo = Long.parseLong(request.getParameter("id"));

    //Usuario de la base de datos
    String dbuser = "avella";
        //Contraseña de la base de datos
    String dbpassword = "12345678";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/gym", dbuser, dbpassword);
    PilotoService pserv = new PilotoService(pool.getConnection());
    boolean res = pserv.delete(id);
    response.sendRedirect("piloto.jsp");
%>