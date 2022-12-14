<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle}</title>
<!-- 폰트어썸 불러오기 -->
<script src="https://unpkg.com/tailwindcss-jit-cdn"></script>
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- 테일윈드 불러오기 -->
<!-- 노말라이즈,라이브러리 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<!-- 커스텀 공통 css -->
<link rel="stylesheet" href="/resource/common.css" />
</head>
<body>
	<header>
	<div class="h-20 flex container mx-auto text-4xl">
	<a class="h-full px-3 flex items-center" href="#"><span>로고</span></a>
	<div class="flex-grow"></div>	
	<ul class="flex">
	<li class="hover:underline"><a class="h-full px-3 flex items-center" href="#"><span>Home</span></a></li>
	<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/usr/article/list"><span>List</span></a></li>	
	<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/usr/article/login"><span>Login</span></a></li>	
	</ul>
	</div>
	</header>
	<section class="my-3 text-2xl">
	<div class="container mx-auto px-3">
	<h1>${pageTitle}&nbsp;page</h1>
	</div>
	</section>
	<main>
	
	</main>