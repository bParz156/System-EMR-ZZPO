package com.company.entities;

public abstract class User {

    private String login;
    private String password;

    void setCredetianls(String login, String password)
    {
        this.login=login;
        this.password=password;
    }

    public boolean checkCredentials(String login, String password)
    {
        return this.login==login && this.password==password;
    }

    private void changePassword(String password)
    {
        setCredetianls(this.login, password);
    }

    public String getPassword() {
        return password;
    }
}
