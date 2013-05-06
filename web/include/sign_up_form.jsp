<%-- 
    Document   : sign_in_form
    Created on : 06-may-2013, 16:30:27
    Author     : cuarti
--%>

<div>
    <h1>Sign up</h1>
    <!--<form id="form" action="authenticationController" method="POST">-->
        <div class="field">
            <h2>Username</h2>
            <input type="text" name="username" value="${ param.username }" required="required" placeholder="user" />
            <label class="error">${ !empty errorU? errorU : "" }</label>
        </div>
        <div class="field">
            <h2>Mail address</h2>
            <input type="email" name="mail" value="${ param.mail }" required="required" placeholder="mail" />
            <label class="error">${ !empty errorM? errorM : "" }</label>
        </div>
        <div class="field">
            <h2>Password</h2>
            <input type="password" name="password" required="required" placeholder="password" />
            <label class="error">${ !empty errorP? errorP : "" }</label>
        </div>
        <div class="field">
            <h2>Confirm your password</h2>
            <input type="password" name="confirmPassword" required="required" placeholder="password" />
            <label class="error">${ !empty errorVP? errorVP : "" }</label>
        </div>
<!--        <input type="hidden" name="action" value="registre" />
        <input type="submit" class="normal_button" value="Registrar" />
    </form>-->
<!--    <form action="Penjat" method="POST" >
        <input type="hidden" name="action" value="goToLogin" />
        <input type="submit" class="transparent_button" value="Ya estas registrat?" />
    </form>-->
</div>
