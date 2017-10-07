Data Transfer Objects
=======================

This is a simple demonstration of how not to use DTOs.

Build and Run
=============

```
mvn clean package
```

Why developers use DTO
=============

* query specified join fetching, but the owner of the fetched association was not present in the select list 
* LazyInitializing Exception
* Multiple views for different clients from the same entity
* JSF evaluation when there is no transaction


Why not to use DTO
=============

# Never, Ever use DTOs which using it is a shame. 

What are alternatives
=============

* Use xml as your data binding structure. see [aegis data binding](http://cxf.apache.org/docs/aegis-databinding-20x.html) to get the idea.
* Create more Abstracttion which leads to less code = less error and less tests.
* As a developer, it is your duty to provide a way for clean code by not using DTOs.

What are DTOs cons
=============

* Constructor overloading which leads to complexity unless you are using Ceylon or a language which support optional parameters.
* Boilerplate code which is cumbersome and tedious.
* ugly code
