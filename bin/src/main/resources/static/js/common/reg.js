window.addEventListener("load", function(){
    let main = document.querySelector(".main");
	let email = document.querySelector("#email");
    let emailKey = email.querySelector(".text-box");
	let emailButton = email.querySelector(".id-button");
	let pwd = main.querySelector("#pwd");
	let password = pwd.querySelector(".password");
	let rePwd = pwd.querySelector(".re-pwd");
	let phone = document.querySelector(".phone");
	
	let submitButton = main.querySelector("input[type=submit]");
	
    let check = false;

	//정규 표현식
	var emailPattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
	var pwdPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
	var phonePattern = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	var text = "";
	function checkAll(){
		//아이디
		/*if(emailPattern.test(emailKey.value) == true){
			text +="ID : " + emailKey.value + "\n";
		}else
			alert("아이디를 잘못 입력하셨습니다.");*/
		if(!emailPattern.test(emailKey.value)){
			alert("아이디를 잘못 입력했습니다.");
			return false;
		}
			
		//패스워드
		/*else if(pwdPattern.test(password.value) == true){
			if(pwdPattern.test(rePwd.value)== true){
				if(password.value == rePwd.value){
					text +="PWD" + password.value + "\n";
				}
			}else 
				alert("패스워드가 일치하지 않습니다.");
		}else{
			alert("패스워드를 잘못 입력하셨습니다.")	
		}	*/
		else if(!pwdPattern.test(password.value)){
			if(!pwdPattern.test(rePwd.value)){
				alert("패스워드를 잘못 입력하셨습니다.")	
				return false;
			}
			alert("패스워드를 잘못 입력하셨습니다.")	
			return false;
		}
		else if(password.value != rePwd.value){
			alert("패스워드가 일치하지 않습니다.");
			return false;
		}
		//핸드폰번호
		/*if(phonePattern.test(phone.value) == true){
			text +="phone : " + phone.value + "\n";
		}else
			alert("형식에 어긋났습니다.");*/
			else if(!phonePattern.test(phone.value)){
				alert("형식에 어긋났습니다.");
				return false;
			}else{
				return true;
			}
	}
		
	emailButton.onclick = function(){
		fetch("/checkDuplicate?checkKey="+emailKey.value,{
			method: "POST"
		})
		.then((response)=>{
			return response.json();
		})
		.then((data)=>{
			let result = data.checkResult;
			
			if(result == 0){
				alert("사용할 수 있는 이메일입니다.");
				check = true;
			}else{
				alert("중복된 이메일입니다.");
			}
		})
	}
	
	submitButton.onclick = function submitCheck(){
		if(check && password.value !="" && password.value == rePwd.value){
			alert("회원가입이 됐습니다.")
			return true;
		}else{
			alert("빈칸을 완성시켜주세요.");
			return false;
		}
	}
});