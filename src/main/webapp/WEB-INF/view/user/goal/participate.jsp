<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>참가하기</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<link href="/css/user/goal/participate.css" type="text/css"
	rel="stylesheet">

<!-- --------------------------- main --------------------------------------- -->

<!-- <tiles:insertAttribute name="main" /> -->
<main id="main">
	<section class="detail-info">
		<div class="detail-info-img">
			<img src="${detail.mainImage}" alt="메인 이미지" />

		</div>
		<div class="detail-info-text">
			<h1>${detail.title}</h1>
			<span>${detail.exExplanation}</span>
			<table class="detail-table">
				<tbody class="w500">

					<tr>
						<td class="center w100">기간</td>

						<td class="left w250"><fmt:formatDate
								value="${detail.startDate}" type="both" pattern="yyyy/MM/dd" />-
							<fmt:formatDate value="${detail.endDate}" type="both"
								pattern="yyyy/MM/dd" /> ${detail.dateDiff} 주</td>
					</tr>
					<tr>
						<td class="center w100">인증횟수</td>
						<td class="left w250">주 ${detail.count}회</td>
					</tr>

					<tr>
						<td class="center w100">인증 요일</td>
						<td class="left w250">${detail.days}</td>
					</tr>

					<tr>
						<td class="center w100">카테고리</td>
						<td class="left w250">${detail.categories}</td>
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
					<tr>
						<td class="center w200">*(${detail.totalParticipants - detail.nowParticipantsCount}
							자리 남아있어요)</td>
					</tr>


				</tbody>
			</table>

			<form method="post" enctype="multipart/form-data">
				<a class="a-input-white-l" href="list">목록</a> <input type="hidden"
					name="goalId" value="${detail.id}">


				<c:if
					test="${detail.totalParticipants == detail.nowParticipantsCount}">

				</c:if>
				<c:if
					test="${detail.totalParticipants > detail.nowParticipantsCount}">
					<input class="a-input-orange-l" type="submit" value="참가">
				</c:if>



			</form>
		</div>

	</section>





	<div class="detail-ex">
		<div class="detail-ex-good">
			<span> 인증예시 : 좋은 예시 </span> <img class="image s-img"
				src="${detail.goodEx}" alt="좋은예시" />

		</div>

		<div class="detail-ex-bad">
			<span> 인증예시 : 나쁜 예시 </span> <img class="s-img" src="${detail.badEx}"
				alt="나쁜예시" />
		</div>
		<div>${detail.exExplanation}</div>
	</div>



</main>
