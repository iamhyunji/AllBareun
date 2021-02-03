window.addEventListener("load", () => {
	const goalContainer = document.querySelector(".goals");
	const reload = goalContainer.querySelector(".del-reload");
	
	goalContainer.addEventListener("click", (e) => {
		if(!e.target.classList.contains("del-button"))
			return;
		let confirmValue = window.confirm(`정말로 이 목표를 삭제하시겠습니까?`)
		
		if(!confirmValue)
			return;
			
		let event = new MouseEvent("click", {
            'view' : window,
            'bubbles' : true,
            'cancelable' : true
        });

        reload.dispatchEvent(event);
	});
})