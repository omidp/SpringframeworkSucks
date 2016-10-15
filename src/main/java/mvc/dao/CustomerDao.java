package mvc.dao;

import org.springframework.data.repository.CrudRepository;

import mvc.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long>
{

}
