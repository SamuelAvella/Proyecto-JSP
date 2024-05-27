<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="members.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="members.UsersService"%>
<%@page import="views.HomeView"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <script src="assets/js/color-modes.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="assets/css/home.css">
    <link rel="stylesheet" href="assets/css/bar.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">



</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = (User)session.getAttribute("user");
        if(user==null){
            response.sendRedirect("login.jsp");
        }
        String dbuser = "avella";
        String dbpassword = "12345678";
        ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/gym", dbuser, dbpassword);
        UsersService userSvc = new UsersService(pool.getConnection());
        ArrayList<User> users = userSvc.requestAll("idUser ASC, username ASC");

        HomeView homeview = new HomeView(users, user);
        out.print(homeview);
    %>
    
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.3.2/dist/chart.umd.js" integrity="sha384-eI7PSr3L1XLISH8JdDII5YN/njoSsxfbrkCTnJrzXt+ENP5MOVBxD+l6sEG4zoLp" crossorigin="anonymous"></script><script src="dashboard.js"></script></body>
</body>
</html>