<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KS Gallery</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${contextPath}/resources/main.css">

<body>
<div class="container">
	<section>
		<div class="feature-posts">
			<a href="${contextPath}/admin/video/videoListView.do" class="feature-post-item"> <span>▶프로그램</span>
			</a> <a href="${contextPath}/admin/video/adminVideoDetail.do?vno=27"
				class="feature-post-item"> <img
				src="${contextPath }/resources/image/Art.jpg" class="w-100" alt="">

			</a> <a href="${contextPath}/admin/video/adminVideoDetail.do?vno=25"
				class="feature-post-item"> <img
				src="${contextPath }/resources/image/Art2.jpg" class="w-100" alt="">

			</a> <a href="#" class="feature-post-item"> <img
				src="${contextPath }/resources/image/Art3.jpg" class="w-100" alt="">

			</a>
		</div>
	</section>
	<hr>
	<div class="page-container">
		<div class="page-content">
			<div class="card">
				<div class="card-header text-center">
					<h5 class="card-title">설전/雪戰</h5>
					<small class="small text-muted">2022 . 10 . 19 <span
						class="px-2">-</span> <a href="#" class="text-muted">리뷰
							카운트(예정)</a>
					</small>
				</div>
				<div class="card-body">
					<div class="blog-media">
						<img src="${contextPath}/resources/image/최대진.png" alt=""
							class="w-100">
					</div>
					<p class="my-3">최대진은 드로잉을 기반으로 일상의 이야기들을 여러 매체로 다양하게 구성하는 작업을
						보여주는 작가이다. 이 작품은 거친 눈보라 아래서 축구경기를 하고있는 선수들의 모습을 묘사하였으며 목탄의 부드러운
						질감을 이용해 흐리게 표현함으로써 기존의 사실성이 강했던 회화에서 새로운 미학적 시도를 하였다.</p>
				</div>

				<div
					class="card-footer d-flex justify-content-between align-items-center flex-basis-0">
					<button class="btn btn-primary circle-35 mr-4">
						<i class="ti-back-right"></i>
					</button>
					<a
						href="${contextPath}/collectible/collectibleDetail.do?goods_id=503"
						class="btn btn-outline-dark btn-sm">READ MORE</a> <a href="#"
						class="text-dark small text-muted">By : 최대진</a>
				</div>
			</div>
		</div>
	</div>
</div>

<hr>

	<div class="row">
		<div class="col-lg-6">
			<div class="card text-center mb-5">
				<div class="card-header p-0">
					<div class="blog-media">
						<img src="${contextPath}/resources/image/광안대교.png" alt=""
							class="w-100">
					</div>
				</div>
				<div class="card-body px-0">
					<h5 class="card-title mb-2">광안대교 3</h5>
					<small class="small text-muted">2022 . 10 . 19 <span
						class="px-2">-</span> <a href="#" class="text-muted">34
							Comments</a>
					</small>
					<p class="my-2">강홍구는 디지털 합성 사진을 주된 매체로 하여 주거환경으로서의 도시의 모습을 담아내는
						작가다. 이 작품은 2002년 제 1회 부산비엔날레 출품작으로 부산을 대표하는 장소인 광안리, 해운대 해수욕장에서
						마주친 건설 중이던 광안대교의 모습을 포착한 디지털 사진 작업이다. 디지털 카메라로 여러 장을 촬영하고 모아서 한
						장으로 거칠게 접합하고 필요에 따라 몇 장면들은 몽타주해 넣는 방식으로 작업한 작품이다. 부산이라는 도시 전체를 거대한
						유원지로 느끼고 마주쳤던 당시의 기억과 개인적 감정들을 담아내고자 했다.</p>
				</div>

				<div class="card-footer p-0 text-center">
					<a
						href="${contextPath}/collectible/collectibleDetail.do?goods_id=500"
						class="btn btn-outline-dark btn-sm">READ MORE</a>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="card text-center mb-5">
				<div class="card-header p-0">
					<div class="blog-media">
						<img src="${contextPath}/resources/image/광안대교 1.jpg" alt=""
							class="w-100">
					</div>
				</div>
				<div class="card-body px-0">
					<h5 class="card-title mb-2">광안대교 1</h5>
					<small class="small text-muted">2020 . 10 . 19 <span
						class="px-2">-</span> <a href="#" class="text-muted">64
							Comments</a>
					</small>
					<p class="my-2">강홍구는 디지털 합성 사진을 주된 매체로 하여 주거환경으로서의 도시의 모습을 담아내는
						작가다. 이 작품은 2002년 제 1회 부산비엔날레 출품작으로 부산을 대표하는 장소인 광안리, 해운대 해수욕장에서
						마주친 건설 중이던 광안대교의 모습을 포착한 디지털 사진 작업이다. 디지털 카메라로 여러 장을 촬영하고 모아서 한
						장으로 거칠게 접합하고 필요에 따라 몇 장면들은 몽타주해 넣는 방식으로 작업한 작품이다. 부산이라는 도시 전체를 거대한
						유원지로 느끼고 마주쳤던 당시의 기억과 개인적 감정들을 담아내고자 했다.</p>
				</div>

				<div class="card-footer p-0 text-center">
					<a href="#" class="btn btn-outline-dark btn-sm">READ MORE</a>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>