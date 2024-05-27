<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="members.User"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="views.ModifyMemberView"%>
<%@page import="members.Member"%>
<%@page import="members.MemberService"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <script src="assets/js/color-modes.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modify memeber</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/bar.css" >
    <link rel="stylesheet" href="assets/css/member.css" >
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        User user = (User)session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        long id = Long.parseLong(request.getParameter("id"));

        String dbuser = "avella";
        String dbpassword = "12345678";

        ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/gym", dbuser, dbpassword);
        MemberService memberSvc = new MemberService(pool.getConnection());
        Member member = memberSvc.requestById(id);

        ModifyMemberView view = new ModifyMemberView(member, user);
        out.println(view);
    %>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>