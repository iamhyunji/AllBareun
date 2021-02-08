<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login</title>
<link rel="stylesheet" href="../css/reset.css" type="text/css" />
<link rel="stylesheet" href="../css/layout.css" type="text/css" />
<link rel="stylesheet" href="../css/common/login.css" type="text/css" />
</head>
<body>

	<!-- main -->
	<main>
		<section class="main">
			<h1 class="text-xl">
				<a href="./index.html"> All바른생각</a>
			</h1>
			<form action="login" method="post" class="login">
				<input type="email" class="text-box id-box" id="id-box"
					name="username" placeholder="아이디를 입력해 주세요."> <input
					type="password" class="text-box pwd-box" id="pwd-box"
					name="password" placeholder="패스워드를 입력해 주세요"> <input
					type="submit" class="login-box" value="로그인">
			</form>



			<div class="reg-id">
				<ul>
					<li><a href="reg">회원가입</a> <span>&nbsp;|&nbsp;</span></li>
					<li><a href="findId">아이디 찾기</a> <span>&nbsp;|&nbsp;</span></li>
					<li><a href="findPwd">비밀번호 찾기</a></li>
				</ul>
			</div>

			<div class="sns-box">
				<a href="javascript:kakaoLogin();" class="login-btn kakao">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
					src="../images/kakao.png"><span>&nbsp;카카오로 시작하기</span></a> <a
					href="" class="login-btn naver">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
					src="../images/naver.png"><span>&nbsp;네이버로 시작하기</span></a> <a
					href="" class="login-btn google">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
					src="../images/google.png"><span>&nbsp;구글로 시작하기</span></a>
			</div>
		</section>
	</main>
	<!--카카오 로그인 API  -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
        Kakao.init('d54c8d7c2510743fb3d930e99341fc2d');
        Kakao.isInitialized();

        function kakaoLogin() {
            window.Kakao.Auth.login({
                scope:'profile, account_email, gender, age_range',
                success: function(authObj) {
                    console.log(authObj);
                    window.kakao.API.request({
                        url:'/v2/user/me',
                        success: res => {
                            const kakao_account = res.kakao_account;
                            console.log(kakao_account);
                        }
                    });
                }
            });
        }
    </script>
</body>
</html>