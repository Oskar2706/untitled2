package by.tms.web;

import by.tms.entity.Operation;
import by.tms.service.CalculatorService;
import by.tms.storage.JDBCOperationStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showhistory")
public class AllOperationServlet extends HttpServlet {
    CalculatorService calculatorService = new CalculatorService();
    JDBCOperationStorage jdbcOperationStorage=new JDBCOperationStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Operation operation:jdbcOperationStorage.showAllStory()) {
            resp.getWriter().println(operation);
        }

    }
}
