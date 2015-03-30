<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<h2>Hello World!</h2>
<table>
<c:forEach var="user"
           items="${sessionScope.userList}">
           <tr>
           <td>${user.name}</td><a href="/blockUser?id={id}"><input type="button" value="block"></a>
            <td>${user.age}</td><a href="/blockUser?id={id}"><input type="button" value="block"></a>
           </tr> 
    
</c:forEach>
</table>
</body>
</html>