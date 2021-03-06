<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
          rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<!--<div th:include="include/navigation.html"></div>-->
<#--<div>{{>include/navigation}}</div>-->
<#include "include/navigation.html">
<!-- Page Header -->
<header class="masthead" style="background-image: url('img/contact-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="page-heading">
                    <h1>Contact Me</h1>
                    <span class="subheading">Have questions? I have answers.</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
            <p>Want to get in touch? Fill out the form below to send me a message and I will get back to you as soon as possible!</p>
            <!-- Contact Form - Enter your email address on line 19 of the mail/contact_me.php file to make this form work. -->
            <!-- WARNING: Some web hosts do not allow emails to be sent through forms to common mail hosts like Gmail or Yahoo. It's recommended that you use a private domain email address! -->
            <!-- To use the contact form, your site must be on a live web host with PHP! The form will not work locally! -->
            <table class="table">
                <thead>
                <tr>
                    <td>글번호</td>
                    <td>가게이름</td>
                    <td>지역</td>
                    <td>작성자 아이디</td>
                    <td>작성일자</td>
                    <td>조회수</td>
                    <td>좋아요 수</td>


                </tr>
                </thead>

                <tbody>
                <#list boardList as board>
                <tr>
                    <td>${board.seq}</td>
                    <td>${board.title}</td>
                    <td>${board.location}</td>
                    <td>${board.member.memberId}</td>
                    <td>${board.reportingDate}</td>
                    <td>${board.readCount}</td>
                    <td>${board.likeCount}</td>
                </tr>
                </#list>
                </tbody>
            </table>

            <br>
            <div id="success"></div>
            <div class="form-group">
                <a href="/boardlist/writeboard">
                    <button class="btn btn-primary" id="writeButton">글쓰기</button>
                </a>
            </div>
        </div>
    </div>
</div>

<hr>

<!-- Footer -->
<div><#include "include/footer.html"></div>
<#--<div>{{>include/footer}}</div>-->
<!--<div th:include="include/footer.html"></div>-->


<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="js/jqBootstrapValidation.js"></script>
<script src="js/contact_me.js"></script>

<!-- Custom scripts for this template -->
<script src="js/clean-blog.min.js"></script>

</body>

</html>
