<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    <link rel="stylesheet" href="../../css/user/mygoal/cert/detail.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
      integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
      crossorigin="anonymous"
    />
 
        <!-- --------------------------- main --------------------------------------- -->

        <main id="main">
          <div id="page-wrapper">
            <!-- Main -->

            <section>
              <div class="tab-part">
                <div class="tab">
                  <a class="tab-button">디테일 인덱스</a>
                  <a class="tab-button">이미지/동영상</a>
                </div>
              </div>
              <div class="major"></div>
              <div class="goal-container">
                <a href="#"><img src="../../images/img1.JPG" alt="" class="l-img" /></a>
                <div class="detail-bar">2021.01.11 <span>월 18:03:24</span> <i class="fa-2x fas fa-user-circle"></i><span class="name">현지</span></div>
                <div class="answer-container">
                  <ul>
                    <div class="answer">
                      <li>1. 오늘 목표를 잘 실행했다고 느낀다</li>
                      <div class="circle-box">
                        <span>그렇지 않다</span>
                        <input type="radio" class="circle c-xl no" name="q1" value="1" />
                        <input type="radio" class="circle c-l no" name="q1" value="2" />
                        <input type="radio" class="circle c-m no" name="q1" value="3" />
                        <input type="radio" class="circle c-s" checked name="q1" value="4" />
                        <input type="radio" class="circle c-m ok" name="q1" value="5" />
                        <input type="radio" class="circle c-l ok" name="q1" value="6" />
                        <input type="radio" class="circle c-xl ok" name="q1" value="7" />
                        <span>그렇다</span>
                      </div>
                    </div>
                    <div class="answer">
                      <li>2. 목표한 계획에 잘 도달하고 있다고 생각한다</li>
                      <div class="circle-box">
                        <span>그렇지 않다</span>
                        <input type="radio" class="circle c-xl no" name="q2" value="1" />
                        <input type="radio" class="circle c-l no" name="q2" value="2" />
                        <input type="radio" class="circle c-m no" name="q2" value="3" />
                        <input type="radio" class="circle c-s" checked name="q2" value="4" />
                        <input type="radio" class="circle c-m ok" name="q2" value="5" />
                        <input type="radio" class="circle c-l ok" name="q2" value="6" />
                        <input type="radio" class="circle c-xl ok" name="q2" value="7" />
                        <span>그렇다</span>
                      </div>
                    </div>
                    <div class="answer">
                      <li>3. 앞으로도 내 스스로 목표를 실천할 의향이 있다.</li>
                      <div class="circle-box">
                        <span>그렇지 않다</span>
                        <input type="radio" class="circle c-xl no" name="q3" value="1" />
                        <input type="radio" class="circle c-l no" name="q3" value="2" />
                        <input type="radio" class="circle c-m no" name="q3" value="3" />
                        <input type="radio" class="circle c-s" checked name="q3" value="4" />
                        <input type="radio" class="circle c-m ok" name="q3" value="5" />
                        <input type="radio" class="circle c-l ok" name="q3" value="6" />
                        <input type="radio" class="circle c-xl ok" name="q3" value="7" />
                        <span>그렇다</span>
                      </div>
                    </div>
                  </ul>
                </div>
                <div class="review">
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam laborum similique facere inventore. Nesciunt, illo doloribus, perferendis laborum cumque iste ducimus natus nulla
                  modi excepturi, molestiae reiciendis quo inventore magnam repellat veritatis? Rerum commodi repellendus recusandae a nemo consequatur voluptates sed corporis, iusto, quaerat aliquid
                  quasi nobis alias vel ab.
                </div>
                <div class="button-container">
                  <input class="a-input-orange-l" type="submit" value="&lt  prev" />
                  <input class="a-input-white-l" type="submit" value="목록" />
                  <input class="a-input-orange-l" type="submit" value="&gt next" />
                </div>
              </div>
            </section>
          </div>
        </main>

