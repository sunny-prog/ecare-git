<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<h2>Hello World!</h2>
<table>
<c:forEach var="user"
           items="${sessionScope.userList}">
           <tr>
           <td>${user.name}</td>
            <td>${user.age}</td>
           </tr> 
    
</c:forEach>
</table>
</body>
</html>