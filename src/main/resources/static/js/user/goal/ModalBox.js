import CSS from "/js/modules/CSS.js";

class ModalBox {
	static alert(message) {
		return new Promise(resolve => {
			let screen = document.createElement("div");
			let frame = document.createElement("div");

			// ----------------------------- Set screen CSS -----------------------------
			CSS.set(screen, {
				position: "fixed",
				left: "0px",
				top: "0px",
				width: "100%",
				height: "100%",
				background: "#000",
				opacity: "0",
				transition: "1s"
			});

			document.body.append(screen);
			setTimeout(() => {
				CSS.set(screen, {
					opacity: "0.7"
				});
			});

			// ----------------------------- Set frame CSS -----------------------------
			screen.addEventListener("transitionend", () => {
				CSS.set(frame, {
					opacity: "1",
					top: "30%"
				});
			});

			CSS.set(frame, {
				position: "fixed",
				top: "40%",
				left: "30%",
				background: "#fff",
				width: "400px",
				height: "300px",
				opacity: "0",
				transition: "top 1s"
			});

			frame.className = "modalbox__alert";
			frame.innerHTML = `
            <div>
                <h1 class="text-l" style="text-align:center">목표 삭제</h1>
            </div>
			<div>
				${message}
			</div>
            <div>
                <input type="button" class="a-input-orange-m" value="확인">
                <input type="button" class="a-input-white-m" value="취소">
            </div>`;

			document.body.append(frame)

			// ----------------------------- Submit -----------------------------
			const okButton = frame.querySelector("input[value=확인]");
			const cancelButton = frame.querySelector("input[value=취소]");
			okButton.onclick = () => {
				screen.remove();
				frame.remove();
				resolve("확인");
			};
			cancelButton.onclick = () => {
				screen.remove();
				frame.remove();
				resolve("취소");
			};
		});
	}

	static confirm(message) {
		let screen = document.createElement("div");
		let frame = document.createElement("div");

		// ----------------------------- Set screen CSS -----------------------------
		CSS.set(screen, {
			position: "fixed",
			left: "0px",
			top: "0px",
			width: "100%",
			height: "100%",
			background: "#000",
			opacity: "0",
			transition: "1s"
		});

		document.body.append(screen);
		setTimeout(() => {
			CSS.set(screen, {
				opacity: "0.7"
			});
		});

		// ----------------------------- Set frame CSS -----------------------------
		screen.addEventListener("transitionend", () => {
			CSS.set(frame, {
				opacity: "1",
				top: "30%"
			});
		});

		CSS.set(frame, {
			position: "fixed",
			top: "40%",
			left: "30%",
			background: "#fff",
			width: "400px",
			height: "300px",
			opacity: "0",
			transition: "top 1s"
		});

		frame.className = "modalbox__confirm";
		frame.innerHTML = `<div>
				                <h1 class="text-l" style="text-align:center">경고</h1>
				            </div>
							<div>
								${message}
							</div>
				            <input type="button" class="a-input-orange-m" value="확인">`;

		document.body.append(frame)

		// ----------------------------- Submit -----------------------------
		const okButton = frame.querySelector("input[value=확인]");
		okButton.onclick = () => {
			screen.remove();
			frame.remove();
		};
	}

	static confirmMypage(message) {
		return new Promise((resolve, reject) => {
			let screen = document.createElement("div");
			let frame = document.createElement("div");

			// ----------------------------- Set screen CSS -----------------------------
			CSS.set(screen, {
				position: "fixed",
				left: "0px",
				top: "0px",
				width: "100%",
				height: "100%",
				background: "#000",
				opacity: "0",
				transition: "1s"
			});

			document.body.append(screen);
			setTimeout(() => {
				CSS.set(screen, {
					opacity: "0.7"
				});
			});

			// ----------------------------- Set frame CSS -----------------------------
			screen.addEventListener("transitionend", () => {
				CSS.set(frame, {
					opacity: "1",
					top: "30%"
				});
			});

			CSS.set(frame, {
				position: "fixed",
				top: "40%",
				left: "30%",
				background: "#fff",
				width: "400px",
				height: "300px",
				opacity: "0",
				transition: "top 1s"
			});

			frame.className = "modalbox__confirm";
			frame.innerHTML = `
            <div>
                <h1 class="text-l" style="text-align:center">목표 삭제</h1>
            </div>
			<div>
				${message}
			</div>
            <div>
                <input type="button" class="a-input-orange-m" value="확인">
                <input type="button" class="a-input-white-m" value="취소">
            </div>`;

			document.body.append(frame)

			// ----------------------------- Submit -----------------------------
			const okButton = frame.querySelector("input[value=확인]");
			const cancelButton = frame.querySelector("input[value=취소]");
			okButton.onclick = () => {
				screen.remove();
				frame.remove();
				return resolve();
			};
			cancelButton.onclick = () => {
				screen.remove();
				frame.remove();
				return reject();
			};
		});
	}

	static invite() {
		return new Promise(resolve => {
			let screen = document.createElement("div");
			let frame = document.createElement("div");

			// ----------------------------- Set screen CSS -----------------------------
			CSS.set(screen, {
				position: "fixed",
				left: "0px",
				top: "0px",
				width: "100%",
				height: "100%",
				background: "#000",
				opacity: "0",
				transition: "1s"
			});

			document.body.append(screen);
			setTimeout(() => {
				CSS.set(screen, {
					opacity: "0.7"
				});
			});

			// ----------------------------- Set frame CSS -----------------------------
			screen.addEventListener("transitionend", () => {
				CSS.set(frame, {
					opacity: "1",
					top: "30%"
				});
			});

			CSS.set(frame, {
				position: "fixed",
				top: "40%",
				left: "30%",
				background: "#fff",
				width: "400px",
				height: "300px",
				opacity: "0",
				transition: "top 1s"
			});

			frame.className = "modalbox";
			frame.innerHTML = `
            <div class="search">
                <h1 class="text-l" style="text-align:center">이메일로 초대</h1>
                <input class="friend" type="text" />
                <input class="a-input-orange-s add-button" type="button" value="초대" />
            </div>
            <ul class="friends-list">

            </ul>
            <div>
                <input type="button" class="a-input-orange-m" value="확인">
                <input type="button" class="a-input-white-m" value="취소">
            </div>
        `;

			document.body.append(frame)

			// ----------------------------- Event -----------------------------
			let totalParticipants = 1;
			let participants = [];
			const friend = frame.querySelector(".friend");
			const friendsList = frame.querySelector(".friends-list")
			const addButton = frame.querySelector(".add-button");

			// 지인 이메일 초대
			addButton.onclick = () => {
				if (totalParticipants >= 10) {
					alert("인원은 자신 포함 총 10명만 가능합니다");
					return;
				}
				fetch(`/api/goal/reg?email=${friend.value}`)
					.then((response) => response.text())
					.then((result) => {
						result = parseInt(result);

						switch (result) {
							case 0:
								alert('잘못된 이메일입니다');
								break;
							default:
								let div = `<li>${friend.value}<i class="fas fa-times del"><input type="hidden" value="${result}"></i></li>`;
								friendsList.insertAdjacentHTML('beforeend', div);

								friend.value = "";
								totalParticipants++;
								participants.push(result);
								break;
						}
					});
			};

			// 지인 삭제
			friendsList.onclick = (e) => {
				if (!e.target.classList.contains("del"))
					return;

				totalParticipants--;
				let index = participants.indexOf(parseInt(e.target.firstElementChild.value));
				participants.splice(index, 1);
				e.target.parentElement.remove();
			}

			// ----------------------------- Submit -----------------------------
			const okButton = frame.querySelector("input[value=확인]");
			const cancelButton = frame.querySelector("input[value=취소]");
			let answer = {};
			okButton.onclick = () => {
				answer = { "button": "OK", totalParticipants, participants };
				screen.remove();
				frame.remove();
				resolve(args);
			};
			cancelButton.onclick = () => {
				answer = { "button": "CANCEL", totalParticipants: 0, participants: null };
				screen.remove();
				frame.remove();
				resolve(args);
			};
		});

	}
}
export default ModalBox;