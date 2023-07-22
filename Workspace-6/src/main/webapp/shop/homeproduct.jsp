<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<!-- home product -->
                        <div class="home-product">
                            <nav class="mobile-category">
                                <ul class="mobile-category-list">
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">Thiết bị mạng</a>
                                    </li>
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">Chuột và bàn phím</a>
                                    </li>
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">USB</a>
                                    </li>
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">Link kiện máy tính</a>
                                    </li>
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">Wifi</a>
                                    </li>
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">Ổ cứng</a>
                                    </li>
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">CD/DVD</a>
                                    </li>
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">Tai nghe</a>
                                    </li>
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">Lót chuột</a>
                                    </li>
                                    <li class="mobile-category-item">
                                        <a href="#" class="mobile-category-item-link">Micro</a>
                                    </li>
                                </ul>
                            </nav>
                            <div id="list-product" class="row sm-gutter">
                            	<c:forEach begin="0" end="${size}" var="i">
	                            	<div data="${i}" class="col l-2-4 m-3 c-6 home-product-item">
							            <a class="home-product-item-link" href="<c:url value='/ProductDetailControl?id=${list[i].getProductId()}'/>">
										<div class="home-product-item__img" style="background-image: url(${list[i].getImage()});"></div>

							                <div class="home-product-item__info">
							                    <h4 class="home-product-item__name">${list[i].getProductName()}</h4>
							                    <div class="home-product-item__price">
							                        <p class="home-product-item__price-old">${list[i].getPrice()}đ</p>
							                        <p class="home-product-item__price-new">${list[i].getPromotionalPrice()}đ</p>
							                        <i class="home-product-item__ship fas fa-shipping-fast"></i>
							                    </div>
							                    <div class="home-product-item__footer">
							                        <div class="home-product-item__save">
							                            <input type="checkbox" id="heart-save-1">
							                            <label for="heart-save-1" class="far fa-heart"></label>
							                        </div>
							                        <div class="home-product-item__rating-star">
							                            <i class="star-checked far fa-star"></i>
							                            <i class="star-checked far fa-star"></i>
							                            <i class="star-checked far fa-star"></i>
							                            <i class="star-checked far fa-star"></i>
							                            <i class="star-uncheck far fa-star"></i>
							                        </div>
							                        <div class="home-product-item__saled">Đã bán ${list[i].getSold()}</div>
							                    </div>
							                    <div class="home-product-item__origin">Hà Nội</div>
							                    <div class="home-product-item__favourite">
							                        Yêu thích
							                    </div>
							                    <div class="home-product-item__sale-off">
							                        <div class="home-product-item__sale-off-value">${list[i].getSalePrice()}%</div>
							                        <div class="home-product-item__sale-off-label">GIẢM</div>
							                    </div>
							                </div>
							                <div class="home-product-item-footer">Tìm sản phẩm tương tự</div>
							            </a>
	        						</div>
	        					</c:forEach>
                            </div>
                        </div>        