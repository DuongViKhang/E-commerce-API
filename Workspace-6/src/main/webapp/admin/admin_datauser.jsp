<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Account Manager</title>
<link rel="icon" href="${root}assets/img/logo/shopee-logo.png" type="image/x-icon">
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${root}plugins/fontawesome-free/css/all.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="${root}plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="${root}plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="${root}plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${root}dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- header -->
  <jsp:include page="./adminheader.jsp"/>
  <!-- header -->
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Account Manager</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="http://localhost:8080/Shopee/admin">Home</a></li>
              <li class="breadcrumb-item active">Account Manager</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <!-- <div class="card">
              <div class="card-header">
                <h3 class="card-title">DataTable with minimal features & hover style</h3>
              </div>
              /.card-header
              <div class="card-body">
                <table id="example2" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>Rendering engine</th>
                    <th>Browser</th>
                    <th>Platform(s)</th>
                    <th>Engine version</th>
                    <th>CSS grade</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>Trident</td>
                    <td>Internet
                      Explorer 4.0
                    </td>
                    <td>Win 95+</td>
                    <td> 4</td>
                    <td>X</td>
                  </tr>
                  </tbody>
                  <tfoot> </tfoot>
                </table>
              </div>
              /.card-body
            </div>
            /.card -->

            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Account Information</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>User Id</th>
                    <th>User Name</th>
                    <th>Card ID</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Role ID</th>
                    <th>Address</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="i" begin="0" end="${size-1}">
                      <tr>
                      	  <td>${listu[i].getUserId()}</td>
                      	  <td>${listu[i].getUserName()}</td>
                          <td>${listu[i].getIdCard()}</td>
                          <td>${listu[i].getEmail()}</td>
                          <td>${listu[i].getPhone()}</td>
                          <td>
                          <c:choose>
	                          	<c:when test="${listu[i].getRoleId() == 1}">${listr[0].getRoleName()}</c:when>
	                          	<c:when test="${listu[i].getRoleId() == 2}">${listr[1].getRoleName()}</c:when>
	                          	<c:when test="${listu[i].getRoleId() == 3}">${listr[2].getRoleName()}</c:when>
	                      </c:choose>
	                      </td>
                          <td>${listu[i].getAddress()}</td>
                      </tr>
                  </c:forEach>
                  </tbody>
                  <tfoot></tfoot>
                </table>
              </div>
              <!-- /.card-body -->
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

	<!-- footer -->
 <jsp:include page="./adminfooter.jsp"/>
	<!-- footer -->
	
  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${root}plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${root}plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables  & Plugins -->
<script src="${root}plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${root}plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${root}plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${root}plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="${root}plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="${root}plugins/jszip/jszip.min.js"></script>
<script src="${root}plugins/pdfmake/pdfmake.min.js"></script>
<script src="${root}plugins/pdfmake/vfs_fonts.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="${root}dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${root}dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>
</body>
</html>
