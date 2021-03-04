import CSS from "../modules/CSS.js";
class ProfileUpload {
  #dropZone;
  #url;
  #resultText;
  #resultFileName;
  #nowImage;
  #beforeImage;

  constructor(dropZone, url) {
    if (typeof dropZone == "string") this.#dropZone = document.querySelector(dropZone);
    else this.#dropZone = dropZone;

    this.#resultText = document.querySelector(".drag-result");
    this.#url = url;
    this.#nowImage = "";
    this.#beforeImage = "";
    this.#resultFileName = document.querySelector(".result-file-name");
    this.#dropZone.addEventListener("drop", this.#drop.bind(this));
    this.#dropZone.addEventListener("dragover", this.#dragover.bind(this));
    this.#dropZone.addEventListener("dragenter", this.#dragenter.bind(this));
    this.#dropZone.addEventListener("dragleave", this.#dragleave.bind(this));
  }

  #drop(e) {
    e.preventDefault();
    e.stopPropagation();

    let valid = e.dataTransfer && e.dataTransfer.types && e.dataTransfer.types.indexOf("Files") >= 0;
    if (!valid) return;
    if (this.#resultText.innerText == "업로드 완료!") {
      let result = confirm("사진을 바꾸시겠습니까?");
      if (result) {
        this.#nowImage = e.dataTransfer.files[0].name;
        this.#resultFileName.value = this.#nowImage;
        fetch(`/reg/upload?fileName=${this.#beforeImage}`).then((data) => console.log(data));
      } else return;
    }
    let fd = new FormData(); // 멀티 파트 지원하는 객체
    fd.append("file", e.dataTransfer.files[0]);
    if (
      fd
        .values()
        .next()
        .value.type.match(/image.*/)
    ) {
      this.#beforeImage = e.dataTransfer.files[0].name;
      this.#nowImage = e.dataTransfer.files[0].name;
      this.#resultFileName.value = this.#nowImage;
      CSS.set(this.#dropZone, {
        "background-image": "url(" + window.URL.createObjectURL(e.dataTransfer.files[0]) + ")",
        outline: "none",
        "background-size": "100% 100%",
      });
      this.#dropZone.firstElementChild.innerText = "";
    } else {
      this.#dropZone.style.background = "#e9e9e9";
      this.#dropZone.style.borderRadius = "20px";
      this.#dropZone.firstElementChild.style.position = "relative";
      this.#dropZone.firstElementChild.style.top = "130px";
      this.#dropZone.firstElementChild.style.left = "80px";

      this.#dropZone.firstElementChild.innerText = "업로드할 파일을 드래그 드롭하세요!";
      alert("이미지가 아닙니다.");
      return;
    }

    //console.log(fd.has("file"));

    let request = new XMLHttpRequest();

    // request.upload.addEventListener("progress", (e) => {
    //   if (e.lengthComputable) {
    //     console.log(`total: ${e.total}, loaded: ${e.loaded}`);
    //     this.#dropZone.firstElementChild.innerText = Math.round((e.loaded * 100) / e.total) + "%";
    //   } else this.#dropZone.firstElementChild.innerText = "전송크기를 계산할 수 없습니다.";
    // });

    request.addEventListener("load", (e) => {
      // 로드가 되면 이벤트로 전달해준다.
      console.log(e.target.responseText);
      this.#resultText.innerText = "업로드 완료!";
      // setTimeout(() => {
      //   this.#dropZone.style.background = "#e9e9e9";
      //   this.#dropZone.style.borderRadius = "20px";
      //   this.#dropZone.firstElementChild.style.position = "relative";
      //   this.#dropZone.firstElementChild.style.top = "130px";
      //   this.#dropZone.firstElementChild.style.left = "80px";

      //   this.#dropZone.firstElementChild.innerText = "업로드할 파일을 드래그 드롭하세요!";
      // }, 1000);
    });
    request.addEventListener("error", (reason) => {
      console.log(reason);
    });
    //console.log("drop:" + e.dataTransfer);

    request.open("POST", this.#url);
    request.send(fd);
  }

  #dragover(e) {
    e.preventDefault();
    e.stopPropagation();
    if (this.#resultText.innerText == "업로드 완료!") return;
    let valid = e.dataTransfer && e.dataTransfer.types && e.dataTransfer.types.indexOf("Files") >= 0;

    let message = valid ? "드롭하세요!" : "유효한 파일이 아닙니다.";

    this.#dropZone.firstElementChild.innerText = message;
  }

  #dragenter(e) {
    e.preventDefault();
    e.stopPropagation();
    if (this.#resultText.innerText == "업로드 완료!") return;

    this.#dropZone.style.background = "#ff8f00";
    this.#dropZone.style.borderRadius = "0px";

    //console.log("enter:" + e.dataTransfer);
  }

  #dragleave(e) {
    e.preventDefault();
    e.stopPropagation();
    if (this.#resultText.innerText == "업로드 완료!") return;
    this.#dropZone.style.background = "#e9e9e9";
    this.#dropZone.style.borderRadius = "20px";

    this.#dropZone.firstElementChild.innerText = "업로드할 파일을 드래그 드롭하세요!";

    //console.log("exit");
  }
}

export default ProfileUpload;