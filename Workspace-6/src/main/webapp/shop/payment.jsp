<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopee</title>
    <link rel="icon" href="${root}assets/img/logo/shopee-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="${root}assets/css/base.css">
    <link rel="stylesheet" href="${root}assets/css/style.css">
    <link rel="stylesheet" href="${root}assets/css/grid.css">
    <link rel="stylesheet" href="${root}assets/css/responsive.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	        crossorigin="anonymous"></script>
	<link href="${root}assets/css/4.css" rel="stylesheet" />
</head>
<body>
	<div class="app">
		<jsp:include page="./header.jsp"/>
		<div class="container py-4 my-4 mx-auto d-flex flex-column">
			<div class="khungThanhToan" style="background-color:white">
		        <form action="PaymentControl" method="get">
		            <section>
		                <div class="khung"">
		                    <div class="khung1_1">
		                        <div class="khung1_1_1">
		                            <div class="tieude_TT">
		                                <h3>Thông tin nhận hàng</h3>
		                                <div class="exit_TT">
		                                    <ion-icon name="arrow-forward-outline" role="img" class="md hydrated" aria-label="arrow forward outline"></ion-icon>
		                                    <a href="<c:url value='/home'/>">Back</a>
		                                </div>
		                            </div>
		                            <div class="khungDienTT">
		                            	<input type="hidden" value="${sessionScope.user.getUserId()}" id="UserId" name="UserId">
		                            	<input type="hidden" value="${id}" id="ProductId" name="ProductId">
		                            	<input type="hidden" value="${storeId}" id="StoreId" name="StoreId">
		                            	<input type="hidden" value="${quantity}" id="Count" name="Count">
		                            	<input type="hidden" value="${total}" id="Total" name="Total">
		                                <label>Họ Tên Người Nhận</label><br>
		                                <input class="form-control" type="text" placeholder="Họ và tên" value="${sessionScope.user.getUserName()}" id="Name" name="name"><br>
		                                <label>SDT Người Nhận</label><br>
		                                <input class="form-control" type="text" placeholder="Số điện thoại" value="${sessionScope.user.getPhone()}" id="Phone" name="Phone"><br>
		                                <label>Email</label><br>
		                                <input class="form-control" type="text" placeholder="Email" value="${sessionScope.user.getEmail()}" id="Email" name="Email"><br>
		                                <label>Địa chỉ Người Nhận</label><br>
		                                <input class="form-control" type="text" placeholder="Địa chỉ" value="${sessionScope.user.getAddress()}" id="Address" name="Address">
										<div><br><br></div>
		                            </div>
		                        </div>
		                        <div class="khung1_1_2">
		                            <div class="VanChuyen">
		                                <h3>Cách vận chuyển</h3>
		                                <div class="CachThucVanChuyen">
		                                    <input type="radio" id="VCh" name="fav_vanchuyen" value="CachVanChuyen">
		                                    <label for="VCh">Giao hàng tận nơi</label>
		                                </div>
		                            </div>
		                            <div class="KThanhToan">
		                                <h3>Cách thức thanh toán</h3>
		                                <div class="CachThucThanhToan">
		                                    <input type="radio" id="tt_tien" name="fav_thanhtoan" value="TT_TienMat">
		                                    <label for="tt_tien">Thanh toán khi nhận hàng</label><br>
		
		                                </div>
		                            </div>
		                        </div>
		                        <div class="khung1_1_3">
		                        	<div class="tongDonHang">
			                            <h3>Đơn hàng</h3>
			                        </div>
			                        <div class="sanphamtrongDonHang">
			                            <div class="sp_1">
			                                <img onerror="this.src='${root}${product.getImage()}'" src="${root}${product.getImage()}" style="border-radius: 5px 2px;" height="50" width="50">
			                                &nbsp;&nbsp;&nbsp;
			                                <div>	
			                                	<p>${product.getProductName()}</p>
			                                </div>
			                                <a><ion-icon name="close-outline" role="img" class="md hydrated" aria-label="close outline"></ion-icon></a>
			                            </div>
			                        </div>
			                        <div class="tinhTien">
			                            <div class="tongTienSp">
			                                <p class="ten_phi">Giá: ${product.getPromotionalPrice()}<sup>đ</sup></p>
			                                <p class="phi">SL: ${quantity}</p>
			                            </div>
			                        </div>
			                        <div class="TongTien">
			                            <div class="Hang_chot_tien">
			                                <p class="gia_cuoi">Tổng cộng</p>
			                                <p class="phi">${total}<sup>đ</sup></p>
			                            </div>
			                            
			                            	<div class="khung1_2_5_2">
			                            	<button type="submit" style="background-color:red; color:white">Đặt hàng</button>
			                            	</div>
			                            

			                        </div>
			                    </div>
			                </div>
			        	</div>
		            </section>
		        </form>
		    </div>
		</div>
		<%@include file="./footer.jsp" %>
	</div>
</body>
</html>