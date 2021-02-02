class VideoPlayer {
  #imgArr;
  #imgLength;
  #imgNumber;
  #working;
  #interval;
  #index;
  #videoFrame;
  #imgTag;
  #stopIcon;
  constructor(imgArr, index, videoFrame, imgTag, stopIcon) {
    this.#imgArr = imgArr;
    this.#imgLength = imgArr.length;
    this.#imgNumber = 1;
    this.#working = false;
    this.#interval = null;
    this.#index = index;
    this.#videoFrame = videoFrame[this.#index];
    this.#imgTag = imgTag[this.#index];
    this.#stopIcon = stopIcon[this.#index];
    this.#imgTag.src = imgArr[0];

    this.#videoFrame.addEventListener("click", this.play.bind(this));
  }

  play() {
    if (!this.#working) {
      console.log("시작");
      return new Promise((resolve) => {
        this.#working = true;
        this.#stopToggle();
        let result = this.#imgArr[this.#imgNumber];
        resolve(result);
      }).then((result) => {
        this.#autoRun(result);
      });
    } else {
      // 작업중일 때
      this.#pause();
    }
  }

  #stopToggle() {
    this.#stopIcon.classList.toggle("video-stop");
    this.#imgTag.classList.toggle("video-play");
  }

  #autoRun(result) {
    this.#interval = setInterval(() => {
      if (this.#imgNumber <= this.#imgLength - 1) {
        this.#imgTag.src = result;
        this.#imgNumber++;
        result = this.#imgArr[this.#imgNumber];
      } else {
        // 마지막 이미지일 때
        clearInterval(this.#interval);
        this.#imgNumber = 0;
        result = this.#imgArr[this.#imgNumber];
        this.#imgTag.src = result;
        this.#working = false;
        this.#stopToggle();
      }
    }, 3000); // 이미지 변경 시간 설정
  }

  #pause() {
    clearInterval(this.#interval);
    //result = this.#imgArr[this.#imgNumber];
    this.#working = false;
    console.log("정지");
    this.#stopToggle();
  }
  //======getter, setter

  get imgLength() {
    return this.#imgLength;
  }
  set imgLength(value) {
    this.#imgLength = value;
  }
  get imgArr() {
    return this.#imgArr;
  }
  set imgArr(arr) {
    this.#imgArr = arr;
  }
  get imgNumber() {
    return this.#imgNumber;
  }
  set imgNumber(value) {
    this.#imgNumber = value;
  }
  get working() {
    return this.#working;
  }
  set working(boolean) {
    this.#working = boolean;
  }
  get interval() {
    return this.#interval;
  }
  set interval(value) {
    this.#interval = value;
  }
  get videoFrame() {
    return this.#videoFrame;
  }
  set videoFrame(value) {
    this.#videoFrame = value;
  }
  get stopIcon() {
    return this.#stopIcon;
  }
  set stopIcon(value) {
    this.#stopIcon = value;
  }
  get imgTag() {
    return this.#imgTag;
  }
  set imgTag(value) {
    this.#imgTag = value;
  }
}

export default VideoPlayer;
