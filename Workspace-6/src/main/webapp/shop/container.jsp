<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<!-- category -->
                        <nav class="category">
                            <h3 class="category-heading">
                                <i class="category-heading-icon fas fa-list-ul"></i>
                                Bộ lọc tìm kiếm
                            </h3>
                            <div class="category-group">
                                <div class="category-group-title">Theo Danh Mục</div>
                                <ul class="category-group-list">
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Thiết bị mạng
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Chuột và bàn phím
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        USB
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Link kiện máy tính
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Wifi
                                    </li>
                                </ul>
                            </div>
                            <div class="category-group">
                                <div class="category-group-title">Nơi Bán</div>
                                <ul class="category-group-list">
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Hà Nội
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Hồ Chí Minh
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Đà Nẵng
                                    </li>
                                </ul>
                            </div>
                            <div class="category-group">
                                <div class="category-group-title">Đơn Vị Vận Chuyển</div>
                                <ul class="category-group-list">
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Hoả tốc
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Nhanh
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Tiết kiệm
                                    </li>
                                </ul>
                            </div>
                            <div class="category-group">
                                <div class="category-group-title">Thương Hiệu</div>
                                <ul class="category-group-list">
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Kingston
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Sandisk
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Seagate
                                    </li>
                                </ul>
                            </div>
                            <div class="category-group">
                                <div class="category-group-title">Khoảng Giá</div>
                                <div class="category-group-filter">
                                    <input type="number" placeholder="đ TỪ" class="category-group-filter-input">
                                    <i class="fas fa-arrow-right"></i>
                                    <input type="number" placeholder="đ ĐẾN" class="category-group-filter-input">
                                </div>
                                <button class="btn btn--primary category-group-filter-btn">Áp dụng</button>
                            </div>
                            <div class="category-group">
                                <div class="category-group-title">Loại Shop</div>
                                <ul class="category-group-list">
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Shoppee
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Shoppee Mail
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Shop yêu thích
                                    </li>
                                </ul>
                            </div>
                            <div class="category-group">
                                <div class="category-group-title">Tình Trạng</div>
                                <ul class="category-group-list">
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Mới
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Đã sử dụng
                                    </li>
                                </ul>
                            </div>
                            <div class="category-group">
                                <div class="category-group-title">Lựa Chọn Thanh Toán</div>
                                <ul class="category-group-list">
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Thanh toán khi nhận hàng
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Chuyển khoản
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Trả góp 0%
                                    </li>
                                </ul>
                            </div>
                            <div class="category-group">
                                <div class="category-group-title">Đánh Giá</div>
                                <div class="rating-star">
                                    <input type="checkbox" class="category-group-item-check">
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                </div>
                                <div class="rating-star">
                                    <input type="checkbox" class="category-group-item-check">
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                </div>
                                <div class="rating-star">
                                    <input type="checkbox" class="category-group-item-check">
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                </div>
                                <div class="rating-star">
                                    <input type="checkbox" class="category-group-item-check">
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                </div>
                                <div class="rating-star">
                                    <input type="checkbox" class="category-group-item-check">
                                    <i class="star-checked far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                    <i class="star-uncheck far fa-star"></i>
                                </div>
                            </div>
                            <div class="category-group">
                                <div class="category-group-title">Dịch Vụ & Khuyến Mãi</div>
                                <ul class="category-group-list">
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Freeship Xtra
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Hoàn xu Xtra
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Đang giảm giá
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Miễn phí vận chuyển
                                    </li>
                                    <li class="category-group-item">
                                        <input type="checkbox" class="category-group-item-check">
                                        Gì cũng rẻ
                                    </li> 
                                </ul>
                            </div>
                            <button class="btn btn--primary category-group-filter-btn category-group--margin">LÀM MỚI</button>
                        </nav>