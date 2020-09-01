<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Jquery -->
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script>
$(document).ready(function() {
	/* 게시판 목록*/
	$.get("/board/boardlist", function(rData) {
		$.each(rData, function() {
			var name = $(this).attr("name");
			var code = $(this).attr("code");
			var str = "<li><a href='/board/"+code+"'>"+name+"</a></li>";
			
			$("#dropdown_boardList").append(str);
		});
	});
});
</script>

<nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href='<c:url value="/"/>'>Home</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">게시판목록<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu" id="dropdown_boardList">
	              <!-- 
	                <li><a href="#">Action</a></li>
	                <li class="divider"></li>
	                <li class="dropdown-header">Nav header</li>
	                <li><a href="#">One more separated link</a></li>
	               -->
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li
            	<c:if test="${pageCode eq 'LOGIN' }"> class="active"</c:if>
            ><a href="/user/login">로그인</a></li>
            <li
            	<c:if test="${pageCode eq 'SIGN' }"> class="active"</c:if>
            ><a href="/user/sign">회원가입<span class="sr-only">(current)</span></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>