package members;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import crud.CRUD;

public class UsersService implements CRUD<User>{

    Connection conn;
    public UsersService(Connection conn){
        this.conn = conn;
    }
    @Override
    public ArrayList<User> query(String column, String value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<User> query(String column, long value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    private ArrayList<User> _requestAll(String sql) throws SQLException{
        ArrayList<User> result = new ArrayList<User>();
        Statement statement = this.conn.createStatement();   

        ResultSet querySet = statement.executeQuery(sql);
        while(querySet.next()) {
            int id = querySet.getInt("idUser");
            String username = querySet.getString("username");
            String email = querySet.getString("email");
            String password = querySet.getString("password");
            result.add(new User(id, username, email, password));
        } 
        statement.close();

        return result;
    }

    @Override
    public ArrayList<User> requestAll(String sortedBy) throws SQLException{
        String sql = "SELECT idUser, username, email, password FROM users"+(sortedBy.length()>0?(" ORDER BY "+sortedBy):"");
        return this._requestAll(sql);
    }

    @Override
    public User requestById(long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestById'");
    }

    @Override
    public long create(User model) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public long update(User object) throws SQLException {
        long id = object.getId();
        String username = object.getUsername();
        String email = object.getEmail();
        Statement statement = this.conn.createStatement(); 

        String sql = String.format("UPDATE users SET username = '%s', email = '%s' WHERE idUser=%d", username, email, id);
        int affectedRows = statement.executeUpdate(sql);
        statement.close();

        if (affectedRows == 0)
            throw new SQLException("Creating user failed, no rows affected.");
        else
            return affectedRows;
    }

    @Override
    public boolean delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
