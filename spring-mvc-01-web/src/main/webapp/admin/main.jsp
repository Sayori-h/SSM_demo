<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/9/27
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark text-light">
<div class="container py-5">
    <div class="card border-0 shadow-lg">
        <div class="card-header bg-primary text-white">
            <h2>🌈 系统消息</h2>
        </div>
        <div class="card-body bg-light text-dark">
            <div class="display-4 mb-3">${info}</div>
            <div class="text-end">
                <a href="${pageContext.request.contextPath}/" class="btn btn-outline-primary">
                    ← 返回首页
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
