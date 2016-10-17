package mvc.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "customer_order")
public class Order
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_name")
    private String orderName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public String getOrderName()
    {
        return orderName;
    }

    public void setOrderName(String orderName)
    {
        this.orderName = orderName;
    }

    @Override
    public String toString()
    {
        return orderName;
    }

}
