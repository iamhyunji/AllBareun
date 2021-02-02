import UploadBox from "../../modules/UploadBox.js";
window.addEventListener("load", () => {
  const dropZone = document.querySelector(".drag-box");
  const goalId = document.location.href.split("/")[4];
  const hiddenId = document.querySelector(".hidden-id");
  const id = hiddenId.value;
  const uploadBox = new UploadBox(dropZone, `/mygoal/${goalId}/auth/upload?id=${id}`);
});
