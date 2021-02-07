<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>결과 리포트</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- 차트 링크 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!-- 차트 -->

<link href="/css/user/mypage/report/result.css" type="text/css"
	rel="stylesheet">
<!-- <script src="/js/user/mypage/report/result.js"></script> -->

<!----------------------------- <body> --------------------------------------- -->

<!----------------------------- main --------------------------------------- -->

<!-- <tiles:insertAttribute name="main" /> -->
<main id="main">

	<div class="result-chart">
		<h1>전체 결과</h1>
		<span>월별 달성 목표 / 월별 총 목표</span>
		<div class="chart3">
			<%--  <c:forEach var="e" items="${evaluation}">
								${e.month}
								${e.sum }
							</c:forEach> --%>

			<canvas id="myChart3">
                        
                    
		
		</div>
	</div>

	<div class="result-chart">
		<h1>월별 달성</h1>
		<span>월별 달성 목표 / 월별 총 목표</span>
		<div class="chart2">
			<canvas id="myChart2">

                    
		
		</div>
		 <c:forEach var="c" items="${categoryChart}">
		
		${c.categoryTitle}
		${c.categorySum}
	</c:forEach>
	</div>

	<div class="result-chart">
		<h1>월별 달성</h1>
		<span>평가지 기반</span>
		<div class="chart1">
			<canvas id="myChart">

                    
		
		</div>
	</div>

</main>
<script>
var ctx1 = document.getElementById('myChart').getContext('2d');
let month = new Array();
let lineSum = new Array();
 <c:forEach var="e" items="${evaluation}">
	month.push(${e.month}+'월');
	lineSum.push(${e.lineSum });
</c:forEach>

    var chart = new Chart(ctx1, { // 챠트 종류를 선택 
        type: 'line',
        // 챠트를 그릴 데이타
        data: {
            labels: month,
            datasets: [{
                label: '데이터 표시 색', backgroundColor: 'transparent', borderColor: 'red',
                data: lineSum
            }]
        }, // 옵션 
        options: {}
    });


    var ctx3 = document.getElementById('myChart3').getContext('2d');

    var chart = new Chart(ctx3, { // 챠트 종류를 선택 
        type: 'radar',
        // 챠트를 그릴 데이타
        data: {
            labels: ['생활','자산','운동'],
            datasets: [{
                label: '데이터 표시 색', backgroundColor: 'rgba(75, 192, 192, 0.2)', borderColor: 'green',

                 data: [22,12,34]
            }]
        }, // 옵션 
        options: {}
    });


    var ctx2 = document.getElementById('myChart2');
    var myChart = new Chart(ctx2, {
        type: 'bar', data: {
            labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
            datasets: [{
                label: '데이터 표시 색', data: [12, 19, 3, 5, 2, 3,5],
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