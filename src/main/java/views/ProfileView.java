package views;

import members.User;

public class ProfileView {
    private User user;
    private String confirmacion;
    private String error;

    public ProfileView(User user, String confirmacion, String error){
        this.user = user;
        this.confirmacion = confirmacion;
        this.error = error;
    }

    @Override
    public String toString() {
        NavbarView navbar = new NavbarView(user);
        SideMenuView menu = new SideMenuView();

        StringBuilder sb = new StringBuilder();
        sb.append(navbar.toString());
        sb.append("""
            <div class="main-container">
                """);
        sb.append(menu.toString());
        sb.append("""
                <div class="main-content">
                    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                        <h1 class="mt-5">Change data</h1>
                        <div class="container">
                            <form method="POST" action="changeUser.jsp" class="p-3 border rounded shadow-sm">   
                                <div class="form-floating mb-3">
                                    <label for="floatingInput">Username</label>
                                    <input type="text" class="form-control" name="username" id="floatingInput" value=\"""").append(user.getUsername()).append("""
                                        \" placeholder="Username">
                                </div>
                                <div class="form-floating mb-3">
                                    <label for="floatingInput">Email</label>
                                    <input type="text" class="form-control" name="email" id="floatingInput" value=\"""").append(user.getEmail()).append("""
                                        \" placeholder="Email"> 
                                </div>""");

                                if (confirmacion != null && !confirmacion.isEmpty()) {
                                    sb.append("<h4 class=\"confirmacion text-success\">").append(confirmacion).append("</h4>");
                                } else if (error != null && !error.isEmpty()) {
                                    sb.append("<h4 class=\"error text-danger\">").append(error).append("</h4>");
                                }
                            
                                sb.append("""
                                <div class="text-end">
                                    <button class="btn btn-primary" type="submit">Cambiar</button>
                                </div>
                            </form>
                        </div>
                        
                    </main>
                </div>
            </div>
        """);
        
        
        return sb.toString();
    }
}
