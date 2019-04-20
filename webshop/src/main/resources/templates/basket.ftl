<#import "parts/common.ftl" as common>

<@common.page>
<div class="text-center">
    <#if buyResult?? && !buyResult>
            <h3 class="text-danger">Error! You have too little money in your balance.</h3>
            <a href="/user_profile" class="text-success">Replenish it and try again.</a>
    <#else>
        <h3>Total price: ${totalPrice}  $</h3>
            <form method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="buttonInHeader">
                    <button class="btn btn-success" type="submit">Buy</button>
                </div>
            </form>
    </#if>
</div>
<table class="table table-hover">
    <tbody>
    <#list basketProducts as product>
        <tr>
            <td width="150" class="align-middle">
                <a style="display: block;" href="/products/${product.id}">
                <#if product.fileName??>
                    <img width="150" height="150" src="/img/${product.fileName}" alt="image fruct">
                </#if>
                </a>
            </td>
            <td width="500" class="text-center align-middle">
                    ${product.productName} - ${product.cost} $
            </td>
            <td width="50" class="align-middle">
                <div class="text-center">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <a href="/delete-product-${product.id}" class="btn btn-danger">Delete</a>
                </div>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
</@common.page>