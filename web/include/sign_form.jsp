<%-- 
    Document   : sign_form
    Created on : 06-may-2013, 20:18:22
    Author     : cuarti
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="authentication" >
    <div class="selection" >
        <span class="option selected" >Sign in</span>
        <span class="option" >Sign up</span>
    </div>
    <c:import url="include/sign_in_form.jsp" />
    <c:import url="include/sign_up_form.jsp" />
</div>