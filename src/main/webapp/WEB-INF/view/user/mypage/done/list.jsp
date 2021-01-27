
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/member/mypage/done/list.css">
<main id="main">
	<h1 class="d-none">Content Body > Main</h1>

	<section class="search">
		<h1 class="d-none">검색폼</h1>
		<form action="#" method="get" class="search__form">
			<div>
				<input type="checkbox" name="category" />
				<label>역량</label>
				<input type="checkbox" name="category" />
				<label>생활</label>
				<input type="checkbox" name="category" />
				<label>관계</label>
				<input type="checkbox" name="category" />
				<label>건강</label>
				<input type="checkbox" name="category" />
				<label>취미</label>
				<input type="checkbox" name="category" />
				<label>자산</label>
			</div>

			<div>
				<label>참가 인원</label>
				<select class="select-s" name="participation">
					<option value="">전체</option>
					<option value="">개인</option>
					<option value="">그룹</option>
				</select>
			</div>

			<div>
				<label>종료</label>
				<select class="select-s" name="finish">
					<option value="#">전체</option>
					<option value="#">완료</option>
					<option value="#">미완료</option>
				</select>
			</div>

			<input class="a-input-white-s" type="submit" value="검색" />
		</form>
	</section>

	<section class="goals">
		<h1 class="d-none">목표 리스트</h1>
		<ul class="goals__list">
			<li>
				<img class="s-img" src="/images/img1.JPG" alt="" />
				<div>
					<h2 class="text-l"><a href="#">10분 독서</a></h2>
					<span>카테고리 : 취미, 역량</span>
					<span>기간 : 4주 (2020.09.09 - 2021.01.09)</span>
					<span>횟수 : 3회 (월, 수, 금)</span>
					<span>참가 : 4명 (중언, 본율, 혜영, 현지)</span>
				</div>
				<div>
					<input class="del-button" type="button" value="x" />
					<a class="a-input-orange-s" href="#">결과 리포트</a>
				</div>
			</li>

			<li>
				<img class="s-img" src="/images/img2.jpeg" alt="" />
				<div>
					<h2 class="text-l"><a href="#">6시 기상하기</a></h2>
					<span>카테고리 : 생활</span>
					<span>기간 : 4주 (2020.09.09 - 2021.01.09)</span>
					<span>횟수 : 매일</span>
					<span>참가 : 4명 (본율, 혜영, 현지, 중언)</span>
				</div>
				<div>
					<input class="del-button" type="button" value="x" />
					<div>
						<input class="a-input-white-s" type="button" value="재도전" />
						<a class="a-input-orange-s" href="#">결과 리포트</a>
					</div>
				</div>
			</li>

			<li>
				<img class="s-img" src="/images/img3.jpeg" alt="" />
				<div>
					<h2 class="text-l"><a href="#">저녁 일기 쓰기</a></h2>
					<span>카테고리 : 취미, 생활</span>
					<span>기간 : 4주 (2020.09.09 - 2021.01.09)</span>
					<span>횟수 : 3회 (월, 수, 금)</span>
					<span>참가 : 4명 (혜영, 현지, 중언, 본율)</span>
				</div>
				<div>
					<input class="del-button" type="button" value="x" />
					<a class="a-input-orange-s" href="#">결과 리포트</a>
				</div>
			</li>
		</ul>
	</section>
</main>
