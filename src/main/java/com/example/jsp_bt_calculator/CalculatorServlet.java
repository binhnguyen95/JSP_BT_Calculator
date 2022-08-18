package com.example.jsp_bt_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculalor", value = "/Calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Float first = Float.parseFloat(req.getParameter("first"));
        Float second = Float.parseFloat(req.getParameter("second"));
        char operator = req.getParameter("Operator").charAt(0);

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        try {
            float result = calculate(first, second, operator);
            writer.println(first + " " + operator + " " + second + " = " + result);
        } catch (Exception ex) {
            writer.println("VCL");
        }
        writer.println("</html>");
    }

    public float calculate(float first, float second, char operator){
        switch (operator){
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                if(second != 0)
                    return first / second;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
