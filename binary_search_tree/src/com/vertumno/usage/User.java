package com.vertumno.usage;

public class User
{
    int id;
    public String toString()
    {
        return "ID: " + this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id)
    {
        this.id = id;
    }
}