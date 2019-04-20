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
<div class="card-columns">
    <#list products as product>
    <div class="card">
        <p><a href="/products/${product.id}">
            <#if product.fileName??>
            <img width="200" height="200" src="/img/${product.fileName}" class="card-img-top">
        </#if>
            </a></p>
        <h5 class="card-title text-center">${product.productName} - ${product.cost} $</h5>
    </div>
    <#else>
    No products
</#list>
</div>
</#macro>