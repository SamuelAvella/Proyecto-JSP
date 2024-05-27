package views;

public class RegisterView {
    public RegisterView(){

    }

    @Override
    public String toString() {
        return """
          <div class="container d-flex justify-content-center align-items-center min-vh-100">
            <main class="form-register text-center p-4 border rounded">
                <form method="POST" action="newRegister.jsp">
                    <h1 class="h3 mb-3 font-weight-normal">Fitness Administration</h1>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" name="username" id="floatingUsername" placeholder="lucas" required>
                        <label for="floatingUsername">Username</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" name="email" id="floatingEmail" placeholder="name@example.com" required>
                        <label for="floatingEmail">Email</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control" name="password" id="floatingPassword" placeholder="password1234" required>
                        <label for="floatingPassword">Password</label>
                    </div>
                    
                    <button class="btn btn-primary btn-block py-2" type="submit">Register</button>
        
                    <div class="form-check text-start my-3">
                        <a href="login.jsp" class="login-btn">Login instead</a>
                    </div>
                </form>
            </main>
          </div>
                """;
    }
}
