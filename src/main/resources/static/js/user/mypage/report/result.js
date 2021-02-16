
window.addEventListener("load", () => {



	/*fetch(`/api/mypage/done/2`)
		.then((response) => response.json())
		.then((json) => {
			var ctx2 = document.getElementById('myChart2');
			let barSum = new Array();
			let month = new Array();
			for (let x of json) {
				for (let y of x) {
					barSum.push(y.barSum);
					month2.push(y.month + "월");
				}

			}
			var myChart = new Chart(ctx2, {
				type: 'bar', data: {
					labels: month,
					datasets: [{
						label: '데이터 표시 모양', data: barSum,
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



		});*/


	fetch(`/api/mypage/report/lineChart`)
		.then((response) => response.json())
		.then((json2) => {

			var ctx1 = document.getElementById('myChart').getContext('2d');
			let month2 = new Array();
			let lineSum = new Array();
			for (let b of json2) {
				lineSum.push(b.lineSum);
				month2.push(b.month + "월");

			} console.log(json2);

			var chart = new Chart(ctx1, { // 챠트 종류를 선택 
				type: 'line',
				// 챠트를 그릴 데이타
				data: {
					labels: month2,
					datasets: [{
						label: '데이터 표시 색', backgroundColor: 'transparent', borderColor: 'red',
						data: lineSum
					}]
				}, // 옵션 
				options: {}
			});

		});




	fetch(`/api/mypage/report/radarChart`)
		.then((response) => response.json())
		.then((json3) => {

			var ctx3 = document.getElementById('myChart').getContext('2d');
			let category = new Array();
			let radarSum = new Array();
			for (let a of json3) {
				radarSum.push(a.radarSum);
				category.push(a.categoryTitle);
			}

			var chart = new Chart(ctx3, { // 챠트 종류를 선택 
				type: 'radar',
				// 챠트를 그릴 데이타
				data: {
					labels: category,
					datasets: [{
						label: '데이터 표시 색', backgroundColor: 'rgba(75, 192, 192, 0.2)', borderColor: 'green',

						data: radarSum
					}]
				}, // 옵션 
				options: {}
			});

		});





});