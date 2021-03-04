<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>디테일 인덱스</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- 차트 링크 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!-- 차트 -->
<link href="/css/user/mygoal/detail-index.css" type="text/css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<script src="/js/user/mygoal/detail.js"></script>


<!-- --------------------------- <body> --------------------------------------- -->

<!-- --------------------------- main --------------------------------------- -->

<!-- <tiles:insertAttribute name="main" /> -->
<div class="tab-part">
	<div class="tab">
		<a href="${detail.id}" class="tab-button">디테일 인덱스</a> <a
			href="cert/list/${detail.id}" class="tab-button">이미지</a>
	</div>

</div>
<main id="main">


	<section class="detail-info">
		<div class="detail-info-img">
			<img src="${detail.mainImage}" alt="메인 이미지" />

		</div>
		<div class="detail-info-text">
			<h1>${detail.title}</h1>
			<span>${detail.exExplanation}</span>
			<table class="detail-table">
				<tbody>

					<tr>
						<td class="center w100">기간</td>

						<td class="left w200"><fmt:formatDate
								value="${detail.startDate}" type="both" pattern="yyyy/MM/dd" />-
							<fmt:formatDate value="${detail.endDate}" type="both"
								pattern="yyyy/MM/dd" /></td>
					</tr>
					<tr>
						<td class="center w100">인증횟수</td>
						<td class="left w200">${detail.count}회</td>
					</tr>

					<tr>
						<td class="center w100">인증 요일</td>
						<td class="left w200">${detail.days}</td>
					</tr>

					<tr>
						<td class="center w100">카테고리</td>
						<td class="left w200">${detail.categories}</td>
					</tr>

					<tr>
						<td class="center w100">참여인원</td>

						<td class="left w200"><c:forEach var="c" items="${profile}">
							${c.userName}
							</c:forEach></td>

						<td class="center w250"><c:forEach var="n" items="${profile}">
								<img class="w30-radius" src="${n.userProfile}" alt="프로필" />
							</c:forEach></td>

					</tr>


				</tbody>
			</table>
		</div>

	</section>


	<div class="detail-result">
		<div class="detail-result-chart">
			<h2>목표이행률</h2>
			<span></span>
			<div class="chart1">
				<canvas id="myChart"></canvas>

			</div>
		</div>

		<div class="detail-result-chart">
			<h2>진행평가 그래프</h2>
			<span></span>
			<div class="chart2">
				<canvas id="myChart2"></canvas>
			</div>
		</div>
		




	</div>
		




	</div>



</main>

<script>


   

</script>
