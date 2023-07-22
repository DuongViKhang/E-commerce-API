<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopee Seller</title>
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
	<jsp:include page="./headerlogin.jsp"/>
	<div style="background-color: rgb(238, 77, 45);">
		<div class="login__center">
			<div class="login__space">
				<div class="space"></div>
				<div>
					<form action="sellerlogin" method="post" id="form-1">
						<div class="login__form">
							<div class="form__header">
								<div class="form__header__title">Đăng Nhập</div>
							</div>
							<div class="form__body">
								<div></div>
								<div class = "username">
									<div class="username__zone">
										<input class = "user__input" type="text" placeholder="Email/Số điện thoại.." autocomplete="on" name = "username" maxlength="128" value>
									</div>
									<div class = "form-message">${mess}</div>
								</div>
								<div class ="password">
									<div class="username__zone">
										<input class = "user__input" type="password" placeholder="Mật khẩu.." autocomplete="current-password" name = "password" maxlength="16" value>
									</div>
									<div class = "form-message">${mess}</div>
								</div>
								<button class="login__btn">ĐĂNG NHẬP</button>
								<div class="infor">
									<a class="forget" href="#">Quên mật khẩu?</a>
								</div>
								<div class="login__network">
									<div class="or">
										<div class="line"></div>
										<span class = "title__or">Hoặc</span>
										<div class="line"></div>
									</div>
									<div class="network">
										<button class = "network__btn">
											<div class="icon social-white-background social-white-fb-blue-png"></div>
											<div>Facebook</div>
										</button>
										<button class = "network__btn">
											<div>Google</div>
										</button>
									</div>
								</div>
							</div>
							<div class="form__footer">
								<div class="form__footer__link">Bạn mới biết đến Shopee? <a class = "link__btn" href="#">Đăng ký</a></div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="./footer.jsp" %>
</div>
</body>
</html>