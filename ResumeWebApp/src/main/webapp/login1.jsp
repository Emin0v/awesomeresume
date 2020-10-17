<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>


<form action="login" method="POST" >
    <div class="login-form" style="background-color: lightskyblue">
        <h2 class="text-center">Log in</h2>
        <div class="form-group">

            <input placeholder="Enter email" class="form-control" type="email" name="email"/>

        </div>
        <div class="form-group">
            <input placeholder="Enter password" class="form-control" type="password" name="password"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary">Sign in</button>
        </div>
    </div>


</form>

</body>
</html>
