package br.infnet.at.user.clientUser;

import br.infnet.at.user.User;

public class ClientUser extends User {

    private String preferredCategory;
    private String preferredActor;

    public ClientUser() {
        super();
        this.preferredCategory = "Testando Categoria";
        this.preferredActor = "Testando Ator";
    }

    public ClientUser(String preferredCategory, String preferredActor) {
        this.preferredCategory = preferredCategory;
        this.preferredActor = preferredActor;
    }

    public ClientUser(String firstName, String lastName, Integer age, String email, String preferredCategory, String preferredActor) {
        super(firstName, lastName, age, email);
        this.preferredCategory = preferredCategory;
        this.preferredActor = preferredActor;
    }

    @Override
    public String toString() {
        return "ClientUser{" +
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", active=" + getIsActive() +
                ", preferredCategory='" + preferredCategory + '\'' +
                ", preferredActor='" + preferredActor + '\'' +
                '}';
    }

    public String getPreferredCategory() {
        return preferredCategory;
    }

    public void setPreferredCategory(String preferredCategory) {
        this.preferredCategory = preferredCategory;
    }

    public String getPreferredActor() {
        return preferredActor;
    }

    public void setPreferredActor(String preferredActor) {
        this.preferredActor = preferredActor;
    }
}
