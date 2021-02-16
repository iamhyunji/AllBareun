<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/user/mygoal/cert/detail.css" />    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
      integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
      crossorigin="anonymous"
    />
   	<script src="/js/user/mygoal/cert/detail.js"></script>
        <!-- --------------------------- main --------------------------------------- -->

        <main id="main">
          <div id="page-wrapper">
            <!-- Main -->

            <section>
              <div class="tab-part">
                <div class="tab">
                  <a href="/mygoal/${g}" class="tab-button">디테일 인덱스</a>
                  <a href="/mygoal/cert/list/${g}" class="tab-button">이미지</a>
                </div>
              </div>
             <%--  <fmt:timeZone value="KST"> --%>
              <div class="major"></div>
              <div class="goal-container">
                <img src="${d.authImage}" alt="" class="l-img" />
                <div class="detail-bar">
	               <div class="date">
	               <fmt:formatDate var="dateFmt" value="${d.regdate}" pattern="yyyy.MM.dd"/>
	                <span>${dateFmt}</span>
	                <fmt:formatDate var="dateDay" value="${d.regdate}" pattern="E"/> 
	                <fmt:formatDate var="dateHour" value="${d.regdate}" pattern="HH:mm:ss"/> 
	                <span>${dateDay} ${dateHour}</span>
	               </div>
	               <div>
	                 <img class="fa-user-circle" src="${d.profile}"/>
	                 <span class="name">${d.name }</span>
	                </div>
                 </div>
                 <%-- </fmt:timeZone> --%>
                <div class="answer-container">
                  <ul>
                    <div class="answer">
                      <li>1. 오늘 목표를 잘 실행했다고 느낀다</li>
                      <div class="circle-box">
                        <span>그렇지 않다</span>
                        <span class="circle c-xl"/></span>
                        <span  class="circle c-l "   /></span>
                        <span  class="circle c-m "   /></span>
                        <span  class="circle c-s"   /></span>
                        <span  class="circle c-m "  /></span>
                        <span  class="circle c-l "   /></span>
                        <span  class="circle c-xl "  /></span>
                        <span>그렇다</span>
                      </div>
                    </div>
                    <div class="answer">
                      <li>2. 목표한 계획에 잘 도달하고 있다고 생각한다</li>
                      <div class="circle-box">
                        <span>그렇지 않다</span>
                        <span class="circle c-xl"/></span>
                        <span  class="circle c-l "   /></span>
                        <span  class="circle c-m "   /></span>
                        <span  class="circle c-s"   /></span>
                        <span  class="circle c-m "  /></span>
                        <span  class="circle c-l "   /></span>
                        <span  class="circle c-xl "  /></span>
                        <span>그렇다</span>
                      </div>
                    </div>
                    <div class="answer">
                      <li>3. 앞으로도 내 스스로 목표를 실천할 의향이 있다.</li>
                      <div class="circle-box">
                        <span>그렇지 않다</span>
                         <span class="circle c-xl"/></span>
                        <span  class="circle c-l "   /></span>
                        <span  class="circle c-m "   /></span>
                        <span  class="circle c-s"   /></span>
                        <span  class="circle c-m "  /></span>
                        <span  class="circle c-l "   /></span>
                        <span  class="circle c-xl "  /></span>    
                        <span>그렇다</span>
                      </div>
                    </div>
                  </ul>
                </div>
                <div class="review">
                	${d.explanation}
                </div>
                <div class="button-container">
                
                <c:choose >
	                <c:when test="${empty prev}">
	                <input class="a-input-orange-l" type="button" value="마지막입니다" />
	                </c:when>
	                <c:otherwise>
	                 	<a href="${prev.id}"><input class="a-input-orange-l" type="button" value="&lt  prev" /></a>
	                </c:otherwise>
	                </c:choose>
                
                <a href="/mygoal/cert/list/${d.goalId}"><input class="a-input-white-l" type="button" value="목록" /></a>
                
                <c:choose >
	                <c:when test="${empty next}">
	               		<input class="a-input-orange-l" type="button" value="마지막입니다" />
	                </c:when>
	                <c:otherwise>
	               		<a href="${next.id}"><input class="a-input-orange-l" type="button" value="&gt next" /></a>
	                </c:otherwise>
                </c:choose>
                </div>
              </div>
            </section>
          </div>
        </main>

