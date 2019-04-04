<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<h2>Login with username and password</h2>
		
		<!-- errorMsg가 비어있지 않다면 -->
		<c:if test="${not empty errorMsg }">
			<div style="color:#ff0000;">
			<h3>${errorMsg}</h3>
			</div>
		</c:if>
		
		<!-- logoutMsg가 비어있지 않다면 -->
		<c:if test="${not empty logoutMsg }">
			<div style="color:#0000ff;">
			<h3>${logoutMsg}</h3>
			</div>
		</c:if>
		
		<form action="<c:url value="/login"/>" method="post">
		<!-- label for값과 input id값이 같아야함 -->
		<!-- input name은 db에 있는거랑 동일해야함 -->
			<div class="form-group">
				<label for="username">Username:</label> 
				<input type="text" class="form-control" id="username" placeholder="Enter username"
					name="username" style="width:50%">

			</div>
			
			<div class="form-group">
				<label for="pwd">Password:</label> 
				<input type="password" class="form-control" id="pwd" placeholder="Enter password"
					name="password" style="width:50%">
			</div>
			<!-- csrf 공격 막기위해 token 생성하는 코드 hidden이라 안보임 -->
			<input type="hidden" name ="${_csrf.parameterName}" value="${_csrf.token }" />
					
			<button type="submit" class="btn btn-primary">Submit</button>

		</form>
	</div>
</div>
