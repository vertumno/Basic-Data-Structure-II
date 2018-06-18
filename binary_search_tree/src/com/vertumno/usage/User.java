package com.vertumno.usage;

/**
 * @author Lucas Gomes Dantas
 * @date June the 18th, 2018
 * This is almost a mockery class. It was implemented simply to store an object inside the Binary Tree.
 * This class only holds an ID.
 */
public class User
{
    private int id;

    public String toString() { return "ID: " + this.id; }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() { return id;}

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) { this.id = id; }

    /**
     * Instantiates a new User.
     *
     * @param id the id
     */
    public User(int id) { this.id = id; }
}