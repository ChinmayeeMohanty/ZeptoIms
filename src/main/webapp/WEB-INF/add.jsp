<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Product</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background: #f9f9f9; }
        h2 { color: #333; }
        form { background: #fff; padding: 20px; border-radius: 6px; width: 350px; box-shadow: 0 0 5px #aaa; }
        label { display: block; margin-top: 10px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; margin-top: 5px; }
        button { margin-top: 15px; padding: 8px 15px; background: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background: #45a049; }
        .msg { margin-bottom: 10px; color: green; }
        .err { margin-bottom: 10px; color: red; }
    </style>
</head>
<body>

<h2>Add Product</h2>

<c:if test="${not empty success}">
    <p class="msg">${success}</p>
</c:if>
<c:if test="${not empty error}">
    <p class="err">${error}</p>
</c:if>

<form:form method="post" action="/admin/product/add" modelAttribute="product">
    <label for="productName">Product Name</label>
    <form:input path="productName" id="productName"/>

    <label for="category">Category</label>
    <form:input path="category" id="category"/>

    <label for="stocks">Stocks</label>
    <form:input path="stocks" id="stocks" type="number"/>

    <label for="price">Price</label>
    <form:input path="price" id="price" type="number" step="5.00"/>

    <button type="submit">Add Product</button>
</form:form>

</body>
</html>
