window.addEventListener("load", function() {
	let id = document.location.href.split("/")[4];
	let month = new Array();

	fetch(`/api/mygoal/lineChart/${id}`)
		.then((response) => response.json())
		.then((json2) => {

			console.log(json2);
			var ctx = document.getElementById('myChart').getContext('2d');

			let lineSum = new Array();
			for (let n of json2) {
				month.push(n.month + "월");
				lineSum.push(n.lineSum);

			}
			var chart = new Chart(ctx, { // 챠트 종류를 선택 
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



		});

	fetch(`/api/mygoal/barChart/${id}`)
		.then((response) => response.json())
		.then((json) => {
			console.log(json);
			var ctx = document.getElementById('myChart2');
			let barSum = new Array();
			//let month2 = new Array();
			for (let a of json) {
				for (let b of a) {
					barSum.push(b.barSum);
					//month2.push(b.month + "월");
				}

			}
			var myChart = new Chart(ctx, {
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



		});














});


