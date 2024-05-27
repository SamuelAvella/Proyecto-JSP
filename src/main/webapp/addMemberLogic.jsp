<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="member.MemberService"%>
<%@page import="member.Member"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    int permanence = request.getParameter("permanence");
    String paid = request.getParameter("paid");

    String dbuser = "avella";
    String dbpassword = "12345678";

    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/gym", dbuser, dbpassword);
    PilotoService pserv = new PilotoService(pool.getConnection());
    Piloto piloto = new Piloto(name, surname, email, password, permanence, paid);
    long affectedRows = pserv.create(piloto);
    response.sendRedirect("member.jsp");
%>