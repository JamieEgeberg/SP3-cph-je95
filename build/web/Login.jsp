<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--<form action="Front" method="POST">-->
        <h1>Welcome to the Cupcakery!</h1>
        Please log in to continue:
        <form action="Login" method="POST">
            <input type="text" name="username" placeholder="Username" />
            <input type="password" name="password" placeholder="Password" />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
