<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
	<header class="header_login">
            <div class="grid wide">
                <!-- search -->
                <div class="header__contain">
                    <div class="header__logo__login">
                        <a href="http://localhost:8080/Shopee/home" class="header__logo-link">
                            <img src="${root}assets/img/logo/Shopee.svg" class="header__logo-img">
                        </a>
                        <div class="title__login">Đăng Nhập Seller</div>
                    </div>
                    <div class ="title__login__help"><a>Bạn cần giúp đỡ ?</a></div>
                </div>
            </div>
            <ul class="header__sort-bar">
                <li class="header__sort-item">
                    <a href="#" class="header__sort-link">Liên quan</a>
                </li>
                <li class="header__sort-item header__sort-item--active">
                    <a href="#" class="header__sort-link">Mới nhất</a>
                </li>
                <li class="header__sort-item">
                    <a href="#" class="header__sort-link">Bán chạy</a>
                </li>
                <li class="header__sort-item">
                    <a href="#" class="header__sort-link">Giá</a>
                </li>
            </ul>
        </header>