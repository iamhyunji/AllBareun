window.addEventListener("load", () => {
  const answerContainer = document.querySelector(".answer-container");
  const circleBoxes = answerContainer.querySelectorAll(".circle-box");

  let url = document.location.href.split("/");
  let goalId = url[5];
  let id = url[7];

  fetch(`/api/mygoal/cert/${goalId}/detail/${id}`)
    .then((response) => response.json())
    .then((arr) => {
      for (let i = 0; i < arr.length; i++) {
        let answer = circleBoxes[i].children[arr[i]];
        answer.classList.add("checked");
      }
    });
});
