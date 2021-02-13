<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="/css/user/mygoal/edit.css">
<script type="module" src="/js/user/mygoal/edit.js"></script>

<main id="main">
	<form action="edit" method="post" enctype="multipart/form-data">
		<section class="required">
			<h1 class="d-none">Main 1 : 목표 기본 등록폼</h1>
			<section class="required__image">
				<h1 class="d-none">목표 메인 이미지</h1>
				<div class="m-img g-mImg" style="background: linear-gradient( rgba(255, 255, 255, 0.8) 100%, rgba(255, 255, 255, 0.8) 100%), center / 100% no-repeat url(${g.mainImage });">
					<input class="g-mImg-file" type="hidden" name="g-mImg" value="${g.mainImage }"/>
					<span class="text-l">이미지 드래그& 드롭</span>
				</div>
			</section>

			<section class="required__content">
				<h1 class="d-none">등록폼</h1>
				<div>
					<input class="text-xl" type="text" placeholder="제목을 입력해주세요" name="g-t" value="${g.title}" />
					<textarea class="description" name="g-ex" rows="2" cols="30"
						placeholder="목표에 대한 설명을 간단히 작성해주세요">${g.explanation}</textarea>

					<p>카테고리 : ${g.categories }</p>
					<p>
						기간 : ${g.dateDiff }주 (
						<fmt:formatDate value="${g.startDate }" pattern="yyyy-MM-dd" />
						-
						<fmt:formatDate value="${g.endDate }" pattern="yyyy-MM-dd" />
						)
					</p>
					<p>횟수 : 주 ${g.count }회 (${g.days })</p>
					<div class="participants__container">참가 : 총
						${g.totalParticipants }명 ${g.participants }
					</div>
				</div>
			</section>
		</section>

		<section class="non-required">
			<h1 class="d-none">Main 2 : 추가 선택 등록폼</h1>
			<div>
				<div>
					<h2 class="text-l">좋은 인증</h2>
					<div class="m-img" style="background-image: url(${g.goodEx });"></div>
				</div>

				<div>
					<h2 class="text-l">나쁜 인증</h2>
					<div class="m-img" style="background-image: url(${g.badEx });"></div>
				</div>

				<div class="description">${g.exExplanation }</div>
			</div>
		</section>

		<section class="buttons">
			<h1 class="d-none">버튼</h1>
			<a class="a-input-white-l" href="../list">취소</a>
			<input class="a-input-orange-l submit-button" type="submit" value="확인">
			<input class="goalId" type="hidden" name="g-id" value="${g.id }" />
		</section>
	</form>
</main>