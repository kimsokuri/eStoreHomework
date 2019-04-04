<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<h2>Administrator Page</h2>
		<!-- 글자 도드러지게 할수있대 lead쓰면 -->
		<p class="lead">Product를 관리할 수 있는 페이지입니다옹</p>
	</div>

	<div class="container">
		<!-- 인벤토리 조회할수있게끔 하자. -->
		<a href="<c:url value ="/admin/productInventory"/>" ><h2>Product Inventory</h2></a>
		<!-- 글자 도드러지게 할수있대 lead쓰면 -->
		<p class="lead">Here you can view, check, modify the product Inventory</p>
	</div>
</div>
