package members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import crud.CRUD;

public class MemberService implements CRUD<Member>{

    Connection conn;

    public MemberService(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<Member> query(String column, String value) throws SQLException {
        ArrayList<Member> listaUsuarios = new ArrayList<>();
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = String.format("SELECT * FROM members WHERE %s='%s'", column, value);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            long id = result.getLong(1);
            String name = result.getString(2);
            String surname = result.getString(3);
            String email = result.getString(4);
            String password = result.getString(5);
            long permanence = result.getLong(6);
            String paid = result.getString(7);
            listaUsuarios.add(new Member(id, name, surname, email, password, permanence, paid));
        }
        statement.close();
        return listaUsuarios;
    }

    @Override
    public ArrayList<Member> query(String column, long value) throws SQLException {
        ArrayList<Member> listaUsuarios = new ArrayList<>();
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = String.format("SELECT * FROM members WHERE %s='%s'", column, value);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            long id = result.getLong(1);
            String name = result.getString(2);
            String surname = result.getString(3);
            String email = result.getString(4);
            String password = result.getString(5);
            long permanence = result.getLong(6);
            String paid = result.getString(7);
            listaUsuarios.add(new Member(id, name, surname, email, password, permanence, paid));
        }
        statement.close();
        return listaUsuarios;
    }

    @Override
    public ArrayList<Member> requestAll(String sortedBy) throws SQLException {
        ArrayList<Member> result = new ArrayList<Member>();
        Statement statement = this.conn.createStatement();   
        sortedBy = "SELECT * FROM members";
        ResultSet querySet = statement.executeQuery(sortedBy);
        while(querySet.next()) {
            long id = querySet.getLong("id");
            String name = querySet.getString("name");
            String surname = querySet.getString("surname");
            String email = querySet.getString("email");
            String password = querySet.getString("password");
            long permanence = querySet.getLong("permanence");
            String paid = querySet.getString("paid");
            result.add(new Member(id, name, surname, email, password, permanence, paid));
        } 
        statement.close();

        return result;
    }

    @Override
    public Member requestById(long id) throws SQLException {
        ArrayList<Member> members = this.requestAll("SELECT * FROM members");
        for (Member member: members){
            if (member.getId()==id){
                return member;
            }
        }
        return null;
    }

    @Override
    public long create(Member model) throws SQLException {
        PreparedStatement prepst = null;
        String sql = String.format("INSERT INTO members(name, surname, email, password, permanence, paid) VALUES (?,?,?,?,?,?)");
        prepst = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        prepst.setString(1, model.getName());
        prepst.setString(2, model.getSurname());
        prepst.setString(3, model.getEmail());
        prepst.setString(4, model.getPassword());
        prepst.setLong(5, model.getPermanence());
        prepst.setString(6, model.getPaid());
        prepst.executeUpdate();
        ResultSet keys = prepst.getGeneratedKeys();
        if(keys.next()){    
            long id = keys.getLong(1);    
            prepst.close();
            return id;
        } 
        else{
            prepst.close();
            throw new SQLException("No se ha podido añadir la membresia.");
        }
    }

    @Override
    public long update(Member object) throws SQLException {
        
        long id = object.getId();
        String name = object.getName();
        String surname = object.getSurname();
        String email = object.getEmail();
        long permanence = object.getPermanence();
        String paid = object.getPaid();
        
        Statement statement = this.conn.createStatement(); 

        String sql = String.format("UPDATE members SET name = '%s', surname = '%s', email = '%s', permanence '%d', paid = '%s' WHERE id=%d", name, surname, email, permanence, paid, id);

        int affectedRows = statement.executeUpdate(sql);

        statement.close();

        if (affectedRows == 0)
            throw new SQLException("Creating user failed, no rows affected.");
        else
            return affectedRows;
    }

    @Override
    public boolean delete(long id) throws SQLException {
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = String.format("DELETE FROM members WHERE id=%d", id);
        int affectedrows = statement.executeUpdate(sql);
        if (affectedrows==0){
            throw new SQLException("No se ha podido eliminar el miembro, no han habido filas afectadas.");
        }
        statement.close();
        return affectedrows==1;
    }
    
}
