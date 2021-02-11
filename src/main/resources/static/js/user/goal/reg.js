import UploadBox from "./UploadBox.js";
import ModalBox from "./ModalBox.js";

window.addEventListener("load", () => {
	const requiredContent = document.querySelector(".required__content");
	const nonRequiired = document.querySelector(".non-required");
	const categoryContainer = requiredContent.querySelector(".category-container");
	const participationContainer = requiredContent.querySelector(".participation-container");
	const participationSelect = participationContainer.querySelector("select");
	const cycleContainer = requiredContent.querySelector(".cycle-container");
	const cycleSelect = cycleContainer.querySelector("select");
	const regButton = document.querySelector(".reg-button");

	// 이미지 업로드
	const mainImg = document.querySelector(".required__image .g-mImg");
	const goodEx = nonRequiired.querySelector(".g-gEx");
	const badEx = nonRequiired.querySelector(".g-bEx");

	let mainUpload = new UploadBox(mainImg, mainImg.innerText);
	let goodExUpload = new UploadBox(goodEx, goodEx.innerText);
	let badExUpload = new UploadBox(badEx, badEx.innerText);

	// 날짜 선택

	// 카테고리
	let categoryCnt = 0;
	let maxCategoryCnt = 2;

	// 카테고리 2개로 입력 제한
	categoryContainer.addEventListener("change", (e) => {
		let element = e.target;

		// gct-id만 받기
		if (element.name != "gct-id")
			return;

		if (element.checked)
			categoryCnt++;
		else
			categoryCnt--;

		if (categoryCnt > maxCategoryCnt) {
			alert(`카테고리는 최대 2개까지 선택 가능합니다`);
			element.checked = false;
			categoryCnt--;
			return;
		}

	});

	// '참가' 옵션 선택에 따른 인원선택, 초대 버튼 표시
	participationContainer.addEventListener("change", (e) => {
		if (e.target.name != "g-ps")
			return;

		let option = e.target.value;

		switch (option) {
			case "-1":
				removeInputsBeforeParticipation();
				break;

			case "0":
				removeInputsBeforeParticipation();

				let inviteInput = `<input class="a-input-white-s invite" type="button" value="초대">`;
				participationContainer.insertAdjacentHTML('beforeend', inviteInput);

				let pContainer = document.createElement("div");
				pContainer.classList.add("participants__container");
				participationContainer.insertAdjacentElement('beforeend', pContainer);

				let inviteButton = participationContainer.querySelector(".invite");
				inviteButton.onclick = inviteButtonClickHandler;

				break;

			case "1":
				removeInputsBeforeParticipation();

				let participationInput = `<input class="select-s total-participants" type="number" name="g-tp" value="2" min="2" max="10" />`;
				participationContainer.insertAdjacentHTML('beforeend', participationInput);
				break;
		}
	});

	function removeInputsBeforeParticipation() {
		let totalParticipantsInput = participationContainer.querySelector(".total-participants");
		let invitedList = participationContainer.querySelectorAll(".invited-list");
		let inviteButton = participationContainer.querySelector(".invite");
		let pContainer = document.querySelector(".participants__container");

		if (totalParticipantsInput != null)
			totalParticipantsInput.remove();
		if (invitedList.item(1) != null)
			invitedList.remove();
		if (inviteButton != null)
			inviteButton.remove();
		if (pContainer != null)
			pContainer.remove();
	};

	// 지인 초대
	function inviteButtonClickHandler() {
		ModalBox.invite()
			.then(({ button, totalParticipants, participants }) => {
				switch (button) {
					case "OK":
						let totalParticipantsInput = `<input class="select-s total-participants" type="hidden" name="g-tp" value="${totalParticipants}"/>`;

						(async () => {
							let userProfileInput = "";

							for (let i = 0; i < participants.length; i++) {
								let response = await fetch(`/api/goal/reg/profile?id=${participants[i]}`);
								let user = await response.json();
								userProfileInput += `<div class="profile"><img class="profile__image" src=${user.profile} /><span class="profile__info">${user.name}</span></div>`;
							}

							return userProfileInput;
						})()
							.then((userProfileInput) => {
								let participantsInput = "";
								for (let i = 0; i < participants.length; i++)
									participantsInput += `<input class="invited-list" type="hidden" name="g-m" value="${participants[i]}" />`;

								let pContainer = document.querySelector(".participants__container");
								let inviteButton = participationContainer.querySelector(".invite");
								
								inviteButton.remove();
								pContainer.insertAdjacentHTML('beforeend', userProfileInput);
								participationContainer.insertAdjacentHTML('beforeend', totalParticipantsInput);
								participationContainer.insertAdjacentHTML('beforeend', participantsInput);
							});

						break;
					default:
						break;
				}
			});
	};

	// 문제 ) '인증 횟수'에서 매일 제외 나머지는 요일 선택 체크박스 보이기
	cycleSelect.addEventListener("change", (e) => {
		let option = e.target.value;
		let cycle = cycleContainer.querySelector(".cycle");

		switch (option) {
			case "everyday":
				cycle.remove();

				let cycleBox = `<div class="cycle" style="display: none">
				<input type="checkbox" name="d-id" value="1" checked />월
				<input type="checkbox" name="d-id" value="2" checked />화
				<input type="checkbox" name="d-id" value="3" checked />수
				<input type="checkbox" name="d-id" value="4" checked />목
				<input type="checkbox" name="d-id" value="5" checked />금
				<input type="checkbox" name="d-id" value="6" checked />토
				<input type="checkbox" name="d-id" value="7" checked />일
			</div>`;

				cycleContainer.insertAdjacentHTML('beforeend', cycleBox);
				break;

			case "week":
				cycle.remove();

				let cycleBoxWeek = `<div class="cycle">
				<input type="checkbox" name="d-id" value="1" />월
				<input type="checkbox" name="d-id" value="2" />화
				<input type="checkbox" name="d-id" value="3" />수
				<input type="checkbox" name="d-id" value="4" />목
				<input type="checkbox" name="d-id" value="5" />금
				<input type="checkbox" name="d-id" value="6" />토
				<input type="checkbox" name="d-id" value="7" />일
			</div>`;

				cycleContainer.insertAdjacentHTML('beforeend', cycleBoxWeek);
				break;

			case "weekday":
				cycle.remove();

				let cycleBoxWeekday = `<div class="cycle">
				<input type="checkbox" name="d-id" value="1" checked />월
				<input type="checkbox" name="d-id" value="2" checked />화
				<input type="checkbox" name="d-id" value="3" checked />수
				<input type="checkbox" name="d-id" value="4" checked />목
				<input type="checkbox" name="d-id" value="5" checked />금
				<input type="checkbox" name="d-id" value="6" />토
				<input type="checkbox" name="d-id" value="7" />일
			</div>`

				cycleContainer.insertAdjacentHTML('beforeend', cycleBoxWeekday);
				break;

			case "weekend":
				cycle.remove();

				let cycleBoxWeekend = `<div class="cycle">
				<input type="checkbox" name="d-id" value="1" />월
				<input type="checkbox" name="d-id" value="2" />화
				<input type="checkbox" name="d-id" value="3" />수
				<input type="checkbox" name="d-id" value="4" />목
				<input type="checkbox" name="d-id" value="5" />금
				<input type="checkbox" name="d-id" value="6" checked />토
				<input type="checkbox" name="d-id" value="7" checked />일
			</div>`

				cycleContainer.insertAdjacentHTML('beforeend', cycleBoxWeekend);
				break;
		}
	});

	// 등록 시 실행 사항
	regButton.addEventListener("click", (e) => {
		//e.preventDefault();

		// 참가 개인일 대 초기화
		if (participationSelect.value == "-1") {
			participationSelect.value = "0";
			let personalInput = `<input class="select-s total-participants" type="hidden" name="g-tp" value="1"/>`;
			participationContainer.insertAdjacentHTML('beforeend', personalInput);
		}

		// 요일 개수
		let checkeds = document.querySelectorAll(`input[name="d-id"]:checked`);
		let countInput = `<input type="hidden" name="g-c" value="${checkeds.length}" />`;
		cycleContainer.insertAdjacentHTML('beforeend', countInput);

		// 이미지 업로드
		mainUpload.upload();
		goodExUpload.upload();
		badExUpload.upload();

	});

})