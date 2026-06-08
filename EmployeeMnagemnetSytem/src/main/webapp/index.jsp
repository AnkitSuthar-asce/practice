<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ems.EmployeeServlet.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
    <link rel="stylesheet" href="https://jsdelivr.net">
</head>
<body class="container mt-5">

    <%
        Employee editEmp = (Employee) request.getAttribute("employeeToEdit");
        boolean isEdit = (editEmp != null);
    %>

    <div class="row">
        <div class="col-md-4">
            <h3><%= isEdit ? "Update Employee" : "Add New Employee" %></h3>
            <form action="employees" method="post" class="card p-3 shadow-sm">
                <% if(isEdit) { %>
                    <input type="hidden" name="id" value="<%= editEmp.getId() %>">
                <% } %>
                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" value="<%= isEdit ? editEmp.getName() : "" %>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" value="<%= isEdit ? editEmp.getEmail() : "" %>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Designation</label>
                    <input type="text" name="designation" class="form-control" value="<%= isEdit ? editEmp.getDesignation() : "" %>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Salary</label>
                    <input type="number" name="salary" step="0.01" class="form-control" value="<%= isEdit ? editEmp.getSalary() : "" %>" required>
                </div>
                <button type="submit" class="btn <%= isEdit ? "btn-warning" : "btn-success" %> w-100">
                    <%= isEdit ? "Update Details" : "Save Employee" %>
                </button>
                <% if(isEdit) { %>
                    <a href="employees" class="btn btn-secondary w-100 mt-2">Cancel</a>
                <% } %>
            </form>
        </div>

        <div class="col-md-8">
            <h3>Employee Database</h3>
            <table class="table table-bordered table-striped mt-3">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th><th>Name</th><th>Email</th><th>Role</th><th>Salary</th><th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        @SuppressWarnings("unchecked")
                        List<Employee> employees = (List<Employee>) request.getAttribute("employeeList");
                        if (employees != null) {
                            for (Employee emp : employees) {
                    %>
                    <tr>
                        <td><%= emp.getId() %></td>
                        <td><%= emp.getName() %></td>
                        <td><%= emp.getEmail() %></td>
                        <td><%= emp.getDesignation() %></td>
                        <td>$<%= String.format("%.2f", emp.getSalary()) %></td>
                        <td>
                            <a href="employees?action=edit&id=<%= emp.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                            <a href="employees?action=delete&id=<%= emp.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Delete this record?');">Delete</a>
                        </td>
                    </tr>
                    <% 
                            }
                        } 
                    %>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
