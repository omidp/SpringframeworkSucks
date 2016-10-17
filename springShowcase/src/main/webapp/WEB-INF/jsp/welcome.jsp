<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
this is from Spring controller  <br />

${message}

<form id="frm" method="post" action="welcome">
	<input name="name" value="${customer.name}" id="name" />
	<input name="baghali"  id="baghali" />
	<input name="order[0].orderName"  id="orderName" value="${customer.order[0].orderName}"/>
	
	<input type="submit" value="Send !"> 
</form>

</body>
</html>