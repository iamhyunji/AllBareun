import CSS from "../modules/CSS.js";
class UploadBox {
  #dropZone;
  #url;
  constructor(dropZone, url) {
    if (typeof dropZone == "string") this.#dropZone = document.querySelector(dropZone);
    else this.#dropZone = dropZone;
    this.#url = url;
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

    // if (files[0].type.match(/image.*/)) {
    //   $(e.target).css({
    //     "background-image": "url(" + window.URL.createObjectURL(files[0]) + ")",
    //     outline: "none",
    //     "background-size": "100% 100%",
    //   });
    // } else {
    //   alert("이미지가 아닙니다.");
    //   return;
    // }

    let fd = new FormData(); // 멀티 파트 지원하는 객체
    fd.append("file", e.dataTransfer.files[0]);
    console.log(fd.values().next());
    if (
      fd
        .values()
        .next()
        .value.type.match(/image.*/)
    ) {
      CSS.set(this.#dropZone, {
        "background-image": "url(" + window.URL.createObjectURL(e.dataTransfer.files[0]) + ")",
        outline: "none",
        "background-size": "100% 100%",
      });
    } else {
      alert("이미지가 아닙니다.");
      return;
    }

    console.log(fd.has("file"));

    // let request = new XMLHttpRequest();

    // request.upload.addEventListener("progress", (e) => {
    //   if (e.lengthComputable) {
    //     console.log(`total: ${e.total}, loaded: ${e.loaded}`);
    //     this.#dropZone.firstElementChild.innerText = Math.round((e.loaded * 100) / e.total) + "%";
    //   } else this.#dropZone.firstElementChild.innerText = "전송크기를 계산할 수 없습니다.";
    // });

    request.addEventListener("load", (e) => {
      // 로드가 되면 이벤트로 전달해준다.
      console.log(e.target.responseText);
      setTimeout(() => {
        this.#dropZone.style.background = "#e9e9e9";
        this.#dropZone.style.borderRadius = "20px";

        this.#dropZone.firstElementChild.innerText = "업로드할 파일을 드래그 드롭하세요!";
      }, 1000);
    });
    // request.addEventListener("error", (reason) => {
    //   console.log(reason);
    // });
    // //console.log("drop:" + e.dataTransfer);

    // console.log("ff");
    // request.open("POST", this.#url);
    // request.send(fd);
  }

  #dragover(e) {
    e.preventDefault();
    e.stopPropagation();

    let valid = e.dataTransfer && e.dataTransfer.types && e.dataTransfer.types.indexOf("Files") >= 0;

    let message = valid ? "드롭하세요!" : "유효한 파일이 아닙니다.";

    this.#dropZone.firstElementChild.innerText = message;

    console.log("dragover:" + e.dataTransfer);
  }

  #dragenter(e) {
    e.preventDefault();
    e.stopPropagation();

    this.#dropZone.style.background = "pink";
    this.#dropZone.style.borderRadius = "0px";

    console.log("enter:" + e.dataTransfer);
  }

  #dragleave(e) {
    e.preventDefault();
    e.stopPropagation();

    this.#dropZone.style.background = "#e9e9e9";
    this.#dropZone.style.borderRadius = "20px";

    this.#dropZone.firstElementChild.innerText = "업로드할 파일을 드래그 드롭하세요!";

    console.log("exit");
  }
}

export default UploadBox;
