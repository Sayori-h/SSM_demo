<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/9/27
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 修正后的JSTL声明 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .user-card:hover {
            transform: translateY(-5px);
            transition: all 0.3s ease;
        }
    </style>
</head>
<body class="bg-light">
<div class="container py-5">
    <h1 class="text-center mb-5">👨💻 用户列表</h1>

    <div class="row row-cols-1 row-cols-md-3 g-4">
        <div class="col">
            <div class="card user-card h-100 shadow">
                <div class="card-header bg-info text-white">
                    <h5 class="card-title mb-0">${user.FUsername}</h5>
                </div>
                <div class="card-body">
                    <ul class="list-unstyled">
                        <li>📧 邮箱: ${user.FMail}</li>
                        <li>📱 电话: ${user.FPhonenumber}</li>
                        <li>🏠 地址: ${user.FAddress}</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>


    <div class="text-center mt-4">
        <a href="${pageContext.request.contextPath}/" class="btn btn-primary">
            ← 返回首页
        </a>
    </div>
</div>
</body>
</html>
