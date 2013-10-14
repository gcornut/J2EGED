var makeOnClick = function() {
    console.log("makeOnClick");
    var link;
    var links = $(".ui-datagrid td a");
    for (var i = 0; i < links.length; i++) {
        link = links[i];
        var onclick = $(link).attr("onclick");
        var cell = $(link).parents("td.ui-datagrid-column");
        cell.attr("onclick", onclick);
    }
    links = $(".ui-datatable td a");
    for (var i = 0; i < links.length; i++) {
        link = links[i];
        var onclick = $(link).attr("onclick");
        var cell = $(link).parents(".ui-datatable-tablewrapper tr");
        cell.attr("onclick", onclick);
    }
};

$(makeOnClick);
PrimeFaces.ab = function (cfg,ext){
    setTimeout(makeOnClick ,250);
    setTimeout(makeOnClick ,500);
    setTimeout(makeOnClick ,1000);
    setTimeout(makeOnClick ,2000);
    return PrimeFaces.ajax.AjaxRequest(cfg,ext);
};