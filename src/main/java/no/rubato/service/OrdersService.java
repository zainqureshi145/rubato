package no.rubato.service;

import no.rubato.model.Orders;
import no.rubato.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ordersService")
public class OrdersService {
    private OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    public Orders findByIdOrder(int idOrder){
        return ordersRepository.findByIdOrder(idOrder);
    }
    public Orders findByIdUser(int idUser){
        return ordersRepository.findByIdUser(idUser);
    }
    public Orders findByIdBand(int idBand){
        return ordersRepository.findByIdBand(idBand);
    }

    public void saveOrder(Orders orders){
        ordersRepository.save(orders);
    }
}