/**
 * zyxx自定义组件 - 全局
 *
 * @author Tellsea
 * @date 2020-5-9
 */
layui.define(['element', 'table', 'layer'], function (exports) {
    var element = layui.element
        , table = layui.table
        , layer = layui.layer
        , $ = layui.jquery;

    var active = {
        openTabsPage: function (url, text) {
            top.layui.index.openTabsPage(url, text, parent.layui.admin.tabsPage.index);
        },

        /**
         * 表单弹出层
         *
         * @param title    标题
         * @param pageId  节点id
         * @param formId  表单id
         * @param isMax   是否最大化
         * @param w       宽度
         * @param h       高度
         * @returns {s.index}
         * // 参数：标题，节点id，表单id，是否最大化，宽度，高度，确定回调
         */
        openForm: function () {
            var title = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : false;
            var pageId = arguments.length > 1 ? arguments[1] : undefined;
            var formId = arguments.length > 2 ? arguments[2] : undefined;
            var isMax = arguments.length > 3 ? arguments[3] : undefined;
            var w = arguments.length > 4 ? arguments[4] : undefined;
            var h = arguments.length > 5 ? arguments[5] : undefined;
            var yesFunc = arguments.length > 6 ? arguments[6] : undefined;
            if (w <= 0) w = (window).width() * 0.9;
            if (h <= 0) h = $(window).height() * 0.9;
            var index = layer.open({
                id: (new Date()).getTime(),
                type: 1,
                title: title,
                content: $("#" + pageId),
                area: [w + 'px', h + 'px'],
                maxmin: true,
                // true 是最大化展示 false 不是最大化展示
                fix: false,
                //不固定
                shadeClose: false,
                // 是否带滚动 true 带滚动 false 不带滚动
                scrollbar: false,
                shade: 0.4,
                btn: ["确定", "取消"],
                yes: yesFunc,
                end: function end() {
                    $("#" + formId)[0].reset();
                    $("[name='sizeDiv']").remove();
                    $("#" + pageId).css("display", "none");
                    $(".layui-form-danger").removeClass("layui-form-danger");
                    $(".error").removeClass("error");
                }
            });
            if (isMax) {
                layer.full(index);
            }
            return index;
        },

        openDetail: function () {
            var title = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : false;
            var pageId = arguments.length > 1 ? arguments[1] : undefined;
            var isMax = arguments.length > 2 ? arguments[2] : undefined;
            var w = arguments.length > 3 ? arguments[3] : undefined;
            var h = arguments.length > 4 ? arguments[4] : undefined;
            if (w <= 0) w = (window).width() * 0.9;
            if (h <= 0) h = $(window).height() * 0.9;
            var index = layer.open({
                id: (new Date()).getTime(),
                type: 1,
                title: title,
                content: $("#" + pageId),
                area: [w + 'px', h + 'px'],
                maxmin: true,
                // true 是最大化展示 false 不是最大化展示
                fix: false,
                //不固定
                shadeClose: false,
                // 是否带滚动 true 带滚动 false 不带滚动
                scrollbar: false,
                shade: 0.4,
                btn: ["取消"],
                // yes: yesFunc,
                // end: function end() {
                //
                // }
            });
            if (isMax) {
                layer.full(index);
            }
            return index;
        },

        /* --------------------------------------------------------- 工具 */
        /**
         * 空验证
         *
         * @param val
         * @returns {boolean}
         */
        isEmpty: function (val) {
            if (val == undefined || val == null || val == '' || val.length == 0) {
                return true;
            } else {
                return false;
            }
        },
        /**
         * 非空验证
         * @param val
         * @returns {boolean}
         */
        isNotEmpty: function (val) {
            if (active.isEmpty(val)) {
                return false;
            } else {
                return true;
            }
        },

        /**
         * 邮箱验证
         *
         * @param val
         * @returns {boolean}
         */
        isEmail: function (val) {
            var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
            return reg.test(val);
        },

        /**
         * 身份证号码验证
         *
         * @param val
         * @returns {boolean}
         * 身份证正则表达式(15位):isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
         * 身份证正则表达式(18位):isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
         */
        isCard: function (val) {
            var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            return reg.test(val);
        },

        /**
         * 手机号码
         *
         * @param val
         * @returns {boolean}
         */
        isPhone: function (val) {
            var reg = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
            return reg.test(val);
        },

        /**
         * 固定电话
         *
         * @param val
         * @returns {boolean}
         */
        isLandline: function (val) {
            var reg = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
            return reg.test(val);
        },

        /**
         * 手机号码或者固定电话
         *
         * @param val
         * @returns {boolean}
         */
        isPhoneOrLandline: function (val) {
            var reg = /^((0\d{2,3}-\d{7,8})|(1[3456789]\d{9}))$/;
            return reg.test(val);
        },

        /**
         * 邮编
         *
         * @param val
         * @returns {boolean}
         */
        isPostalcode: function (val) {
            var reg = /^[1-9][0-9]{5}$/;
            return reg.test(val);
        },

        /**
         * 银行卡号，15,16,19位
         *
         * @param val
         * @returns {boolean}
         */
        isBank: function (val) {
            var reg = /^([1-9]{1})(\d{14}|\d{18}|\d{15})$/;
            return reg.test(val);
        },

        setLocalStorage: function (key, val) {
            localStorage.setItem(key, JSON.stringify(val));
        },
        getLocalStorage: function (key) {
            return JSON.parse(localStorage.getItem(key));
        },
        // 如果为空，则转为0
        convert: function (val) {
            if (active.isEmpty(val)) {
                return 0;
            }
            return val;
        },
        // 将字符串转换为对象
        parse: function (val) {
            return val ? JSON.parse(val.replace(/\n/g, "\\\\n").replace(/\r/g, "\\\\r")) : '';
        },
        // 字符串分隔
        split: function (val) {
            if (active.isNotEmpty(val)) {
                return val.split(',');
            }
            return [];
        }
    };

    exports('zyxx', active);
});
