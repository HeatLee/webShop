<#import "parts/common.ftl" as common>

<@common.page>
<form action="/login" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Username:</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="Username" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
            <#if error??>
                <div class="alert alert-danger">
                    ${error}
                </div>
            </#if>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button class="btn btn-success" type="submit">
        Sign In
    </button>
    <a href="/registration">New user</a>
</form>
</@common.page>