<#import "parts/common.ftl" as common>

<@common.page>
    <div class="text-center">
        <h3>${user.username}</h3>
        <h5>Balance: ${user.money} $</h5>
        <a class="btn btn-success" data-toggle="collapse" href="#collapseExample" role="button"
               aria-expanded="false" aria-controls="collapseExample">
                Replenish
        </a>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" enctype="multipart/form-data">
                    <input type="number" name="money" min="0.00" max="10000.00" step="0.01" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="form-group mt-2">
                        <button type="submit" class="btn btn-success">Ok</button>
                        <a class="btn btn-secondary" data-toggle="collapse" href="#collapseExample" role="button"
                           aria-expanded="false" aria-controls="collapseExample">
                            Cancel
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@common.page>