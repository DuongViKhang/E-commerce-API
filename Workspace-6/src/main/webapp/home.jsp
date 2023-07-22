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
</head>
<body>
	<div class="app">
		<jsp:include page="./shop/header.jsp"/>
		<!-- container -->
        <div class="container">
            <div class="grid wide">
                <div class="row sm-gutter">
                    <div class="col l-2 m-0 c-0">
                    	<jsp:include page="./shop/container.jsp"/>
                    </div>
                    <div class="col l-10 m-12 c-12">
                    	<jsp:include page="./shop/homefilter.jsp"/>
                    	<jsp:include page="./shop/homeproduct.jsp"/>
                    	<!-- pagination -->
                        <ul class="pagination home-product-pagination">
                            <c:forEach begin="1" end="${numberPage}" var="i">
		                        <li class="pagination-item">
                                	<a href="<c:url value='/home?index=${i}'/>" class="pagination-item-link">${i}</a>
                            	</li>
			                 </c:forEach>
                        </ul>
                    </div>
                 </div>
             </div>
		<%@include file="./shop/footer.jsp" %>
	</div>
	</div>
	<!-- script js -->
</body>
</html>