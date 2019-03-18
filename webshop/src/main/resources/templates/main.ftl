<#import "parts/common.ftl" as common>

<@common.page>
List of users

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Money</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td>${user.money}</td>
    </tr>
    </#list>
    </tbody>
</table>
</@common.page>