package members;

public class Member {
    
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private long permanence;
    private String paid;

    public Member() {

    }

    public Member(long id, String name, String surname, String email, String password, long permanence, String paid) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.permanence = permanence;
        this.paid = paid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPermanence() {
        return permanence;
    }

    public void setPermanence(long permanence) {
        this.permanence = permanence;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return String.format("%s (%s %s)",getEmail(), getName(), getSurname());
    }

}
