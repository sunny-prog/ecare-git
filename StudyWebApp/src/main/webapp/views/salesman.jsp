<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<h2>eCare</h2>
<div class="nav">
  <div class="container">
    <ul>
    <li><a href="/StudyWebApp/tariff.jsp">tariffs</a></li>
    <li><a href='<%= request.getContextPath() %>/views/TariffSee.go'>tariffs</a></li>
    </ul>
    <h3>Contracts:</h3>
    <ul>
      <li>create new</li>
      <li>see</li>
      <li>block</li>
      <li>unblock</li>
    </ul>
  </div>
  <input type='submit' value='SEND' />
</div>

</body>
</html>
