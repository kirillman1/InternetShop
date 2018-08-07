package ru.gontov.enterprise.servlet.project;

import ru.gontov.enterprise.dao.ProductDAO;
import ru.gontov.enterprise.constant.FieldConst;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product-remove")
public class ProductRemoveServlet extends HttpServlet {

    @Inject
    private ProductDAO productDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String productId = req.getParameter(FieldConst.ID);
        productDAO.removeProductById(productId);
        resp.sendRedirect("product-list");
    }

}
