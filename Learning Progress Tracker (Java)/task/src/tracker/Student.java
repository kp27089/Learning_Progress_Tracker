package tracker;

public class Student {
    String name;
    String lastName;
    String email;
    static int counter = 9999;
    String id;
    String java;
    String dsa;
    String databases;
    String spring;


    public Student(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        counter++;
        this.id = String.valueOf(counter);
        this.java = String.valueOf(0);
        this.java = String.valueOf(0);
        this.dsa = String.valueOf(0);
        this.databases = String.valueOf(0);
        this.spring = String.valueOf(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public String getDsa() {
        return dsa;
    }

    public void setDsa(String dsa) {
        this.dsa = dsa;
    }

    public String getDatabases() {
        return databases;
    }

    public void setDatabases(String databases) {
        this.databases = databases;
    }

    public String getSpring() {
        return spring;
    }

    public void setSpring(String spring) {
        this.spring = spring;
    }
}
