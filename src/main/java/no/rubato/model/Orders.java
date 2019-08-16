package no.rubato.model;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idOrder;
    @Column(name = "id_user_o")
    private int idUser;
    @Column(name = "id_band_o")
    private int idBand;
////Generate Getters and Setters
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBand() {
        return idBand;
    }

    public void setIdBand(int idBand) {
        this.idBand = idBand;
    }
}
