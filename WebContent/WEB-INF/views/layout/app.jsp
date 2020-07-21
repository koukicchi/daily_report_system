<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>I日報管理システム</title>
<link rel="stylesheet" href="<c:url value='/css/reset.css'></c:url>">
<link rel="stylesheet" href="<c:url value='/css/style.css'></c:url>">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h1>日報管理システム</h1>
        </div>
        <div id="content">${param.content}</div>
        <div id="footer">by Tarou Kirameki.</div>
    </div>

</body>
</html>