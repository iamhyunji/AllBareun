import VideoPlayer from "./VideoPlayer.js";

window.addEventListener("load", function() {
	const profileLoc = document.querySelector(".profile");
	const videoSection = document.querySelector(".video-section");
	const videoFrame = document.querySelectorAll(".video-frame");
	const imgTag = document.querySelectorAll(".video-img");
	const stopIcon = document.querySelectorAll(".video-stop");
	let id = document.location.href.split("/")[5];

	fetch(`/api/mypage/done/${id}`)
		.then((response) => response.json())
		.then((json) => {
			profileLoc.innerHTML = "";

			let authImage = new Array();
			let partUser = new Array();
			for (let n of json) {

				authImage.push(n.authImage);
				partUser.push(n.name);

				/*console.log(partUser);
				console.log(date);*/

				//console.log(json)
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


					//console.log(json2);
					/*console.log(profile);
					console.log(userName);
					*/
					
					let imgArrs = new Array(profile.length);  // 2차원 배열 [사람index][이미지갯수]
					for (var x = 0; x < profile.length; x++) {
						let tr = ``;
						tr = `<img class="w30-radius" src=${profile[x]} /> <span style="padding-right: 310px;">${userName[x]}</span>`;
						profileLoc.insertAdjacentHTML("beforeend", tr);
						
						let arr = [];		// 해당 회원이 등록한 인증 이미지 목록
						for (var y = 0; y < partUser.length; y++) {

							/*console.log("-----------profile----------------");
							console.log(profile);
							console.log("-------------partUser--------------");
							console.log(partUser);
							console.log("----------authImage-----------------");
							console.log(authImage);
							console.log("------------userName---------------");
							console.log(userName);*/
							console.log(`userName[${x}]=${userName[x]} / partUser[${y}]=${partUser[y]}`);
							if (userName[x] == partUser[y]) {
								
							/*	let td = ``;
								td = `<img class="w50-radius" src=${authImage[y]} />`;

								profileLoc.insertAdjacentHTML("beforeend", td);*/
								console.log("-----------"+userName[x]+"-------------------");
								console.log(authImage);
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


