
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>Wide;</h1>

    <c:if test="${ !empty user }" >
        <div id="header_user_panel" class="logged" >
            <!--<img src="images/${ user.image }" >-->
            <h3>${ user.name }</h3>
            <a href="" >logout</a>
        </div>
    </c:if>

    <c:if test="${ empty user }" >
        <div id="header_user_panel" >
            <h4>login</h4>
        </div>
    </c:if>

</header>
