package mvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mvc.model.Customer;

public interface CustomerDaoCustom 
{

    
    public List<Customer> fetch();
    
    public Long resultCount();
    
}
