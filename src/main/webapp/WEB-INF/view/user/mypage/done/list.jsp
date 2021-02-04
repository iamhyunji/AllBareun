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
		<form action="#" method="get" class="search__form">
			<div>
				<input type="checkbox" name="category" />
				<label>역량</label>
				<input type="checkbox" name="category" />
				<label>생활</label>
				<input type="checkbox" name="category" />
				<label>관계</label>
				<input type="checkbox" name="category" />
				<label>건강</label>
				<input type="checkbox" name="category" />
				<label>취미</label>
				<input type="checkbox" name="category" />
				<label>자산</label>
			</div>

			<div>
				<label>참가 인원</label>
				<select class="select-s" name="participation">
					<option value="">전체</option>
					<option value="">개인</option>
					<option value="">그룹</option>
				</select>
			</div>

			<div>
				<label>종료</label>
				<select class="select-s" name="finish">
					<option value="#">전체</option>
					<option value="#">완료</option>
					<option value="#">미완료</option>
				</select>
			</div>

			<input class="a-input-white-s" type="submit" value="검색" />
		</form>
	</section>

	<section class="goals">
		<h1 class="d-none">목표 리스트</h1>
		<ul class="goals__list">
			<c:forEach var="g" items="${list }" varStatus="st">
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
							<div class="profile__container">
								${g.participants }
							</div>
						</div>
					</div>
					<div class="goal__buttons">
						<i class="fas fa-times del-button"><a href="list?del-goalId=${g.id }" style="display : none"></a></i>
						<c:if test="${gaList[st.index].achieve < 3.0 }">
							<a class="a-input-white-s retry-button" href="${g.id }/retry">재도전</a>
						</c:if>
						<a class="a-input-orange-s" href="#">결과 리포트</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</section>
</main>
