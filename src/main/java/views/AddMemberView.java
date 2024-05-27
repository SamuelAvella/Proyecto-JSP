package views;

import members.User;

public class AddMemberView {
    
    private User user;
    
    public AddMemberView(User user){
        this.user = user;
    }

    @Override
    public String toString() {
        NavbarView navbar = new NavbarView(user);
        SideMenuView menu = new SideMenuView();

        return navbar.toString() + """
            <div class="main-container">""" +
                menu.toString() +
                """
                    <div class="main-content">
                    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 main-content">
                        <h1 class="mt-5">Add a member</h1>    
                        <div class="container">
                                <form action="addMember.jsp" method="post">
                                    <div class="form-floating">
                                        <label for="floatingInput1">Name</label>
                                        <input type="text" class="form-control" name="name" id="floatingInput1">
                                    </div>
                                    <div class="form-floating">
                                        <label for="floatingInput2">Surname</label>
                                        <input type="text" class="form-control" name="surname" id="floatingInput2">
                                        
                                    </div>
                                    <div class="form-floating">
                                        <label for="floatingInput4">Email</label>
                                        <input type="text" class="form-control" name="email" id="floatingInpu3">
                                    </div>
                                    <div class="form-floating">
                                        <label for="floatingInput5">Permanence</label>
                                        <input type="number" class="form-control" name="permanence" id="floatingInpu3" min="1" max="12" step="1">
                                        
                                    </div>
                                    <div class="form-floating">
                                        <label for="floatingInput6">Paid</label>
                                        <input type="text" class="form-control" name="paid" id="floatingInpu3">
                                        
                                    </div>
                                    <br>
                                    <button type="submit" id="btnAdd" class="btn">Add member</button>
                                </form>
                            </div>
                    </main>
                </div>
            </div>

        """;
    }
}
