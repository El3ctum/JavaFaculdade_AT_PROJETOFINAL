package br.infnet.at.user;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
    private Boolean isActive;

    public User(){
        this.setFirstName("Davi");
        this.setLastName("Vieira");
        this.setAge(25);
        this.setEmail("davilealmarcal198@gmail.com");
        this.setPassword("Testando");
    };

    public User(String firstName, String lastName, Integer age, String email) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setEmail(email);
    }


    @Override
    public String toString() {
        return "The user name is: " + firstName + " and his age is: " + age + ".";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
