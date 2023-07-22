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
     
     
</head>
<body>
	<div class="app">
		<jsp:include page="./header.jsp"/>
		<div class="container my-3">
	        <div class="row">
	            <div class="col-md-12 col-lg-12">
	                <div class="category-title position-relative">
	                    <h2 class="text-center">Giỏ hàng</h2>
	                </div>
	                <table class="table table-bordered">
	                		<c:if test="${sizec >= 0}">
			                    <thead>
			                        <tr>
			                            <th>Ảnh</th>
			                            <th> Tên sản phẩm</th>
			                            <th>Đơn giá</th>
			                            <th>Số lượng</th>
			                            <th>Thành tiền</th>
			                            <th></th>
			
			                        </tr>
			                    </thead>
	                    		<tbody>
			                    	<c:forEach begin="0" end="${sizec}" var="i">
				                        <tr>
				                            <td><img src="${root}${listp[i].getImage()}" width="50px" height="50" alt=""></td>
				                            <td>${listp[i].getProductName()}</td>
				                            <td>${listp[i].getPromotionalPrice()}đ</td>
				                            <td>${list[i].getCount()}</td>
				                            <td>${total[i]}đ</td>
				                            <td><a href="http://localhost:8080/Shopee/DeleteCartItem?cartId=${list[i].getCartItemId()}">Xóa</a></td>
				                        </tr>
			                        </c:forEach>
			                        <tr>
			                            <td colspan="2"><h2><br>Tổng: ${totalCart}đ</h2></td>
			                            <td colspan="5">
			                            	<br>
			                                <a href="<c:url value='http://localhost:8080/Shopee/CartPaymentControl'/>"><button class="btn btn-primary"><b>Thanh Toán</b></button></a>
			                            </td>
			                        </tr>
		                        </tbody>
		                	</c:if>
		                    <c:if test="${sizec < 0}">
		                		<tbody>
			                		<tr>
				                    	<br><br>
				                    	<h2>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				                    	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				                    	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Chưa có đơn hàng</h2>
				                    </tr>
		                        </tbody>
		                	</c:if> 
	                </table>
	            </div>
	        </div>
	        <div class="col-md-4"> </div>
    	</div>
		<%@include file="./footer.jsp" %>
	</div>
</body>
</html>