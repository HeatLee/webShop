<#import "parts/common.ftl" as common>

<@common.page>

<div class="card-columns">
    <#list products as product>
    <div class="card">
        <p><a href="/products/${product.id}">
            <#if product.fileName??>
                <img width="200" height="200" src="/img/${product.fileName}" class="card-img-top">
            </#if>
            </a></p>
        <h5 class="card-title">${product.name} - ${product.price} $</h5>
    </div>
    <#else>
    No products
    </#list>
</div>
</@common.page>