<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<%--<link rel="stylesheet" href="assets/css/login.css">--%>

<body>
    <div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="login" method="post">
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input style="background: azure" type="email" name="username" id="username"
                                       class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input style="background: azure" type="password" name="password" id="password"
                                       class="form-control">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">Sign in</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
