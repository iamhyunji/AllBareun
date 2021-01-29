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
</head>
<body>
    <!-- main -->
    <main>
        <section class="main">
            <div class="page-back"><a href="./login.html"> &lt;</a></div>
            <h1 class="text-xl">All바른생각</h1>
            <h2 class="text-l">회원가입</h2>
            
            <form action="reg" method="post" class="member">
                <section class="member-box">
                    <p><span class="star">*</span>아이디</p>
                    <input type="text" class="text-box" name="email" placeholder="이메일 입력">
                    
                    <p><span class="star">*</span>비밀번호</p>
                    <input type="text" class="text-box" name="password" placeholder="비밀번호(숫자,영문,특수문자 조합 최소 8자)">
                    <input type="text" class="text-box" name="re-psw" placeholder="비밀번호 확인">
                    
                    <p><span class="star">*</span>이름</p>
                    <input type="text" class="text-box" name="name" placeholder="이름">
                    
                    <p>성별</p>
                    <input type="radio" name="gender"> 남 <input type="radio" name="gender"> 여
                    
                    <p>나이</p>
                    <input type="text" class="text-box" name="age" placeholder="예) 30">
                    
                    <p>핸드폰 번호</p>
                    <input type="text" class="text-box" name="phone" placeholder="예)010-1111-1234">
                    
                    <p>프로필 사진</p>
                    <div class="drop-zone">
                        <span id="img-text">이미지 사진</span>
                        <input type="file" name="profile" id=""  class="hidden-btn">
                        
                    </div>
                </section>
                <div class="submit-box">
                <input type="submit" class="submit-btn" value="All바른생각 회원가입">
                </div>
            </form>
        </section>
    </main>
</body>
</html>