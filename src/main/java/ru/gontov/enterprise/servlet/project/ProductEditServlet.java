package ru.gontov.enterprise.servlet.project;

import ru.gontov.enterprise.dao.ProductDAO;
import ru.gontov.enterprise.entity.Product;
import ru.gontov.enterprise.constant.FieldConst;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product-edit")
public class ProductEditServlet extends HttpServlet {

    @Inject
    private ProductDAO productDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String productId = req.getParameter(FieldConst.ID);
        final Product product = productDAO.getProductById(productId);
        if (product == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        req.setAttribute(FieldConst.PRODUCT, product);
        req.getRequestDispatcher("WEB-INF/views/product-edit.jsp").forward(req, resp);
    }

}
