package Control;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Model.Category;
import Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "AdAddProduct", value = "/seller/AdAddProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class AdAddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        CategoryDAO ca = new CategoryDAO();

        List<Category> listc = ca.getAllCategory();
        
        request.setAttribute("listc", listc);
        request.setAttribute("size", listc.size());
        request.getRequestDispatcher("./admin_addproduct.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("tensanpham");
        String decrip = request.getParameter("motasanpham");
        int proprice = Integer.parseInt(request.getParameter("inprice"));

        int price = Integer.parseInt(request.getParameter("price"));
        int sale = Integer.parseInt(request.getParameter("sale"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryid = Integer.parseInt(request.getParameter("maDM"));
        String oldImage = request.getParameter("oldImage");
        String images;


        // get images
        Collection<Part> fileParts = request.getParts();
        int index = 0;
        for (int i = index; i < fileParts.size(); i++) {
            Part part = (Part) fileParts.toArray()[i];
            if (!part.getName().equals("multiPartServlet") || part.getSubmittedFileName() == null || part.getSubmittedFileName().equals("")) {
                System.out.println(part.getName());
                fileParts.remove(part);
                i = index - 1;
            }
        }

        // create a folder containing images
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HHmmss");

        String formattedDate = myDateObj.format(myFormatObj);

        String path = "assets" + "/" + "img" + "/" + "home";
        List<String> image = new ArrayList<>();
        if (!fileParts.isEmpty()) {

            String realPath = request.getServletContext().getRealPath("/" + path);
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectories(Paths.get(realPath));
            } // tao folder

            for (Part part : fileParts) {
//                String fileName = part.getSubmittedFileName();
                String filename
                        = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                part.write(realPath + "/" + filename);
                image.add(path + "/" + filename);
            }
            images = image.get(0);
        } else {
            images = oldImage;
            if(oldImage.equals(""))
            {
                images = "assets/img/images/emptyImage.png";
            }
        }
        ProductDAO product = new ProductDAO();
        product.addProduct(name, decrip, price, sale, proprice, quantity, images, categoryid, 2, 1);
        response.sendRedirect("AdAddProduct");
    }

}
