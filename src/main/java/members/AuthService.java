package members;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthService implements AuthInterface{
    Connection conn = null;

    public AuthService(Connection conn){
        this.conn = conn;
    }

    @Override
    public User login(String username, String password) throws SQLException{
        User result = null;
        Statement statement = this.conn.createStatement();    
        String sql = String.format("SELECT idUser, username, email, password FROM users WHERE username='%s' AND password='%s'", username, password);
        ResultSet querySet = statement.executeQuery(sql);
        if(querySet.next()) {
            long id = querySet.getLong("idUser");
            String email = querySet.getString("email");
            result = new User(id, username, email, password);
        }
        statement.close();    
        return result;
    }

    @Override
    public void logout() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

    @Override
    public User register(String username, String email, String password) throws SQLException {
         
         Statement statement = this.conn.createStatement();    
         String sql = String.format("INSERT INTO users (username, email, password) VALUES ('%s', '%s', '%s')",username, email, password);

         int affectedRows = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
         if (affectedRows == 0) {
             throw new SQLException("Creating user failed, no rows affected.");
         }
 
         try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
             if (generatedKeys.next()) {
                 long id = generatedKeys.getLong(1);
                 statement.close();
                 return new User(id, username, email, password);
             }
             else {
                 statement.close();
                 throw new SQLException("Creating user failed, no ID obtained.");
             }
         }
    }
    
}
