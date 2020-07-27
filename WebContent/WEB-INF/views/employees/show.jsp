<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${employee!=null}">
                <h2>id : ${employee.id} の従業員情報 詳細ページ</h2>

                <table>
                    <tr>
                        <th>社員番号</th>
                        <td><c:out value="${employee.code}"></c:out></td>
                    </tr>

                    <tr>
                        <th>氏名</th>
                        <td><c:out value="${employee.name}"></c:out></td>
                    </tr>

                    <tr>
                        <th>権限</th>
                        <td><c:choose>
                                <c:when test="${employee.admin_flag==1}">管理者</c:when>
                                <c:otherwise>一般</c:otherwise>
                            </c:choose></td>
                    </tr>

                    <tr>
                        <th>登録日時</th>
                        <td><c:out value="${employee.created_at}"></c:out>
                    </tr>

                    <tr>
                        <th>更新日時</th>
                        <td><c:out value="${employee.updated_at}"></c:out>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p>
            <a href="<c:url value='/employees/index'></c:url>">一覧に戻る</a>
    </c:param>
</c:import>