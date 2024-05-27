<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="members.User"%>
<%@page import="views.RegisterView"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <script src="assets/js/color-modes.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">

    

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <link href="assets/css/sign-in.css" rel="stylesheet">
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = (User)session.getAttribute("user");
        if(user!=null)
            response.sendRedirect("home.jsp");
        else{
            String error = request.getParameter("error");
        }
        RegisterView view = new RegisterView();
        out.println(view);
    %>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>