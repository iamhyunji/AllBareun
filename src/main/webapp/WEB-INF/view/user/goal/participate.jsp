<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<title>참가하기</title>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
      integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
      crossorigin="anonymous"/>
<link href="/css/user/goal/participate.css" type="text/css"
	rel="stylesheet">

			<!-- --------------------------- main --------------------------------------- -->

			<!-- <tiles:insertAttribute name="main" /> -->
			<main id="main">
				<section class="detail-info">
					<div class="detail-info-img">
						<img src="/images/img3.jpeg" alt="메인 이미지" />
	
					</div>
					<div class="detail-info-text">
						<h1> 저녁일기 쓰기 </h1> 
						<span>한줄이라도 좋아요</span>
						<table class="detail-table">
							<tbody>
	
								<tr>
									<td class="center w100">기간</td>
									<td class="left w200">2021/03/20 - 2021/06/31</td>
								</tr>
								<tr>
									<td class="center w100">인증횟수</td>
									<td class="left w200">2회</td>
								</tr>
	
								<tr>
									<td class="center w100">참여인원</td>
									<td class="left w200">본율,중언,현지,혜영</td>
									<td class="center w200"><i class="fa-2x fas fa-user-circle"></i></td>
	
								</tr>
	
	
							</tbody>
						</table>
						<a class="a-input-white-l" href="delete?c=${param.c}&id=${n.id}">목록</a>
						<a class="a-input-orange-l" href="delete?c=${param.c}&id=${n.id}">신청</a>
					</div>

				</section>
				

				<div class="detail-ex">
					<div class="detail-ex-good">
						<span> 인증예시 : 좋은 예시 </span> 
						<img class="image s-img" src="/images/default-image2.png" alt="좋은예시" />

					</div>

					<div class="detail-ex-bad">
						<span> 인증예시 : 나쁜 예시 </span> 
						 <img class="s-img" src="/images/default-image2.png" alt="나쁜예시" />
					</div>
					<div>
						인증방법가지고 오는 곳입니다.
					</div>
				</div>



			</main>
