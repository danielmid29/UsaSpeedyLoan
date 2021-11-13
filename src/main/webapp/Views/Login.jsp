<html>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  <head>

<title>Login Form </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Style.css">
  </head>
  <body>
    <div class="center">
      <h1 style="text-decoration: solid;">Login</h1>
      <form class = "Login-form" method="post" name="form" action="/login"> 
        <div class="txt_field">
          <input type="text" required id="uname" name="user">
          <label>Username</label>
        </div>
        <div class="txt_field">
          <input type="password" required id="pass" name="password">
          <span></span>
          <label>Password</label>
        </div>
        <div style="color: brown;"><c:out value="${error.errorMessage}" /></div>
        <input type="submit" value="Login">    
      </form>
      <br>
    </div>
  </body>
</html>