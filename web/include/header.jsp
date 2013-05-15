
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Wide;</h1>

    <c:if test="${ !empty userSession }" >
        <div id="header_user_panel" class="logged" >
            <%--<img src="images/${ user.image }" >--%>
            <h3>${ userSession.name }</h3>
            <span class="sign_out" >Sign out</span>
        </div>
    </c:if>

    <c:if test="${ empty userSession }" >
        <div id="header_user_panel" >
            <h4>login</h4>
        </div>
    </c:if>

    <div class="menu" >
        <button type="button" class="home" 
            <c:if test="${ !empty homeDisabled && homeDisabled }" >
                disabled="disabled"
            </c:if>
        >Home</button>
        <button type="button" class="social" 
            <c:if test="${ !empty socialDisabled && socialDisabled }" >
                disabled="disabled"
            </c:if>
        >Social</button>
        <c:if test="${ !empty user }" >
            <button type="button" class="editor" 
                <c:if test="${ !empty editorDisabled && editorDisabled }" >
                    disabled="disabled"
                </c:if>
            >Editor</button>
        </c:if>
    </div>

</header>
