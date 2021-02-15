window.addEventListener("load", function(){
   let main = document.querySelector(".main");
   let email = main.querySelector(".email");
   let password = main.querySelector(".password");
   let loginButn = main.querySelector(".login-box");
   
   function check(re, what, message) {
      if(re.test(what.value)) {
         return true;
      }
      alert(message);
      what.value = "";
      what.focus();
      //return false;
   }

   //정규 표현식
   var emailPattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
   var pwdPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,40}$/;
      
   loginButn.onclick = function loginCheck(e){
      e.preventDefault();

      if(email.value ==""){
         alert("아이디를 입력해 주세요.");
         email.focus();
         return false;
      }

      // fetch("/checkEmail?checkKey="+email.value,{
      //    method: "POST"
      // })
      // .then((response)=>{
      //    return response.json();
      // })
      // .then((data)=>{
      //    let result = data.checkResult;

      
      //    if(!check(emailPattern,emailKey,"아이디를 올바르게 입력해주세요")){
      //       return false;
      //    }
      //    else if(result == 0 ){
      //       alert("존재하지 않는 아이디 입니다.");
      //    }
      //    else{

      //    }
      // });

      // fetch("/checkPwd?checkKey="+password.value,{
      //    method: "POST"
      // })
      // .then((response)=>{
      //    return response.json();
      // })
      // .then((data)=>{

      //    let result = data.checkResult;
      //    if(result == 0){

      //    }else{
      //       alert("비밀번호가 일치하지 않습니다.")
      //    }
      // }
   }
});