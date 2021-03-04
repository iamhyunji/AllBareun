import UploadBox from "../goal/UploadBox.js";

window.addEventListener("load", () => {
	const submitButton = document.querySelector(".submit-button");
	const mainImg = document.querySelector(".required__image .g-mImg");

	let mainUpload = new UploadBox(mainImg, mainImg.innerText);

	// 등록 시 실행 사항
	submitButton.addEventListener("click", (e) => {
		//e.preventDefault();
		mainUpload.upload();
	});

})