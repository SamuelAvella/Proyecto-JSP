package views;

public class SideMenuView {
    public SideMenuView(){

    }

    @Override
    public String toString() {
        return """
          <div class="sidebar d-flex flex-column">
            <nav class="nav flex-column">
              <a class="nav-link active" href="home.jsp">
                  Home
              </a>
              <a class="nav-link" href="member.jsp">
                  Members
              </a>
              <a class="nav-link" href="addMember.jsp">
                  Add a member
              </a>
              <a class="nav-link" href="profile.jsp">
                  My Profile
              </a>
              <a class="nav-link" href="logout.jsp">
                  Close Session
              </a>
            </nav>
          </div>
                """;
    }
}
