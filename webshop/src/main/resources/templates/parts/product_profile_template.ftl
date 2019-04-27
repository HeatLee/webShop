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
                    <a href="/basket" class="text-success">Go to basket</a>
                <#else>
                <form method="post">
                    <div class="form-group row">
                        <input type="number" name="weight" min="0.05" max="10000.00" step="0.05" value="1.00"/>
                        <button class="btn btn-success" type="submit">Add to basket</button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                </form>
                </#if>
            </div>
    </div>
</div>
</div>
</#macro>