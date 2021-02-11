import ModalBox from '/js/user/goal/ModalBox.js';

window.addEventListener("load", () => {
	const goalContainer = document.querySelector(".goals");
	
	goalContainer.addEventListener("click", (e) => {
		
		if(!e.target.classList.contains("del-button"))
			return;

		ModalBox.confirmMypage(`정말로 이 목표를 삭제하시겠습니까?`)
		.then((result) => {
			if(!result)
				return;
		});
			
		let delReload = e.target.firstElementChild;
		let event = new MouseEvent("click", {
            'view' : window,
            'bubbles' : true,
            'cancelable' : true
        });

        delReload.dispatchEvent(event);
	});
})