<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Add Product</title>
  <link rel="icon" href="${root}assets/img/logo/shopee-logo.png" type="image/x-icon">
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${root}plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${root}dist/css/adminlte.min.css">
  <script src="https://cdn.tiny.cloud/1/t26dur1jotikorfbmwaw0pijqo7c5jlb4qy2cs3yu2rx43al/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- header -->
  <jsp:include page="./sellerheader.jsp"/>
  <!-- header -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
<%--            <h1>${title}</h1>--%>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="../../admin.jsp">Home</a></li>
<%--              <li class="breadcrumb-item active">${title}</li>--%>
            </ol>
          </div>
        </div>
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- Main content -->
    <section class="content">
      <%--  <form method="get" action="Ad_AddProductControl" id="LoaiSPFrom">
           <div class="form-group">
               <label >Danh mục cha</label>
               <select id="mySelect" onchange="myFunction()" class="form-control select2 select2-hidden-accessible"
                       style="width: 100%;" data-select2-id="1" tabindex="-1" aria-hidden="true" name="maLoai">
                   <c:forEach items="${listLoaiSP}" var="l">
                       <option value="${l.maLoai}" ${l.maLoai == maLoai ? 'selected' : ''}>${l.tenLoai}</option>
                   </c:forEach>
               </select>
           </div>
       </form> --%>
      <form method="post" action="AdAddProduct?action=${action}" id="AddProductForm"
            enctype="multipart/form-data">
        <input type="hidden" name="maLoai">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card card-primary">
                <div class="card-header">
                  <h3 class="card-title">Thông tin sản phẩm</h3>
                </div>
                <!-- /.card-header -->
                <!-- form start -->
                <%--                <form>--%>
                <div class="card-body">
                  <div class="form-group">
                    <label>Tên sản phẩm</label>
                    <input type="text" class="form-control" placeholder="Enter name"
                           name="tensanpham" >
                  </div>
                  <div class="form-group">
                    <label>Mô tả ngắn</label>
                    <textarea class="form-control tiny" placeholder="Enter ..."
                              name="motasanpham"></textarea>
                  </div>
                  <script type="text/javascript">
                    tinymce.init({
                      entity_encoding: "raw"
                    });
                  </script>
                  <div class="form-group">
                    <label>Giá gốc</label>
                    <input type="number" min="0" max="100000000000" step="1" class="form-control"
                           name="inprice"/>
                  </div>
                  <div class="form-group">
                    <label>Giá bán thường</label>
                    <input type="number" min="0" max="100000000000" step="1" class="form-control"
                           name="price" />
                  </div>
                  <div class="form-group">
                    <label>Giá khuyến mãi</label>
                    <input type="number" min="0" max="100000000000" step="1" class="form-control"
                           name="sale" />
                  </div>
                  <div class="form-group">
                    <label>Số lượng</label>
                    <input type="number" class="form-control" name="quantity"
                           />
                  </div>
                  <div class="form-group">
                    <label>Ảnh sản phẩm</label>
                    <%--                      <form action="/action_page.php">--%>
                    <form>
                      <input type="hidden" name="oldImage">
                      <input type="file" name="multiPartServlet" multiple="multiple"/>
                      <%--                                            <input type="file" name="image"/><br><br>--%>
                    </form>
                  </div>
                  <div class="form-group">
                    <label>Danh mục</label>
                    <select class="form-control select2 select2-hidden-accessible"
                            style="width: 100%;" data-select2-id="1" tabindex="-1"
                            aria-hidden="true" name="maDM">
                      <c:forEach var="o" items="${listc}">
                        <option value="${o.categoryId}" >${o.categoryName}</option>
                      </c:forEach>
                    </select>
                  </div>
<%--                  <input type="hidden" value="${sanPham.maSP}" name="maSP"/>--%>
                </div>
                <div class="card-footer">
                  <button type="submit" form="AddProductForm" class="btn btn-primary">Submit</button>
                </div>
                <!-- /.card-body -->
                <%--                  <div class="card-footer">--%>
                <%--                    <button type="submit" class="btn btn-primary">Submit</button>--%>
                <%--                  </div>--%>
                <%--                </form>--%>
              </div>
            </div>
            <!-- begin -->

            <!-- end -->
          </div>
        </div>
      </form>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
    <!-- footer -->
 	<jsp:include page="./sellerfooter.jsp"/>
	<!-- footer -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<script>
    async function uploadFile() {
        let formData = new FormData();
        formData.append("file", ajaxfile.files[0]);
        await fetch('/admin/addproduct', {
            method: "POST",
            body: formData
        });
        alert('The file upload with Ajax and Java was a success!');
    }
</script>
<script>
    $(function () {
        bsCustomFileInput.init();
    });
</script>
<!-- jQuery -->
<script src="${root}plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${root}plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jquery-validation -->
<script src="${root}plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="${root}plugins/jquery-validation/additional-methods.min.js"></script>
<!-- AdminLTE App -->
<script src="${root}dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${root}dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
$(function () {
  $.validator.setDefaults({
    submitHandler: function () {
      alert( "Form successful submitted!" );
    }
  });
  $('#quickForm').validate({
    rules: {
      email: {
        required: true,
        email: true,
      },
      password: {
        required: true,
        minlength: 5
      },
      terms: {
        required: true
      },
    },
    messages: {
      email: {
        required: "Please enter a email address",
        email: "Please enter a valid email address"
      },
      password: {
        required: "Please provide a password",
        minlength: "Your password must be at least 5 characters long"
      },
      terms: "Please accept our terms"
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });
});
</script>
<script>
    tinymce.init({
      selector: 'textarea',
      plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tinycomments tableofcontents footnotes mergetags autocorrect typography inlinecss',
      toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | addcomment showcomments | spellcheckdialog a11ycheck typography | align lineheight | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
      tinycomments_mode: 'embedded',
      tinycomments_author: 'Author name',
      mergetags_list: [
        { value: 'First.Name', title: 'First Name' },
        { value: 'Email', title: 'Email' },
      ]
    });
  </script>
</body>
</html>
