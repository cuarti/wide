
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>WIDE - SOCIAL</title>
        <c:import url="include/common_css_and_js.jsp" />
    </head>
    <body>
        <c:import url="include/header.jsp" />
        <div id="content" >

            <c:if test="${ user.name eq userProfile.name }" >
                <div>
                    <h1>New Project</h1>
                    <form action="project" method="GET" >
                        <input type="hidden" name="action" value="createProject" />
                        <input type="text" name="title" />
                        <input type="submit" value="Create" />
                    </form>
                </div>
            </c:if>

            <h1>${ userProfile.name }</h1>
            <p>${ userProfile.mail }</p>

            <c:if test=" ${ !empty userProfile.projects }" >
                <c:forEach var="i" begin="0" end="5" >
                    <c:set var="u" value="${ userProfile.projects[i] }" />
                    <c:if test="${ !empty u }" >
                        <p>${ u.name }</p>
                    </c:if>
                </c:forEach>
            </c:if>

        </div>
        <footer>
        </footer>
        <c:import url="include/modal_window.jsp" />
    </body>
</html>
