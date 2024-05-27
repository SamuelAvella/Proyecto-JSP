<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="members.User"%>
<%@page import="views.AddMemberView"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <script src="assets/js/color-modes.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Member</title>
    <link rel="stylesheet" href="assets/css/member.css">
    <link rel="stylesheet" href="assets/css/bar.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">

    <style>
    #btnAdd{
        background-color: #28a745 !important;
        color: white;
    }

    #btnAdd:hover{
        background-color: #2fcf54;
        color:white;
    }
    </style>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = (User)session.getAttribute("user");
        if(user==null){
            response.sendRedirect("login.jsp");
        }
        
        AddMemberView view = new AddMemberView(user);
        out.println(view);
    %>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>