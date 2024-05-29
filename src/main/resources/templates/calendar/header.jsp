<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 부트스트랩 CSS 링크, font, icon -->
<link
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        rel="stylesheet">
<link rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
      integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<!-- 부트스트랩 JS 링크 -->
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>

<!-- Header -->
<link
        href="${pageContext.request.contextPath}/css/common/header.css?v=2.06"
        rel="stylesheet">
<script
        src="${pageContext.request.contextPath}/js/common/header.js?v=2.06"></script>

<style>
    /*메뉴바 우측 상단 미니프로필*/
    .mini-profile {
        width: 24px;
        height: 24px;
        border-radius: 70%;
        overflow: hidden;
    }

    .me-auto {
        font-weight: bold;
        margin-right: 60% !important;
    }

    .dropdown-toggle {
        color: #46BEFF !important;
    }

    /*프로필사진들*/
    .profile {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }

    nav {
        padding: 2px !important;
        border: none !important;
    }

    .line {
        margin-top: 30px;
        width: 80%;
        margin-left: 10%;
    }

    .idid {
        font-weight: bold;
    }

    a {
        color: black;
    }

    /* Important styles */
    #toggle {
        display: block;
        /* width: 28px;
        height: 30px;
        margin: 30px auto 10px; */
    }

    #toggle span:after,
    #toggle span:before {
        content: "";
        position: absolute;
        left: 0;
        /* top: -9px; */
    }

    #toggle span:after {
        /* top: 9px; */
    }

    #toggle span {
        position: relative;
        display: block;
    }

    #toggle span,
    #toggle span:after,
    #toggle span:before {
        width: 100%;
        height: 0px;
        background-color: white;
        transition: all 0.3s;
        backface-visibility: hidden;
        border-radius: 0px;
    }

    /* on activation */
    #toggle.on span {
        background-color: transparent;
        border-radius: 0px;
    }

    #toggle.on span:before {
        transform: rotate(45deg) translate(5px, 5px);
        border-radius: 0px;
    }

    #toggle.on span:after {
        transform: rotate(-45deg) translate(7px, -8px);
        border-radius: 0px;
    }

    #toggle.on + #menu {
        opacity: 1;
        visibility: visible;
    }

    /* menu appearance*/
    #menu {
        position: relative;
        color: #999;
        width: 200px;
        padding: 10px;
        margin-top: 30px;
        margin: auto;
        font-family: "Segoe UI", Candara, "Bitstream Vera Sans", "DejaVu Sans", "Bitstream Vera Sans", "Trebuchet MS", Verdana, "Verdana Ref", sans-serif;
        text-align: center;
        border-radius: 4px;
        background: #dee2e6;
        box-shadow: 0 1px 8px rgba(0, 0, 0, 0.05);
        /* just for this demo */
        opacity: 0;
        visibility: hidden;
        transition: opacity .4s;
    }

    #menu:after {
        position: absolute;
        top: -15px;
        left: 155px;
        content: "";
        display: block;
        border-left: 15px solid transparent;
        border-right: 15px solid transparent;
        border-bottom: 20px solid #dee2e6;
    }

    ul, li, li .a-link-login {
        list-style: none;
        display: block;
        margin: 0;
        padding: 0;
    }

    li .a-link-login {
        padding: 5px;
        color: #888;
        text-decoration: none;
        transition: all .2s;
    }

    li .a-link-login:hover,
    li .a-link-login:focus {
        background: #4f97e5;
        color: #fff;
    }

    .nav-link {
        font-size: 24px;
    }

    .nav-submenu > span {
        font-size: 16px;
    }

    .nav-sub {
        font-size: 12px;
    }

    /* demo styles */
    /* body { margin-top: 3em; background: #eee; color: #555; font-family: "Open Sans", "Segoe UI", Helvetica, Arial, sans-serif; } */
    .a-link-login {
        font-size: 12px;
        text-align: center;
        color: #888;
    }
</style>


<c:if test="${empty member_id}">
    <!-- 아이디 없을때 -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary">

        <div class="container-fluid">
            <a class="navbar-brand" href="mainpage.main"> <img id="LOGO"
                                                               style="width: 115px; height: 30px"
                                                               src="${pageContext.request.contextPath}/resource/image/common/LOGO.jpg"></a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active"
                                            aria-current="page" href="FAQ.inq">HELP</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true" aria-expanded="false">STORE</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="store.st">카테고리 1</a>
                            <a class="dropdown-item" href="#">카테고리 2</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">카테고리 3</a>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="icon-pack" style="margin-right: 50px; width: 200px;">
                <span class="material-symbols-outlined"><a href="SNSMain.bo">public</a></span>
                <span class="material-symbols-outlined">chat_bubble</span> <span
                    class="material-symbols-outlined">add_shopping_cart</span>
            </div>

            <!-- 로그인 화면 -->
            <div class="icon-pack" style="margin-right: 25px;">
                <a href="#menu" id="toggle">
                    <label class="idid"
                           style="float: right; margin-left: 10px; width: 120px;"><span style="font-size: 20px;"><i
                            class="fa-solid fa-lock"></i>&nbsp;로그인</span></label>
                </a>
                <div id="menu" style="margin-top: 45px;">
                    <ul>
                        <li><a class="a-link-login" href="login.member"><i
                                class="fa-solid fa-circle-user"></i>&nbsp;<strong>로그인</strong></a></li>
                        <li><a class="a-link-login" href="join.member"><i class="fa-solid fa-user-plus"></i><strong>&nbsp;회원가입</strong></a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
        <div class='darkshadow'></div>
        <div class='header'>
            <div class='header-right'>
                <div class='header-menu'>
                    <a arial-label='Menu' class='menu-toggle'
                       href='javascript:Display();'>
                        <svg focusable='false'
                             height='24' viewBox='0 0 24 24' width='24'>
                            <path
                                    d='M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z'/>
                        </svg>
                    </a>
                </div>
            </div>
        </div>
        <nav id='nav-wrapper' style="display: none">
            <ul>
                <li><a class='nav-submenu' href='javascript:;'
                       title='Bahasa Program'><i class="fa-solid fa-user-plus"></i>&nbsp;&nbsp;<span>ABOUT US
                    <!-- <span class='new'></span> --></span>
                    <svg
                            class='down' height='24' viewBox='0 0 24 24' width='24'>
                        <path
                                d='M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z'/>
                    </svg>
                </a>
                    <ul class='nav-sub'>
                        <li><a href='/p/about.html' itemprop='url'><span
                                itemprop='name'>카테고리1</span></a></li>
                        <li><a href='/p/contact.html' itemprop='url'><span
                                itemprop='name'>카테고리2</span></a></li>
                    </ul>
                </li>
                <li><a class='nav-submenu' href='javascript:;' title='Blogger'><span><i
                        class="fa-solid fa-cart-shopping"></i>&nbsp;&nbsp;STORE</span>
                    <svg class='down' height='24'
                         viewBox='0 0 24 24' width='24'>
                        <path
                                d='M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z'/>
                    </svg>
                </a>
                    <ul class='nav-sub'>
                        <li><a href='/search/label/Template' itemprop='url'><span
                                itemprop='name'>여행패키지</span></a></li>
                        <li><a href='/search/label/Tips' itemprop='url'><span
                                itemprop='name'>카테고리1</span></a></li>
                        <li><a href='/search/label/Tips' itemprop='url'><span
                                itemprop='name'>카테고리2</span></a></li>
                        <li><a href='/search/label/Tips' itemprop='url'><span
                                itemprop='name'>카테고리3</span></a></li>
                    </ul>
                </li>
                <li><a class='nav-submenu' href='javascript:;'
                       title='Framework'><span><i class="fa-solid fa-circle-user"></i>&nbsp;&nbsp;MY PAGE</span>
                    <svg class='down' height='24'
                         viewBox='0 0 24 24' width='24'>
                        <path
                                d='M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z'/>
                    </svg>
                </a>
                    <ul class='nav-sub'>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>내 정보 보기</span></a></li>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>나의 여행 다이어리</span></a></li>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>장바구니</span></a></li>
                    </ul>
                </li>
                <li><a class='nav-submenu' href='javascript:;'
                       title='Framework'><span><i class="fa-solid fa-shapes"></i>&nbsp;&nbsp;CONTENT</span>
                    <svg class='down' height='24'
                         viewBox='0 0 24 24' width='24'>
                        <path
                                d='M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z'/>
                    </svg>
                </a>
                    <ul class='nav-sub'>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>그룹 커뮤니티</span></a></li>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>MBTI 성향 확인하기</span></a></li>
                    </ul>
                </li>
                <li><a href='/search/label/Firebase' itemprop='url'><span style="font-size: 16px;"
                                                                          itemprop='name'><i
                        class="fa-solid fa-gear"></i>&nbsp;&nbsp;SETTING</span></a></li>

            </ul>
        </nav>
        <!-- End Navigation -->
    </nav>
</c:if>

<c:if test="${!empty member_id}">
    <!-- 아이디 있을때 해더 -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary">

        <div class="container-fluid">

            <a class="navbar-brand" href="mainpage.main"> <img id="LOGO"
                                                               style="width: 115px; height: 30px"
                                                               src="${pageContext.request.contextPath}/resource/image/common/LOGO.jpg"></a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active"
                                            aria-current="page" href="FAQ.inq">HELP</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true" aria-expanded="false">STORE</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="store.st">카테고리 1</a>
                            <a class="dropdown-item" href="#">카테고리 2</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">카테고리 3</a>
                        </div>
                    </li>
                </ul>
            </div>

        </div>
        <div class="icon-pack" style="margin-right: 50px; width: 200px;">
            <span class="material-symbols-outlined"><a href="SNSMain.bo">public</a></span>
            <span class="material-symbols-outlined">chat_bubble</span> <span
                class="material-symbols-outlined">add_shopping_cart</span>
        </div>

        <!-- 프로필 사진 -->
        <div class="icon-pack" style="margin-right: 25px;">
            <a href="#menu" id="toggle">
                <label class="idid"
                       style="float: right; margin-left: 10px; width: 120px;"><span style="font-size: 20px;"><i
                        class="fa-solid fa-circle-user"></i>&nbsp;${ member_nickname}</span></label>
                    <%-- <div class="mini-profile" style="float: right; margin-left: 20px;">
                        <a href="mypage.mypage"> <img class="profilelogin"
                            style="margin-bottom: 3px;"
                            src="${pageContext.request.contextPath}/resource/image/common/Profile_default.png">
                        </a>
                    </div> --%>
            </a>
            <div id="menu" style="margin-top: 45px;">
                <ul>
                    <li><a class="a-link-login" href="mypageinfo.mypage"><i
                            class="fa-solid fa-circle-user"></i>&nbsp;<strong>마이페이지</strong></a></li>
                    <li><a class="a-link-login" href="logout.member"><i
                            class="fa-solid fa-right-from-bracket"></i><strong>&nbsp;로그아웃</strong></a></li>
                </ul>
            </div>
        </div>

        <div class='darkshadow'></div>
        <div class='header'>
            <div class='header-right' style="margin-right: 20px;">
                <div class='header-menu'>
                    <a arial-label='Menu' class='menu-toggle'
                       href='javascript:Display();'>
                        <svg focusable='false'
                             height='24' viewBox='0 0 24 24' width='24'>
                            <path
                                    d='M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z'/>
                        </svg>
                    </a>
                </div>
            </div>
        </div>
        <nav id='nav-wrapper' style="display: none">
            <ul>
                <li><a class='nav-submenu' href='javascript:;'
                       title='Bahasa Program'><i class="fa-solid fa-user-plus"></i>&nbsp;&nbsp;<span>ABOUT US
                    <!-- <span class='new'></span> --></span>
                    <svg
                            class='down' height='24' viewBox='0 0 24 24' width='24'>
                        <path
                                d='M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z'/>
                    </svg>
                </a>
                    <ul class='nav-sub'>
                        <li><a href='/p/about.html' itemprop='url'><span
                                itemprop='name'>카테고리1</span></a></li>
                        <li><a href='/p/contact.html' itemprop='url'><span
                                itemprop='name'>카테고리2</span></a></li>
                    </ul>
                </li>
                <li><a class='nav-submenu' href='javascript:;' title='Blogger'><span><i
                        class="fa-solid fa-cart-shopping"></i>&nbsp;&nbsp;STORE</span>
                    <svg class='down' height='24'
                         viewBox='0 0 24 24' width='24'>
                        <path
                                d='M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z'/>
                    </svg>
                </a>
                    <ul class='nav-sub'>
                        <li><a href='/search/label/Template' itemprop='url'><span
                                itemprop='name'>여행패키지</span></a></li>
                        <li><a href='/search/label/Tips' itemprop='url'><span
                                itemprop='name'>카테고리1</span></a></li>
                        <li><a href='/search/label/Tips' itemprop='url'><span
                                itemprop='name'>카테고리2</span></a></li>
                        <li><a href='/search/label/Tips' itemprop='url'><span
                                itemprop='name'>카테고리3</span></a></li>
                    </ul>
                </li>
                <li><a class='nav-submenu' href='javascript:;'
                       title='Framework'><span><i class="fa-solid fa-circle-user"></i>&nbsp;&nbsp;MY PAGE</span>
                    <svg class='down' height='24'
                         viewBox='0 0 24 24' width='24'>
                        <path
                                d='M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z'/>
                    </svg>
                </a>
                    <ul class='nav-sub'>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>내 정보 보기</span></a></li>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>나의 여행 다이어리</span></a></li>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>장바구니</span></a></li>
                    </ul>
                </li>
                <li><a class='nav-submenu' href='javascript:;'
                       title='Framework'><span><i class="fa-solid fa-shapes"></i>&nbsp;&nbsp;CONTENT</span>
                    <svg class='down' height='24'
                         viewBox='0 0 24 24' width='24'>
                        <path
                                d='M7.41,8.58L12,13.17L16.59,8.58L18,10L12,16L6,10L7.41,8.58Z'/>
                    </svg>
                </a>
                    <ul class='nav-sub'>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>그룹 커뮤니티</span></a></li>
                        <li><a href='/search/label/Material' itemprop='url'><span
                                itemprop='name'>MBTI 성향 확인하기</span></a></li>
                    </ul>
                </li>
                <li><a href='/search/label/Firebase' itemprop='url'><span style="font-size: 16px;"
                                                                          itemprop='name'><i
                        class="fa-solid fa-gear"></i>&nbsp;&nbsp;SETTING</span></a></li>

            </ul>
        </nav>
        <!-- End Navigation -->
    </nav>
</c:if>
<script>
    var theToggle = document.getElementById('toggle');

    //based on Todd Motto functions
    //https://toddmotto.com/labs/reusable-js/

    //hasClass
    function hasClass(elem, className) {
        return new RegExp(' ' + className + ' ').test(' ' + elem.className + ' ');
    }

    //addClass
    function addClass(elem, className) {
        if (!hasClass(elem, className)) {
            elem.className += ' ' + className;
        }
    }

    //removeClass
    function removeClass(elem, className) {
        var newClass = ' ' + elem.className.replace(/[\t\r\n]/g, ' ') + ' ';
        if (hasClass(elem, className)) {
            while (newClass.indexOf(' ' + className + ' ') >= 0) {
                newClass = newClass.replace(' ' + className + ' ', ' ');
            }
            elem.className = newClass.replace(/^\s+|\s+$/g, '');
        }
    }

    //toggleClass
    function toggleClass(elem, className) {
        var newClass = ' ' + elem.className.replace(/[\t\r\n]/g, " ") + ' ';
        if (hasClass(elem, className)) {
            while (newClass.indexOf(" " + className + " ") >= 0) {
                newClass = newClass.replace(" " + className + " ", " ");
            }
            elem.className = newClass.replace(/^\s+|\s+$/g, '');
        } else {
            elem.className += ' ' + className;
        }
    }

    theToggle.onclick = function () {
        toggleClass(this, 'on');
        return false;
    }
</script>