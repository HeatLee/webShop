<#import "parts/common.ftl" as common>

<@common.page>
<table>
    <tbody>
    <#list basketProducts as product>
        <tr>
            <div class="card">
                <#if product.fileName??>
                    <img width="200" height="200" src="/img/${product.fileName}" class="card-img-top">
                </#if>
            </div>
        </td>
        <td>${product.price}</td>
    </tr>
    </#list>
    </tbody>
</table>
</@common.page>