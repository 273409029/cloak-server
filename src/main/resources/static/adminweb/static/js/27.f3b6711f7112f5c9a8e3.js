webpackJsonp([27],{"2V3i":function(t,e){},"2aLV":function(t,e,s){"use strict";e.c=function(t){return Object(n.a)({url:"/flashSession/list",method:"get",params:t})},e.d=function(t){return Object(n.a)({url:"/flashSession/selectList",method:"get",params:t})},e.f=function(t,e){return Object(n.a)({url:"/flashSession/update/status/"+t,method:"post",params:e})},e.b=function(t){return Object(n.a)({url:"/flashSession/delete/"+t,method:"post"})},e.a=function(t){return Object(n.a)({url:"/flashSession/create",method:"post",data:t})},e.e=function(t,e){return Object(n.a)({url:"/flashSession/update/"+t,method:"post",data:e})};var n=s("vLgD")},A7Ya:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=s("woOf"),a=s.n(n),i=s("2aLV"),l=s("xT6B"),o={name:null,startTime:null,endTime:null,status:0},r={name:"flashPromotionSessionList",data:function(){return{list:null,listLoading:!1,dialogVisible:!1,isEdit:!1,flashSession:a()({},o)}},created:function(){this.getList()},filters:{formatTime:function(t){if(null==t||""===t)return"N/A";var e=new Date(t);return Object(l.a)(e,"hh:mm:ss")}},methods:{handleAdd:function(){this.dialogVisible=!0,this.isEdit=!1,this.flashSession=a()({},o)},handleStatusChange:function(t,e){var s=this;this.$confirm("是否要修改该状态?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(i.f)(e.id,{status:e.status}).then(function(t){s.$message({type:"success",message:"修改成功!"})})}).catch(function(){s.$message({type:"info",message:"取消修改"}),s.getList()})},handleUpdate:function(t,e){this.dialogVisible=!0,this.isEdit=!0,this.flashSession=a()({},e),this.flashSession.startTime=new Date(e.startTime),this.flashSession.endTime=new Date(e.endTime)},handleDelete:function(t,e){var s=this;this.$confirm("是否要删除该时间段?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(i.b)(e.id).then(function(t){s.$message({type:"success",message:"删除成功!"}),s.getList()})})},handleDialogConfirm:function(){var t=this;this.$confirm("是否要确认?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.isEdit?Object(i.e)(t.flashSession.id,t.flashSession).then(function(e){t.$message({message:"修改成功！",type:"success"}),t.dialogVisible=!1,t.getList()}):Object(i.a)(t.flashSession).then(function(e){t.$message({message:"添加成功！",type:"success"}),t.dialogVisible=!1,t.getList()})})},getList:function(){var t=this;this.listLoading=!0,Object(i.c)({}).then(function(e){t.listLoading=!1,t.list=e.data})}}},c={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"app-container"},[s("el-card",{staticClass:"operate-container",attrs:{shadow:"never"}},[s("i",{staticClass:"el-icon-tickets"}),t._v(" "),s("span",[t._v("数据列表")]),t._v(" "),s("el-button",{staticClass:"btn-add",attrs:{size:"mini"},on:{click:function(e){t.handleAdd()}}},[t._v("添加")])],1),t._v(" "),s("div",{staticClass:"table-container"},[s("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],ref:"flashSessionTable",staticStyle:{width:"100%"},attrs:{data:t.list,border:""}},[s("el-table-column",{attrs:{label:"编号",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.id))]}}])}),t._v(" "),s("el-table-column",{attrs:{label:"秒杀时间段名称",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.name))]}}])}),t._v(" "),s("el-table-column",{attrs:{label:"每日开始时间",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(t._f("formatTime")(e.row.startTime)))]}}])}),t._v(" "),s("el-table-column",{attrs:{label:"每日结束时间",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(t._f("formatTime")(e.row.endTime)))]}}])}),t._v(" "),s("el-table-column",{attrs:{label:"启用",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[s("el-switch",{attrs:{"active-value":1,"inactive-value":0},on:{change:function(s){t.handleStatusChange(e.$index,e.row)}},model:{value:e.row.status,callback:function(s){t.$set(e.row,"status",s)},expression:"scope.row.status"}})]}}])}),t._v(" "),s("el-table-column",{attrs:{label:"操作",width:"180",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[s("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(s){t.handleUpdate(e.$index,e.row)}}},[t._v("编辑\n          ")]),t._v(" "),s("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(s){t.handleDelete(e.$index,e.row)}}},[t._v("删除\n          ")])]}}])})],1)],1),t._v(" "),s("el-dialog",{attrs:{title:"添加时间段",visible:t.dialogVisible,width:"40%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[s("el-form",{ref:"flashSessionForm",attrs:{model:t.flashSession,"label-width":"150px",size:"small"}},[s("el-form-item",{attrs:{label:"秒杀时间段名称："}},[s("el-input",{staticStyle:{width:"250px"},model:{value:t.flashSession.name,callback:function(e){t.$set(t.flashSession,"name",e)},expression:"flashSession.name"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"每日开始时间："}},[s("el-time-picker",{attrs:{placeholder:"请选择时间"},model:{value:t.flashSession.startTime,callback:function(e){t.$set(t.flashSession,"startTime",e)},expression:"flashSession.startTime"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"每日结束时间："}},[s("el-time-picker",{attrs:{placeholder:"请选择时间"},model:{value:t.flashSession.endTime,callback:function(e){t.$set(t.flashSession,"endTime",e)},expression:"flashSession.endTime"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"是否启用"}},[s("el-radio-group",{model:{value:t.flashSession.status,callback:function(e){t.$set(t.flashSession,"status",e)},expression:"flashSession.status"}},[s("el-radio",{attrs:{label:1}},[t._v("启用")]),t._v(" "),s("el-radio",{attrs:{label:0}},[t._v("不启用")])],1)],1)],1),t._v(" "),s("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{size:"small"},on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),t._v(" "),s("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(e){t.handleDialogConfirm()}}},[t._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var u=s("VU/8")(r,c,!1,function(t){s("2V3i")},"data-v-3591e9b2",null);e.default=u.exports}});
//# sourceMappingURL=27.f3b6711f7112f5c9a8e3.js.map