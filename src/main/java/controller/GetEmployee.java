package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitys.*;
import service.EmpService;

@WebServlet("/getemployee")
public class GetEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpService empService = new EmpService();
        PrintWriter pr = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id")); // Get ID from the form
        
        Employe employe = empService.fetchById(id); // Fetch employee by ID
        
        pr.print("<!DOCTYPE html>\r\n"
                + "<html lang=\"en\">\r\n"
                + "<head>\r\n"
                + "    <meta charset=\"UTF-8\">\r\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + "    <title>Employee Details</title>\r\n"
                + "    <style>\r\n"
                + "        body {\r\n"
                + "            font-family: Arial, sans-serif;\r\n"
                + "            background-color: #f4f4f4;\r\n"
                + "            display: flex;\r\n"
                + "            justify-content: center;\r\n"
                + "            align-items: center;\r\n"
                + "            height: 100vh;\r\n"
                + "            margin: 0;\r\n"
                + "        }\r\n"
                + "        .container {\r\n"
                + "            background-color: #fff;\r\n"
                + "            padding: 20px;\r\n"
                + "            border-radius: 10px;\r\n"
                + "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
                + "        }\r\n"
                + "    </style>\r\n"
                + "</head>\r\n"
                + "<body>\r\n"
                + "    <div class=\"container\">\r\n");

        if (employe != null) {
            pr.print("<h2>Employee Details</h2>\r\n"
                    + "<p><strong>ID:</strong> " + employe.getId() + "</p>\r\n"
                    + "<p><strong>Name:</strong> " + employe.getName() + "</p>\r\n"
                    + "<p><strong>Age:</strong> " + employe.getAge() + "</p>\r\n"
                    + "<p><strong>Email:</strong> " + employe.getEmailid() + "</p>\r\n"
                    + "<p><strong>Salary:</strong> " + employe.getSalary() + "</p>\r\n");
        } else {
            pr.print("<h2>No Employee Found with ID: " + id + "</h2>\r\n");
        }

        pr.print("    </div>\r\n"
                + "</body>\r\n"
                + "</html>");
    }
}
