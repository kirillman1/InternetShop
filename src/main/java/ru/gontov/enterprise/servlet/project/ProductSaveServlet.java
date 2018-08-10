package ru.gontov.enterprise.servlet.project;

import ru.gontov.enterprise.dao.ProductDAO;
import ru.gontov.enterprise.constant.FieldConst;
import ru.gontov.enterprise.entity.Product;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product-save")
public class ProductSaveServlet extends HttpServlet {

    @Inject
    private ProductDAO productDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter(FieldConst.ID);
        if (id == null || id.isEmpty()) {
            sendRedirectProductList(resp);
            return;
        }
        final Product product = productDAO.getProductById(id);
        if (product == null) {
            sendRedirectProductList(resp);
            return;
        }
        product.setName(req.getParameter(FieldConst.NAME));
        product.setDescription(req.getParameter(FieldConst.DESCRIPTION));
        productDAO.merge(product);
        sendRedirectProductList(resp);
    }

    private void sendRedirectProductList(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("product-list");
    }

}
