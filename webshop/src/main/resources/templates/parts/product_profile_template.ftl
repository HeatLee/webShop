<#macro page isContains>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <#if product.fileName??>
            <img width="400" height="400" src="/img/${product.fileName}" alt="image fruct" class="img-thumbnail">
        </#if>
    </div>
    <div class="col-sm">
        <div class="profile-component">
            <div class="text-center">
                <h2>${product.productName}</h2>
            </div>
            <h3>${product.toString()}</h3>
            <div class="text-center">
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
</div>
</#macro>