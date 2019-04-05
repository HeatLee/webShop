<#import "parts/common.ftl" as common>

<@common.page>
<div class="text-center">
    <h3>Total price: ${totalPrice} $</h3>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="buttonInHeader">
            <button class="btn btn-success" type="submit">Buy</button>
        </div>
    </form>
</div>
<table class="table table-hover">
<!--    <thead>-->
<!--    <tr>-->
<!--        <th width="150"></th>-->
<!--        <th width="500"></th>-->
<!--        <th width="50"></th>-->
<!--    </tr>-->
<!--    </thead>-->
    <tbody>
    <#list basketProducts as product>
        <tr>
            <td width="150" class="align-middle">
                <#if product.fileName??>
                    <img width="150" height="150" src="/img/${product.fileName}" alt="image fruct">
                </#if>
            </td>
            <td width="500" class="text-center align-middle">${product.name} - ${product.price} $</td>
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