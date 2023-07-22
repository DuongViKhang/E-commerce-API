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
     <link href="${root}assets/css/2.css" rel="stylesheet" />
     <link href="${root}assets/css/3.css" rel="stylesheet" />
</head>
<body>
	<div class="app">
		<jsp:include page="./header.jsp"/>
		<div class="container py-4 my-4 mx-auto d-flex flex-column">
		    <div class="section">
			    <div class="anh_sp">
                    <img onerror="this.src='${root}${product.getImage()}'" src="${root}${product.getImage()}" width="300">
			    </div>
			    <form method="post">
				    <div class="thongtin">
				        <div class="name">
				            <h1 style="font-size:40px">${product.getProductName()}</h1>
				        </div>
				        <span class="thuonghieu1">
				            <h1 style="font-size:20px"><b>Cửa hàng: ${store}</b></p>
				            <input type="hidden" name="id" value="${product.getProductId()}" style="width:5%">
				        </span>
				        <div class="gia"><p id="gia">Giá: ${product.getPromotionalPrice()}đ</p></div>
				        <div class="nhapdulieu">
				                <div class="soluong">
				                    <b>Số lượng: <input id="quantity" name="quantity" type="number" min="1" value="1"></b>
				                </div>
				        </div>
				        <br />
				        <c:if test="${sessionScope.user != null}">
				        	<div class="themgiohang">
	                    		<button style="background-color:red; color:white" type="submit" name="action" value="Mua">Mua</button>
				        	</div>
				        	<div class="themgiohang">
	                    		<button style="background-color:blue; color:white" type="submit" name="action" value="Đặt hàng">Đặt hàng</button>
				        	</div>
				        </c:if>
				        <c:if test="${sessionScope.user == null}">
				        	<div class="themgiohang">
	                    		<button style="background-color:red; color:white" onclick="location.href='http://localhost:8080/Shopee/shop/login'" type="button">Mua</button>
				        	</div>
				        	<div class="themgiohang">
	                    		<button style="background-color:blue; color:white" onclick="location.href='http://localhost:8080/Shopee/shop/login'" type="button">Đặt hàng</button>
				        	</div>
				        </c:if>
				        <%-- <c:if test="${sessionScope.user == null}">
				        	<div class="themgiohang" style="background-color:red; color:white;height: 36px;width: 146px;text-align: center;">
	                    		<a style="background-color:red; color:white;height: 36px;width: 146px;" href="http://localhost:8080/Shopee/shop/login">Mua</a>
				        	</div>
				        </c:if> --%>
				        <div class="mota">
				        	<h3>Mô tả</h3>${product.getDecription()}
				        </div>
				    </div>
		    	</form>
			</div>
		</div>
		<%@include file="./footer.jsp" %>
	</div>
</body>
</html>