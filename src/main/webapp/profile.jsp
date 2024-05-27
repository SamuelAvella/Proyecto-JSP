<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="members.User"%>
<%@page import="views.ProfileView"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <script src="assets/js/color-modes.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="assets/css/bar.css" >
    <link rel="stylesheet" href="assets/css/member.css" >
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = (User)session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("login.jsp");
            return; // Asegura que el código no continúe ejecutándose
        }
        String username = user.getUsername();
        String email = user.getEmail();
        String confirmacion = request.getParameter("confirmacion");
        String error = request.getParameter("error");

        ProfileView view = new ProfileView(user, confirmacion, error);
        out.print(view);
    %>

    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.3.2/dist/chart.umd.js" integrity="sha384-eI7PSr3L1XLISH8JdDII5YN/njoSsxfbrkCTnJrzXt+ENP5MOVBxD+l6sEG4zoLp" crossorigin="anonymous"></script>
    <script src="dashboard.js"></script>
</body>
</html>
