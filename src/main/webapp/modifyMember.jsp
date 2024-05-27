<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="members.MemberService"%>
<%@page import="members.Member"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    long id = Long.parseLong(request.getParameter("id"));
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String email = request.getParameter("email");
    String password = request.getParameter("password"); // Si el formulario tiene un campo para password
    int permanence = Integer.parseInt(request.getParameter("permanence"));
    String paid = request.getParameter("paid");

    String dbuser = "avella";
    String dbpassword = "12345678";

    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/gym", dbuser, dbpassword);
    MemberService memberSvc = new MemberService(pool.getConnection());
    Member member = new Member(id, name, surname, email, password, permanence, paid);
    
    int affectedRows = memberSvc.update(member);
    response.sendRedirect("member.jsp");
%>
