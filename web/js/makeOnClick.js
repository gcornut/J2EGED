var makeOnClick = function() {
    console.log("makeOnClick");
    var link;
    var links = $(".ui-datagrid td a");
    for (var i = 0; i < links.length; i++) {
        link = links[i];

        var onclick = $(link).attr("onclick");
        var idFolder = onclick.match("value:'(.+)'")[1];
        var source = $(link).attr("onclick").match("source:'(.+)',up")[1];
        var cell = ($(link).parent().parent().parent().parent().parent().parent().parent());
        cell.attr("onclick", "PrimeFaces.ab({source:'" + source + "',update:'formFolder formBreadcrumb',params:[{name:'idFolder',value:'" + idFolder + "'}]});");
    }
    links = $(".ui-datatable td a");
    for (var i = 0; i < links.length; i++) {
        link = links[i];

        var onclick = $(link).attr("onclick");
        var idFolder = onclick.match("value:'(.+)'")[1];
        var source = $(link).attr("onclick").match("source:'(.+)',up")[1];
        var cell = ($(link).parent().parent().parent());
        cell.attr("onclick", "PrimeFaces.ab({source:'" + source + "',update:'formFolder formBreadcrumb',params:[{name:'idFolder',value:'" + idFolder + "'}]});");
    }
};

$(makeOnClick);
PrimeFaces.ab = function (cfg,ext){setTimeout(makeOnClick ,250);return PrimeFaces.ajax.AjaxRequest(cfg,ext);};