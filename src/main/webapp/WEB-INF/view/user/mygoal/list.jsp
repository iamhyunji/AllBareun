<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/user/mygoal/list.css">

<main id="main">
	<h1 class="d-none">Content Body > Main</h1>
	
	<section>
		<h1 class="d-none">주단위 캘린더</h1>
		<ol class="calendar__weekly">
			<li>
				<div>
					4일
					<ul>
						<li>스트레칭 하기</li>
						<li>저녁 일기 쓰기</li>
					</ul>
				</div>
			</li>
			<li>
				<div>
					5일
					<ul>
						<li>스트레칭 하기</li>
						<li>저녁 일기 쓰기</li>
					</ul>
				</div>
			</li>
			<li>
				<div>
					6일
					<ul>
						<li>스트레칭 하기</li>
						<li>저녁 일기 쓰기</li>
					</ul>
				</div>
			</li>
			<li>
				<div>
					7일
					<ul>
						<li>스트레칭 하기</li>
						<li>저녁 일기 쓰기</li>
					</ul>
				</div>
			</li>
			<li>
				<div>
					8일
					<ul>
						<li>스트레칭 하기</li>
						<li>저녁 일기 쓰기</li>
					</ul>
				</div>
			</li>
			<li>
				<div>
					9일
					<ul>
						<li>스트레칭 하기</li>
						<li>저녁 일기 쓰기</li>
					</ul>
				</div>
			</li>
			<li>
				<div>
					10일
					<ul>
						<li>스트레칭 하기</li>
						<li>저녁 일기 쓰기</li>
					</ul>
				</div>
			</li>
		</ol>
	</section>
	
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
	
			<input class="a-input-white-s hover" type="submit" value="검색" />
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
						<a href="#" class="setting">*</a>
						<a class="a-input-orange-s" href="#">인증하기</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</section>
</main>