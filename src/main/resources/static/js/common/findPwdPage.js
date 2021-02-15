window.addEventListener("load", function(){
    let main = document.querySelector(".main");
    let password = main.querySelector(".password");
    let rePassword = main.querySelector(".re-password");
    let updateButton = main.querySelector("input[type=submit]");
    let button = main.querySelector("#button");
    
    var pwdPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,40}$/;
    
    function check(re, what, message) {
        if(re.test(what.value)) {
            return true;
        }
        alert(message);
        what.value = "";
        what.focus();
    }


    updateButton.onclick = function submitCheck(e){
		e.preventDefault();
        if(!check(pwdPattern,password,"비밀번호는 숫자,영문,특수문자를 조합하여 8글자 이상으로 입력해주세요")){
            
            return false;
        }

        if(password.value != rePassword.value){
            alert("비밀번호가 다릅니다. 다시 입력해주세요.");
            rePassword.value="";
            rePassword.focus();
            return false;
        }
        alert("비밀번호가 수정되었습니다.")
    }

});