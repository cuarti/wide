
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            
            <c:if test="${ !empty error }" >
                <span class="error" >${ error }</span>
            </c:if>
            <c:if test="${ empty error }" >
                <span>Project created successfully.</span>
            </c:if>

            <h1>Projects</h1>
            
            <c:forEach var="p" items="${ user.projects }" >
                <div>
                    <span>Title: ${ p.title }</span>
                    <span>Description: ${ p.description }</span>
                    <span>Logo: ${ p.logo }</span>
                    <span>Users: 
                        <c:forEach var="u" items="${ p.users }" >${ u.name }</c:forEach>
                    </span>
                    <span>Images: 
                        <c:forEach var="i" items="${ p.images }" >${ i }</c:forEach>
                    </span>
                    <span>Tags: 
                        <c:forEach var="t" items="${ p.tags }" >${ t }</c:forEach>
                    </span>
                    <span>Followers: 
                        <c:forEach var="f" items="${ p.followersList }" >${ f }</c:forEach>
                    </span>
                    <span>Files: 
                        <c:forEach var="f" items="${ p.files }" >${ f }</c:forEach>
                    </span>
                </div>
            </c:forEach>
            
        </div>
        <footer>
        </footer>
        <c:import url="include/modal_window.jsp" />
    </body>
</html>
