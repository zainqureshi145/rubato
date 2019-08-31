package no.rubato.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Table(name="persons")
public class Persons implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idPerson;
    @NotBlank(message = "Name is required")
    @Column(name="name")
    private String name;
    @Email(message = "Username should be an email")
    @NotEmpty(message = "Please Provide a valid Email Address")
    @Column(unique = true)
    private String username;
    @Column(name = "phone")
    private String phone;
    @NotBlank(message = "Password is required")
    @Column(name = "password")
    private String password;
    @Transient
    private String confirmPassword;
    @Column(name = "role")
    private String role;
    @Column(name = "vipps")
    private String vipps;

    //OneToMany with Project
    //@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "person", orphanRemoval = true)
    //private List<Persons> persons = new ArrayList<>();

    public Persons() {
    }

    ////Generate Getters and Setters
    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getVipps() {
        return vipps;
    }

    public void setVipps(String vipps) {
        this.vipps = vipps;
    }

    //UserDetails interface methods

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
