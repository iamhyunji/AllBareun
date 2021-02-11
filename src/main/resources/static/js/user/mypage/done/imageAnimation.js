import VideoPlayer from "./VideoPlayer.js";

window.addEventListener("load", function () {
	
	var list = document.getElementsByClassName('.arrayValue');

[...list].forEach((elem, index) => {
    console.log(elem, index);
});

	let month = new Array();
		/*month.push(${}+'월');
		lineSum.push(${e.lineSum });*/
	let aaa = document.querySelector(".aaa").innerHTML;
	let arrayValue = document.querySelector(".arrayValue").innerHTML;
	let userId = document.querySelector(".userId").innerHTML;
	let authImage = document.querySelector(".authImage").innerHTML;
  const videoSection = document.querySelector(".video-section");
  const videoFrame = document.querySelectorAll(".video-frame");
  const imgTag = document.querySelectorAll(".video-img");
  const stopIcon = document.querySelectorAll(".video-stop");
/*console.log(arrayValue);
console.log(userId);
console.log(authImage);
*/

console.log(aaa.length);

/*for(int i=0 ; i<userList.legth ; i++)
  for(int j=0 ; j<list.length ; j++) {
    if(userList[i] == list[j].getUserId() ) {
      arr[i][] = list[j].get이미지()
     }
  }*/

  let imgArrs = [];
  imgArrs[0] = ["/images/all.png", "/images/naver.png", "/images/all.png", "/images/naver.png", "/images/all.png"];
  imgArrs[1] = ["/images/naver.png", "/images/kakao.png", "/images/naver.png", "/images/kakao.png", "/images/kakao.png", "/images/naver.png"];
  imgArrs[2] = ["/images/kakao.png", "/images/all.png", "/images/kakao.png", "/images/all.png", "/images/kakao.png"];
  let videoPlayers = [];
  for (let i = 0; i < imgArrs.length; i++) {
    videoPlayers[i] = new VideoPlayer(imgArrs[i], i, videoFrame, imgTag, stopIcon);
  }

});
