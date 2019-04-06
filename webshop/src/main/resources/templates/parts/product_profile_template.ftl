<#macro page isContains>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <#if product.fileName??>
            <img width="400" height="400" src="/img/${product.fileName}" alt="image fruct" class="img-thumbnail">
        </#if>
    </div>
    <div class="col-sm text-center">
        <div class="profile-component">
            <h3>${product.productName} - ${product.cost} $</h3>
            <#if isContains>
            <a href="/basket">Go to basket</a>
            <#else>
            <form method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button class="btn btn-success" type="submit">Add to basket</button>
            </form>
        </#if>
    </div>
</div>
</div>
</#macro>