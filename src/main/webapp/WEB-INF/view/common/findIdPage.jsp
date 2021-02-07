<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>findID</title>
    <link rel="stylesheet" href="../css/reset.css" type="text/css" />
    <link rel="stylesheet" href="../css/layout.css" type="text/css" />
    <link rel="stylesheet" href="../css/common/find.css" type="text/css" />
</head>
<body>
    <!-- main -->
    <main>
        <section class="main">
            <div class="page-back"><a href="./login"> &lt;</a></div>
            <h1>아이디 찾기</h1>

            <div class="find-box">
                <div class="find-id find unclicked">아이디 찾기</div>
                <a href="./findPwd"><div class="find-pwd find clicked">비밀번호 찾기</div></a>
            </div>

            <br>
            <span class="color">${name}</span> 님의 아이디는<br>
            <span class="color">${email} </span>입니다
            
            <a href="./login" class="a-input-orange-m" id="login-button">로그인</a>

            </form>
        </section>
    </main>
</body>
</html>