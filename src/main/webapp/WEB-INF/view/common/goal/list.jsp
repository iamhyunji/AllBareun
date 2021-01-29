<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="../../css/common/list.css" />
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
        <main id="main">
          <!-- Main -->

          <div id="page-wrapper">
            <section class="search-container">
              <form action="">
                <table class="search-table">
                  <tr>
                    <th class="select-s">카테고리</th>
                    <td>
                      <div class="category">
                        <span><input type="checkbox" name="categories" value="생활"/>생활</span>
                        <span><input type="checkbox" name="categories"  value="취미"/>취미</span>
                        <span><input type="checkbox" name="categories"  value="건강"/>건강</span>
                        <span><input type="checkbox" name="categories"  value="관계"/>관계</span>
                        <span><input type="checkbox" name="categories"  value="역량"/>역량</span>
                        <span><input type="checkbox" name="categories"  value="자산"/>자산</span>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <th class="select-s">기간</th>
                    <td>
                      <div><input name="startDate" type="date" /> ~ <input name="endDate" type="date" /></div>
                    </td>
                  </tr>
                  <tr>
                    <th class="select-s">요일</th>
                    <td>
                      <div class="day">
                        <span><input type="checkbox" name="days" value="월" />월</span>
                        <span><input type="checkbox" name="days" value="화" />화</span>
                        <span><input type="checkbox" name="days" value="수" />수</span>
                        <span> <input type="checkbox" name="days" value="목" />목</span>
                        <span><input type="checkbox" name="days" value="금" />금</span>
                        <span><input type="checkbox" name="days" value="토" />토</span>
                        <span> <input type="checkbox" name="days" value="일" />일</span>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <th class="select-s">인원</th>
                    <td>
                      <div>
                        <select name="totalParticipants" id="">
                          <option value="0">전체</option>
                          <option value="1">1명</option>
                          <option value="2">2명</option>
                          <option value="3">3명</option>
                          <option value="4">4명</option>
                          <option value="5">5명</option>
                          <option value="6">6명</option>
                          <option value="7">7명</option>
                          <option value="8">8명</option>
                          <option value="9">9명</option>
                          <option value="10">10명</option>
                        </select>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2">
                      <div>
                        <input class="search-bar select-xl" type="text" name="query" placeholder="목표 검색!" />
                        <input class="a-input-white-s" type="submit" value="검색" />
                      </div>
                    </td>
                  </tr>
                </table>
              </form>
            </section>
            <section>
              <ul class="list-container">
              <c:forEach var="n" items="${list}">
                <!-- list -->
                <li class="goal-list">
                  <a href="#" class="image"><img src="${n.mainImage}" alt="" /></a>
                  <div class="para">
                    <div class="goal-title">
                      <h2>${n.title}</h2>
                      <span>${n.categories}</span>
                    </div>
                    <fmt:formatDate var="startDate" value="${n.startDate}" pattern="yyyy.MM.dd"/>
                    <fmt:formatDate var="endDate" value="${n.endDate}" pattern="yyyy.MM.dd"/>
                    <p>기간 : ${n.dateDiff}주 (${startDate}~${endDate})</p>
                    <p>횟수 : 주 ${n.count}회 (${n.days})</p>
                    <p>모집 : ${n.totalParticipants}명 (${n.nowParticipantsCount}/${n.totalParticipants})</p>
                    <a href="#" class="button">참가하기</a>
                  </div>
                </li>
              </c:forEach>
              </ul>
            </section>
          </div>
        </main>
    
