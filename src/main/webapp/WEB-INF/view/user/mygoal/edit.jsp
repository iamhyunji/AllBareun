<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/user/mygoal/edit.css">

<main id="main">
    <form action="edit" method="post">
        <section class="required">
            <h1 class="d-none">Main 1 : 목표 기본 등록폼</h1>
            <section class="required__image">
                <h1 class="d-none">목표 메인 이미지</h1>
                <div class="m-img" name="mainImage">
                    메인 이미지 등록
                    선택 / 드래그&드롭
                </div>
            </section>

            <section class="required__content">
                <h1 class="d-none">등록폼</h1>
                <div>
                    <input class="text-xl" type="text" placeholder="제목을 입력해주세요" name="title" value="${g.title}" />
                    <textarea class="description" name="explanation" rows="2" cols="30" placeholder="목표에 대한 설명을 간단히 작성해주세요">${g.explanation}</textarea>

                    <span>카테고리 : ${g.categories }</span>
                    <span>기간 : 4주 (${g.startDate } - ${g.endDate })</span>
                    <span>횟수 : ${g.days }</span>
                    <span>참가 : ${g.totalParticipants }명 (${g.groupParticipants })</span>
                </div>
            </section>
        </section>

        <section class="non-required">
            <h1 class="d-none">Main 2 : 추가 선택 등록폼</h1>
            <div>
                <div>
                    <h2 class="text-l">좋은 인증</h2>
                    <img class="m-img" src="${g.goodEx }" alt="">
                </div>

                <div>
                    <h2 class="text-l">나쁜 인증</h2>
                    <img class="m-img" src="${g.badEx }" alt="">
                </div>

                <div class="description">g.certificationExplanation</div>
            </div>
        </section>

        <section class="buttons">
            <h1 class="d-none">버튼</h1>
            <a class="a-input-white-l" href="../list">취소</a>
            <input class="a-input-orange-l" type="submit" value="확인">
        </section>
    </form>
</main>