<#import "parts/common.ftl" as common>
<#import "parts/login_template.ftl" as login>

<@common.page>
<div  class="mb-1">Add new user</div>
${message?if_exists}
<@login.page "/registration" true />
</@common.page>