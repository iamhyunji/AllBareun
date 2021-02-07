import UploadBox from "../../modules/UploadBox.js";
window.addEventListener("load", () => {
  const dropZone = document.querySelector(".drag-box");
  const goalId = document.location.href.split("/")[4];
  const hiddenId = document.querySelector(".hidden-id");
  const id = hiddenId.value;
  const form = document.querySelector("#form");
  const submitBtn = document.querySelector(".submit-btn");
  const cancelBtn = document.querySelector(".cancel-btn");
  const uploadBox = new UploadBox(dropZone, `/mygoal/${goalId}/auth/upload?id=${id}`);
  submitBtn.addEventListener("click", (e) => {
    e.preventDefault();
    let resultText = document.querySelector(".drag-result").innerText;
    console.log(resultText);
    if (resultText == "업로드 완료!") {
      form.submit();
    } else {
      alert("인증 사진을 올려주세요");
    }
  });
});
