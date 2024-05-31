webpackJsonp([36],{VMCT:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l=a("mvHQ"),i=a.n(l),n=a("woOf"),s=a.n(n),r=a("vLgD");var o=a("xT6B"),u={pageNum:1,pageSize:10,startTimeStr:null,endTimeStr:null,startTime:null,endTimeTime:null,isCheck:null},c=[{label:"全场赠券",value:0},{label:"会员赠券",value:1},{label:"购物赠券",value:2},{label:"注册赠券",value:3}],d={name:"cloakRequestLogList",data:function(){return{listQuery:s()({},u),typeOptions:s()({},c),list:null,total:null,listLoading:!1,multipleSelection:[],dialogVisible:!1,formattedHeaderInfo:""}},created:function(){this.getList()},filters:{formatType:function(t){for(var e=0;e<c.length;e++)if(t===c[e].value)return c[e].label;return""},formatUseType:function(t){return 0===t?"全场通用":1===t?"指定分类":"指定商品"},formatPlatform:function(t){return 1===t?"移动平台":2===t?"PC平台":"全平台"},formatBoolean:function(t){return t?"是":"否"},formatDate:function(t){if(null==t||""===t)return"N/A";var e=new Date(t);return Object(o.a)(e,"yyyy-MM-dd hh:mm:ss")},formatStatus:function(t){var e=(new Date).getTime();return new Date(t)>e?"未过期":"已过期"}},methods:{handleResetSearch:function(){this.listQuery=s()({},u)},handleSearchList:function(){this.listQuery.pageNum=1,this.getList()},handleSelectionChange:function(t){this.multipleSelection=t},handleSizeChange:function(t){this.listQuery.pageNum=1,this.listQuery.pageSize=t,this.getList()},handleCurrentChange:function(t){this.listQuery.pageNum=t,this.getList()},showHeaderInfo:function(t){var e=t;try{for(;"string"==typeof e;)e=JSON.parse(e)}catch(t){return console.error("Failed to parse header info:",t),this.formattedHeaderInfo="Invalid JSON format",void(this.dialogVisible=!0)}this.formattedHeaderInfo=i()(e,null,2),this.dialogVisible=!0},getList:function(){var t,e=this;this.listLoading=!0,this.listQuery.startTime=this.listQuery.startTimeStr?new Date(this.listQuery.startTimeStr).getTime():null,this.listQuery.endTime=this.listQuery.endTimeStr?new Date(this.listQuery.endTimeStr).getTime():null,(t=this.listQuery,Object(r.a)({url:"/requestLogs/list",method:"get",params:t})).then(function(t){e.listLoading=!1,e.list=t.data.records,e.total=t.data.total})}}},f={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-card",{staticClass:"filter-container",attrs:{shadow:"never"}},[a("div",[a("i",{staticClass:"el-icon-search"}),t._v(" "),a("span",[t._v("筛选搜索")]),t._v(" "),a("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",size:"small"},on:{click:function(e){t.handleSearchList()}}},[t._v("\n        查询搜索\n      ")]),t._v(" "),a("el-button",{staticStyle:{float:"right","margin-right":"15px"},attrs:{size:"small"},on:{click:function(e){t.handleResetSearch()}}},[t._v("\n        重置\n      ")])],1),t._v(" "),a("div",{staticStyle:{"margin-top":"15px"}},[a("el-form",{attrs:{inline:!0,model:t.listQuery,size:"small","label-width":"140px"}},[a("el-form-item",{attrs:{label:"开始时间："}},[a("el-date-picker",{staticClass:"input-width",attrs:{"value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime",placeholder:"请选择时间"},model:{value:t.listQuery.startTimeStr,callback:function(e){t.$set(t.listQuery,"startTimeStr",e)},expression:"listQuery.startTimeStr"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"结束时间："}},[a("el-date-picker",{staticClass:"input-width",attrs:{"value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime",placeholder:"请选择时间"},model:{value:t.listQuery.endTimeStr,callback:function(e){t.$set(t.listQuery,"endTimeStr",e)},expression:"listQuery.endTimeStr"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"域名："}},[a("el-input",{staticClass:"input-width",attrs:{placeholder:"请求的域名"},model:{value:t.listQuery.domainName,callback:function(e){t.$set(t.listQuery,"domainName",e)},expression:"listQuery.domainName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"是否审核中："}},[a("el-select",{staticClass:"input-width",attrs:{placeholder:"请选择"},model:{value:t.listQuery.isCheck,callback:function(e){t.$set(t.listQuery,"isCheck",e)},expression:"listQuery.isCheck"}},[a("el-option",{attrs:{label:"是",value:"true"}}),t._v(" "),a("el-option",{attrs:{label:"否",value:"false"}})],1)],1)],1)],1)]),t._v(" "),a("el-card",{staticClass:"operate-container",attrs:{shadow:"never"}},[a("i",{staticClass:"el-icon-tickets"}),t._v(" "),a("span",[t._v("数据列表")])]),t._v(" "),a("div",{staticClass:"table-container"},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],ref:"couponTable",staticStyle:{width:"100%"},attrs:{data:t.list,border:""},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"60",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{label:"请求的域名",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.domainName))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"请求IP",align:"center",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.requestIp))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"IP所属地区",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.ipRegion))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"UA",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.userAgent))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"是否审核中",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(t._f("formatBoolean")(e.row.checkStatus)))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"请求时间",width:"180",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(t._f("formatDate")(e.row.createTime)))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"请求头信息",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"primary"},on:{click:function(a){t.showHeaderInfo(e.row.headerInfo)}}},[t._v("查看")])]}}])})],1),t._v(" "),a("el-dialog",{attrs:{visible:t.dialogVisible,title:"请求头信息"},on:{"update:visible":function(e){t.dialogVisible=e}}},[a("pre",{staticClass:"formatted-json"},[t._v(t._s(t.formattedHeaderInfo))]),t._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogVisible=!1}}},[t._v("关闭")])],1)])],1),t._v(" "),a("div",{staticClass:"pagination-container"},[a("el-pagination",{attrs:{background:"",layout:"total, sizes,prev, pager, next,jumper","current-page":t.listQuery.pageNum,"page-size":t.listQuery.pageSize,"page-sizes":[5,10,15],total:t.total},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.listQuery,"pageNum",e)}}})],1)],1)},staticRenderFns:[]};var m=a("VU/8")(d,f,!1,function(t){a("x+Y7")},"data-v-6b055af8",null);e.default=m.exports},"x+Y7":function(t,e){}});
//# sourceMappingURL=36.81b62e125d0ffb7bac87.js.map