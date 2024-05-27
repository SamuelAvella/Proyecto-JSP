package views;

import members.User;
import java.util.ArrayList;

public class HomeView {
    private ArrayList<User> users;
    private User user;

    public HomeView(ArrayList<User> users, User user){
        this.users = users;
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder userList = new StringBuilder();
        NavbarView navbar = new NavbarView(user);
        SideMenuView menu = new SideMenuView();
        for (User u : users) {
            userList.append(String.format(
                "<tr>"+
                "    <td>%d</td>"+
                "    <td>%s</td>"+
                "    <td>%s</td>"+
                "    <td>%s</td>"+
                "</tr>", u.getId(),
                u.getUsername(),
                u.getEmail(),
                u.getPassword()));
        }

        return navbar.toString() + """
          <div class="main-container">"""+
            menu.toString()
            +"""
            <div class="main-content">
              <div class="user-list">
                  <h2 class="mb-4">Users</h2>
                  <table class="table table-striped">
                      <thead class="thead-green">
                          <tr>
                              <th>ID</th>
                              <th>Username</th>
                              <th>Email</th>
                              <th>Password</th>
                          </tr>
                      </thead>
                      <tbody>
                        """ + userList.toString() + """
                      </tbody>
                    </table>
                </div>
              </div>
          </div>
                """;
    }
}