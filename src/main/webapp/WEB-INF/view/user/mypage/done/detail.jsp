<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <title>개인 결과 리포트</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- 차트 링크 -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script> <!-- 차트 -->
        <link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
      integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
      crossorigin="anonymous"/>

<link href="/css/user/mypage/done/detail.css" type="text/css"
	rel="stylesheet">



	<!-- --------------------------- <body> --------------------------------------- -->
	

			<!-- --------------------------- main --------------------------------------- -->

			<!-- <tiles:insertAttribute name="main" /> -->
			<main id="main">
				<section class="detail-info">
					<div class="detail-info-img">
						<img src="/images/img1.jpg" alt="메인 이미지" />
	
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
					</div>

				</section>


                <div class="detail-result">
                    <div class="detail-result-chart">
                        <h2>평가지</h2>
                        <span>실제 인증 횟수/ 전체횟수</span>
                        <div class="chart1" >
                            <canvas id="myChart"></canvas>
    
                        </div>
                    </div>
                   
                    <div class="detail-result-chart">
                        <h2>달성도</h2>
                        <span>실제 인증 횟수/ 전체횟수</span>
                        <div class="chart2" >
                            <canvas id="myChart2"></canvas>
    
                        </div>
                    </div>

                   

                    
                </div>


                <div>
                    <span>이미지</span>
                    <!-- 이건 본율 오빠한테 받아야겠다 -->
                </div>

            </main>

   


<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, { // 챠트 종류를 선택 
        type: 'line',
        // 챠트를 그릴 데이타
        data: {
            labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
            datasets: [{
                label: 'My First dataset', backgroundColor: 'transparent', borderColor: 'pink',
                data: [0, 10, 5, 2, 20, 30, 45]
            }]
        }, // 옵션 
        options: {}
    });



    var ctx = document.getElementById('myChart2');
    var myChart = new Chart(ctx, {
        type: 'bar', data: {
            labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
            datasets: [{
                label: '# of Votes', data: [12, 19, 3, 5, 2, 3,5],
                backgroundColor: ['rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'],
                borderColor: ['rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
</script>