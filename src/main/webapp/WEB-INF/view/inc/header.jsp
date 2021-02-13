<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<header id="header">
	<h1 class="d-none">All바른생각</h1>

	<div class="main-logo">
		<a href="/index"><img src="/images/all.png" alt=""></a>
	</div>

	<nav>
		<h1 class="d-none">Header Navigation Bar</h1>
		<ul class="h-list">
			<li><a href="#">서비스 소개</a></li>
			<li><a href="/goal/list">목표</a></li>
			<li><a href="/goal/reg">개설</a></li>
			<li><a href="/mygoal/list">내 목표</a></li>
			<s:authorize access="isAnonymous()">
				<li><a href="/login">로그인</a></li>
			</s:authorize>
			<s:authorize access="isAuthenticated()">
			<li><a href="/mypage/report/result">마이페이지</a></li>
			<li><a href="/logout">로그아웃</a></li>
			</s:authorize>
		</ul>
	</nav>
</header>