<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" integrity="sha384-vSIIfh2YWi9wW0r9iZe7RJPrKwp6bG+s9QZMoITbCckVJqGCCRhc+ccxNcdpHuYu" crossorigin="anonymous">
<link rel="stylesheet" href="/css/user/mypage/done/list.css">
<script type="text/javascript" src="/js/user/mypage/done/list.js"></script>

<main id="main">
	<h1 class="d-none">Content Body > Main</h1>

	<section class="search">
		<h1 class="d-none">검색폼</h1>
		<form action="list" method="get" class="search__form">
			<div>
				<input type="checkbox" name="sc" value="생활" />
				<label>생활</label>
				<input type="checkbox" name="sc" value="취미" />
				<label>취미</label>
				<input type="checkbox" name="sc" value="건강" />
				<label>건강</label>
				<input type="checkbox" name="sc" value="관계" />
				<label>관계</label>
				<input type="checkbox" name="sc" value="역량" />
				<label>역량</label>
				<input type="checkbox" name="sc" value="자산" />
				<label>자산</label>
			</div>

			<div>
				<label>참가</label>
				<select class="select-s" name="sp">
					<option value="0" ${ (param.sp == "0") ? "selected" : "" } >전체</option>
					<option value="1" ${ (param.sp == "1") ? "selected" : "" } >개인</option>
					<option value="2" ${ (param.sp == "2") ? "selected" : "" } >그룹</option>
				</select>
			</div>

			<div>
				<label>종료</label>
				<select class="select-s" name="sa">
					<option value="2" ${ (param.sa == "2") ? "selected" : "" }>전체</option>
					<option value="1" ${ (param.sa == "1") ? "selected" : "" }>완료</option>
					<option value="0" ${ (param.sa == "0") ? "selected" : "" }>미완료</option>
				</select>
			</div>

			<input type="text" name="q" value="${param.q }" />
			
			<input class="a-input-white-s" type="submit" value="검색" />
		</form>
	</section>

	<section class="goals">
		<h1 class="d-none">목표 리스트</h1>
		<ul class="goals__list">
			<c:forEach var="g" items="${list }">
				<li>
					<a href="${g.id }"><img class="s-img" src="${g.mainImage }" alt="" /></a>
					<div class="goal__contents">
						<div class="goal__title">
							<h2 class="text-l"><a href="${g.id }">${g.title }</a></h2>
							<p class="text-m-bold">${g.categories }</p>
						</div>
						<p>기간 : ${g.dateDiff }주 (<fmt:formatDate value="${g.startDate }" pattern="yyyy-MM-dd" /> - <fmt:formatDate value="${g.endDate }" pattern="yyyy-MM-dd" />)</p>
						<p>횟수 : 주 ${g.count }회 (${g.days })</p>
						<div class="participants__container">
							참가 : 총 ${g.totalParticipants }명
							${g.participants }
						</div>
					</div>
					<div class="goal__buttons">
						<i class="fas fa-times del-button"><a href="list?del-goalId=${g.id }" style="display : none"></a></i>
						<c:if test="${g.achievement < 5}">
							<a class="a-input-white-s retry-button" href="${g.id }/retry">재도전</a>
						</c:if>
						<a class="a-input-orange-s" href="#">결과 리포트</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</section>
</main>
