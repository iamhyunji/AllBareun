<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/user/mypage/done/list.css">

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
			<c:forEach var="g" items="${list }">
				<li>
					<img class="s-img" src="${g.mainImage }" alt="" />
					<div>
						<h2 class="text-l"><a href="#">${g.title }</a></h2>
						<span>카테고리 : ${g.categories }</span>
						<span>기간 : 4주 (${g.startDate } - ${g.endDate })</span>
						<span>횟수 : ${g.count }회 (${g.days })</span>
						<span>참가 : ${g.totalParticipants }명 (${g.groupParticipants })</span>
					</div>
					<div>
						<input class="del-button" type="button" value="x" />
						<a class="a-input-orange-s" href="#">결과 리포트</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</section>
</main>
