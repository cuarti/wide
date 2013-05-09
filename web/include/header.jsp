
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Wide;</h1>

    <c:if test="${ !empty user }" >
        <div id="header_user_panel" class="logged" >
            <%--<img src="images/${ user.image }" >--%>
            <h3>${ user.name }</h3>
            <span class="sign_out" >Sign out</span>
        </div>
    </c:if>
    
    <c:if test="${ empty user }" >
        <div id="header_user_panel" >
            <h4>login</h4>
        </div>
    </c:if>
    
    <div class="menu" >
        <button type="button" class="home" >Home</button>
        <button type="button" class="social" >Social</button>
        <c:if test="${ !empty user }" >
            <button type="button" class="editor" >Editor</button>
        </c:if>
    </div>

</header>
