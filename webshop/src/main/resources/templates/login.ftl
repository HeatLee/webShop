<#import "parts/common.ftl" as common>
<#import "parts/login_template.ftl" as login>

<@common.page>
${error?if_exists}
<@login.page "/login" false />
</@common.page>