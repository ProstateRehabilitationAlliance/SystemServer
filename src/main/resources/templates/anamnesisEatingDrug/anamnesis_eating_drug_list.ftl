<table class="easyui-datagrid" id="drugEatList" title="正在服用的药品"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/drug/eat/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <#--<th data-options="field:'id',width:60">ID</th>-->
        <th data-options="field:'eatingDrugName',width:200">药品名称</th>
        <th data-options="field:'spellName',width:100">药品缩写</th>
        <th data-options="field:'eatingDrugNumber',width:100">药品编号</th>
        <th data-options="field:'orderWeight',width:100">权重</th>
        <th data-options="field:'createName',width:70,align:'right',formatter:TAOTAO.formatPrice">创建者</th>
        <th data-options="field:'createTime',width:70,align:'right'">创建时间</th>
        <th data-options="field:'updateName',width:100">修改者</th>
        <th data-options="field:'updateTime',width:60">修改时间</th>
        <th data-options="field:'deleteName',width:130">删除者</th>
        <th data-options="field:'deleteTime',width:130">删除时间</th>
        <th data-options="field:'delFlag',width:130">删除标记</th>
    </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
        var itemList = $("#drugEatList");
        var sels = itemList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    }

    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
            $(".tree-title:contains('新增商品')").parent().click();
            var node = $("#contentCategoryTree").tree("getSelected");
            /*if(!node || !$("#contentCategoryTree").tree("isLeaf",node.target)){
                $.messager.alert('提示','新增内容必须选择一个内容分类!');
                return ;
            }*/
            TT.createWindow({
                url : "/anamnesis_eating_drug_add"
            });
        }
    }
    ,{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','必须选择一个商品才能编辑!');
                return ;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个商品!');
                return ;
            }
//
//            $("#itemEditWindow").window({
//                onLoad :function(){
//                    //回显数据
//                    var data = $("#drugEatList").datagrid("getSelections")[0];
//                    data.priceView = TAOTAO.formatPrice(data.price);
//                    $("#itemeEditForm").form("load",data);
//
//                    // 加载商品描述
//                    $.getJSON('/drug/eat/selectbyid'+data.id,function(_data){
//                        if(_data.status == 20000){
//                            //UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
//                            $.messager.alert(data.status+data.msg);
//                            itemEditEditor.html(_data.data.itemDesc);
//
//                        }
//                    });
//
//                    //加载商品规格
//                    $.getJSON('/rest/item/param/item/query/'+data.id,function(_data){
//                        if(_data && _data.status == 200 && _data.data && _data.data.paramData){
//                            $("#itemeEditForm .params").show();
//                            $("#itemeEditForm [name=itemParams]").val(_data.data.paramData);
//                            $("#itemeEditForm [name=itemParamId]").val(_data.data.id);
//
//                            //回显商品规格
//                            var paramData = JSON.parse(_data.data.paramData);
//
//                            var html = "<ul>";
//                            for(var i in paramData){
//                                var pd = paramData[i];
//                                html+="<li><table>";
//                                html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
//
//                                for(var j in pd.params){
//                                    var ps = pd.params[j];
//                                    html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
//                                }
//
//                                html+="</li></table>";
//                            }
//                            html+= "</ul>";
//                            $("#itemeEditForm .params td").eq(1).html(html);
//                        }
//                    });
//
//                    TAOTAO.init({
//                        "pics" : data.image,
//                        "cid" : data.cid,
//                        fun:function(node){
//                            TAOTAO.changeItemParam(node, "itemeEditForm");
//                        }
//                    });
//                }
//            }).window("open");
            $(".tree-title:contains('更新类型')").parent().click();
            var node = $("#contentCategoryTree").tree("getSelected");

            TT.createWindow({
                url : "/anamnesis_eating_drug_edit",
                onLoad : function(){
                    var data = $("#drugEatList").datagrid("getSelections")[0];
                    $("#drugEatEditForm").form("load",data);
                    contentEditEditor.html(data.content);
                }
            });
        }
    }
    ,{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中商品!');
                return ;
            }
            $.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
                if (r){
                    var params = {"id":ids};
                    $.post("/drug/eat/delete",params, function(data){
                        if(data.status == 20000){
                            $.messager.alert('提示','删除商品成功!',undefined,function(){
                                $("#drugEatList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }

//	,'-',{
//        text:'下架',
//        iconCls:'icon-remove',
//        handler:function(){
//            var ids = getSelectionsIds();
//            if(ids.length == 0){
//                $.messager.alert('提示','未选中商品!');
//                return ;
//            }
//            $.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
//                if (r){
//                    var params = {"ids":ids};
//                    $.post("/rest/item/instock",params, function(data){
//                        if(data.status == 200){
//                            $.messager.alert('提示','下架商品成功!',undefined,function(){
//                                $("#drugEatList").datagrid("reload");
//                            });
//                        }
//                    });
//                }
//            });
//        }
//    }
//    ,{
//        text:'上架',
//        iconCls:'icon-remove',
//        handler:function(){
//            var ids = getSelectionsIds();
//            if(ids.length == 0){
//                $.messager.alert('提示','未选中商品!');
//                return ;
//            }
//            $.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
//                if (r){
//                    var params = {"ids":ids};
//                    $.post("/rest/item/reshelf",params, function(data){
//                        if(data.status == 200){
//                            $.messager.alert('提示','上架商品成功!',undefined,function(){
//                                $("#drugEatList").reload;
//                            });
//                        }
//                    });
//                }
//            });
//        }
//    }
	];
</script>