<%--
  这是注释：
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/9/27
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PowerNode 用户中心</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .hero-section {
            background: linear-gradient(45deg, #6c5ce7, #a66efa);
            height: 100vh;
            display: flex;
            align-items: center;
            color: white;
        }
        .nav-glass {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            border-radius: 15px;
        }
    </style>
</head>
<body>
<div class="hero-section">
    <div class="container text-center">
        <h1 class="display-4 mb-4">🚀 Welcome to PowerNode</h1>
        <div class="nav-glass p-4 d-inline-block">
            <div class="d-grid gap-3">
                <a href="${pageContext.request.contextPath}/web/hello"
                   class="btn btn-lg btn-light btn-hover-scale">
                    📢 查看欢迎信息
                </a>
                <a href="${pageContext.request.contextPath}/web/user"
                   class="btn btn-lg btn-light btn-hover-scale">
                    👥 用户列表
                </a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
