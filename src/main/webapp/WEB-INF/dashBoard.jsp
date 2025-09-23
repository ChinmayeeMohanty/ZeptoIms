<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background: #f9f9f9; }
        h2 { background: #333; color: #fff; padding: 10px; }
        .stats { margin: 15px 0; padding: 10px; background: #eee; border-radius: 6px; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; background: #fff; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background: #444; color: #fff; }
        tr:nth-child(even) { background: #f2f2f2; }
        .section { margin-bottom: 25px; }
    </style>
</head>
<body>

    <h2>Admin Dashboard</h2>

    <div class="stats">
        <p><strong>Total Products:</strong> ${totalProducts}</p>
        <p><strong>Total Users:</strong> ${users.size()}</p>
    </div>

    <div class="section">
        <h3>Product List</h3>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Stock</th>
                    <th>Price (₹)</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${products}">
                    <tr>
                        <td>${p.productId}</td>
                        <td>${p.productName}</td>
                        <td>${p.category}</td>
                        <td>${p.stocks}</td>
                        <td>${p.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="section">
        <h3>User List</h3>
        <table>
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Enabled</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${users}">
                    <tr>
                        <td>${u.userId}</td>
                        <td>${u.userName}</td>
                        <td>${u.emailId}</td>
                        <td>${u.mobileNo}</td>
                        <td>${u.enabled}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
