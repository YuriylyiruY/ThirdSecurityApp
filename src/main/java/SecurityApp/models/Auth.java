package SecurityApp.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Auth")
public class Auth {

    @Id
    @Column(name = "auth_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auth_id;

    @NotEmpty(message = "Role should not be empty")
    @Column(name = "role")
    private String role;
    @ElementCollection
    //List<String> rolesForTimeleaf = new ArrayList<>();


    @ManyToMany

    @JoinTable(
            name = "Person_Auth"
            , joinColumns = @JoinColumn(name = "for_auth_id")
            , inverseJoinColumns = @JoinColumn(name = "for_person_id")
    )
    private Set<User> people = new HashSet<>();


    public Auth() {
    }

    public Auth(String role) {

        this.role = role;
    }

    public void addRolePerson(User user) {
        if (user == null) {
            people = new HashSet<>();

        }

        people.add(user);
    }

    public Set<User> getPeople() {
        return people;
    }

    public void setPeople(User user) {
        people.add(user);

    }

    public int getIdForAuth() {
        return auth_id;
    }

    public void setIdForAuth(int idForAuth) {
        this.auth_id = idForAuth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(@NotEmpty(message = "Role should not be empty") String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "role='" + role + '\'' +
                ", idForAuth=" + auth_id +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + auth_id;
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Auth auth = (Auth) obj;
        if (auth_id != auth.auth_id) {
            return false;
        }
        return true;
    }

}
