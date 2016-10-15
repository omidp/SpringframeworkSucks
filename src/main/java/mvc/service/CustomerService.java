package mvc.service;

import java.util.Arrays;
import java.util.List;

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
//        Order order = orderDao.findAll(Arrays.asList(1L)).iterator().next();
//        System.out.println(order.getCustomer().getName());        
//        return order;
//        List<Customer> fetch = customerDao.fetch();
//        for (Customer customer : fetch)
//        {
//            System.out.println(customer.getOrder().iterator().next().getOrderName());
//        }
//        
        //org.hibernate.QueryException: query specified join fetching, but the owner of the fetched association was not present in the select list [FromElement{explicit,not a collection join,fetch join,fetch non-lazy properties,classAlias=generatedAlias1,role=mvc.model.Customer.order,tableName=customer_order,tableAlias=order1_,origin=customer customer0_,columns={customer0_.id ,className=mvc.model.Order}}]
        Long resultCount = customerDao.resultCount();
        System.out.println(resultCount);
        return new Order();
    }
    
    
}


