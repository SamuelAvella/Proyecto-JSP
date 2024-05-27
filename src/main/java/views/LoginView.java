package views;

public class LoginView {
    public LoginView(){

    }

    @Override
    public String toString() {
        return """
            <div class="container d-flex justify-content-center align-items-center min-vh-100">
                <main class="form-login text-center p-4 border rounded">
                    <form method="POST" action="login.jsp">
                        <h1 class="h3 mb-3 font-weight-normal">Fitness Administration</h1>
                        <br>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="username" id="floatingInput" placeholder="lucas" required>
                            <label for="floatingInput">Username</label>
                        </div>
                        <br>
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" name="password" id="floatingPassword" placeholder="password1234" required>
                            <label for="floatingPassword">Password</label>
                        </div>
                        
                        <button class="btn btn-primary btn-block py-2" type="submit">Log in</button>

                        <div class="form-check text-start my-3">
                            <a href="register.jsp" class="register-btn">Register instead</a>
                        </div>
                    </form>
                </main>
            </div>
                """;
    }
}
