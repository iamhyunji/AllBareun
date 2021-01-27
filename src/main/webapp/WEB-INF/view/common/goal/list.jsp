<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <link rel="stylesheet" href="../../css/common/list.css" />

 
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
                        <span><input type="checkbox" name="category" />생활</span>
                        <span><input type="checkbox" name="category" />건강</span>
                        <span><input type="checkbox" name="category" />관계</span>
                        <span><input type="checkbox" name="category" />역량</span>
                        <span><input type="checkbox" name="category" />자산</span>
                        <span><input type="checkbox" name="category" />취미</span>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <th class="select-s">기간</th>
                    <td>
                      <div><input type="date" /> ~ <input type="date" /></div>
                    </td>
                  </tr>
                  <tr>
                    <th class="select-s">요일</th>
                    <td>
                      <div class="day">
                        <span><input type="checkbox" name="day" value="mon" />월</span>
                        <span><input type="checkbox" name="day" value="tue" />화</span>
                        <span><input type="checkbox" name="day" value="wed" />수</span>
                        <span> <input type="checkbox" name="day" value="thu" />목</span>
                        <span><input type="checkbox" name="day" value="fri" />금</span>
                        <span><input type="checkbox" name="day" value="sat" />토</span>
                        <span> <input type="checkbox" name="day" value="sun" />일</span>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <th class="select-s">인원</th>
                    <td>
                      <div>
                        <select name="count" id="">
                          <option value="all">전체</option>
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
                        <input class="search-bar select-xl" type="text" placeholder="목표 검색!" />
                        <input class="a-input-orange-s" type="submit" value="검색" />
                      </div>
                    </td>
                  </tr>
                </table>
              </form>
            </section>
            <section>
              <ul class="list-container">
                <!-- list -->
                <li class="goal-list">
                  <a href="#" class="image"><img src="images/pic01.jpg" alt="" /></a>
                  <div class="para">
                    <div class="goal-title">
                      <h2>그림 그리기</h2>
                      <span>취미</span>
                    </div>
                    <p>기간 : 3달 (2021.2.1~2020.5.1)</p>
                    <p>횟수 : 월 2회 (화,목)</p>
                    <p>모집 : 3명 (1/3)</p>
                    <a href="#" class="button">참가하기</a>
                  </div>
                </li>
                <!-- list -->
                <li class="goal-list">
                  <a href="#" class="image"><img src="images/pic02.jpg" alt="" /></a>
                  <div class="para">
                    <div class="goal-title">
                      <h2>그림 그리기</h2>
                      <span>취미</span>
                    </div>
                    <p>기간 : 3달</p>
                    <p>횟수 : 월 2회</p>
                    <p>모집 : 3명</p>
                    <a href="#" class="button">참가하기</a>
                  </div>
                </li>
                <!-- list -->
                <li class="goal-list">
                  <a href="#" class="image"><img src="images/pic03.jpg" alt="" /></a>
                  <div class="para">
                    <div class="goal-title">
                      <h2>그림 그리기</h2>
                      <span>취미</span>
                    </div>
                    <p>기간 : 3달</p>
                    <p>횟수 : 월 2회</p>
                    <p>모집 : 3명</p>
                    <a href="#" class="button">참가하기</a>
                  </div>
                </li>
                <!-- list -->
                <li class="goal-list">
                  <a href="#" class="image"><img src="images/pic04.jpg" alt="" /></a>
                  <div class="para">
                    <div class="goal-title">
                      <h2>그림 그리기</h2>
                      <span>취미</span>
                    </div>
                    <p>기간 : 3달</p>
                    <p>횟수 : 월 2회</p>
                    <p>모집 : 3명</p>
                    <a href="#" class="button">참가하기</a>
                  </div>
                </li>
                <!-- list -->
                <li class="goal-list">
                  <a href="#" class="image"><img src="images/pic05.jpg" alt="" /></a>
                  <div class="para">
                    <div class="goal-title">
                      <h2>그림 그리기</h2>
                      <span>취미</span>
                    </div>
                    <p>기간 : 3달</p>
                    <p>횟수 : 월 2회</p>
                    <p>모집 : 3명</p>
                    <a href="#" class="button">참가하기</a>
                  </div>
                </li>
                <!-- list -->
                <li class="goal-list">
                  <a href="#" class="image"><img src="images/pic06.jpg" alt="" /></a>
                  <div class="para">
                    <div class="goal-title">
                      <h2>그림 그리기</h2>
                      <span>취미</span>
                    </div>
                    <p>기간 : 3달</p>
                    <p>횟수 : 월 2회</p>
                    <p>모집 : 3명</p>
                    <a href="#" class="button">참가하기</a>
                  </div>
                </li>
              </ul>
            </section>
          </div>
        </main>
    
