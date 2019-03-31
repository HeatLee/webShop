<#import "parts/common.ftl" as common>

<@common.page>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <#if product.fileName??>
                <img width="400" height="400" src="/img/${product.fileName}" >
            </#if>
        </div>
        <div class="col-sm">
            <div class="profile-component">
                <h3 class="text-center">${product.productName} - ${product.cost} $</h3>
                <button class="btn btn-success text-center" type="submit">Add to basket</button>
            </div>
        </div>
</div>
</@common.page>