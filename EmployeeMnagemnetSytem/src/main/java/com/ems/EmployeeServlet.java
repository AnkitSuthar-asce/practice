package com.ems;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final EmployeeDAO dao = new EmployeeDAO();

    public static class Employee {
        private int id;
        private String name;
        private String email;
        private String designation;
        private double salary;

        public Employee(int id, String name, String email, String designation, double salary) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.designation = designation;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getDesignation() { return designation; }
        public double getSalary() { return salary; }
    }

    public static class EmployeeDAO {
        final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        final String USER = "system";
        final String PASSWORD = "India12345";

        private Connection getConnection() throws SQLException {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        public List<Employee> getAllEmployees() throws SQLException {
            List<Employee> list = new ArrayList<>();
            String sql = "SELECT id, name, email, designation, salary FROM EMPLOYEES ORDER BY id DESC";
            try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    list.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("designation"), rs.getDouble("salary")));
                }
            }
            return list;
        }

        public Employee getEmployeeById(int id) throws SQLException {
            String sql = "SELECT id, name, email, designation, salary FROM EMPLOYEES WHERE id = ?";
            try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("designation"), rs.getDouble("salary"));
                    }
                }
            }
            return null;
        }

        public void addEmployee(String name, String email, String designation, double salary) throws SQLException {
            String sql = "INSERT INTO EMPLOYEES (name, email, designation, salary) VALUES (?, ?, ?, ?)";
            try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, designation);
                ps.setDouble(4, salary);
                ps.executeUpdate();
            }
        }

        public void updateEmployee(int id, String name, String email, String designation, double salary) throws SQLException {
            String sql = "UPDATE EMPLOYEES SET name = ?, email = ?, designation = ?, salary = ? WHERE id = ?";
            try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, designation);
                ps.setDouble(4, salary);
                ps.setInt(5, id);
                ps.executeUpdate();
            }
        }

        public void deleteEmployee(int id) throws SQLException {
            String sql = "DELETE FROM EMPLOYEES WHERE id = ?";
            try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteEmployee(id);
                response.sendRedirect("employees");
                return;
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Employee existingEmp = dao.getEmployeeById(id);
                request.setAttribute("employeeToEdit", existingEmp);
            }
            
            List<Employee> list = dao.getAllEmployees();
            request.setAttribute("employeeList", list);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String designation = request.getParameter("designation");
            double salary = Double.parseDouble(request.getParameter("salary"));

            if (idStr != null && !idStr.trim().isEmpty()) {
                int id = Integer.parseInt(idStr);
                dao.updateEmployee(id, name, email, designation, salary);
            } else {
                dao.addEmployee(name, email, designation, salary);
            }
            response.sendRedirect("employees");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
