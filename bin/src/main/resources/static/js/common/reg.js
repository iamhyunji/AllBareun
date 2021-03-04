import ProfileUpload from "../modules/ProfileUpload.js"

window.addEventListener("load", function(){
   let main = document.querySelector(".main");
   let email = document.querySelector("#email");
   let emailKey = email.querySelector(".text-box");
   let emailButton = email.querySelector(".id-button");
   let pwd = main.querySelector("#pwd");
   let password = pwd.querySelector(".password");
   let rePwd = pwd.querySelector(".re-pwd");
   let name = main.querySelector(".name");
   let phone = document.querySelector(".phone");
   let submitButton = main.querySelector("input[type=submit]");
   const dropZone = document.querySelector(".drag-box");
   const uploadBox = new ProfileUpload(dropZone, "/reg/upload");
   const hiddenId = document.querySelector(".hidden-id");
   const id = hiddenId.value;
   
   function check(re, what, message) {
      if(re.test(what.value)) {
         return true;
      }
      alert(message);
      what.value = "";
      what.focus();
      //return false;
   }
    // let check = false;

   //정규 표현식
   var emailPattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
   var pwdPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,40}$/;
   var phonePattern = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
      
   emailButton.onclick = function idCheck(){
      fetch("/checkDuplicate?checkKey="+emailKey.value,{
         method: "POST"
      })
      .then((response)=>{
         return response.json();
      })
      .then((data)=>{
         let result = data.checkResult;
         if(email.value ==""){
            alert("이메일을 입력해 주세요.");
            email.focus();
            return false;
         }
         else if(!check(emailPattern,emailKey,"이메일을 올바르게 입력해주세요")){
            return false;
         }
         else if(result == 0 ){
            alert("사용할 수 있는 이메일입니다.");
         }else{
            alert("중복된 이메일입니다.");
         }
      })
   }
   
   submitButton.onclick = function submitCheck(){

      if(!check(pwdPattern,password,"비밀번호는 숫자,영문,특수문자를 조합하여 8글자 이상으로 입력해주세요")){
         return false;
      }

      if(password.value != rePwd.value){
         alert("비밀번호가 다릅니다. 다시 입력해주세요.");
         rePwd.value="";
         rePwd.focus();
         return false;
      }

      if(reg.name.value==""){
         alert("이름을 입력해주세요.");
         reg.name.focus();
         return false;
      }
      if(!check(phonePattern,phone,"전화번호를 형식에 맞게 입력해주세요")){
         return false;
      }
      alert("회원가입이 완료되었습니다.");
   }
});