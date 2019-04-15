<#macro page sectionActive1,sectionActive2>
<div class="store-navbar">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <#if sectionActive1>
                <a class="nav-link active" href="/fruits">Fruits</a>
            <#else>
                <a class="nav-link" href="/fruits">Fruits</a>
            </#if>
        </li>
        <li class="nav-item">
            <#if sectionActive2>
                <a class="nav-link active" href="/vegetables">Vegetables</a>
            <#else>
                <a class="nav-link" href="/vegetables">Vegetables</a>
            </#if>
        </li>
    </ul>
</div>
</#macro>