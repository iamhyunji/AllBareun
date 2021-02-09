import CSS from '../../modules/CSS.js';

class UploadBox {
	#dropZone
	#defaultExplanation
	#imageInput
	#goalId
	#imageFileName

	constructor(dropZone, defaultExplanation) {
		if (typeof dropZone == "string")
			this.#dropZone = document.querySelector(dropzone);
		else
			this.#dropZone = dropZone;

		this.#defaultExplanation = defaultExplanation;
		this.#imageInput = dropZone.firstElementChild;
		this.#goalId = document.querySelector(".goalId").value;

		this.#dropZone.addEventListener("drop", this.#dropHandler.bind(this));
		this.#dropZone.addEventListener("dragover", this.#dragOverHandler.bind(this));
		this.#dropZone.addEventListener("dragenter", this.#dragEnterHandler.bind(this));
		this.#dropZone.addEventListener("dragleave", this.#dragLeaveHandler.bind(this));

	}

	#dropHandler(e) {
		e.preventDefault();
		e.stopPropagation();

		// 파일 형식인지 확인
		let valid = e.dataTransfer
			&& e.dataTransfer.types
			&& e.dataTransfer.types.indexOf("Files") >= 0;

		// 유효하지 않은 형식일 때 처리 방식
		if (!valid) {
			alert('이미지가 아닙니다.');

			CSS.set(this.#dropZone, {
				background: "#e9e9e9",
				borderRadius: "0px",
				opacity: "1"
			});
			this.#dropZone.lastElementChild.innerText = this.#defaultExplanation;

			return;
		}

		let fileName = e.dataTransfer.files[0];

		CSS.set(this.#dropZone, {
			"background-image": "url(" + window.URL.createObjectURL(fileName) + ")",
			outline: "none",
			"background-size": "100% 100%",
			borderRadius: "0px",
			opacity: "1"
		});

		this.#dropZone.lastElementChild.innerText = "";
		this.#imageFileName = fileName;

	};

	#dragOverHandler(e) {
		e.preventDefault();
		e.stopPropagation();

		let valid = e.dataTransfer
			&& e.dataTransfer.types
			&& e.dataTransfer.types.indexOf("Files") >= 0;

		let message = valid ? "드롭하세요!" : "유효한 파일이 아닙니다.";

		this.#dropZone.lastElementChild.innerText = message;

		//console.log("dragover:" + e.dataTransfer);
	};

	#dragEnterHandler(e) {
		e.preventDefault();
		e.stopPropagation();

		CSS.set(this.#dropZone, {
			background: "#ff8f00",
			borderRadius: "20px",
			opacity: "1"
		});

		//console.log("enter:" + e.dataTransfer);
	};

	#dragLeaveHandler(e) {
		e.preventDefault();
		e.stopPropagation();

		CSS.set(this.#dropZone, {
			background: "#e9e9e9",
			borderRadius: "0px",
			opacity: "1"
		});

		this.#dropZone.lastElementChild.innerText = this.#defaultExplanation;

		//console.log("exit");
	};

	upload() {
		// 파일 업로드
		//console.log(e.dataTransfer.files[0]);
		//let fileName = e.dataTransfer.files[0];
		let fileName = this.#imageFileName;

		if (fileName == null) {
			let fileArr = this.#imageInput.value.split("/");
			let len = fileArr.length;
			this.#imageInput.value = fileArr[len - 1];
			let type = fileArr[len - 1].split(".")[1];
			fileName = new File([this.#imageInput], this.#imageInput.value, { type: "image/" + type });
		}
		else
			this.#imageInput.value = fileName.name;

		let url = `/goal/reg/upload?id=${this.#goalId}`;
		let fd = new FormData();
		fd.append("file", fileName);

		let request = new XMLHttpRequest();

		request.addEventListener("load", (e) => {
			//console.log(status);
			//console.log(`e.target.responseText - ${e.target.responseText}`);
		});
		request.addEventListener("error", (reason) => {
			console.log(reason);
			// console.log(e.target.responseText);
		});

		request.open("POST", url);
		request.send(fd);

	};
}

export default UploadBox;