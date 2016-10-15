== This is what happens when you use combination of JSF, JPA(Hibernate) and Spring framework

=== First Rule : all associations are LAZY

+ try to get count query by fetching lazy associatoin 

```
org.hibernate.QueryException: query specified join fetching, but the owner of the fetched association was not present in the select list 
```

+ try to evaluate JSF expression #{customer.order.orderName}

	due to hibernate proxy, you can't

+ when there is no more transaction manager


```
Lazyinitializeexception 
```

more Errors will come up. stay tune.

=== Conclusion

# Never, Ever use this combination otherwise you end up using so many DTOs which is shame. 
