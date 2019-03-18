<#macro page>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-success" type="submit">Sign Out</button>
    </form>
</#macro>