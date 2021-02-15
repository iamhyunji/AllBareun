window.addEventListener("load", () => {
  const body = document.querySelector("body");
  const searchContainer = document.querySelector(".search-container");
  const listContainer = document.querySelector(".list-container");
  const startDate = searchContainer.querySelector(".start-date");
  const endDate = searchContainer.querySelector(".end-date");
  const selectCount = searchContainer.querySelector(".select-count");
  const allDateBtn = searchContainer.querySelector(".all-date-button");
  const searchBar = searchContainer.querySelector(".search-bar");
  const searchBtn = searchContainer.querySelector(".search-button");
  const categoryBox = searchContainer.querySelector(".category");

  let scrollCount = 0;

  body.onscroll = () => {
    //현재문서의 높이
    let scrollHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight);
    //현재 스크롤탑의 값
    let scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop);

    //현재 화면 높이 값
    let clientHeight = document.documentElement.clientHeight;
	console.log("scrollHeight:"+scrollHeight);
	console.log("scrollTop:"+scrollTop);
	console.log("clientHeight:"+clientHeight);
	
    if (scrollTop + clientHeight >= scrollHeight - 3) {
      //스크롤이 마지막일때
		console.log("마지막");
      scrollCount++;
      render(scrollCount);
    }
  };
  categoryBox.onclick = (e) => {
    let checked = categoryBox.querySelectorAll("input[type=checkbox]:checked");
    if (checked.length > 2) {
      alert("카테고리는 2개까지 선택가능합니다");
      return false;
    }
  };

  searchContainer.onchange = (e) => {
    e.preventDefault();
    scrollCount = 0;
    render(scrollCount);
  };

  searchBtn.onclick = (e) => {
    e.preventDefault();
    scrollCount = 0;
    render(scrollCount);
  };
  allDateBtn.onclick = (e) => {
    startDate.value = null;
    endDate.value = null;
    scrollCount = 0;
    render(scrollCount);
  };
});

function render(scrollCount = 0) {
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
  let offset = scrollCount * 6;
  if (scrollCount == 0) {
    fetch(`/api/goal/list/?categories=${categories}&startDate=${sd}&endDate=${ed}&days=${days}&totalParticipants=${count}&query=${query}&count=6`)
      .then((response) => response.json())
      .then((json) => {
        listContainer.innerHTML = "";
        let tr = "";
        for (let n of json) {
          let startDate = getFormatDate(new Date(n.startDate));
          let endDate = getFormatDate(new Date(n.endDate));
          tr += `
              <li class="goal-list">`;
          if (n.totalParticipants <= n.nowParticipantsCount) tr += `<a href="${n.id}" class="image"><img src="${n.mainImage}" alt="" /></a>`;
          else tr += `<a href="${n.id}" class="image"><img src="${n.mainImage}" alt="" /></a>`;

          tr += `<div class="para">
              <div class="goal-title">`;
          if (n.totalParticipants <= n.nowParticipantsCount) tr += `<a href="${n.id}"><h2 class="title">${n.title}</h2></a>`;
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
  } else {
    fetch(`/api/goal/scrollList/?categories=${categories}&startDate=${sd}&endDate=${ed}&days=${days}&totalParticipants=${count}&query=${query}&offset=${offset}`)
      .then((response) => response.json())
      .then((json) => {
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
}

function scrollLast(scrollCount) {
  //현재문서의 높이
  var scrollHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight);
  //현재 스크롤탑의 값
  var scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop);

  //현재 화면 높이 값
  var clientHeight = document.documentElement.clientHeight;

  if (scrollTop + clientHeight == scrollHeight) {
    //스크롤이 마지막일때
    console.log("마지막");
    render(scrollCount);
  }
}

function getFormatDate(date) {
  let year = date.getFullYear();
  let month = 1 + date.getMonth();
  month = month >= 10 ? month : "0" + month;
  let day = date.getDate();
  day = day >= 10 ? day : "0" + day;
  return year + "." + month + "." + day;
}
