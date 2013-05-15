
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
        <div id="content" class="user" >

            <c:if test="${ userSession.id eq user.id }" >
                <div>
                    <h1>New Project</h1>
                    <form action="project" method="GET" >
                        <input type="hidden" name="action" value="createProject" />
                        <input type="text" name="title" />
                        <input type="submit" value="Create" />
                    </form>
                </div>
            </c:if>

            <c:if test="${ !empty messageResponse }" >
                <div>${ messageResponse }</div>
            </c:if>
            
            <div class="name" >${ user.name }</div>
            <div class="mail" >${ user.mail }</p>
            
            <div class="description" >${ user.description }</div>

            Projects:
            <c:if test="${ !empty user.projects }" >
                <c:forEach var="p" items="${ user.projects }" >
                    <div>
                    <a href="social?action=project&value=${ p.id }" >${ p.title }</a>
                    </div>
                </c:forEach>
            </c:if>
            
            Following:
            <c:if test="${ !empty user.following }" >
                <c:forEach var="f" items="${ user.following }" >
                    <p>${ f.title }</p>
                </c:forEach>
            </c:if>
        </div>
        <footer>
        </footer>
        <c:import url="include/modal_window.jsp" />
    </body>
</html>
