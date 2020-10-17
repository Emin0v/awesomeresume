<%@page import="com.company.dao.inter.UserDaoInter" %>
<%@page import="com.company.entity.User" %>
<%@page import="com.company.main.Context" %>
<%@ page import="com.company.dao.inter.CountryDaoInter" %>
<%@ page import="com.company.entity.Country" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<%

    User u = (User) request.getAttribute("user");
    CountryDaoInter countryDao = Context.instanceCountryDao();
    List<Country> countryList = countryDao.getAll();

%>
<div style="margin-left: 50px;margin-right: 50px ">
    <form class="form-horizontal" action="userdetail" method="POST">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="<%=u.getId()%>"/>

        <div class="form-row">
            <div class="form-group form-group col-md-6">
                <label>name</label>
                <input class="form-control" placeholder="Enter name" type="text" name="name" value="<%=u.getName()%>"/>
                <br/>
                <label>surname</label>
                <input class="form-control" placeholder="Enter surname" type="text" name="surname"
                       value="<%=u.getSurname()%>"/>
            </div>
        </div>

        <br/>
        <br/>

        <div>
            <div class="form-row">
                <div class="form-group form-group col-md-6">
                    <label>address</label>
                    <input class="form-control" placeholder="Enter address" type="text" name="address"
                           value="<%=u.getAddress()%>"/>
                </div>

                <div class="form-group form-group col-md-6">
                    <label>phone</label>
                    <input class="form-control" placeholder="Enter phone" type="text" name="phone"
                           value="<%=u.getPhone()%>"/>
                </div>

                <div class="form-group form-group col-md-6">
                    <label>email</label>
                    <input class="form-control" placeholder="Enter email" type="text" name="email"
                           value="<%=u.getEmail()%>"/>
                </div>

                <div class="form-group form-group col-md-6">
                    <%--                    <label>birthdate</label>--%>
                     <%--                    <input class="form-control" placeholder="Enter birthdate" type="text" name="birthdate"--%>
                    <%--                           value="<%=u.getBirthDate()%>"/>--%>
<%--                    <div class="form-group row">--%>
                        <label for="example-date-input" class="col-2 col-form-label">Birthdate</label>
                        <div class="col-10">
                            <input class="form-control" type="date" name="birthdate" value="<%=u.getBirthDate()%>" id="example-date-input">
                        </div>
<%--                    </div>--%>
                </div>
            </div>
            <br/>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect1">Country</label>
                </div>
                <select class="custom-select" id="inputGroupSelect1" name="country">
                    <option selected><%=u.getBirthplace()%>
                    </option>

                    <%for (Country c : countryList) {%>
                    <option value="<%=c%>"><%=c%>
                    </option>
                    <%}%>
                </select>

            </div>

        </div>
        </br>
        <input class="btn btn-primary" type="submit" name="save" value="Save"/>
    </form>

</div>

</body>
</html>
