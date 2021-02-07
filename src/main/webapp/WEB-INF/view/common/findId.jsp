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

            <form class="find-id" method="post" action="findIdPage">
            <input type="text" class="text-box name-box" name="name" placeholder="이름을 입력해 주세요.">
            <input type="text" class="text-box phone-box" name="phone" placeholder="핸드폰 번호를 입력해 주세요.(-없이)">
			<br>
			<input type="submit" class="find-btn" value="아이디 찾기">
            </form>
        </section>
    </main>
</body>
</html>