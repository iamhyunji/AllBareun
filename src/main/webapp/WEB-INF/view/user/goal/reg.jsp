<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/user/goal/reg.css">

<main id="main">
	<form action="reg" method="post">
		<section class="required">
			<h1 class="d-none">Main 1 : 목표 기본 등록폼</h1>
			<section class="required__image">
				<h1 class="d-none">목표 메인 이미지</h1>
				<div class="m-img" name="gMainImg">메인 이미지 등록 선택 / 드래그&드롭</div>
			</section>

			<section class="required__content">
				<h1 class="d-none">등록폼</h1>
				<div>
					<input class="text-xl" type="text" name="gt" placeholder="제목을 입력해주세요" />
					<textarea class="description" name="gEx" rows="2" cols="30" placeholder="목표에 대한 설명을 간단히 작성해주세요"></textarea>

					<div>
						<label>기간</label>
						<span>4주</span>
						<input type="date" name="gsd" /> - <input type="date" name="ged" />
					</div>

					<div>
						<label>카테고리</label>
						<input type="checkbox" name="gcId" value="1" />생활
						<input type="checkbox" name="gcId" value="2" />건강
						<input type="checkbox" name="gcId" value="3" />관계
						<input type="checkbox" name="gcId" value="4" />역량
						<input type="checkbox" name="gcId" value="5" />자산
						<input type="checkbox" name="gcId" value="6" />취미
					</div>

					<div>
						<label>참가</label>
						<select class="select-s" name="gps">
							<option value="0">개인</option>
							<option value="0">지인 그룹</option>
							<option value="1">공개 그룹</option>
						</select>
						<input class="select-s" type="number" name="gtp" value="1" min="1" max="10" />
						<input class="a-input-white-s" type="button" value="초대">
					</div>

					<div>
						<label>인증횟수</label>
						<select class="select-s">
							<option>매일</option>
							<option>매주</option>
							<option>주중</option>
							<option>주말</option>
						</select>
						<input class="select-s" type="number" name="gc" min="1" max="99" value="1" />회/일
						<input type="checkbox" name="" value="1" />월
						<input type="checkbox" name="dId" value="2" />화
						<input type="checkbox" name="dId" value="3" />수
						<input type="checkbox" name="dId" value="4" />목
						<input type="checkbox" name="dId" value="5" />금
						<input type="checkbox" name="dId" value="6" />토
						<input type="checkbox" name="dId" value="7" />일
					</div>

					<div>
						<label>인증 사진</label>
						<input type="radio" />인증 사진 있음
						<input type="radio" />인증 사진 없음
					</div>
				</div>
			</section>
		</section>

		<section class="non-required">
			<h1 class="d-none">Main 2 : 추가 선택 등록폼</h1>
			<div>
				<div>
					<h2 class="text-l">좋은 인증</h2>
					<div class="m-img" name="gGEx">좋은 인증 예시 사진</div>
				</div>

				<div>
					<h2 class="text-l">나쁜 인증</h2>
					<div class="m-img" name="gBEx">나쁜 인증 예시 사진</div>
				</div>

				<!-- <textarea class="description" name="#" value="#" rows="2" cols="30" placeholder="인증 기준과 인증 방법을 서술해주세요"></textarea> -->
				<textarea class="description" rows="2" cols="30" placeholder="인증 기준과 인증 방법을 서술해주세요"></textarea>
			</div>
		</section>

		<section class="buttons">
			<h1 class="d-none">버튼</h1>
			<a class="a-input-white-l" href="#">취소</a>
			<input class="a-input-orange-l" type="submit" value="제 목표를 개설해주세요">
		</section>
	</form>
</main>