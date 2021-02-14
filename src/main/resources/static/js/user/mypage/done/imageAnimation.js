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

			let date = new Array();
			let partUser = new Array();
			for (let n of json) {

				date.push(n.authImage);
				partUser.push(n.name);
				console.log(partUser);
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
					
					
					
					console.log(profile.length);
					console.log(partUser);
					console.log(userName);
					
					for (var x = 0; x < profile.length; x++) {
						let tr = ``;
							tr = `<img class="w30-radius" src=${profile[x]} /> <span>${userName[x]}</span>`;
							profileLoc.insertAdjacentHTML("beforeend", tr);
						for (var y = 0; y < partUser.length; y++) {
								
							if (userName[x] == partUser[y]) {
								let arr = new Array();
								let td = ``;
								td = `<img class="w50-radius" src=${date[y]} />`;
								arr = date[y];

								profileLoc.insertAdjacentHTML("beforeend", td);

								let imgArrs = [];
									imgArrs[x] = arr;
								let videoPlayers = [];
								for (let i = 0; i < imgArrs.length; i++) {
									videoPlayers[i] = new VideoPlayer(imgArrs[i], i, videoFrame, imgTag, stopIcon);


								}


							}
							
						}


					}
					console.log(profile.length);


				});





		});






});


