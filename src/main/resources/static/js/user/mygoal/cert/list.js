window.addEventListener("load", () => {
  const inputBox = document.querySelector(".input-box");
  const selectName = inputBox.querySelector(".select-name");
  const startDate = inputBox.querySelector(".start-date");
  const endDate = inputBox.querySelector(".end-date");
  const mainContainer = document.querySelector(".main-container");
  const allDateBtn = inputBox.querySelector(".all-date-button");

  inputBox.onchange = (e) => {
    e.preventDefault();
    render();
  };

  allDateBtn.onclick = (e) => {
    startDate.value = null;
    endDate.value = null;
    render();
  };
});

function render() {
  const inputBox = document.querySelector(".input-box");
  const selectName = inputBox.querySelector(".select-name");
  const startDate = inputBox.querySelector(".start-date");
  const endDate = inputBox.querySelector(".end-date");
  const mainContainer = document.querySelector(".main-container");
  let name = selectName.value;
  let sd = startDate.value;
  let ed = endDate.value;

  let goalId = document.location.href.split("/")[6];

  fetch(`/api/mygoal/cert/list/${goalId}?name=${name}&startDate=${sd}&endDate=${ed}`)
    .then((response) => response.json())
    .then((json) => {
      mainContainer.innerHTML = "";

      let dateVar = "";
      for (let n of json) {
        let date = getFormatDate(new Date(n.regdate));
        let tr = ``;
        if (date != dateVar) {
          dateVar = date;
          tr = ` <div class="image-container">
               <div class="date text-l">${date}</div>
                 <ul class="list-container">`;
          for (let a of json) {
            let aDate = getFormatDate(new Date(a.regdate));
            if (aDate == dateVar) {
              tr += `  <li class="goal-list">
                      <a href="/mygoal/cert/${a.goalId}/detail/${a.id}" class="image"><img src="${a.authImage}" alt="" /><img class="fa-user-circle" src="${a.profile}"/></a>
                  </li>`;
            }
          }
          tr += ` </ul>
             </div>`;
        }

        mainContainer.insertAdjacentHTML("beforeend", tr);
      }
    });
}

function getFormatDate(date) {
  let year = date.getFullYear();
  let month = 1 + date.getMonth();
  month = month >= 10 ? month : "0" + month;
  let day = date.getDate();
  day = day >= 10 ? day : "0" + day;
  return year + "." + month + "." + day;
}
