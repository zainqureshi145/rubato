package no.rubato.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="persons")
public class Persons implements UserDetails {

    public Persons(@NotBlank(message = "Name is required") String name, @Email(message = "Username should be an email") @NotEmpty(message = "Please Provide a valid Email Address") String username, String phone, @NotBlank(message = "Password is required") String password, String confirmPassword, String role, String vipps, String about, String price, List<Images> images, List<Audio> audio, List<Video> video, List<Orders> orders) {
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
        this.vipps = vipps;
        this.about = about;
        this.price = price;
        this.images = images;
        this.audio = audio;
        this.video = video;
        this.orders = orders;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persons")
    private long idPerson;
    @NotBlank(message = "Name is required")
    @Column(name="name")
    private String name;
    @Email(message = "Username should be an email")
    @NotEmpty(message = "Please Provide a valid Email Address")
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
    @Column(name = "about")
    private String about;
    @Column(name = "price")
    private String price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Images> images;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Audio> audio;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> video;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Orders> orders;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<Audio> getAudio() {
        return audio;
    }

    public void setAudio(List<Audio> audio) {
        this.audio = audio;
    }

    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
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
