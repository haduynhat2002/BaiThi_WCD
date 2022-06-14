package com.example.thiwcd.controller;

import com.example.thiwcd.entity.Phone;
import com.example.thiwcd.model.MySqlPhoneModel;
import com.example.thiwcd.model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreatePhoneServlet extends HttpServlet {
    private PhoneModel phoneModel;

    public CreatePhoneServlet() {
        this.phoneModel = new MySqlPhoneModel();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addphone.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            String name = req.getParameter("name");
            String brand = req.getParameter("brand");
            double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");
            Phone phone = Phone.PhoneBuilder.aPhone()
                    .name(name)
                    .brand(brand)
                    .price(price)
                    .description(description)
                    .build();
            if (phone.isValid()) {
                boolean result = phoneModel.save(phone);
                if (result) {
                    resp.sendRedirect("/listphone");
                } else {
                    throw new Exception("Can save product");
                }
            } else {
                req.setAttribute("errors", phone.getErrors());
                req.setAttribute("category", phone);
                req.getRequestDispatcher("/admin/product/list.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            req.getRequestDispatcher("/admin/error/500.jsp").forward(req, resp);
        }
    }
}
