
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Wide;</h1>
    <div id="header_user_panel" >
        <c:if test="${ !empty user }" >
            <img src="images/${ user.image }" >
            <h3>${ user.name }</h3>
            <a href="" >logout</a>
        </c:if>
        <c:if test="${ empty user }" >
            <h4>login</h4>
        </c:if>
    </div>
</header>
