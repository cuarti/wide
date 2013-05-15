
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>WIDE - SOCIAL</title>
        <link rel="stylesheet" href="style/sass/social.css" />
        <c:import url="include/common_css_and_js.jsp" />
    </head>
    <body>
        <c:import url="include/header.jsp" />
        <div id="content" class="project" >
            <c:if test="${ empty project }" >
                There aren't any project named ${ param.value } that the ${ param.user } user have.
            </c:if>
            <c:if test="${ !empty project }" >

                <div class="title" >${ project.title }</div>
                
                <div class="content_left" >

                    <div class="logo module" >${ project.logo }</div>

                    <div class="description module" >
                        <p class="bold" >Description: </p>
                        <div class="content" >
                            <c:if test="${ empty project.description }" >
                                There aren't description for this project.
                            </c:if>
                            <c:if test="${ !empty project.description }" >
                                ${ project.description }
                            </c:if>
                        </div>
                    </div>

                    <div class="tags module" >
                        <p class="bold" >Tags: </p>
                        <div>
                            <c:if test="${ empty project.tags }" >
                                There aren't tags for this project.
                            </c:if>
                            <c:if test="${ !empty project.tags }" >
                                <c:forEach var="t" items="${ project.tags }" >${ t }</c:forEach>
                            </c:if>
                        </div>
                    </div>

                </div>
                <div class="content_middle" >

                    <div class="files module" >
                        <p class="bold" >Files: </p>
                        <div>
                            <%--<c:if test="${ empty project.files }" >
                                There aren't files for this project.
                            </c:if>
                            <c:if test="${ !empty project.files }" >
                                <c:forEach var="f" items="${ project.files }" >${ f }</c:forEach>
                            </c:if>--%>
                        </div>
                    </div>

                </div>
                <div class="content_right" >

                    <div class="images module" >
                        <p class="bold" >Images: </p>
                        <c:if test="${ empty project.images }" >
                            There aren't images for this project.
                        </c:if>
                        <c:if test="${ !empty project.images }" >
                            <c:forEach var="i" items="${ project.images }" >${ i }</c:forEach>
                        </c:if>
                    </div>

                    <div class="users module" >
                        <p class="bold" >Users: </p>
                        <div>
                            <c:forEach var="u" items="${ project.users }" >
                                <a href="social?action=user&value=${ u.name }">${ u.name }</a>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="followers module" >
                        <p class="bold" >Followers: </p>
                        <div>
                            <c:if test="${ empty project.followers } " >
                                There aren't followers for this project.
                            </c:if>
                            <c:if test="${ !empty project.followers }" >
                                <c:forEach var="f" items="${ project.followers }" >${ f }</c:forEach>
                            </c:if>
                        </div>
                    </div>
                    
                    <div class="otherProjects module" >
                        <p class="bold" >Other projects: </p>
                        <div>
                            <c:if test="${ empty otherProjects }" >
                                There aren't more projects.
                            </c:if>
                            <c:if test="${ !empty otherProjects }" >
                                <c:forEach var="p" items="${ otherProjects }" >
                                    <a href="social?action=project&value=${ p.id }">${ p.title }</a>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <footer>
        </footer>
        <c:import url="include/modal_window.jsp" />
    </body>
</html>
