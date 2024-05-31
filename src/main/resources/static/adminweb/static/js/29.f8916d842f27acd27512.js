webpackJsonp([29],{ZKkC:function(t,e){},gEzv:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=a("woOf"),l=a.n(n),i=a("UgCr"),s=a("vLgD");function o(t,e){return Object(s.a)({url:"/sku/"+t,method:"get",params:e})}var u=a("3idm"),r=a("s/Rn"),c=a("mRsl"),d={keyword:null,pageNum:1,pageSize:5,publishStatus:null,verifyStatus:null,productSn:null,productCategoryId:null,brandId:null},p={name:"productList",data:function(){return{editSkuInfo:{dialogVisible:!1,productId:null,productSn:"",productAttributeCategoryId:null,stockList:[],productAttr:[],keyword:null},operates:[{label:"商品上架",value:"publishOn"},{label:"商品下架",value:"publishOff"},{label:"设为推荐",value:"recommendOn"},{label:"取消推荐",value:"recommendOff"},{label:"设为新品",value:"newOn"},{label:"取消新品",value:"newOff"},{label:"转移到分类",value:"transferCategory"},{label:"移入回收站",value:"recycle"}],operateType:null,listQuery:l()({},d),list:null,total:null,listLoading:!0,selectProductCateValue:null,multipleSelection:[],productCateOptions:[],brandOptions:[],publishStatusOptions:[{value:1,label:"上架"},{value:0,label:"下架"}],verifyStatusOptions:[{value:1,label:"审核通过"},{value:0,label:"未审核"}]}},created:function(){this.getList(),this.getBrandList(),this.getProductCateList()},watch:{selectProductCateValue:function(t){null!=t&&2==t.length?this.listQuery.productCategoryId=t[1]:this.listQuery.productCategoryId=null}},filters:{verifyStatusFilter:function(t){return 1===t?"审核通过":"未审核"}},methods:{getProductSkuSp:function(t,e){var a=JSON.parse(t.spData);return null!=a&&e<a.length?a[e].value:null},getList:function(){var t=this;this.listLoading=!0,Object(i.b)(this.listQuery).then(function(e){t.listLoading=!1,t.list=e.data.list,t.total=e.data.total})},getBrandList:function(){var t=this;Object(r.c)({pageNum:1,pageSize:100}).then(function(e){t.brandOptions=[];for(var a=e.data.list,n=0;n<a.length;n++)t.brandOptions.push({label:a[n].name,value:a[n].id})})},getProductCateList:function(){var t=this;Object(c.d)().then(function(e){var a=e.data;t.productCateOptions=[];for(var n=0;n<a.length;n++){var l=[];if(null!=a[n].children&&a[n].children.length>0)for(var i=0;i<a[n].children.length;i++)l.push({label:a[n].children[i].name,value:a[n].children[i].id});t.productCateOptions.push({label:a[n].name,value:a[n].id,children:l})}})},handleShowSkuEditDialog:function(t,e){var a=this;this.editSkuInfo.dialogVisible=!0,this.editSkuInfo.productId=e.id,this.editSkuInfo.productSn=e.productSn,this.editSkuInfo.productAttributeCategoryId=e.productAttributeCategoryId,this.editSkuInfo.keyword=null,o(e.id,{keyword:this.editSkuInfo.keyword}).then(function(t){a.editSkuInfo.stockList=t.data}),null!=e.productAttributeCategoryId&&Object(u.c)(e.productAttributeCategoryId,{type:0}).then(function(t){a.editSkuInfo.productAttr=t.data.list})},handleSearchEditSku:function(){var t=this;o(this.editSkuInfo.productId,{keyword:this.editSkuInfo.keyword}).then(function(e){t.editSkuInfo.stockList=e.data})},handleEditSkuConfirm:function(){var t=this;null==this.editSkuInfo.stockList||this.editSkuInfo.stockList.length<=0?this.$message({message:"暂无sku信息",type:"warning",duration:1e3}):this.$confirm("是否要进行修改","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var e,a;(e=t.editSkuInfo.productId,a=t.editSkuInfo.stockList,Object(s.a)({url:"/sku/update/"+e,method:"post",data:a})).then(function(e){t.$message({message:"修改成功",type:"success",duration:1e3}),t.editSkuInfo.dialogVisible=!1})})},handleSearchList:function(){this.listQuery.pageNum=1,this.getList()},handleAddProduct:function(){this.$router.push({path:"/pms/addProduct"})},handleBatchOperate:function(){var t=this;null!=this.operateType?null==this.multipleSelection||this.multipleSelection.length<1?this.$message({message:"请选择要操作的商品",type:"warning",duration:1e3}):this.$confirm("是否要进行该批量操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){for(var e=[],a=0;a<t.multipleSelection.length;a++)e.push(t.multipleSelection[a].id);switch(t.operateType){case t.operates[0].value:t.updatePublishStatus(1,e);break;case t.operates[1].value:t.updatePublishStatus(0,e);break;case t.operates[2].value:t.updateRecommendStatus(1,e);break;case t.operates[3].value:t.updateRecommendStatus(0,e);break;case t.operates[4].value:t.updateNewStatus(1,e);break;case t.operates[5].value:t.updateNewStatus(0,e);break;case t.operates[6].value:break;case t.operates[7].value:t.updateDeleteStatus(1,e)}t.getList()}):this.$message({message:"请选择操作类型",type:"warning",duration:1e3})},handleSizeChange:function(t){this.listQuery.pageNum=1,this.listQuery.pageSize=t,this.getList()},handleCurrentChange:function(t){this.listQuery.pageNum=t,this.getList()},handleSelectionChange:function(t){this.multipleSelection=t},handlePublishStatusChange:function(t,e){var a=[];a.push(e.id),this.updatePublishStatus(e.publishStatus,a)},handleNewStatusChange:function(t,e){var a=[];a.push(e.id),this.updateNewStatus(e.newStatus,a)},handleRecommendStatusChange:function(t,e){var a=[];a.push(e.id),this.updateRecommendStatus(e.recommandStatus,a)},handleResetSearch:function(){this.selectProductCateValue=[],this.listQuery=l()({},d)},handleDelete:function(t,e){var a=this;this.$confirm("是否要进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var t=[];t.push(e.id),a.updateDeleteStatus(1,t)})},handleUpdateProduct:function(t,e){this.$router.push({path:"/pms/updateProduct",query:{id:e.id}})},handleShowProduct:function(t,e){console.log("handleShowProduct",e)},handleShowVerifyDetail:function(t,e){console.log("handleShowVerifyDetail",e)},handleShowLog:function(t,e){console.log("handleShowLog",e)},updatePublishStatus:function(t,e){var a=this,n=new URLSearchParams;n.append("ids",e),n.append("publishStatus",t),Object(i.h)(n).then(function(t){a.$message({message:"修改成功",type:"success",duration:1e3})})},updateNewStatus:function(t,e){var a=this,n=new URLSearchParams;n.append("ids",e),n.append("newStatus",t),Object(i.f)(n).then(function(t){a.$message({message:"修改成功",type:"success",duration:1e3})})},updateRecommendStatus:function(t,e){var a=this,n=new URLSearchParams;n.append("ids",e),n.append("recommendStatus",t),Object(i.i)(n).then(function(t){a.$message({message:"修改成功",type:"success",duration:1e3})})},updateDeleteStatus:function(t,e){var a=this,n=new URLSearchParams;n.append("ids",e),n.append("deleteStatus",t),Object(i.e)(n).then(function(t){a.$message({message:"删除成功",type:"success",duration:1e3})}),this.getList()}}},h={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-card",{staticClass:"filter-container",attrs:{shadow:"never"}},[a("div",[a("i",{staticClass:"el-icon-search"}),t._v(" "),a("span",[t._v("筛选搜索")]),t._v(" "),a("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",size:"small"},on:{click:function(e){t.handleSearchList()}}},[t._v("\n        查询结果\n      ")]),t._v(" "),a("el-button",{staticStyle:{float:"right","margin-right":"15px"},attrs:{size:"small"},on:{click:function(e){t.handleResetSearch()}}},[t._v("\n        重置\n      ")])],1),t._v(" "),a("div",{staticStyle:{"margin-top":"15px"}},[a("el-form",{attrs:{inline:!0,model:t.listQuery,size:"small","label-width":"140px"}},[a("el-form-item",{attrs:{label:"输入搜索："}},[a("el-input",{staticStyle:{width:"203px"},attrs:{placeholder:"商品名称"},model:{value:t.listQuery.keyword,callback:function(e){t.$set(t.listQuery,"keyword",e)},expression:"listQuery.keyword"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"商品货号："}},[a("el-input",{staticStyle:{width:"203px"},attrs:{placeholder:"商品货号"},model:{value:t.listQuery.productSn,callback:function(e){t.$set(t.listQuery,"productSn",e)},expression:"listQuery.productSn"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"商品分类："}},[a("el-cascader",{attrs:{clearable:"",options:t.productCateOptions},model:{value:t.selectProductCateValue,callback:function(e){t.selectProductCateValue=e},expression:"selectProductCateValue"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"商品品牌："}},[a("el-select",{attrs:{placeholder:"请选择品牌",clearable:""},model:{value:t.listQuery.brandId,callback:function(e){t.$set(t.listQuery,"brandId",e)},expression:"listQuery.brandId"}},t._l(t.brandOptions,function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})}))],1),t._v(" "),a("el-form-item",{attrs:{label:"上架状态："}},[a("el-select",{attrs:{placeholder:"全部",clearable:""},model:{value:t.listQuery.publishStatus,callback:function(e){t.$set(t.listQuery,"publishStatus",e)},expression:"listQuery.publishStatus"}},t._l(t.publishStatusOptions,function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})}))],1),t._v(" "),a("el-form-item",{attrs:{label:"审核状态："}},[a("el-select",{attrs:{placeholder:"全部",clearable:""},model:{value:t.listQuery.verifyStatus,callback:function(e){t.$set(t.listQuery,"verifyStatus",e)},expression:"listQuery.verifyStatus"}},t._l(t.verifyStatusOptions,function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})}))],1)],1)],1)]),t._v(" "),a("el-card",{staticClass:"operate-container",attrs:{shadow:"never"}},[a("i",{staticClass:"el-icon-tickets"}),t._v(" "),a("span",[t._v("数据列表")]),t._v(" "),a("el-button",{staticClass:"btn-add",attrs:{size:"mini"},on:{click:function(e){t.handleAddProduct()}}},[t._v("\n      添加\n    ")])],1),t._v(" "),a("div",{staticClass:"table-container"},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],ref:"productTable",staticStyle:{width:"100%"},attrs:{data:t.list,border:""},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"60",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{label:"编号",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.id))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"商品图片",width:"120",align:"center"},scopedSlots:t._u([{key:"default",fn:function(t){return[a("img",{staticStyle:{height:"80px"},attrs:{src:t.row.pic}})]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"商品名称",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("p",[t._v(t._s(e.row.name))]),t._v(" "),a("p",[t._v("品牌："+t._s(e.row.brandName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"价格/货号",width:"120",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("p",[t._v("价格：￥"+t._s(e.row.price))]),t._v(" "),a("p",[t._v("货号："+t._s(e.row.productSn))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"标签",width:"140",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("p",[t._v("上架：\n            "),a("el-switch",{attrs:{"active-value":1,"inactive-value":0},on:{change:function(a){t.handlePublishStatusChange(e.$index,e.row)}},model:{value:e.row.publishStatus,callback:function(a){t.$set(e.row,"publishStatus",a)},expression:"scope.row.publishStatus"}})],1),t._v(" "),a("p",[t._v("新品：\n            "),a("el-switch",{attrs:{"active-value":1,"inactive-value":0},on:{change:function(a){t.handleNewStatusChange(e.$index,e.row)}},model:{value:e.row.newStatus,callback:function(a){t.$set(e.row,"newStatus",a)},expression:"scope.row.newStatus"}})],1),t._v(" "),a("p",[t._v("推荐：\n            "),a("el-switch",{attrs:{"active-value":1,"inactive-value":0},on:{change:function(a){t.handleRecommendStatusChange(e.$index,e.row)}},model:{value:e.row.recommandStatus,callback:function(a){t.$set(e.row,"recommandStatus",a)},expression:"scope.row.recommandStatus"}})],1)]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"排序",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.sort))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"SKU库存",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"primary",icon:"el-icon-edit",circle:""},on:{click:function(a){t.handleShowSkuEditDialog(e.$index,e.row)}}})]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"销量",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.sale))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("p",[t._v(t._s(t._f("verifyStatusFilter")(e.row.verifyStatus)))]),t._v(" "),a("p",[a("el-button",{attrs:{type:"text"},on:{click:function(a){t.handleShowVerifyDetail(e.$index,e.row)}}},[t._v("审核详情\n            ")])],1)]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",width:"160",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("p",[a("el-button",{attrs:{size:"mini"},on:{click:function(a){t.handleShowProduct(e.$index,e.row)}}},[t._v("查看\n            ")]),t._v(" "),a("el-button",{attrs:{size:"mini"},on:{click:function(a){t.handleUpdateProduct(e.$index,e.row)}}},[t._v("编辑\n            ")])],1),t._v(" "),a("p",[a("el-button",{attrs:{size:"mini"},on:{click:function(a){t.handleShowLog(e.$index,e.row)}}},[t._v("日志\n            ")]),t._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){t.handleDelete(e.$index,e.row)}}},[t._v("删除\n            ")])],1)]}}])})],1)],1),t._v(" "),a("div",{staticClass:"batch-operate-container"},[a("el-select",{attrs:{size:"small",placeholder:"批量操作"},model:{value:t.operateType,callback:function(e){t.operateType=e},expression:"operateType"}},t._l(t.operates,function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),t._v(" "),a("el-button",{staticClass:"search-button",staticStyle:{"margin-left":"20px"},attrs:{type:"primary",size:"small"},on:{click:function(e){t.handleBatchOperate()}}},[t._v("\n      确定\n    ")])],1),t._v(" "),a("div",{staticClass:"pagination-container"},[a("el-pagination",{attrs:{background:"",layout:"total, sizes,prev, pager, next,jumper","page-size":t.listQuery.pageSize,"page-sizes":[5,10,15],"current-page":t.listQuery.pageNum,total:t.total},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.listQuery,"pageNum",e)}}})],1),t._v(" "),a("el-dialog",{attrs:{title:"编辑货品信息",visible:t.editSkuInfo.dialogVisible,width:"40%"},on:{"update:visible":function(e){t.$set(t.editSkuInfo,"dialogVisible",e)}}},[a("span",[t._v("商品货号：")]),t._v(" "),a("span",[t._v(t._s(t.editSkuInfo.productSn))]),t._v(" "),a("el-input",{staticStyle:{width:"50%","margin-left":"20px"},attrs:{placeholder:"按sku编号搜索",size:"small"},model:{value:t.editSkuInfo.keyword,callback:function(e){t.$set(t.editSkuInfo,"keyword",e)},expression:"editSkuInfo.keyword"}},[a("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:t.handleSearchEditSku},slot:"append"})],1),t._v(" "),a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.editSkuInfo.stockList,border:""}},[a("el-table-column",{attrs:{label:"SKU编号",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-input",{model:{value:e.row.skuCode,callback:function(a){t.$set(e.row,"skuCode",a)},expression:"scope.row.skuCode"}})]}}])}),t._v(" "),t._l(t.editSkuInfo.productAttr,function(e,n){return a("el-table-column",{key:e.id,attrs:{label:e.name,align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n          "+t._s(t.getProductSkuSp(e.row,n))+"\n        ")]}}])})}),t._v(" "),a("el-table-column",{attrs:{label:"销售价格",width:"80",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-input",{model:{value:e.row.price,callback:function(a){t.$set(e.row,"price",a)},expression:"scope.row.price"}})]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"商品库存",width:"80",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-input",{model:{value:e.row.stock,callback:function(a){t.$set(e.row,"stock",a)},expression:"scope.row.stock"}})]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"库存预警值",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-input",{model:{value:e.row.lowStock,callback:function(a){t.$set(e.row,"lowStock",a)},expression:"scope.row.lowStock"}})]}}])})],2),t._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.editSkuInfo.dialogVisible=!1}}},[t._v("取 消")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:t.handleEditSkuConfirm}},[t._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var f=a("VU/8")(p,h,!1,function(t){a("ZKkC")},null,null);e.default=f.exports}});
//# sourceMappingURL=29.f8916d842f27acd27512.js.map