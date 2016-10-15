package mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.model.Customer;

public class CustomerDaoImpl implements CustomerDaoCustom 
{

    @Autowired
    EntityManager entityManager;
    
    
    @Override
    public List<Customer> fetch()
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        createCriteria(builder,query, root);
        List<Customer> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }
    
    @Override
    public Long resultCount()
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Customer> root = query.from(Customer.class);
        createCriteria(builder,query, root);
        return entityManager.createQuery(query.select(builder.count(root))).getSingleResult();
    }


    private void createCriteria(CriteriaBuilder builder, CriteriaQuery<?> query, Root<Customer> root)
    {
        Fetch<Object, Object> fetch = root.fetch("order");
    }

}
