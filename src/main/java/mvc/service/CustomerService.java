package mvc.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.dao.CustomerDao;
import mvc.dao.OrderDao;
import mvc.model.Customer;
import mvc.model.Order;

@Service
@Transactional
public class CustomerService
{

    
    @Autowired
    CustomerDao customerDao;
    
    @Autowired
    OrderDao orderDao;

    @Transactional
    public Order load()
    {
//        
        //if transaction manager will be ignored in configuration you get Lazyinitializeexception from order.getCustomer 
        Order order = orderDao.findAll(Arrays.asList(1L)).iterator().next();
        System.out.println(order.getCustomer().getName());        
        return order;
    }
    
    
}


