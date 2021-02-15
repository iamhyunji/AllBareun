<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>membership</title>
<link rel="stylesheet" href="../css/reset.css" type="text/css" />
<link rel="stylesheet" href="../css/layout.css" type="text/css" />
<link rel="stylesheet" href="../css/common/reg.css" type="text/css" />
<script type="module" src="../js/common/reg.js"></script>
</head>
<body>
   <!-- main -->
   <main>
      <section class="main">
         <div class="page-back">
            <a href="./login"> &lt;</a>
         </div>
         <h1 class="text-xl">All바른생각</h1>
         <h2 class="text-l">회원가입</h2>

         <form name="reg" action="reg" method="post" class="member"
            onsubmit="return submitCheck();">
            <section class="member-box">
               <p>
                  <span class="star">*</span>아이디
               </p>
               <div id="email">
                  <input type="email" class="text-box" name="email"
                     placeholder="이메일 입력 예) Allbaren@gmail.com">
                  <button type="button" class="id-button" onclick="idCheck()">ID중복검사</button>
               </div>

               <div id="pwd">
                  <p>
                     <span class="star">*</span>비밀번호
                  </p>
                  <input type="password" class="text-box password" name="password"
                     placeholder="(숫자,영문,특수문자 조합 최소 8자)">
                  <p>
                     <span class="star">*</span>비밀번호 확인
                  </p>
                  <input type="password" class="text-box re-pwd" name="re-pwd"
                     placeholder="비밀번호 확인">
               </div>

               <p>
                  <span class="star">*</span>이름
               </p>
               <input type="text" class="text-box" name="name" placeholder="이름">

               <p>성별</p>
               <input type="radio" name="gender" value="남"> 남자 <input
                  type="radio" name="gender" value="여"> 여자

               <p>생년월일</p>
               <input type="text" class="text-box" name="birth"
                  placeholder="예) 19930620">

               <p>
                  <span class="star">*</span>핸드폰 번호
               </p>
               <input type="text" class="text-box phone" name="phone"
                  placeholder="예)010-1111-1234">
                  
                <p>
                  <span class="star">*</span>이메일 주소
               </p>
               <div id="mail">
                  <input type="email" class="text-box" name="mail"
                     placeholder="이메일 입력">
               </div>

               <p>프로필 사진</p>

               <div class="drag-box">
                  <span>업로드할 파일을 드래그 드롭하세요!<span>
               </div>
               <input class="result-file-name" type="hidden" name="resultFileName"
                  value="">
               <div class="drag-result"></div>
               <input class="hidden-id" name="userId" type="hidden" value=${userId}>

            </section>
            <div class="submit-box">
               <input type="submit" class="submit-btn" value="All바른생각 회원가입">
            </div>
         </form>
      </section>
   </main>
</body>
</html>