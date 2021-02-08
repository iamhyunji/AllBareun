window.addEventListener("load", () => {
  const searchContainer = document.querySelector(".search-container");
  const listContainer = document.querySelector(".list-container");
  const startDate = searchContainer.querySelector(".start-date");
  const endDate = searchContainer.querySelector(".end-date");
  const selectCount = searchContainer.querySelector(".select-count");
  const allDateBtn = searchContainer.querySelector(".all-date-button");
  const searchBar = searchContainer.querySelector(".search-bar");
  const searchBtn = searchContainer.querySelector(".search-button");

  searchContainer.onchange = (e) => {
    e.preventDefault();
    render();
  };

  searchBtn.onclick = (e) => {
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
  const searchContainer = document.querySelector(".search-container");
  const listContainer = document.querySelector(".list-container");
  const startDate = searchContainer.querySelector(".start-date");
  const endDate = searchContainer.querySelector(".end-date");
  const selectCount = searchContainer.querySelector(".select-count");
  const searchBar = searchContainer.querySelector(".search-bar");

  let categoriesChecked = searchContainer.querySelectorAll("input[name=categories]:checked");
  let categoriesArr = [];
  for (var i = 0; i < categoriesChecked.length; i++) {
    categoriesArr[i] = categoriesChecked[i].value;
  }
  let daysChecked = searchContainer.querySelectorAll("input[name=days]:checked");
  let daysArr = [];
  for (var i = 0; i < daysChecked.length; i++) {
    daysArr[i] = daysChecked[i].value;
  }

  let categories = categoriesArr.join();
  let sd = startDate.value;
  let ed = endDate.value;
  let days = daysArr.join();
  let count = selectCount.value;
  let query = searchBar.value;
  fetch(`/api/goal/list/?categories=${categories}&startDate=${sd}&endDate=${ed}&days=${days}&totalParticipants=${count}&query=${query}`)
    .then((response) => response.json())
    .then((json) => {
      listContainer.innerHTML = "";
      let tr = "";
      for (let n of json) {
        let startDate = getFormatDate(new Date(n.startDate));
        let endDate = getFormatDate(new Date(n.endDate));
        tr += `
              <li class="goal-list">`;
        if (n.totalParticipants <= n.nowParticipantsCount) tr += `<img src="${n.mainImage}" alt="" />`;
        else tr += `<a href="${n.id}" class="image"><img src="${n.mainImage}" alt="" /></a>`;

        tr += `<div class="para">
              <div class="goal-title">`;
        if (n.totalParticipants <= n.nowParticipantsCount) tr += `<h2 class="title">${n.title}</h2>`;
        else tr += `<a href="${n.id}"><h2 class="title">${n.title}</h2></a>`;

        tr += `<span>${n.categories}</span>
              </div>
              <p>기간 : ${n.dateDiff}주 (${startDate}~${endDate})</p>
              <p>횟수 : 주 ${n.count}회 (${n.days})</p>
              <p>모집 : ${n.totalParticipants}명 (${n.nowParticipantsCount}/${n.totalParticipants})</p>`;

        if (n.totalParticipants <= n.nowParticipantsCount) tr += `<div class="full-button">마감</div>`;
        else tr += `<a href="${n.id}" class="button">참가하기</a>`;

        tr += `</div>
                    </li>`;
      }
      listContainer.insertAdjacentHTML("beforeend", tr);
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
