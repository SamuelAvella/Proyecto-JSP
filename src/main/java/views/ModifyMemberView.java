package views;

import members.Member;
import members.User;

public class ModifyMemberView {
    private Member member;
    private User user;

    public ModifyMemberView(Member member, User user) {
        this.member = member;
        this.user = user;
    }

    @Override
    public String toString() {
        NavbarView navbar = new NavbarView(user);
        SideMenuView menu = new SideMenuView();

        StringBuilder sb = new StringBuilder();
        sb.append(navbar.toString());
        sb.append("""
            <div class="main-container">""")
            .append(menu.toString())
            .append("""
                <div class="main-content">
                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 main-content">
                    <h1 class="h3 mb-3">Modify member</h1>
                    <form action="modifyMember.jsp?" method="post">
                        <input type="hidden" name="id" value="%d">
                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" class="form-control" id="name" name="name" value="%s" required>
                        </div>
                        <div class="mb-3">
                            <label for="surname" class="form-label">Surname</label>
                            <input type="text" class="form-control" id="surname" name="surname" value="%s" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" name="email" id="email" value="%s" required>
                        </div>
                        <div class="mb-3">
                            <label for="permanence">Permanence</label>
                            <input type="number" class="form-control" name="permanence" id="permanence" value="%d" required>
                        </div>
                        <div class="mb-3">
                            <label for="paid">Paid</label>
                            <input type="text" class="form-control" name="paid" id="paid" value="%s" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </form>
                </main>
            </div>
        </div>
    """.formatted(member.getId(), member.getName(), member.getSurname(), member.getEmail(), member.getPermanence(), member.getPaid()));

        return sb.toString();
    }
}
