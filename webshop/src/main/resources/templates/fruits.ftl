<#import "parts/common.ftl" as common>
<#import "parts/store_navbar.ftl" as store_navbar>

<@common.page>
<@store_navbar.page true false/>
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
</@common.page>