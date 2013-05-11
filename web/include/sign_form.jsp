
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" tagdir="/WEB-INF/tags" %>

<div class="authentication" >
    
    <div class="selection" >
        <span class="option selected" >Sign in</span>
        <span class="option" >Sign up</span>
    </div>

    <%--    Sign in Form    --%>
    <div class="sign_in">
        <h1>Sign in</h1>
        <div class="field" >
            <h2>Username</h2>
            <input type="text" class="username" required="required" placeholder="username" />
        </div>
        <div class="field" >
            <h2>Pasword</h2>
            <input type="password" class="password" required="required" placeholder="password" />
        </div>
        <button class="submit_button" >Sign in</button>
    </div>

    <%--    Sign up Form    --%>
    <div class="sign_up" >
        <h1>Sign up</h1>
        <div class="field">
            <h2>Username</h2>
            <input type="text" class="username" required="required" placeholder="user" />
        </div>
        <div class="field">
            <h2>Mail address</h2>
            <input type="email" class="mail" required="required" placeholder="mail" />
        </div>
        <div class="field">
            <h2>Password</h2>
            <input type="password" class="password" required="required" placeholder="password" />
        </div>
        <div class="field">
            <h2>Confirm your password</h2>
            <input type="password" class="confirmPassword" required="required" placeholder="password" />
        </div>
        <button class="submit_button" >Sign up</button>
    </div>

</div>
    
<ct:js action="add" jsFile="js/authentication.js" />
