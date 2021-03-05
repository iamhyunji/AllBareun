# 올바른생각
<p align="center">
<img width="400px" src="src/main/resources/static/images/readme/all.png"/>
</p>


## 📑 프로젝트 소개
- [x] 새해맞이 목표 달성 커뮤니티 사이트
- [x] 많은 사람들이 목표를 세우지만 목표 달성률은 8%에 그치는 문제를 돕고자 기획
- [x] 주요 기능1. 다양한 사람들과 구체적인 방법으로 공동 목표를 도전
- [x] 주요 기능2. 주기적인 인증을 통해 지속적인 행동을 할 수 있게 도와줌
- [x] 주요 기능3. 목표가 종료되면 내 결과 리포트로 발전을 확인할 수 있음


## 🛠 사용 기술
| Front-End      | Back-End       | DataBase | Tool                                       |
| -------------- | -------------- | -------- | ------------------------------------------ |
| HTML5<br>CSS3<br>JS ES6 | Mybatis<br>Spring | MySQL    | SpringBoot<br>Git<br>Trello<br>Kakao Oven<br>Photoshop |


## 📅 개발 기간
![프로젝트일정(올바른생각)](src/main/resources/static/images/readme/schedule.png)


## 💼 설치
```
> git clone https://github.com/cyon13/AllBareun
```


## 📊 E-R Diagram
![E-R Diagram](src/main/resources/static/images/readme/ERwin.png)


## 📖 Issues 관리
![issue](src/main/resources/static/images/readme/issue.png)


## 🎞 실행 화면

✅ [1] 회원가입 : 서비스를 이용하기 위한 회원가입 페이지입니다.

![회원가입](src/main/resources/static/images/readme/gif/sign-up.gif)

✅ [2] 로그인

![로그인](src/main/resources/static/images/readme/gif/sign-in.gif)

✅ [3] 인덱스 페이지 : 로그인 후 개인별 스케줄을 관리할 수 있는 인덱스 페이지입니다. FullCalendar 라이브러리를 통해 구현하였고, 이벤트 생성, 수정, 삭제가 가능합니다.

![인덱스](src/main/resources/static/images/readme/gif/index.gif)

✅ [4] 목표 탭 & 참가 : 사용자들이 공개한 목표 리스트로, 원하는 내용으로 검색이 가능하고, 사용자들은 마감하지 않은 목표에 한에 참가할 수 있습니다.

![참가](src/main/resources/static/images/readme/gif/goal.gif)

✅ [5] 목표 개설 : 원하는 목표를 개설하는 페이지로, 참가는 개인, 지인, 공개 중 선택할 수 있으며, 지인과 함께 목표를 진행할 시 이메일을 초대 가능합니다.

![개설](src/main/resources/static/images/readme/gif/reg.gif)

✅ [6] 초대 응답 : 초대 응답 페이지로, 초대 받은 사용자는 초대를 삭제함으로써 초대를 거절할 수도 있고, 도전함으로써 수락할 수도 있습니다.

![초대 응답](src/main/resources/static/images/readme/gif/invited.gif)

✅ [7] 내 목표 : 현재 진행하고 있는 목표 리스트로, 원하는 목표를 검색하여 찾을 수도 있습니다.

![내 목표](src/main/resources/static/images/readme/gif/mygoal.gif)

✅ [8] 인증 : 인증 기준과 설명에 따라 인증 사진을 등록합니다.

![인증](src/main/resources/static/images/readme/gif/auth.gif)

✅ [9] 디테일 : 목표에 대한 디테일 페이지로, 해당 목표를 설명하는 정보란, 각 참여자의 집계 데이터, 모든 참여자의 인증 내역을 확인할 수 있습니다.

![디테일](src/main/resources/static/images/readme/gif/detail.gif)

✅ [10] 종합 리포트 : 사용자가 참여하고 있는 모든 목표들을 카테고리별로 집계/분석한 종합 리포트입니다.

![종합 리포트](src/main/resources/static/images/readme/gif/total-report.gif)

✅ [11] 목표 리포트 : 완료된 해당 목표의 집계 데이터 및 모든 인증 내역을 엮어 보여주는 페이지입니다.

![목표 리포트](src/main/resources/static/images/readme/gif/goal-report.gif)

✅ [12] 재도전 : 기준(달성률 80% 이상)을 달성하지 못하면 해당 목표는 삭제 또는 재도전할 수 있습니다.

![재도전](src/main/resources/static/images/readme/gif/retry.gif)

## 💻 개발자

 | ![신중언](https://avatars2.githubusercontent.com/u/64012038?s=400&u=c1bf92ce021077a9d78d8418315c938e797fb238&v=4)<br>[신중언](https://github.com/Joong-eon)| ![구본율](https://avatars.githubusercontent.com/u/35316595?s=400&v=4)<br>[구본율](https://github.com/cyon13) | ![김현지](https://avatars.githubusercontent.com/u/55617281?s=400&u=45166515684d080b5782457babcc6920191823ee&v=4)<br>[김현지](https://github.com/iamhyunji) | ![임혜영](https://avatars.githubusercontent.com/u/54495841?s=400&v=4)<br>[임혜영](https://github.com/HYEYOUNGLIM) |
 | :---------------: | :---------------: | :---------------: | :---------------: |


## 기여
* Front End & Back End
	- 목표 등록
	- 내 목표 리스트
	- 완료 목표 리스트
	- 초대된 목표


## 어려웠던 점
- [x] 정규화 된 테이블에 데이터를 저장하고 검색하기 위한 View를 생성하는 것이 어려웠습니다.
- [x] 라이브러리를 처음 사용해봐서 낯설었습니다.
- [x] 시스템이 작아 팀원들의 작업 분배가 어려웠고, 겹치는 부분이 많아 개발 시 충돌의 문제가 있었습니다.


## 느낀점
- [x] 팀원들을 위해서, 또 추후 확장성을 위해서 가독성 높은 쿼리 및 코드의 필요성을 느꼈습니다.
- [x] FullCalendar 라이브러리를 시작으로 다양한 API, 라이브러리를 접해보고 싶어졌습니다.
- [x] 시스템 세분화 및 작업 분배의 중요성을 느꼈습니다.
- [x] 프레임워크를 이해할 수 있었고, 프레임워크의 효율성을 체험할 수 있었습니다.