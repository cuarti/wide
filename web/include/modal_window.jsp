
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="modal" >
    <div class="window" >
        <div class="content" >
            <c:import url="include/sign_form.jsp" />
        </div>
        <span class="close" title="Close" >X</span>
    </div>
</div>
<div id="info_modal" >
    <div class="window" >
        <div class="content" ></div>
        <img src="images/loading.gif" />
    </div>
</div>