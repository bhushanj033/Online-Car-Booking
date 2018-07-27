<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

  
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/mystyle.css" rel="stylesheet">
	 <link href="${css}/all.css" rel="stylesheet">
  </head>

 
<body>
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
        <form action="Customer/CustomerList">
        
        <button type="submit">List Customers</button>
        </form>
          </div>
        </div>
      </div>
  </div>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

  </body>

</html>
