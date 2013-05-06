<%-- 
    Document   : logged_in_form
    Created on : 06-may-2013, 16:29:29
    Author     : cuarti
--%>

<div>
    <h1>Sign in</h1>
    <!--<form id="form" action="authenticationController" method="POST">-->
        <div class="field" >
            <h2>Username or mail address</h2>
            <input type="email" name="mail" value="${ param.mail }" required="required" placeholder="user or mail" />
            <label class='error'>${ !empty errorM? errorM : "" }</label>
        </div>
        <div class="field" >
            <h2 class="title_field" >Pasword</h2>
            <input type="password" name="password" required="required" placeholder="password" />
            <label class="error">${ !empty errorP? errorP : "" }</label>
        </div>
<!--        <input type="hidden" name="action" value="login" />
        <input type="submit" class="normal_button" value="Inicia Sessió" />-->
    <!--</form>-->
<!--    <form action="Penjat" method="POST" >
        <input type="hidden" name="action" value="goToRegistre" />
        <input type="submit" class="transparent_button" value="No estas registrat?" />
    </form>-->
</div>
