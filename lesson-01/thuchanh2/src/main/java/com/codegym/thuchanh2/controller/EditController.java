package com.codegym.thuchanh2.controller;

import com.codegym.thuchanh2.model.entity.Customer;
import com.codegym.thuchanh2.model.service.CustomerService;
import com.codegym.thuchanh2.model.service.impl.SimpleCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditController", urlPatterns = "/edit")
public class EditController extends HttpServlet {
    @Autowired
    private CustomerService customerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "edit":
                showEditForm(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "save":
                saveCustomer(req, resp);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

        try {
            int id = Integer.parseInt(request.getParameter("customerId"));
            Customer currentCustomer = customerService.findCustomer(id);
            request.setAttribute("customer", currentCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/customers/info.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        customerService.update(id, name, email, address);

        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
