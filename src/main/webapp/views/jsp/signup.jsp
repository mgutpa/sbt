<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your credentials</title>

</head>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/views/js/jquery-3.3.1.min.js">
	</script>
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/views/js/bootstrap.min.js">
	</script>
	
<body>

<div class="container">

    <form method="POST" action="<%=request.getContextPath()%>/login">
        <h2 >Log in</h2>

        <div>
            <span></span>
            <input name="username" type="text"  placeholder="Username"/> <br>
            <input name="password" type="password"  placeholder="Password"/><br>
            <span></span>

            <button  type="submit">Log In</button>
        </div>

    </form>

</div>
</body>
</html>