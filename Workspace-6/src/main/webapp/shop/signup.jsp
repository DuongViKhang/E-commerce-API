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
	<jsp:include page="./headersignup.jsp"/>
	<div style="background-color: rgb(238, 77, 45);">
		<div class="login__center">
			<div class="login__space">
				<div class="space"></div>
				<div>
					<form action="signup" method="post" id="form-1">
						<div class="login__form">
							<div class="form__header">
								<div class="form__header__title">Đăng Ký</div>
							</div>
							<div class="form__body">
								<div></div>
								<div class = "username">
									<div class="username__zone">
										<input class = "user__input" type="text" placeholder="Họ tên.." autocomplete="on" name = "username" maxlength="128" value>
									</div>
									<div class = "form-message">${mess}</div>
								</div>
								<div class = "username">
									<div class="username__zone">
										<input class = "user__input" type="text" placeholder="Số điện thoại.." autocomplete="on" name = "phone" maxlength="128" value>
									</div>
									<div class = "form-message">${mess}</div>
								</div>
								<div class = "username">
									<div class="username__zone">
										<input class = "user__input" type="text" placeholder="Email.." autocomplete="on" name = "email" maxlength="128" value>
									</div>
									<div class = "form-message">${mess}</div>
								</div>
								<div class = "username">
									<div class="username__zone">
										<input class = "user__input" type="text" placeholder="Số ID.." autocomplete="on" name = "idCard" maxlength="128" value>
									</div>
									<div class = "form-message">${mess}</div>
								</div>
								<div class ="password">
									<div class="username__zone">
										<input class = "user__input" type="password" placeholder="Mật khẩu.." autocomplete="current-password" name = "password" maxlength="16" value>
									</div>
									<div class = "form-message">${mess}</div>
								</div>
								<button class="login__btn">ĐĂNG KÝ</button>
							</div>
							<div class="form__footer">
								<div class="form__footer__link">Bạn đã có tài khoản? <a class = "link__btn" href="./login.jsp">Đăng nhập</a></div>
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