<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- inc Start -->
<%@ include file="../include/inc.jsp" %>
<!-- inc End -->

<meta charset="UTF-8">
<title>Main</title>
</head>
<body>	
    <div class="container">
      <!-- Content Start -->
      <div class="jumbotron">
        <h2>주소가 잘못되거나 없는 페이지입니다. </h2>
        <p>
          <a class="btn btn-lg btn-primary" href="<c:url  value ="/" />" role="button">메인페이지로 &raquo;</a>
        </p>
      </div>
      <!-- Content End -->   
    </div>
</body>
</html>







    
