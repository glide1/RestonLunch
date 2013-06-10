<@layout.basic>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">Restaurants</li>
                    <#list restaurants as restaurant>
                    <li><a href="${rc.contextPath}/restaurants/details/${restaurant.name}.html ">${restaurant.name}</a></li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</div>

</@layout.basic>