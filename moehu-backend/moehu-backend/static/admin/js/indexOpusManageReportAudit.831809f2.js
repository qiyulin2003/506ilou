(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["indexOpusManageReportAudit"],{

/***/ "1500":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var regenerator_runtime_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__("96cf");
/* harmony import */ var regenerator_runtime_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(regenerator_runtime_runtime__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__("1da1");
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__("d4ec");
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__("bee2");
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__("262e");
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createSuper__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__("2caf");
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__("9ab4");
/* harmony import */ var vue_property_decorator__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__("60a3");
/* harmony import */ var _layout_base_layout__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__("cb9f");







/*
 * Copyright (c) 2021. bmy
 * Email：2271608011@qq.com
 * Github：https://github.com/helpcode
 */
 // import "@pageLess/OpusAudit.less";




var ReportAudit = /*#__PURE__*/function (_VueType) {
  Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__[/* default */ "a"])(ReportAudit, _VueType);

  var _super = Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createSuper__WEBPACK_IMPORTED_MODULE_5__[/* default */ "a"])(ReportAudit);

  function ReportAudit() {
    var _this;

    Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__[/* default */ "a"])(this, ReportAudit);

    _this = _super.apply(this, arguments);
    _this.RouterMeta = {
      title: '作品举报审核',
      isLogin: false
    };
    return _this;
  }

  Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__[/* default */ "a"])(ReportAudit, [{
    key: "created",
    value: function () {
      var _created = Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__[/* default */ "a"])( /*#__PURE__*/regeneratorRuntime.mark(function _callee() {
        return regeneratorRuntime.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
              case "end":
                return _context.stop();
            }
          }
        }, _callee);
      }));

      function created() {
        return _created.apply(this, arguments);
      }

      return created;
    }()
  }, {
    key: "beforeRouteEnter",
    // 路由拦截器
    value: function beforeRouteEnter(to, from, next) {
      next();
    }
  }, {
    key: "render",
    value: function render() {
      var h = arguments[0];
      return h("div", {
        "class": "ReportAudit"
      }, ["\u4F5C\u54C1\u4E3E\u62A5\u5BA1\u6838"]);
    }
  }]);

  return ReportAudit;
}(_layout_base_layout__WEBPACK_IMPORTED_MODULE_8__[/* VueType */ "a"]);

ReportAudit = Object(tslib__WEBPACK_IMPORTED_MODULE_6__[/* __decorate */ "a"])([vue_property_decorator__WEBPACK_IMPORTED_MODULE_7__[/* Component */ "a"]], ReportAudit);
/* harmony default export */ __webpack_exports__["default"] = (ReportAudit);

/***/ })

}]);