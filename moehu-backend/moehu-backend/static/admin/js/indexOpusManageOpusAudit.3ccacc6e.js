(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["indexOpusManageOpusAudit"],{

/***/ "2638":
/***/ (function(module, exports, __webpack_require__) {

"use strict";
function _extends(){return _extends=Object.assign||function(a){for(var b,c=1;c<arguments.length;c++)for(var d in b=arguments[c],b)Object.prototype.hasOwnProperty.call(b,d)&&(a[d]=b[d]);return a},_extends.apply(this,arguments)}var normalMerge=["attrs","props","domProps"],toArrayMerge=["class","style","directives"],functionalMerge=["on","nativeOn"],mergeJsxProps=function(a){return a.reduce(function(c,a){for(var b in a)if(!c[b])c[b]=a[b];else if(-1!==normalMerge.indexOf(b))c[b]=_extends({},c[b],a[b]);else if(-1!==toArrayMerge.indexOf(b)){var d=c[b]instanceof Array?c[b]:[c[b]],e=a[b]instanceof Array?a[b]:[a[b]];c[b]=d.concat(e)}else if(-1!==functionalMerge.indexOf(b)){for(var f in a[b])if(c[b][f]){var g=c[b][f]instanceof Array?c[b][f]:[c[b][f]],h=a[b][f]instanceof Array?a[b][f]:[a[b][f]];c[b][f]=g.concat(h)}else c[b][f]=a[b][f];}else if("hook"==b)for(var i in a[b])c[b][i]=c[b][i]?mergeFn(c[b][i],a[b][i]):a[b][i];else c[b]=a[b];return c},{})},mergeFn=function(a,b){return function(){a&&a.apply(this,arguments),b&&b.apply(this,arguments)}};module.exports=mergeJsxProps;


/***/ }),

/***/ "27b4":
/***/ (function(module, exports, __webpack_require__) {

// extracted by mini-css-extract-plugin

/***/ }),

/***/ "2dc3":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// EXTERNAL MODULE: ./node_modules/core-js/modules/es.array.filter.js
var es_array_filter = __webpack_require__("4de4");

// EXTERNAL MODULE: ./node_modules/core-js/modules/es.array.map.js
var es_array_map = __webpack_require__("d81d");

// EXTERNAL MODULE: ./node_modules/@vue/babel-helper-vue-jsx-merge-props/dist/helper.js
var helper = __webpack_require__("2638");
var helper_default = /*#__PURE__*/__webpack_require__.n(helper);

// EXTERNAL MODULE: ./node_modules/regenerator-runtime/runtime.js
var runtime = __webpack_require__("96cf");

// EXTERNAL MODULE: ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js
var asyncToGenerator = __webpack_require__("1da1");

// EXTERNAL MODULE: ./node_modules/@babel/runtime/helpers/esm/classCallCheck.js
var classCallCheck = __webpack_require__("d4ec");

// EXTERNAL MODULE: ./node_modules/@babel/runtime/helpers/esm/createClass.js
var createClass = __webpack_require__("bee2");

// EXTERNAL MODULE: ./node_modules/@babel/runtime/helpers/esm/assertThisInitialized.js
var assertThisInitialized = __webpack_require__("257e");

// EXTERNAL MODULE: ./node_modules/@babel/runtime/helpers/esm/inherits.js + 1 modules
var inherits = __webpack_require__("262e");

// EXTERNAL MODULE: ./node_modules/@babel/runtime/helpers/esm/createSuper.js + 4 modules
var createSuper = __webpack_require__("2caf");

// EXTERNAL MODULE: ./node_modules/tslib/tslib.es6.js
var tslib_es6 = __webpack_require__("9ab4");

// EXTERNAL MODULE: ./src/application/assets/less/page/OpusAudit.less
var page_OpusAudit = __webpack_require__("e226");

// EXTERNAL MODULE: ./node_modules/vue-property-decorator/lib/vue-property-decorator.js
var vue_property_decorator = __webpack_require__("60a3");

// EXTERNAL MODULE: ./src/application/layout/base.layout.ts
var base_layout = __webpack_require__("cb9f");

// EXTERNAL MODULE: ./src/application/components/PageHeader.tsx
var PageHeader = __webpack_require__("e294");

// EXTERNAL MODULE: ./src/core/annotation/Ioc.annotation.ts + 1 modules
var Ioc_annotation = __webpack_require__("4771");

// EXTERNAL MODULE: ./src/core/service/impl/OpusAudit.service.impl.ts
var OpusAudit_service_impl = __webpack_require__("1518");

// EXTERNAL MODULE: ./src/application/logic/Base.logic.ts
var Base_logic = __webpack_require__("463b");

// CONCATENATED MODULE: ./src/application/logic/page/OpusAudit.logic.ts








/*
 * Copyright (c) 2021. bmy
 * Email：2271608011@qq.com
 * Github：https://github.com/helpcode
 */
var _a;





var OpusAudit_logic_OpusAuditLogic = /*#__PURE__*/function (_BaseLogic) {
  Object(inherits["a" /* default */])(OpusAuditLogic, _BaseLogic);

  var _super = Object(createSuper["a" /* default */])(OpusAuditLogic);

  function OpusAuditLogic(point) {
    var _this;

    Object(classCallCheck["a" /* default */])(this, OpusAuditLogic);

    _this = _super.call(this);
    _this.opus = [];
    _this.dialogVisible = false;
    _this.filter = {
      opus_title: null,
      opus_status: null,
      opus_type: null,
      opus_original: null
    };
    _this._ = point;
    return _this;
  }

  Object(createClass["a" /* default */])(OpusAuditLogic, [{
    key: "StartUp",
    value: function () {
      var _StartUp = Object(asyncToGenerator["a" /* default */])( /*#__PURE__*/regeneratorRuntime.mark(function _callee() {
        return regeneratorRuntime.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return this.GetOpusAuditList();

              case 2:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, this);
      }));

      function StartUp() {
        return _StartUp.apply(this, arguments);
      }

      return StartUp;
    }()
  }, {
    key: "GetOpusAuditList",
    value: function () {
      var _GetOpusAuditList = Object(asyncToGenerator["a" /* default */])( /*#__PURE__*/regeneratorRuntime.mark(function _callee2() {
        var res;
        return regeneratorRuntime.wrap(function _callee2$(_context2) {
          while (1) {
            switch (_context2.prev = _context2.next) {
              case 0:
                _context2.next = 2;
                return this.opusAuditServiceImpl.OpusAudit(Object.assign({
                  page: this.page,
                  count: this.count
                }, this.filter));

              case 2:
                res = _context2.sent;
                this.opus = res.result;
                this.total_page = res.total_page;
                console.log(this.opus);
                console.log(this.total_page);

              case 7:
              case "end":
                return _context2.stop();
            }
          }
        }, _callee2, this);
      }));

      function GetOpusAuditList() {
        return _GetOpusAuditList.apply(this, arguments);
      }

      return GetOpusAuditList;
    }()
  }, {
    key: "GetOpusInfo",
    value: function () {
      var _GetOpusInfo = Object(asyncToGenerator["a" /* default */])( /*#__PURE__*/regeneratorRuntime.mark(function _callee3(row) {
        var res;
        return regeneratorRuntime.wrap(function _callee3$(_context3) {
          while (1) {
            switch (_context3.prev = _context3.next) {
              case 0:
                _context3.next = 2;
                return this.opusAuditServiceImpl.OpusInfo({
                  opus_id: row.opus_id
                });

              case 2:
                res = _context3.sent;
                this.OpusInfo = res;
                this.dialogVisible = true;
                console.log(res);

              case 6:
              case "end":
                return _context3.stop();
            }
          }
        }, _callee3, this);
      }));

      function GetOpusInfo(_x) {
        return _GetOpusInfo.apply(this, arguments);
      }

      return GetOpusInfo;
    }()
  }, {
    key: "Approved",
    value: function () {
      var _Approved = Object(asyncToGenerator["a" /* default */])( /*#__PURE__*/regeneratorRuntime.mark(function _callee4(id, status) {
        var res;
        return regeneratorRuntime.wrap(function _callee4$(_context4) {
          while (1) {
            switch (_context4.prev = _context4.next) {
              case 0:
                _context4.next = 2;
                return this.opusAuditServiceImpl.Approved({
                  opus_id: id,
                  opus_status: status
                });

              case 2:
                res = _context4.sent;
                _context4.next = 5;
                return this.GetOpusAuditList();

              case 5:
              case "end":
                return _context4.stop();
            }
          }
        }, _callee4, this);
      }));

      function Approved(_x2, _x3) {
        return _Approved.apply(this, arguments);
      }

      return Approved;
    }()
  }]);

  return OpusAuditLogic;
}(Base_logic["a" /* BaseLogic */]);

Object(tslib_es6["a" /* __decorate */])([Object(Ioc_annotation["a" /* Inject */])(), Object(tslib_es6["b" /* __metadata */])("design:type", typeof (_a = typeof OpusAudit_service_impl["OpusAuditServiceImpl"] !== "undefined" && OpusAudit_service_impl["OpusAuditServiceImpl"]) === "function" ? _a : Object)], OpusAudit_logic_OpusAuditLogic.prototype, "opusAuditServiceImpl", void 0);
// CONCATENATED MODULE: ./src/application/page/index/OpusManage/OpusAudit.tsx




















 //TODO 进入详情 + 审核
//TODO 列表页面分页

var OpusAudit_OpusAudit = /*#__PURE__*/function (_VueType) {
  Object(inherits["a" /* default */])(OpusAudit, _VueType);

  var _super = Object(createSuper["a" /* default */])(OpusAudit);

  function OpusAudit() {
    var _this;

    Object(classCallCheck["a" /* default */])(this, OpusAudit);

    _this = _super.call(this);
    _this.RouterMeta = {
      title: '作品审核',
      isLogin: false
    }; // 抽离组件所有逻辑到独立类，解耦页面和数据

    _this.serve = new OpusAudit_logic_OpusAuditLogic(Object(assertThisInitialized["a" /* default */])(_this));
    return _this;
  }

  Object(createClass["a" /* default */])(OpusAudit, [{
    key: "created",
    value: function () {
      var _created = Object(asyncToGenerator["a" /* default */])( /*#__PURE__*/regeneratorRuntime.mark(function _callee() {
        return regeneratorRuntime.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                this.serve.StartUp();

              case 1:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, this);
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
    key: "OpusInfo",
    value: function OpusInfo() {
      var _this2 = this,
          _this$serve$OpusInfo,
          _this$serve$OpusInfo2,
          _this$serve$OpusInfo3,
          _this$serve$OpusInfo4,
          _this$serve$OpusInfo5,
          _this$serve$OpusInfo6,
          _this$serve$OpusInfo7,
          _this$serve$OpusInfo8,
          _this$serve$OpusInfo9,
          _this$serve$OpusInfo10,
          _this$serve$OpusInfo11,
          _this$serve$OpusInfo12,
          _this$serve$OpusInfo13,
          _this$serve$OpusInfo14,
          _this$serve$OpusInfo15,
          _this$serve$OpusInfo16,
          _this$serve$OpusInfo17,
          _this$serve$OpusInfo18,
          _this$serve$OpusInfo19,
          _this$serve$OpusInfo20,
          _this$serve$OpusInfo21,
          _this$serve$OpusInfo22,
          _this$serve$OpusInfo23,
          _this$serve$OpusInfo24,
          _this$serve$OpusInfo25,
          _this$serve$OpusInfo26,
          _this$serve$OpusInfo27,
          _this$serve$OpusInfo28,
          _this$serve$OpusInfo29,
          _this$serve$OpusInfo30,
          _this$serve$OpusInfo31,
          _this$serve$OpusInfo32,
          _this$serve$OpusInfo33,
          _this$serve$OpusInfo34,
          _this$serve$OpusInfo35,
          _this$serve$OpusInfo36,
          _this$serve$OpusInfo37,
          _this$serve$OpusInfo38,
          _this$serve$OpusInfo39,
          _this$serve$OpusInfo40,
          _this$serve$OpusInfo41,
          _this$serve$OpusInfo42,
          _this$serve$OpusInfo43,
          _this$serve$OpusInfo44,
          _this$serve$OpusInfo45,
          _this$serve$OpusInfo46,
          _this$serve$OpusInfo47,
          _this$serve$OpusInfo48,
          _this$serve$OpusInfo49,
          _this$serve$OpusInfo50,
          _this$serve$OpusInfo51,
          _this$serve$OpusInfo52,
          _this$serve$OpusInfo53;

      var h = this.$createElement;
      return h("el-dialog", helper_default()([{}, {
        scopedSlots: {
          title: function title(data) {
            var _this2$serve$OpusInfo;

            return h("div", {
              "class": "OpusDialog"
            }, [h("h1", ["\u4F5C\u54C1\u3010", (_this2$serve$OpusInfo = _this2.serve.OpusInfo) === null || _this2$serve$OpusInfo === void 0 ? void 0 : _this2$serve$OpusInfo.opus_title, "\u3011\u8BE6\u60C5\uFF1A"])]);
          }
        }
      }, {
        "attrs": {
          "show-close": false,
          "visible": this.serve.dialogVisible,
          "width": "70%"
        }
      }]), [h("div", {
        "class": "info"
      }, [h("div", {
        "class": "info_main"
      }, [h("div", {
        "class": "title"
      }, ["1\uFF1A\u4F5C\u54C1\u4E3B\u6570\u636E"]), h("ul", {
        "class": "list"
      }, [h("li", [h("span", ["\u4F5C\u54C1\u6807\u9898\uFF1A"]), h("div", {
        "class": "content"
      }, [(_this$serve$OpusInfo = this.serve.OpusInfo) === null || _this$serve$OpusInfo === void 0 ? void 0 : _this$serve$OpusInfo.opus_title])]), h("li", [h("span", ["\u4F5C\u54C1\u4ECB\u7ECD\uFF1A"]), h("div", {
        "class": "content"
      }, [(_this$serve$OpusInfo2 = this.serve.OpusInfo) === null || _this$serve$OpusInfo2 === void 0 ? void 0 : _this$serve$OpusInfo2.opus_introduce])]), h("li", [h("span", ["\u53D1\u5E03\u65F6\u95F4\uFF1A"]), h("div", {
        "class": "content"
      }, [(_this$serve$OpusInfo3 = this.serve.OpusInfo) === null || _this$serve$OpusInfo3 === void 0 ? void 0 : _this$serve$OpusInfo3.opus_introduce])]), h("li", [h("span", ["\u70B9\u8D5E\u6570\u91CF\uFF1A"]), h("div", {
        "class": "content"
      }, [(_this$serve$OpusInfo4 = this.serve.OpusInfo) === null || _this$serve$OpusInfo4 === void 0 ? void 0 : _this$serve$OpusInfo4.opus_satisfied])]), h("li", [h("span", ["\u6D4F\u89C8\u6570\u91CF\uFF1A"]), h("div", {
        "class": "content"
      }, [(_this$serve$OpusInfo5 = this.serve.OpusInfo) === null || _this$serve$OpusInfo5 === void 0 ? void 0 : _this$serve$OpusInfo5.opus_see])]), h("li", [h("span", ["\u5173\u6CE8\u6570\u91CF\uFF1A"]), h("div", {
        "class": "content"
      }, [(_this$serve$OpusInfo6 = this.serve.OpusInfo) === null || _this$serve$OpusInfo6 === void 0 ? void 0 : _this$serve$OpusInfo6.opus_follow])]), h("li", [h("span", ["\u6536\u85CF\u6570\u91CF\uFF1A"]), h("div", {
        "class": "content"
      }, [(_this$serve$OpusInfo7 = this.serve.OpusInfo) === null || _this$serve$OpusInfo7 === void 0 ? void 0 : _this$serve$OpusInfo7.opus_collection])]), h("li", [h("span", ["\u4F5C\u54C1\u4E3B\u56FE\uFF1A"]), h("div", {
        "class": "content"
      }, [h("el-image", {
        "style": "width: 50px;height: 50px; ",
        "attrs": {
          "src": (_this$serve$OpusInfo8 = this.serve.OpusInfo) === null || _this$serve$OpusInfo8 === void 0 ? void 0 : _this$serve$OpusInfo8.opus_img,
          "preview-src-list": [(_this$serve$OpusInfo9 = this.serve.OpusInfo) === null || _this$serve$OpusInfo9 === void 0 ? void 0 : _this$serve$OpusInfo9.opus_img]
        }
      })])]), h("li", [h("span", ["\u5BA1\u6838\u72B6\u6001\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo10 = this.serve.OpusInfo) === null || _this$serve$OpusInfo10 === void 0 ? void 0 : _this$serve$OpusInfo10.opus_status) == 0 ? '等待审核' : ((_this$serve$OpusInfo11 = this.serve.OpusInfo) === null || _this$serve$OpusInfo11 === void 0 ? void 0 : _this$serve$OpusInfo11.opus_status) - 1 ? '审核驳回' : '审核通过'])]), h("li", [h("span", ["\u4F5C\u54C1\u5206\u7C7B\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo12 = this.serve.OpusInfo) === null || _this$serve$OpusInfo12 === void 0 ? void 0 : _this$serve$OpusInfo12.opus_type) == 1 ? '推荐' : ((_this$serve$OpusInfo13 = this.serve.OpusInfo) === null || _this$serve$OpusInfo13 === void 0 ? void 0 : _this$serve$OpusInfo13.opus_type) == 2 ? '排行' : '关注'])]), h("li", [h("span", ["\u662F\u5426\u539F\u521B\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo14 = this.serve.OpusInfo) === null || _this$serve$OpusInfo14 === void 0 ? void 0 : _this$serve$OpusInfo14.opus_original) == 1 ? '原创' : '非原创'])]), h("li", [h("span", ["\u516C\u5F00\u8303\u56F4\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo15 = this.serve.OpusInfo) === null || _this$serve$OpusInfo15 === void 0 ? void 0 : _this$serve$OpusInfo15.opus_jurisdiction) == 1 ? '所有人' : ((_this$serve$OpusInfo16 = this.serve.OpusInfo) === null || _this$serve$OpusInfo16 === void 0 ? void 0 : _this$serve$OpusInfo16.opus_jurisdiction) == 2 ? '好友' : '不公开'])]), h("li", [h("span", ["\u5141\u8BB8\u7F16\u8F91\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo17 = this.serve.OpusInfo) === null || _this$serve$OpusInfo17 === void 0 ? void 0 : _this$serve$OpusInfo17.opus_is_edit) == 1 ? '开启编辑' : '关闭编辑'])])])]), h("div", {
        "class": "info_main"
      }, [h("div", {
        "class": "title"
      }, ["2\uFF1A\u4F5C\u54C1\u56FE\u96C6"]), h("div", {
        "class": "list"
      }, [((_this$serve$OpusInfo18 = this.serve.OpusInfo) === null || _this$serve$OpusInfo18 === void 0 ? void 0 : _this$serve$OpusInfo18.opus_imgs.length) == 0 ? '暂无图片' : (_this$serve$OpusInfo19 = this.serve.OpusInfo) === null || _this$serve$OpusInfo19 === void 0 ? void 0 : _this$serve$OpusInfo19.opus_imgs.map(function (v, i) {
        var _this2$serve$OpusInfo2;

        return h("el-image", {
          "style": "width: 50px;margin-right: 10px",
          "attrs": {
            "src": v.img_url,
            "preview-src-list": (_this2$serve$OpusInfo2 = _this2.serve.OpusInfo) === null || _this2$serve$OpusInfo2 === void 0 ? void 0 : _this2$serve$OpusInfo2.opus_imgs.map(function (v) {
              return v.img_url;
            })
          }
        });
      })])]), h("div", {
        "class": "info_main"
      }, [h("div", {
        "class": "title"
      }, ["3\uFF1A\u7528\u6237\u4FE1\u606F"]), h("ul", {
        "class": "list"
      }, [h("li", [h("span", ["\u7528\u6237\u7F16\u53F7\uFF1A"]), h("div", {
        "class": "content"
      }, [(_this$serve$OpusInfo20 = this.serve.OpusInfo) === null || _this$serve$OpusInfo20 === void 0 ? void 0 : (_this$serve$OpusInfo21 = _this$serve$OpusInfo20.user_info) === null || _this$serve$OpusInfo21 === void 0 ? void 0 : _this$serve$OpusInfo21.user_id])]), h("li", [h("span", ["\u771F\u5B9E\u59D3\u540D\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo22 = this.serve.OpusInfo) === null || _this$serve$OpusInfo22 === void 0 ? void 0 : (_this$serve$OpusInfo23 = _this$serve$OpusInfo22.user_info) === null || _this$serve$OpusInfo23 === void 0 ? void 0 : _this$serve$OpusInfo23.user_real_name) || '用户未填写'])]), h("li", [h("span", ["\u7528\u6237\u6635\u79F0\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo24 = this.serve.OpusInfo) === null || _this$serve$OpusInfo24 === void 0 ? void 0 : (_this$serve$OpusInfo25 = _this$serve$OpusInfo24.user_info) === null || _this$serve$OpusInfo25 === void 0 ? void 0 : _this$serve$OpusInfo25.user_nickname) || '用户未填写'])]), h("li", [h("span", ["\u7528\u6237\u6027\u522B\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo26 = this.serve.OpusInfo) === null || _this$serve$OpusInfo26 === void 0 ? void 0 : (_this$serve$OpusInfo27 = _this$serve$OpusInfo26.user_info) === null || _this$serve$OpusInfo27 === void 0 ? void 0 : _this$serve$OpusInfo27.user_sex) || '用户未填写'])]), h("li", [h("span", ["\u7528\u6237\u624B\u673A\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo28 = this.serve.OpusInfo) === null || _this$serve$OpusInfo28 === void 0 ? void 0 : (_this$serve$OpusInfo29 = _this$serve$OpusInfo28.user_info) === null || _this$serve$OpusInfo29 === void 0 ? void 0 : _this$serve$OpusInfo29.user_phone) || '用户未填写'])]), h("li", [h("span", ["\u8EAB\u4EFD\u8BC1\u53F7\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo30 = this.serve.OpusInfo) === null || _this$serve$OpusInfo30 === void 0 ? void 0 : (_this$serve$OpusInfo31 = _this$serve$OpusInfo30.user_info) === null || _this$serve$OpusInfo31 === void 0 ? void 0 : _this$serve$OpusInfo31.user_id_card) || '用户未填写'])]), h("li", [h("span", ["\u7528\u6237\u90AE\u7BB1\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo32 = this.serve.OpusInfo) === null || _this$serve$OpusInfo32 === void 0 ? void 0 : (_this$serve$OpusInfo33 = _this$serve$OpusInfo32.user_info) === null || _this$serve$OpusInfo33 === void 0 ? void 0 : _this$serve$OpusInfo33.user_email) || '用户未填写'])]), h("li", [h("span", ["\u94F6\u884C\u5361\u53F7\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo34 = this.serve.OpusInfo) === null || _this$serve$OpusInfo34 === void 0 ? void 0 : (_this$serve$OpusInfo35 = _this$serve$OpusInfo34.user_info) === null || _this$serve$OpusInfo35 === void 0 ? void 0 : _this$serve$OpusInfo35.user_bank_card) || '用户未填写'])]), h("li", [h("span", ["\u5174\u8DA3\u7231\u597D\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo36 = this.serve.OpusInfo) === null || _this$serve$OpusInfo36 === void 0 ? void 0 : (_this$serve$OpusInfo37 = _this$serve$OpusInfo36.user_info) === null || _this$serve$OpusInfo37 === void 0 ? void 0 : _this$serve$OpusInfo37.user_work) || '用户未填写'])]), h("li", [h("span", ["\u5934\u50CF\u5730\u5740\uFF1A"]), h("div", {
        "class": "content"
      }, [h("el-image", {
        "style": "width: 50px; height: 50px",
        "attrs": {
          "src": (_this$serve$OpusInfo38 = this.serve.OpusInfo) === null || _this$serve$OpusInfo38 === void 0 ? void 0 : (_this$serve$OpusInfo39 = _this$serve$OpusInfo38.user_info) === null || _this$serve$OpusInfo39 === void 0 ? void 0 : _this$serve$OpusInfo39.user_head_img,
          "preview-src-list": [(_this$serve$OpusInfo40 = this.serve.OpusInfo) === null || _this$serve$OpusInfo40 === void 0 ? void 0 : (_this$serve$OpusInfo41 = _this$serve$OpusInfo40.user_info) === null || _this$serve$OpusInfo41 === void 0 ? void 0 : _this$serve$OpusInfo41.user_head_img]
        }
      })])]), h("li", [h("span", ["\u552F\u4E00uid\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo42 = this.serve.OpusInfo) === null || _this$serve$OpusInfo42 === void 0 ? void 0 : (_this$serve$OpusInfo43 = _this$serve$OpusInfo42.user_info) === null || _this$serve$OpusInfo43 === void 0 ? void 0 : _this$serve$OpusInfo43.user_uid.substring(0, 10)) + '..' || false])]), h("li", [h("span", ["\u6CE8\u518C\u65F6\u95F4\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo44 = this.serve.OpusInfo) === null || _this$serve$OpusInfo44 === void 0 ? void 0 : (_this$serve$OpusInfo45 = _this$serve$OpusInfo44.user_info) === null || _this$serve$OpusInfo45 === void 0 ? void 0 : _this$serve$OpusInfo45.user_reg_time.substring(0, 19)) || '用户未填写'])]), h("li", [h("span", ["\u7528\u6237\u751F\u65E5\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo46 = this.serve.OpusInfo) === null || _this$serve$OpusInfo46 === void 0 ? void 0 : (_this$serve$OpusInfo47 = _this$serve$OpusInfo46.user_info) === null || _this$serve$OpusInfo47 === void 0 ? void 0 : _this$serve$OpusInfo47.user_birthday) || '用户未填写'])]), h("li", [h("span", ["\u7528\u6237\u661F\u5EA7\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo48 = this.serve.OpusInfo) === null || _this$serve$OpusInfo48 === void 0 ? void 0 : (_this$serve$OpusInfo49 = _this$serve$OpusInfo48.user_info) === null || _this$serve$OpusInfo49 === void 0 ? void 0 : _this$serve$OpusInfo49.user_constellation) || '用户未填写'])]), h("li", [h("span", ["\u4E2A\u4EBA\u7B7E\u540D\uFF1A"]), h("div", {
        "class": "content"
      }, [((_this$serve$OpusInfo50 = this.serve.OpusInfo) === null || _this$serve$OpusInfo50 === void 0 ? void 0 : (_this$serve$OpusInfo51 = _this$serve$OpusInfo50.user_info) === null || _this$serve$OpusInfo51 === void 0 ? void 0 : _this$serve$OpusInfo51.user_autograph) || '用户未填写'])])])]), h("div", {
        "class": "info_main"
      }, [h("div", {
        "class": "title"
      }, ["4\uFF1A\u4F5C\u54C1\u6807\u7B7E"]), h("div", {
        "class": "list"
      }, [((_this$serve$OpusInfo52 = this.serve.OpusInfo) === null || _this$serve$OpusInfo52 === void 0 ? void 0 : _this$serve$OpusInfo52.tags.length) == 0 ? '暂无数据' : (_this$serve$OpusInfo53 = this.serve.OpusInfo) === null || _this$serve$OpusInfo53 === void 0 ? void 0 : _this$serve$OpusInfo53.tags.map(function (v, i) {
        return h("el-tag", {
          "style": "margin-right: 10px;",
          "attrs": {
            "effect": "plain"
          }
        }, [v.tags_title]);
      })])])]), h("span", {
        "slot": "footer",
        "class": "dialog-footer"
      }, [h("el-button", {
        "attrs": {
          "type": "primary"
        },
        "on": {
          "click": function click() {
            _this2.serve.dialogVisible = false;
          }
        }
      }, ["\u786E \u5B9A"])])]);
    }
  }, {
    key: "InfoLink",
    value: function InfoLink(row) {
      var _this3 = this;

      var h = this.$createElement;
      return h("el-tag", {
        "attrs": {
          "effect": "plain",
          "type": "info"
        },
        "style": {
          marginLeft: '5px'
        },
        "on": {
          "click": /*#__PURE__*/Object(asyncToGenerator["a" /* default */])( /*#__PURE__*/regeneratorRuntime.mark(function _callee2() {
            return regeneratorRuntime.wrap(function _callee2$(_context2) {
              while (1) {
                switch (_context2.prev = _context2.next) {
                  case 0:
                    _context2.next = 2;
                    return _this3.serve.GetOpusInfo(row);

                  case 2:
                    return _context2.abrupt("return", _context2.sent);

                  case 3:
                  case "end":
                    return _context2.stop();
                }
              }
            }, _callee2);
          }))
        }
      }, ["\u67E5\u770B\u8BE6\u60C5"]);
    }
  }, {
    key: "render",
    value: function render() {
      var _this4 = this;

      var h = arguments[0];
      return h("div", {
        "class": "OpusAudit"
      }, [this.OpusInfo(), h(PageHeader["a" /* default */], {
        "attrs": {
          "title": "作品审核",
          "subtitle": "对用户发布的作品进行审核管理"
        }
      }), h("el-form", {
        "attrs": {
          "inline": true
        },
        "on": {
          "input": function input() {}
        },
        "model": this.serve.filter,
        "class": "demo-form-inline"
      }, [h("el-form-item", {
        "attrs": {
          "label": "作品标题"
        }
      }, [h("el-input", {
        "attrs": {
          "clearable": true,
          "placeholder": "作品标题"
        },
        "model": {
          value: _this4.serve.filter.opus_title,
          callback: function callback($$v) {
            _this4.$set(_this4.serve.filter, "opus_title", $$v);
          }
        }
      })]), h("el-form-item", {
        "attrs": {
          "label": "作品状态"
        }
      }, [h("el-select", {
        "attrs": {
          "clearable": true,
          "placeholder": "请选择作品状态"
        },
        "on": {
          "change": function change() {
            return _this4.serve.page = 1;
          }
        },
        "model": {
          value: _this4.serve.filter.opus_status,
          callback: function callback($$v) {
            _this4.$set(_this4.serve.filter, "opus_status", $$v);
          }
        }
      }, [h("el-option", {
        "attrs": {
          "label": "等待审核",
          "value": "0"
        }
      }), h("el-option", {
        "attrs": {
          "label": "审核驳回",
          "value": "-1"
        }
      }), h("el-option", {
        "attrs": {
          "label": "审核通过",
          "value": "1"
        }
      })])]), h("el-form-item", {
        "attrs": {
          "label": "作品分类"
        }
      }, [h("el-select", {
        "attrs": {
          "clearable": true,
          "placeholder": "请选择作品分类"
        },
        "on": {
          "change": function change() {
            return _this4.serve.page = 1;
          }
        },
        "model": {
          value: _this4.serve.filter.opus_type,
          callback: function callback($$v) {
            _this4.$set(_this4.serve.filter, "opus_type", $$v);
          }
        }
      }, [h("el-option", {
        "attrs": {
          "label": "推荐",
          "value": "1"
        }
      }), h("el-option", {
        "attrs": {
          "label": "排行",
          "value": "2"
        }
      }), h("el-option", {
        "attrs": {
          "label": "关注",
          "value": "3"
        }
      })])]), h("el-form-item", {
        "attrs": {
          "label": "作品原创"
        }
      }, [h("el-select", {
        "attrs": {
          "clearable": true,
          "placeholder": "请选择作品原创"
        },
        "on": {
          "change": function change() {
            return _this4.serve.page = 1;
          }
        },
        "model": {
          value: _this4.serve.filter.opus_original,
          callback: function callback($$v) {
            _this4.$set(_this4.serve.filter, "opus_original", $$v);
          }
        }
      }, [h("el-option", {
        "attrs": {
          "label": "原创",
          "value": "1"
        }
      }), h("el-option", {
        "attrs": {
          "label": "非原创",
          "value": "0"
        }
      })])]), h("el-form-item", [h("el-button", {
        "attrs": {
          "type": "primary"
        },
        "on": {
          "click": function click() {
            return _this4.serve.GetOpusAuditList();
          }
        }
      }, ["\u67E5\u8BE2"])])]), h("el-table", {
        "attrs": {
          "data": this.serve.opus,
          "border": true,
          "stripe": true,
          "default-sort": {
            prop: 'opus_id',
            order: 'ascending'
          }
        },
        "style": "width: 100%"
      }, [h("el-table-column", helper_default()([{
        "attrs": {
          "fixed": "left",
          "label": "操作",
          "width": "280"
        }
      }, {
        scopedSlots: {
          default: function _default(data) {
            switch (data.row.opus_status) {
              case 0:
                return h("span", [h("el-tag", {
                  "style": {
                    marginRight: '5px'
                  },
                  "attrs": {
                    "effect": "dark",
                    "type": "success"
                  },
                  "on": {
                    "click": /*#__PURE__*/Object(asyncToGenerator["a" /* default */])( /*#__PURE__*/regeneratorRuntime.mark(function _callee3() {
                      return regeneratorRuntime.wrap(function _callee3$(_context3) {
                        while (1) {
                          switch (_context3.prev = _context3.next) {
                            case 0:
                              _context3.next = 2;
                              return _this4.serve.Approved(data.row.opus_id, 1);

                            case 2:
                            case "end":
                              return _context3.stop();
                          }
                        }
                      }, _callee3);
                    }))
                  }
                }, ["\u901A\u8FC7\u5BA1\u6838"]), h("el-tag", {
                  "attrs": {
                    "effect": "dark",
                    "type": "danger"
                  },
                  "on": {
                    "click": /*#__PURE__*/Object(asyncToGenerator["a" /* default */])( /*#__PURE__*/regeneratorRuntime.mark(function _callee4() {
                      return regeneratorRuntime.wrap(function _callee4$(_context4) {
                        while (1) {
                          switch (_context4.prev = _context4.next) {
                            case 0:
                              _context4.next = 2;
                              return _this4.serve.Approved(data.row.opus_id, -1);

                            case 2:
                            case "end":
                              return _context4.stop();
                          }
                        }
                      }, _callee4);
                    }))
                  }
                }, ["\u62D2\u7EDD\u901A\u8FC7"]), _this4.InfoLink(data.row)]);
                break;

              case -1:
                return _this4.InfoLink(data.row);
                break;

              case 1:
                return _this4.InfoLink(data.row);
                break;
            }
          }
        }
      }])), h("el-table-column", helper_default()([{}, {
        scopedSlots: {
          default: function _default(data) {
            switch (data.row.opus_status) {
              case 0:
                return h("el-tag", {
                  "attrs": {
                    "type": "info"
                  }
                }, [h("i", {
                  "class": "el-icon-time",
                  "style": "margin-right: 5px"
                }), "\u7B49\u5F85\u5BA1\u6838"]);
                break;

              case -1:
                return h("el-tag", {
                  "attrs": {
                    "type": "danger"
                  }
                }, [h("i", {
                  "class": "el-icon-circle-close",
                  "style": "margin-right: 5px"
                }), "\u5BA1\u6838\u9A73\u56DE"]);
                break;

              case 1:
                return h("el-tag", {
                  "attrs": {
                    "type": "success"
                  }
                }, [h("i", {
                  "class": "el-icon-circle-check",
                  "style": "margin-right: 5px"
                }), "\u901A\u8FC7\u5BA1\u6838"]);
                break;
            }
          }
        }
      }, {
        "attrs": {
          "width": "120",
          "label": "审核状态"
        }
      }])), h("el-table-column", {
        "attrs": {
          "prop": "opus_id",
          "sortable": true,
          "label": "编号"
        }
      }), h("el-table-column", {
        "attrs": {
          "prop": "opus_title",
          "label": "标题",
          "width": "180"
        }
      }), h("el-table-column", {
        "attrs": {
          "prop": "opus_introduce",
          "label": "介绍"
        }
      }), h("el-table-column", helper_default()([{}, {
        scopedSlots: {
          default: function _default(data) {
            return h("el-image", {
              "on": {
                "click": function click() {
                  console.log(data.row.opus_img);
                }
              },
              "attrs": {
                "width": "100%",
                "preview-src-list": [data.row.opus_img],
                "src": data.row.opus_img,
                "alt": ""
              }
            });
          }
        }
      }, {
        "attrs": {
          "label": "封面图"
        }
      }])), h("el-table-column", {
        "attrs": {
          "prop": "opus_time",
          "label": "发布时间"
        }
      }), h("el-table-column", helper_default()([{}, {
        scopedSlots: {
          default: function _default(data) {
            return h("span", [data.row.opus_type == 1 ? '推荐' : data.row.opus_type == 2 ? '排行' : '关注']);
          }
        }
      }, {
        "attrs": {
          "label": "作品分类"
        }
      }])), h("el-table-column", helper_default()([{
        "attrs": {
          "prop": "opus_original"
        }
      }, {
        scopedSlots: {
          default: function _default(data) {
            return h("el-tag", {
              "attrs": {
                "type": data.row.opus_original ? "success" : "danger"
              }
            }, [data.row.opus_original == 1 ? '原创' : '非原创']);
          }
        }
      }, {
        "attrs": {
          "label": "是否原创"
        }
      }])), h("el-table-column", {
        "attrs": {
          "prop": "opus_see",
          "sortable": true,
          "label": "浏览量"
        }
      }), h("el-table-column", {
        "attrs": {
          "prop": "opus_follow",
          "sortable": true,
          "label": "关注数量"
        }
      }), h("el-table-column", {
        "attrs": {
          "prop": "opus_collection",
          "sortable": true,
          "label": "收藏数量"
        }
      }), h("el-table-column", {
        "attrs": {
          "prop": "opus_satisfied",
          "sortable": true,
          "label": "点赞数量"
        }
      })]), h("br"), h("el-pagination", {
        "attrs": {
          "background": true,
          "layout": "prev, pager, next",
          "page-size": this.serve.count,
          "current-page": this.serve.page,
          "page-count": this.serve.total_page
        },
        "on": {
          "current-change": function currentChange(page) {
            _this4.serve.page = page;

            _this4.serve.GetOpusAuditList();
          }
        }
      })]);
    }
  }]);

  return OpusAudit;
}(base_layout["a" /* VueType */]);

OpusAudit_OpusAudit = Object(tslib_es6["a" /* __decorate */])([vue_property_decorator["a" /* Component */], Object(tslib_es6["b" /* __metadata */])("design:paramtypes", [])], OpusAudit_OpusAudit);
/* harmony default export */ var OpusManage_OpusAudit = __webpack_exports__["default"] = (OpusAudit_OpusAudit);

/***/ }),

/***/ "463b":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BaseLogic; });
/* harmony import */ var regenerator_runtime_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__("96cf");
/* harmony import */ var regenerator_runtime_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(regenerator_runtime_runtime__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__("1da1");
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__("d4ec");
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__("bee2");
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__("9ab4");
/* harmony import */ var _ann_Ioc_annotation__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__("4771");
/* harmony import */ var _impl_User_service_impl__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__("32f6");





/*
 * Copyright (c) 2020. bmy
 */
var _a;




/**
 * logic 层的父类
 * 主要实现 页面公共参数和ajax方法的地方
 */

var BaseLogic = /*#__PURE__*/function () {
  function BaseLogic() {
    Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__[/* default */ "a"])(this, BaseLogic);

    this.page = 1;
    this.total_page = 1;
    this.count = 10; // 请求参数

    this.PageParams = {
      limit: 10,
      page: 1
    };
  }
  /**
   * 【页面中公共的多次被用到的接口】可以在这个父类中定义，
   * 子类logic中直接使用，避免方法的冗余
   * @constructor
   */


  Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__[/* default */ "a"])(BaseLogic, [{
    key: "DepartmentListRequest",
    value: function () {
      var _DepartmentListRequest = Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__[/* default */ "a"])( /*#__PURE__*/regeneratorRuntime.mark(function _callee() {
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

      function DepartmentListRequest() {
        return _DepartmentListRequest.apply(this, arguments);
      }

      return DepartmentListRequest;
    }()
  }]);

  return BaseLogic;
}();

Object(tslib__WEBPACK_IMPORTED_MODULE_4__[/* __decorate */ "a"])([Object(_ann_Ioc_annotation__WEBPACK_IMPORTED_MODULE_5__[/* Inject */ "a"])(), Object(tslib__WEBPACK_IMPORTED_MODULE_4__[/* __metadata */ "b"])("design:type", typeof (_a = typeof _impl_User_service_impl__WEBPACK_IMPORTED_MODULE_6__["UserServiceImpl"] !== "undefined" && _impl_User_service_impl__WEBPACK_IMPORTED_MODULE_6__["UserServiceImpl"]) === "function" ? _a : Object)], BaseLogic.prototype, "UserServiceImpl", void 0);

/***/ }),

/***/ "d81d":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var $ = __webpack_require__("23e7");
var $map = __webpack_require__("b727").map;
var arrayMethodHasSpeciesSupport = __webpack_require__("1dde");
var arrayMethodUsesToLength = __webpack_require__("ae40");

var HAS_SPECIES_SUPPORT = arrayMethodHasSpeciesSupport('map');
// FF49- issue
var USES_TO_LENGTH = arrayMethodUsesToLength('map');

// `Array.prototype.map` method
// https://tc39.github.io/ecma262/#sec-array.prototype.map
// with adding support of @@species
$({ target: 'Array', proto: true, forced: !HAS_SPECIES_SUPPORT || !USES_TO_LENGTH }, {
  map: function map(callbackfn /* , thisArg */) {
    return $map(this, callbackfn, arguments.length > 1 ? arguments[1] : undefined);
  }
});


/***/ }),

/***/ "e226":
/***/ (function(module, exports, __webpack_require__) {

// extracted by mini-css-extract-plugin

/***/ }),

/***/ "e294":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__("d4ec");
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__("bee2");
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__("262e");
/* harmony import */ var _Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createSuper__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__("2caf");
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__("9ab4");
/* harmony import */ var vue_property_decorator__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__("60a3");
/* harmony import */ var _componentsLess_PageHeader_less__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__("27b4");
/* harmony import */ var _componentsLess_PageHeader_less__WEBPACK_IMPORTED_MODULE_6___default = /*#__PURE__*/__webpack_require__.n(_componentsLess_PageHeader_less__WEBPACK_IMPORTED_MODULE_6__);





/*
 * Copyright (c) 2021. bmy
 * Email：2271608011@qq.com
 * Github：https://github.com/helpcode
 */




var PageHeader = /*#__PURE__*/function (_Vue) {
  Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_2__[/* default */ "a"])(PageHeader, _Vue);

  var _super = Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createSuper__WEBPACK_IMPORTED_MODULE_3__[/* default */ "a"])(PageHeader);

  function PageHeader() {
    Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])(this, PageHeader);

    return _super.apply(this, arguments);
  }

  Object(_Users_bmy_Desktop_TsxVueClassApi_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__[/* default */ "a"])(PageHeader, [{
    key: "mounted",
    value: function mounted() {}
  }, {
    key: "render",
    value: function render() {
      var h = arguments[0];
      return h("div", {
        "class": "page_header"
      }, [h("i", {
        "class": "el-icon-back"
      }), h("h1", [this.title]), h("span", [this.subtitle])]);
    }
  }]);

  return PageHeader;
}(vue_property_decorator__WEBPACK_IMPORTED_MODULE_5__[/* Vue */ "c"]);

Object(tslib__WEBPACK_IMPORTED_MODULE_4__[/* __decorate */ "a"])([Object(vue_property_decorator__WEBPACK_IMPORTED_MODULE_5__[/* Prop */ "b"])({
  default: ''
}), Object(tslib__WEBPACK_IMPORTED_MODULE_4__[/* __metadata */ "b"])("design:type", String)], PageHeader.prototype, "title", void 0);

Object(tslib__WEBPACK_IMPORTED_MODULE_4__[/* __decorate */ "a"])([Object(vue_property_decorator__WEBPACK_IMPORTED_MODULE_5__[/* Prop */ "b"])({
  default: ''
}), Object(tslib__WEBPACK_IMPORTED_MODULE_4__[/* __metadata */ "b"])("design:type", String)], PageHeader.prototype, "subtitle", void 0);

PageHeader = Object(tslib__WEBPACK_IMPORTED_MODULE_4__[/* __decorate */ "a"])([vue_property_decorator__WEBPACK_IMPORTED_MODULE_5__[/* Component */ "a"]], PageHeader);
/* harmony default export */ __webpack_exports__["a"] = (PageHeader);

/***/ })

}]);