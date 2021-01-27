<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <link rel="stylesheet" href="../../css/reset.css" />
    <link rel="stylesheet" href="../../css/user/mygoal/auth.css" />



    <!-- --------------------------- <body> --------------------------------------- -->

        <!-- --------------------------- main --------------------------------------- -->

        <!-- <tiles:insertAttribute name="main" /> -->
        <main id="main">
          <form action="">
            <section>
              <div class="main-container">
                <div class="contents-box">
                  <div class="ex-box">
                    <h1 class="title">인증 방법 예시</h1>
                    <div class="auth-box">
                      <div class="image-box">인증 예시 사진</div>
                      <div class="image-box">인증 예시 사진</div>
                      <textarea class="textarea" rows="5" cols="33" readonly>인증방법</textarea>
                    </div>
                  </div>
                </div>
                <div class="drag-box">드래그 박스</div>
                <div class="answer-container">
                  <ul>
                    <div class="answer">
                      <li>1. 오늘 목표를 잘 실행했다고 느낀다</li>
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
                  </ul>
                </div>
                <div class="button-container">
                  <input class="a-input-orange-l" type="submit" value="확인" />
                  <input class="a-input-white-l" type="button" value="취소" />
                </div>
              </div>
            </section>
          </form>
        </main>
    