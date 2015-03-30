<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<h2>eCare</h2>
<table>
<c:forEach var="tariff"
           items="${sessionScope.tariffList}">
           <tr>
           <td>${tariff.price}</td><a href="/blockUser?id={id}"><input type="button" value="block"></a>
           <td>${tariff.title}</td><a href="/blockUser?id={id}"><input type="button" value="block"></a>
           </tr> 
    
</c:forEach>
</table>
</body>
</html>