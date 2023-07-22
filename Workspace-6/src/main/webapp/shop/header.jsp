<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
	<header class="header">
            <div class="grid wide">
                <!-- navbar -->
                <nav class="header__navbar hide-on-mobile-tablet">
                    <ul class="header__nav-list">
                        <li class="header__nav-item header__nav-item--hover header__nav-item--separate"><a href="http://localhost:8080/Shopee/seller" class="header__nav-item-link">Kênh người bán</a></li>
                        <li class="header__nav-item header__nav-item--hover header__nav-item--separate">Trở thành Người bán Shopee</li>
                        <li class="header__nav-item header__nav-item--hover header__nav-item--separate header__show-qr">
                            Tải ứng dụng
                        </li>
                        <!-- qr code -->
                        <div class="header__qrcode">
                            <img src="${root}assets/img/qr/qr-code.png" class="header__qr">
                            <div class="header__apps">
                                <a href="#" class="header__app-link">
                                    <img src="${root}assets/img/qr/app-store.png" class="header__app-img">
                                </a>
                                <a href="#" class="header__app-link">
                                    <img src="${root}assets/img/qr/gg-play.png" class="header__app-img">
                                </a>
                                <a href="#" class="header__app-link">
                                    <img src="${root}assets/img/qr/app-gallery.png" class="header__app-img">
                                </a>
                                <a href="#" class="header__app-link">
                                    <img src="${root}assets/img/qr/ltp-img.png" class="header__app-img">
                                </a>
                            </div>
                        </div>
                        <li class="header__nav-item">
                            Kết nối
                            <a href="#" class="header__nav-icon-link">
                                <i class="header__nav-icon fab fa-facebook"></i>
                            </a>
                            <a href="#" class="header__nav-icon-link">
                                <i class="header__nav-icon fab fa-instagram"></i>
                            </a>
                        </li>
                    </ul>
                    <ul class="header__nav-list">
                        <li class="header__nav-item header__show-note">
                            <a href="#" class="header__nav-item-link">
                                <i class="header__nav-icon far fa-bell"></i>
                                Thông báo
                            </a>
                            <!-- thông báo -->
                        </li>
                        <li class="header__nav-item">
                            <a href="#" class="header__nav-item-link">
                                <i class="header__nav-icon far fa-question-circle"></i>
                                Hỗ trợ
                            </a>
                        </li>
                        <c:if test="${sessionScope.user == null}">
	                        <li class="header__nav-item header__nav-item--bold header__nav-item--separate">
	                            <a href="http://localhost:8080/Shopee/shop/signup" class="header__nav-item-link">Đăng ký</a>
	                        </li>
	                        <li class="header__nav-item header__nav-item--bold">
	                            <a href="http://localhost:8080/Shopee/shop/login" class="header__nav-item-link">Đăng nhập</a>
	                        </li>
						</c:if>
						<c:if test="${sessionScope.user != null}">
	                        <li class="header__nav-item header__nav-item--bold header__nav-item--separate">
	                        	<img src="${root}/assets/img/user.png" class="header__nav-user-avt">
	                            <a href="http://localhost:8080/Shopee/AccountInfoControl" class="header__nav-item-link">${sessionScope.user.userName}</a>
	                        </li>
	                        <li class="header__nav-item header__nav-item--bold">
	                            <!-- <a href="http://localhost:8080/Shopee/shop/logout" class="header__nav-item-link">Đăng xuất</a> -->
	                            <form action="logout" method="POST">
	                                <li class="js-logout-btn">
	                                    <button type="submit" class="logout">
	                                        Đăng xuất
	                                    </button>
	                                </li>
                            	</form>
	                        </li>
						</c:if>
                    </ul>
                </nav>
                <!-- search -->
                <div class="header__contain">
                    <label for="mobile-search" class="header__mobile-search">
                        <i class="header__mobile-search-icon fas fa-search"></i>
                    </label>
                    <div class="header__logo">
                        <a href="http://localhost:8080/Shopee/home" class="header__logo-link">
                            <img src="${root}assets/img/logo/logo-full-white.png" class="header__logo-img">
                        </a>
                    </div>
                    <input type="checkbox" id="mobile-search" class="header__search-check" hidden>
                    <!-- header__cart--no-cart --><!-- header__cart--has-cart -->
                    <div class="header__cart header__cart--has-cart">
                        <i class="header__cart-icon fas fa-shopping-cart"></i>
                        <div class="header__cart-count">${sizec + 1}</div>
                        
                        <div class="header__cart-list no-cart">
                            <img src="${root}assets/img/sp/no-cart.png" class="header__no-cart-img">
                            <p class="header__no-cart-text">Chưa có sản phẩm</p>
                        </div>
                        
                        <div class="header__cart-list has-cart">
                            <h4 class="header__cart-heading">Sản phẩm đã chọn</h4>
                            <ul class="header__cart-list-item">
	                            <c:if test="${sizec >= 0}">
	                            	<c:forEach begin="0" end="${sizec}" var="i">
		                                <li class="header__cart-item">
		                                    <img src="${root}${listp[i].getImage()}" class="header__cart-item-img">
		                                    <div class="header__cart-item-info">
		                                        <div class="header__cart-item-heading">
		                                            <h3 class="header__cart-item-name">${listp[i].getProductName()}</h3>
		                                            <p class="header__cart-item-price">${listp[i].getPromotionalPrice()}đ</p>
		                                        </div>
		                                        <div class="header__cart-item-body">
		                                            <p class="header__cart-item-number">x ${listc[i].getCount()}</p>
		                                        </div>
		                                    </div>
		                                </li>
		                        	</c:forEach>
	                            </c:if>
	                            <c:if test="${sizec < 0}">
	                           		<h1>Chưa có đơn hàng</h1>
	                            </c:if>
                            </ul>
                            <div class="header__cart-footer">
                                <a href="http://localhost:8080/Shopee/CartControl" class="btn btn--primary header__cart-see-cart">Xem giỏ hàng</a>
                            </div>
                        </div>
                    </div>
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