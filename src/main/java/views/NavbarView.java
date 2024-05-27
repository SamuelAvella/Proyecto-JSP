package views;

import members.User;

public class NavbarView {
    private User user;

    public NavbarView(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return """
          <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
            <a class="navbar-brand" href="home.jsp">Fitness Administration</a>
            <div class="ml-auto text-white">
            <a href="profile.jsp?id=%d"><button type="button" ><i class="bi bi-person"></i></button></a>
            """+ (user != null ? user.getUsername() : "") + """
            </div>
          </nav>
                """;
    }

    
}
