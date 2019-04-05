<#include "security.ftl">
<#import "logout.ftl" as logout>
<#import "/spring.ftl" as spring/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Ibay</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/store">Store<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/basket">Basket<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <div class="navbar-text mr-3">${name}</div>
        <div>
            <#if isActive>
            <@logout.page/>
            <#else>
            <form action="/login" method="post">
                <!--<input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
                <button class="btn btn-success" type="submit">Sign In</button>
            </form>
        </#if>
    </div>
</nav>
</nav>