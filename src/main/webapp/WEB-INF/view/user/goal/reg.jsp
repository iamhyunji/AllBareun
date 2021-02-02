<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/user/goal/reg.css">
<script src="/js/user/goal/reg.js"></script>

<main id="main">
	<form action="reg" method="post">
		<section class="required">
			<h1 class="d-none">Main 1 : 목표 기본 등록폼</h1>
			<section class="required__image">
				<h1 class="d-none">목표 메인 이미지</h1>
				<div class="m-img" name="g-mImg">메인 이미지 등록 선택 / 드래그&드롭</div>
			</section>

			<section class="required__content">
				<h1 class="d-none">등록폼</h1>
				<div>
					<input class="text-xl" type="text" name="g-t" placeholder="제목을 입력해주세요" required="required" />
					<textarea class="description" name="g-ex" rows="2" cols="30" placeholder="목표에 대한 설명을 간단히 작성해주세요" required="required"></textarea>

					<div>
						<label>기간</label>
						<span>4주</span>
						<input type="date" name="g-sd" required="required" /> - <input type="date" name="g-ed" required="required" />
					</div>

					<div class="category-container">
						<label>카테고리</label>
						<input type="checkbox" name="gct-id" value="1" />생활
						<input type="checkbox" name="gct-id" value="2" />건강
						<input type="checkbox" name="gct-id" value="3" />관계
						<input type="checkbox" name="gct-id" value="4" />역량
						<input type="checkbox" name="gct-id" value="5" />자산
						<input type="checkbox" name="gct-id" value="6" />취미
					</div>

					<div class="participation-container">
						<label>참가</label>
						<select class="select-s" name="g-ps">
							<option value="-1">개인</option>
							<option value="0">지인 그룹</option>
							<option value="1">공개 그룹</option>
						</select>
						<input class="select-s total-participants" type="hidden" name="g-tp" value="1" min="1" max="1" />
					</div>

					<div class="cycle-container">
						<label>인증 주기</label>
						<select class="select-s">
							<option value="everyday">매일</option>
							<option value="week">매주</option>
							<option value="weekday">주중</option>
							<option value="weekend">주말</option>
						</select>
						<div class="cycle" style="display: none">
							<input type="checkbox" name="d-id" value="1" checked />월
							<input type="checkbox" name="d-id" value="2" checked />화
							<input type="checkbox" name="d-id" value="3" checked />수
							<input type="checkbox" name="d-id" value="4" checked />목
							<input type="checkbox" name="d-id" value="5" checked />금
							<input type="checkbox" name="d-id" value="6" checked />토
							<input type="checkbox" name="d-id" value="7" checked />일
						</div>
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
					<div class="m-img" name="g-gEx">좋은 인증 예시 사진</div>
				</div>

				<div>
					<h2 class="text-l">나쁜 인증</h2>
					<div class="m-img" name="g-bEx">나쁜 인증 예시 사진</div>
				</div>

				<textarea class="description" name="g-exEx" rows="2" cols="30" placeholder="인증 기준과 인증 방법을 서술해주세요"></textarea>
			</div>
		</section>

		<section class="buttons">
			<h1 class="d-none">버튼</h1>
			<a class="a-input-white-l" href="#">취소</a>
			<input class="a-input-orange-l reg-button" type="submit" value="제 목표를 개설해주세요">
		</section>
	</form>
</main>