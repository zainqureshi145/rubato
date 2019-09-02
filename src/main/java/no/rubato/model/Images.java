package no.rubato.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private long idImage;
    @Column(name = "name")
    private String name;
    @Column(name = "path")
    private String path;
    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    private Persons persons;


    public long getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }
}
