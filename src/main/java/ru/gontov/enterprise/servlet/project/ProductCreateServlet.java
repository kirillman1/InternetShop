package ru.gontov.enterprise.servlet.project;

import ru.gontov.enterprise.dao.ProductDAO;
import ru.gontov.enterprise.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product-create")
public class ProductCreateServlet extends HttpServlet {

    @Inject
    private ProductDAO productDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productDAO.merge(new Product());
        resp.sendRedirect("product-list");
    }

}
