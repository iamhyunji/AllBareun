window.addEventListener("load", () => {
	const requiredContent = document.querySelector(".required__content");
	const categoryContainer = requiredContent.querySelector(".category-container");
	const participationContainer = requiredContent.querySelector(".participation-container");
	const participationSelect = participationContainer.querySelector("select");
	const cycleContainer = requiredContent.querySelector(".cycle-container");
	const cycleSelect = cycleContainer.querySelector("select");
	const regButton = document.querySelector(".reg-button");

	// 카테고리
	let categoryCnt = 0;
	let maxCategoryCnt = 2;

	// 카테고리 2개로 입력 제한
	categoryContainer.addEventListener("change", (e) => {
		let element = e.target;

		// gct-id만 받기
		if(element.name != "gct-id")
			return;
		
		if(element.checked)
			categoryCnt++;
		else
			categoryCnt--;

		if(categoryCnt > maxCategoryCnt) {
			alert(`카테고리는 최대 2개까지 선택 가능합니다`);
			element.checked = false;
			categoryCnt--;
			return;
		}

	});
	
	// '참가' 옵션 선택에 따른 인원선택, 초대 버튼 표시
	participationContainer.addEventListener("change", (e) => {
		if(e.target.name != "g-ps")
			return;
		
		let option = e.target.value;
		let totalParticipantsInput = participationContainer.querySelector(".total-participants");
		let invitedList = participationContainer.querySelector(".invited-list");
		let inviteInput = participationContainer.querySelector(".invite");

		switch(option) {
			case "-1":
				let personalInput = `<input class="select-s total-participants" type="hidden" name="g-tp" value="1" min="1" max="1" />`;
				totalParticipantsInput.remove();
				if(invitedList!=null || inviteInput != null){
					invitedList.remove();
					inviteInput.remove();
				}
				participationContainer.insertAdjacentHTML('beforeend', personalInput);
				break;
			case "0":
				let groupInput = `<input class="select-s total-participants" type="number" name="g-tp" value="2" min="2" max="10" />
				<input class="invited-list" name="g-m" value="#userId" />
				<input class="invited-list" name="g-m" value="#userId" />
				<input class="a-input-white-s invite" type="button" value="초대">`;
				totalParticipantsInput.remove();
				participationContainer.insertAdjacentHTML('beforeend', groupInput);
				break;
			case "1":
				let participationInput = `<input class="select-s total-participants" type="number" name="g-tp" value="2" min="2" max="10" />`;
				totalParticipantsInput.remove();
				if(invitedList!=null || inviteInput != null){
					invitedList.remove();
					inviteInput.remove();
				}
				participationContainer.insertAdjacentHTML('beforeend', participationInput);
				break;
		}
	});

	// 문제 ) '인증 횟수'에서 매일 제외 나머지는 요일 선택 체크박스 보이기
	cycleSelect.addEventListener("change", (e) => {
		let option = e.target.value;
		let cycle = cycleContainer.querySelector(".cycle");

		switch(option) {
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
		// 참가 개인일 대 초기화
		if(participationSelect.value == "-1")
			participationSelect.value = "0";
			
		// 요일 개수
		let checkeds = document.querySelectorAll(`input[name="d-id"]:checked`);
		let countInput = `<input type="hidden" name="g-c" value="${checkeds.length}" />`;
		cycleContainer.insertAdjacentHTML('beforeend', countInput);
		
		// console.log(checkeds.length);
	});

	// 문제 ) 제목 입력 시 Enter 키 누르면 submit됨.
	// => Enter 키 누르면 submit되는거 막아줄 것!
	
	// 인증사진 등록 시에만 인증 기준 사진 등록(좋은 예시, 나쁜 예시, 인증 방법 설명) 보이기
})