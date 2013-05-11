
<%@tag import="java.util.List"%>
<%@tag import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="action" required="true" %>
<%@attribute name="cssFile" %>

<% List<String> cssList;%>

<c:choose>
    <c:when test="${ action eq 'add' }" >

        <%--<% cssList = (List) request.getAttribute("cssList"); %>--%>
        <% cssList = (List) request.getSession().getAttribute("cssList");%>
        <c:if test="${ empty cssList }" >
            <% cssList = new ArrayList<String>();%>
        </c:if>

        <%
            cssList.add(cssFile);
            request.getSession().setAttribute("cssList", cssList);
        %>

    </c:when>
    <c:when test="${ action eq 'get' }" >

        <%
            cssList = (List) request.getSession().getAttribute("cssList");

            if (cssList != null) {
                for (String i : cssList) {
                    out.println("<link rel=\"stylesheet\" href=\"" + i + "\" />");
                }
            }
            request.getSession().removeAttribute("cssList");
        %>

        <%--<c:forEach var="i" items="${ cssFile }" >
            <link rel="stylesheet" href="${ i }" />
        </c:forEach>--%>

    </c:when>
</c:choose>