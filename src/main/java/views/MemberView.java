package views;

import java.util.ArrayList;
import members.Member;
import members.User;

public class MemberView {
    private ArrayList<Member> members;
    private User user;

    public MemberView(ArrayList<Member> members, User user) {
        this.members = members;
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder userList = new StringBuilder();
        NavbarView navbar = new NavbarView(user);
        SideMenuView menu = new SideMenuView();

        userList.append("");
        for (Member member : members) {
            userList.append(String.format(
                """
                <div class="col-md-6 member-card">
                    <div class="card mb-3">
                        <div class="card-body">
                            <h5 class="card-title">%s %s</h5>
                            <p class="card-text text-muted">Email: %s</p>
                            <p class="card-text text-muted">Permanence: %d months</p>
                            <p class="card-text text-muted">Paid: %s</p>
                            <div class="d-flex justify-content-between">
                                <a href="updateMember.jsp?id=%d"><button type="button" class="btn btn-outline-warning fs-7 btn-edit"><i class="bi bi-pencil"></i> Edit</button></a>
                                <button class="btn btn-outline-danger btn-delete" onclick="confirmDelete(%d)"><i class="bi bi-trash"></i>Delete</button>                            
                            </div>
                        </div>
                    </div>
                </div>"""
                ,
                member.getName(), member.getSurname(), member.getEmail(), member.getPermanence(), member.getPaid(), member.getId(), member.getId()));
        };

        return navbar.toString() + """
            <div class="main-container">""" +
                menu.toString() +
                """
                    <div class="main-content">
                    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 main-content">
                        <h1 class="h3 mb-3">Members</h1>
                        <div class="row">
                        """ + userList.toString() + """
                        </div>
                        <div class="col">
                            <div class="card h-100">
                                <div class="card-body d-flex align-items-center justify-content-center">
                                    <a href="addMember.jsp" class="btn btn-outline-primary btn-lg" style="width: 100%;">Add member</a>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>
            </div>

            <script>
                function confirmDelete(id) {
                    if (confirm("Are you sure you wanna delete this member?")) {
                        window.location.href = "deleteMember.jsp?id=" + id;
                    }
                }
            </script>
        """;
    }
}
