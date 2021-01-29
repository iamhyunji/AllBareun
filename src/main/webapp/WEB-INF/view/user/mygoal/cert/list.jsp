<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <link rel="stylesheet" href="../../../css/user/mygoal/cert/list.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
      integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
      crossorigin="anonymous"
    />
  

        <!-- --------------------------- main --------------------------------------- -->

        <main id="main">
          <!-- Main -->

          <div id="page-wrapper">
            <section>
              <div class="tab-part">
                <div class="tab">
                  <a class="tab-button">디테일 인덱스</a>
                  <a class="tab-button">이미지/동영상</a>
                </div>
              </div>
              <div class="major">
                <div class="input-box">
                  <select name="name" id="">
                    <option value="">전체</option>
                    <option value="중언">중언</option>
                    <option value="본율">본율</option>
                    <option value="혜영">혜영</option>
                    <option value="현지">현지</option>
                  </select>
                  <input type="date" value="2020-09-09" /> -
                  <input type="date" value="2021-01-09" />
                </div>
              </div>
  
   <main class="main-container">
                 <div class="date text-l">2020-09-08</div>
                <div class="image-container">
                  <ul class="list-container">
                    <!-- list -->
                    <li class="goal-list">
                      <a href="#" class="image"><img src="images/pic01.jpg" alt="" /><i class="fa-2x fas fa-user-circle"></i></a>
                    </li>
                    <!-- list -->
                    <li class="goal-list">
                      <a href="#" class="image"><img src="images/pic02.jpg" alt="" /><i class="fa-2x fas fa-user-circle"></i></a>
                    </li>
                    <!-- list -->
                    <li class="goal-list">
                      <a href="#" class="image"><img src="images/pic03.jpg" alt="" /><i class="fa-2x fas fa-user-circle"></i></a>
                    </li>
                    <!-- list -->
                    <li class="goal-list">
                      <a href="#" class="image"><img src="images/pic04.jpg" alt="" /><i class="fa-2x fas fa-user-circle"></i></a>
                    </li>
                  </ul>
                </div>

              </main>
  
  
  
  
              
              
 <%--         <main class="main-container">
         <c:set var="dateVar" value=" " />
         <c:forEach var="n" items="${list}" varStatus="i">
         <fmt:formatDate var="dateFmt" value="${n.regdate}" pattern="yyyy.MM.dd"/>
              
          <c:if test="${dateFmt ne dateVar}"  var="res" scope="request">   
				 <c:out value="${requestScope.res}"/>
				 <c:set var="dateVar" value="${dateFmt}" /> 
				
			<c:choose>
				<c:when test="${i.first}">
                <div class="image-container">
                 <div class="date text-l">${dateFmt }</div>
                  <ul class="list-container">
                    <!-- list -->
                    <li class="goal-list">
                      <a href="#" class="image"><img src="/images/cert/1/pic06.jpg" alt="" /><i class="fa-2x fas fa-user-circle"></i></a>
                    </li>
                </c:when>
                
                <c:when test="${i.last}">                 	 
                 	 </ul>
                </div>
                <div class="image-container">
                  <div class="date text-l">${dateFmt }</div>
                  <ul class="list-container">
                    <!-- list -->
                    <li class="goal-list">
                      <a href="#" class="image"><img src="/images/cert/1/pic06.jpg" alt="" /><i class="fa-2x fas fa-user-circle"></i></a>
                    </li>
                    </ul>
                </div>
                </c:when>
                
               	<c:otherwise>
               	     </ul>
                </div>
                <div class="image-container">
                  <div class="date text-l">${dateFmt }</div>
                  <ul class="list-container">
                    <!-- list -->
                    <li class="goal-list">
                      <a href="#" class="image"><img src="/images/cert/1/pic06.jpg" alt="" /><i class="fa-2x fas fa-user-circle"></i></a>
                    </li>
               	</c:otherwise>
             </c:choose>
        </c:if>
        
        <c:if test="${dateFmt eq dateVar}"  var="res" scope="request">   
        		   <!-- list -->
                    <li class="goal-list">
                      <a href="#" class="image"><img src="/images/cert/1/pic06.jpg" alt="" /><i class="fa-2x fas fa-user-circle"></i></a>
                    </li>
        </c:if>
        		
         </c:forEach>
        		
    
                  
              </main> --%>
            </section>
          </div>
        </main>

