var globalActive, globalTableFilter;

layui.config({
    base: '/assets/layuiadmin/'
}).extend({
    index: 'lib/index',
    zyxx: 'zyxx/js/zyxx',
    treeTable: 'zyxx/js/treeTable'
}).use(['table', 'element'], function () {
    var table = layui.table
        , element = layui.element
        , $ = layui.$;

    // 监听窗口变化
    $(window).resize(function() {
        // 窗口改变，重置表格高度
        table.reload('dataTable', {height: "full-" + ($('#zyxx-search').height() + 50)});
    });

    // 监听折叠
    element.on('collapse(searchCollapseFilter)', function (data) {
        table.reload('dataTable', {height: "full-" + ($('#zyxx-search').height() + 50)});
    });
});

// 监听lay-event事件
$('body').on('click', '*[lay-event]', function () {
    var othis = $(this)
        , attrEvent = othis.attr('lay-event');
    // active[attrEvent] && active[attrEvent].call(this, othis);
    globalActive[attrEvent] && globalActive[attrEvent].call(this, othis);
});

// 打开监听
function handleFilter(table) {
    var filter = globalTableFilter;
    if ((typeof filter == 'object') && filter.constructor == Array) {
        for (var i = 0; i < filter.length; i++) {
            createFilter(table, filter[i]);
        }
    } else {
        createFilter(table, filter);
    }
}

// 创建监听
function createFilter(table, filterId) {
    // 监听头工具栏事件
    table.on('toolbar(' + filterId + ')', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data;
        eval('globalActive.' + obj.event + "('" + data + "')");
    });

    // 监听行工具事件
    table.on('tool(' + filterId + ')', function (obj) {
        // console.log(obj.event);
        // globalActive[obj.event] && globalActive[obj.event].call(globalActive, obj)
        eval('globalActive.' + obj.event + "('" + JSON.stringify(obj.data) + "')");
    });

    // 监听行单击事件
    /*table.on('row(' + filterId + ')', function (obj) {
        eval('globalActive.' + obj.event + "('" + JSON.stringify(obj.data) + "')");
    });*/

    // 监听行双击事件
    /*table.on('rowDouble(' + filterId + ')', function (obj) {
        eval('globalActive.' + obj.event + "('" + JSON.stringify(obj.data) + "')");
    });*/
}
