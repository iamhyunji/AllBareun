<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="/css/user/mygoal/cert/list.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<script src="/js/user/mygoal/cert/list.js"></script>

<!-- --------------------------- main --------------------------------------- -->

<main id="main">
	<!-- Main -->

          <div id="page-wrapper">
            <section>
              <div class="tab-part">
                <div class="tab">
                  <a href="../../${g}" class="tab-button">디테일 인덱스</a>
                  <a href="./${g}" class="tab-button">이미지</a>
                </div>
                <div class="profile-box">
               		<c:forEach var="p" items="${profileInfo}">
               		<div class="profile">
               		<img class="profile-img" alt="" src="${p.profile}">
               		<span class="profile-name">${p.name}</span>
               		</div>
               		</c:forEach>
               	</div>
              </div>
              <div class="major">
                <div class="input-box">
                  <select class="select-name" name="name" id="">
                    <option value="">전체</option>
                  <c:forEach var="na" items="${nameInfo}">
                    <option value="${na}">${na}</option>
                  </c:forEach>
                  </select>
                  <input class="start-date" type="date" value="" /> -
                  <input class="end-date" type="date" value="" />
                  <input class="a-input-orange-s all-date-button"  type="button" value="전체 날짜"/>
                </div>

			</div>

			<main class="main-container">
				<fmt:timeZone value="KST">
					<c:set var="dateVar" value=" " />
					<c:forEach var="n" items="${list}" varStatus="i">

						<fmt:formatDate var="dateFmt" value="${n.regdate}"
							pattern="yyyy.MM.dd" />
						<c:if test="${dateFmt ne dateVar}" var="res" scope="request">
							<c:set var="dateVar" value="${dateFmt}" />

							<div class="image-container">
								<div class="date text-l">${dateFmt }</div>
								<ul class="list-container">
									<c:forEach var="a" items="${list}" varStatus="j">
										<fmt:formatDate var="aDateFmt" value="${a.regdate}"
											pattern="yyyy.MM.dd" />

										<c:if test="${aDateFmt eq dateVar}">
											<li class="goal-list"><a
												href="/mygoal/cert/${a.goalId}/detail/${a.id}" class="image"><img
													src="${a.authImage}" alt="" /><img class="fa-user-circle"
													src="${a.profile}" /></a></li>
										</c:if>
									</c:forEach>
								</ul>
							</div>
						</c:if>
					</c:forEach>
				</fmt:timeZone>
			</main>

		</section>
	</div>
</main>

