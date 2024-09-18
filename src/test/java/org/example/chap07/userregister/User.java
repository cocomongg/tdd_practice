package org.example.chap07.userregister;

public class User {
    private String id;
    private String password;
    private String email;
    public User(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean matchPassword(String password){
        return this.password.equals(password);
    }
}
