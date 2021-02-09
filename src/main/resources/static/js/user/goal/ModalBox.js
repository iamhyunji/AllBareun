import CSS from "/js/modules/CSS.js";

class ModalBox{   
    static alert(message){
        return new Promise(resolve=>{
            let screen = document.createElement("div");
            let frame = document.createElement("div");
            // 차트, 탐색기, 드래그 업로드 박스, 모달박스, 편집기, ...
            CSS.set(screen, {
                position:"fixed",
                left:"0px",
                top:"0px",
                width:"100%",
                height:"100%",
                background:"#000",
                opacity:"0",
                transition:"1s"
            });
            
            document.body.append(screen);
            setTimeout(()=>{
                CSS.set(screen, {
                    opacity:"0.7"
                });
            });

            screen.addEventListener("transitionend", ()=>{
                CSS.set(frame, {
                    opacity:"1",
                    top:"200px"
                });
            });
            
            CSS.set(frame, {
                position:"fixed",
                top: "300px",
                left:"400px",
                background: "#fff",
                width:"400px",
                minHeight: "300px",
                display: "flex",
                flexDirection: "column",
                opacity:"0",
                transition:"top 1s"                
            });

            frame.innerHTML = `
                <div>
                    <h1 class="text-l" style="text-align:center">경고</h1>
                </div>
                <div style="flex-grow: 1; display:flex;justify-content: center;align-items: center;">
                    이미지 형식의 파일을 올려주세요(png, jpg)
                </div>
                <div style="display:flex;justify-content: center;">
                    <input type="button" class="a-input-orange-m" value="OK">
                    <input type="button" class="a-input-white-m" value="CANCEL">
                </div>
            `;

            document.body.append(frame);

            const okButton = frame.querySelector("input[value=OK]");
            const cancelButton = frame.querySelector("input[value=CANCEL]");
            okButton.onclick = ()=>{
                resolve("OK");
                screen.remove();
                frame.remove();
            };
            cancelButton.onclick = ()=>{
                resolve("CANCEL");
                screen.remove();
                frame.remove();
            };
        });
    }
    static confirm(){

    }    
}

export default ModalBox;