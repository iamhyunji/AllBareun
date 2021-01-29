import UploadBox from "../../modules/UploadBox.js";
window.addEventListener("load", () => {
  const dropZone = document.querySelector(".drag-box");

  const uploadBox = new UploadBox(dropZone, "/images");
});
