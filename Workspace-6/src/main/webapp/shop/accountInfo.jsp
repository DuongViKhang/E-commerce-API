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
  
<link rel="icon" href="${root}assets/img/logo/shopee-logo.png" type="image/x-icon">
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${root}plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="${root}plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${root}plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="${root}plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${root}dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="${root}plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="${root}plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="${root}plugins/summernote/summernote-bs4.min.css">
  
  
  
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
	<jsp:include page="./header.jsp"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Thông tin tài khoản</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="http://localhost:8080/Shopee/home">Trở lại</a></li>
              <li class="breadcrumb-item active">Thông tin tài khoản</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
	
	<section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Thông tin tài khoản</h3>
              </div>
              <!-- /.card-header -->
              <form method="post">
	              <div class="card-body">
	              	  <input type="hidden" class="form-control" name="id" value="${user.getUserId()}">
	              	  <div class="form-group" style="width: 40%">
	                    <label for="exampleInputEmail1">Họ tên</label>
	                    <input type="text" class="form-control" name="username" placeholder="Enter username" value="${user.getUserName()}">
	                  </div>
	                  <div class="form-group" style="width: 40%">
	                    <label for="exampleInputEmail1">ID</label>
	                    <input type="text" class="form-control" name="idCard" placeholder="Enter ID card" value="${user.getIdCard()}">
	                  </div>
	                  <div class="form-group" style="width: 40%">
	                    <label for="exampleInputEmail1">Email</label>
	                    <input type="text" class="form-control" name="email" placeholder="Enter email" value="${user.getEmail()}">
	                  </div>
	              	  <div class="form-group" style="width: 40%">
	                    <label for="exampleInputEmail1">Số điện thoại</label>
	                    <input type="text" class="form-control" name="phone" placeholder="Enter phone number" value="${user.getPhone()}">
	                  </div>
	                  <input type="hidden" class="form-control" name="isEmailActive" value="${user.getIsEmailActive()}">
	                  <input type="hidden" class="form-control" name="password" value="${user.getPassword()}">
	                  <div class="form-group" style="width: 40%">
	                    <label for="exampleInputPassword1">Địa chỉ</label>
	                    <input type="text" class="form-control" name="address" placeholder="Enter address" value="${user.getAddress()}">
	                  </div>
	                  <div class="form-group" style="width: 40%">
	                    <label for="avatar">Ảnh đại diện</label>
                    	<div class="input-group">
                          <div class="custom-file">
                        	<input type="file" id="avatar" name="avatar" value="${user.getAvatar()}">
                          </div>
                      	</div>
	                  </div>
	                  <input type="hidden" class="form-control" name="date" value="${user.getDate()}">
	                  <input type="hidden" class="form-control" name="isDeleted" value="${user.getIsDeleted()}">
	        	  </div>
	              <!-- /.card-body --> 
	              <div class="card-footer">
	                  <button type="submit" class="btn btn-success" style="width: 10%"><b>Update</b></button>
	              </div> 
              </form>
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
  <jsp:include page="./footer.jsp"/>
</div>
<!-- ./wrapper -->
<!-- jQuery -->
<script src="${root}plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${root}plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="${root}plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="${root}plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="${root}plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="${root}plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="${root}plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="${root}plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="${root}plugins/moment/moment.min.js"></script>
<script src="${root}plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="${root}plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="${root}plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="${root}plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${root}dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${root}dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="${root}dist/js/pages/dashboard.js"></script>
</body>
</html>