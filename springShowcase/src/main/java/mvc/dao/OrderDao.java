package mvc.dao;

import org.springframework.data.repository.CrudRepository;

import mvc.model.Customer;
import mvc.model.Order;

public interface OrderDao extends CrudRepository<Order, Long>
{

}
