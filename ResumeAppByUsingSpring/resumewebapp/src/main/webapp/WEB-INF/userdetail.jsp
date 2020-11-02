<%@page import="com.company.dao.inter.UserDaoInter" %>
<%@page import="com.company.entity.User" %>
<%@page import="com.company.main.Context" %>
<%@page import="com.company.dao.inter.CountryDaoInter" %>
<%@page import="com.company.entity.Country" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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
//    CountryDaoInter countryDao = Context.instanceCountryDao();
//    List<Country> countryList = countryDao.getAll();

%>
<div style="margin-left: 50px;margin-right: 50px ">
    <f:form class="form-horizontal" action="userdetail" method="POST" modelAttribute="userdetail">
        <input type="hidden" name="action" value="save"/>
        <f:input type="hidden" path="id"/>

        <div class="form-row">
            <div class="form-group form-group col-md-6">
                <label>name</label>
                <f:input class="form-control" placeholder="Enter name" path="name"/>
                <br/>
                <label>surname</label>
                <f:input class="form-control" placeholder="Enter surname" path="surname"/>
            </div>
        </div>

        <br/>
        <br/>

        <div>
            <div class="form-row">
                <div class="form-group form-group col-md-6">
                    <label>address</label>
                    <f:input class="form-control" placeholder="Enter address" path="address"/>
                </div>

                <div class="form-group form-group col-md-6">
                    <label>phone</label>
                    <f:input class="form-control" placeholder="Enter phone" path="phone"/>
                </div>

                <div class="form-group form-group col-md-6">
                    <label>email</label>
                    <f:input class="form-control" placeholder="Enter email" path="email"/>
                </div>

                <div class="form-group form-group col-md-6">
                        <label for="example-date-input" class="col-2 col-form-label">Birthdate</label>
                        <div class="col-10">
                            <f:input class="form-control" type="date" path="birthdate" id="example-date-input"/>
                        </div>
                </div>
            </div>
            <br/>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect1">Country</label>
                </div>
                <f:select class="custom-select" id="inputGroupSelect1" path="birthplace">
                    <option selected><%=u.getBirthplace()%>
                    </option>

                <c:forEach items="${country}" var="c">
                    <option value="${c.name}">${c.name}</option>

                    </c:forEach>
                </f:select>

<%--            </div>--%>
<%--            <div class="input-group mb-3">--%>
<%--                <div class="input-group-prepend">--%>
<%--                    <label class="input-group-text" for="inputGroupSelect1">Country</label>--%>
<%--                </div>--%>
<%--                <select class="custom-select" id="inputGroupSelect1" name="country">--%>
<%--                    <option selected><%=u.getBirthplace()%>--%>
<%--                    </option>--%>

<%--                    <%for (Country c : countryList) {%>--%>
<%--                    <option value="<%=c%>"><%=c%>--%>
<%--                    </option>--%>
<%--                    <%}%>--%>
<%--                </select>--%>

<%--            </div>--%>

        </div>
        </br>
<%--        <input class="btn btn-primary" type="submit" name="save" value="Save"/>--%>
        <f:button class="btn btn-primary" type="submit">Save</f:button>
    </f:form>

</div>

</body>
</html>
