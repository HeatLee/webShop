<#import "parts/common.ftl" as common>
<#import "/spring.ftl" as spring/>

<@common.page>
<fieldset>
    <h1>Create your Account</h1>
    <form action="<@spring.url '/registration'/>" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Username:</label>
            <div class="col-sm-6">
                <@spring.bind "userForm.username"/>
                <input type="text" name="${spring.status.expression}" value="${spring.status.value?if_exists}"
                       class="form-control" placeholder="Username" />
                <#if spring.status.error>
                    <div class="alert alert-danger">
                        ${spring.status.errorCodes[0]?if_exists}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <@spring.bind "userForm.password"/>
                <input type="password" name="${spring.status.expression}" value="${spring.status.value?if_exists}"
                       class="form-control" placeholder="Password"/>
                <#if spring.status.error>
                    <div class="alert alert-danger">
                        ${spring.status.errorCodes[0]?if_exists}
                    </div>
                </#if>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-success" type="submit">Create</button>
    </form>
</fieldset>
</@common.page>

