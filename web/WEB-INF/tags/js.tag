
<%@tag import="java.util.List"%>
<%@tag import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="action" required="true" %>
<%@attribute name="jsFile" %>

<% List<String> jsList;%>

<c:choose>
    <c:when test="${ action eq 'add' }" >

        <%--<% jsList = (List) request.getAttribute("jsList"); %>--%>
        <% jsList = (List) request.getSession().getAttribute("jsList");%>
        <c:if test="${ empty jsList }" >
            <% jsList = new ArrayList<String>();%>
        </c:if>

        <%
            jsList.add(jsFile);
            request.getSession().setAttribute("jsList", jsList);
        %>

    </c:when>
    <c:when test="${ action eq 'get' }" >

        <%
            jsList = (List) request.getSession().getAttribute("jsList");

            if (jsList != null) {
                for (String i : jsList) {
                    out.println("<script type=\"text/javascript\" src=\"" + i + "\" ></script>");
                }
            }

            request.getSession().removeAttribute("jsList");
        %>

        <%--<c:forEach var="i" items="${ jsList }" >
            <link rel="stylesheet" href="${ i }" />
        </c:forEach>--%>

    </c:when>
</c:choose>