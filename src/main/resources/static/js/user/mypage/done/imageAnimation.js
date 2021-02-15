import VideoPlayer from "./VideoPlayer.js";

window.addEventListener("load", function() {
	const profileLoc = document.querySelector(".profile");
	const videoSection = document.querySelector(".video-section");
	const videoFrame = document.querySelectorAll(".video-frame");
	const imgTag = document.querySelectorAll(".video-img");
	const stopIcon = document.querySelectorAll(".video-stop");
	let id = document.location.href.split("/")[5];



	fetch(`/api/mypage/barChart/${id}`)
		.then((response) => response.json())
		.then((json) => {
			console.log(json);
			var ctx = document.getElementById('myChart2');
			let barSum = new Array();
			let month2 = new Array();
			for (let a of json) {
				for (let b of a) {
					barSum.push(b.barSum);
					month2.push(b.month+"월");
				}

			}
			var myChart = new Chart(ctx, {
				type: 'bar', data: {
					labels: month2,
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






	fetch(`/api/mypage/lineChart/${id}`)
		.then((response) => response.json())
		.then((json2) => {

			console.log(json2);
			var ctx = document.getElementById('myChart').getContext('2d');
			let month = new Array();
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


	fetch(`/api/mypage/done/${id}`)
		.then((response) => response.json())
		.then((json) => {
			profileLoc.innerHTML = "";

			let authImage = new Array();
			let partUser = new Array();
			for (let n of json) {

				authImage.push(n.authImage);
				partUser.push(n.name);

			}

			fetch(`/api/mypage/profile/${id}`)
				.then((response) => response.json())
				.then((json2) => {
					profileLoc.innerHTML = "";

					let profile = new Array();
					let userName = new Array();

					for (let a of json2) {

						profile.push(a.userProfile);
						userName.push(a.userName);

					}


					let imgArrs = new Array(profile.length);  // 2차원 배열 [사람index][이미지갯수]
					for (var x = 0; x < profile.length; x++) {
						let tr = ``;
						tr = `<img class="w30-radius" src=${profile[x]} /> <span style="padding-right: 310px;">${userName[x]}</span>`;
						profileLoc.insertAdjacentHTML("beforeend", tr);

						let arr = [];		// 해당 회원이 등록한 인증 이미지 목록
						for (var y = 0; y < partUser.length; y++) {

							if (userName[x] == partUser[y]) {

								arr.push(authImage[y]);
							}
						}

						imgArrs[x] = arr;

					}
					let videoPlayers = [];
					for (let i = 0; i < imgArrs.length; i++) {
						videoPlayers.push(new VideoPlayer(imgArrs[i], i, videoFrame, imgTag, stopIcon));

					}


				});

		});






});


