package no.rubato.repository;

import no.rubato.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    Orders findByIdOrder (int idOrder);
    Orders findByIdUser (int idUser);
    Orders findByIdBand (int idBand);
}
