<table class="easyui-datagrid" id="anamnesisAllergyDrugList" title="商品列表"
       data-options="singleSelect:true,collapsible:true,rownumbers:true,
       pagination:true,url:'/drug/allergy/list',
       method:'get',toolbar:toolbar">
    <thead>
<tr >
       <th data-options="field:'ck',checkbox:true"></th>
       <th data-options="field:'allergyDrugName',width:200">过敏药物名称</th>
    <th data-options="field:'spellName',width:100">过敏药物中文缩写</th>
        <th data-options="field:'allergyDrugNumber',width:100">过敏药物编号</th>
        <th data-options="field:'orderWeight',width:100">权重</th>
        <th data-options="field:'createUser',width:70,align:'right'">创造者</th>
        <th data-options="field:'createTime',width:70,align:'right',formatter:TAOTAO.formatDateTime">创造时间</th>
        <th data-options="field:'updateUser',width:100">更新人</th>
        <th data-options="field:'updateTime',width:60,align:'center',formatter:TAOTAO.formatDateTime">更新时间</th>
    </tr>
    </thead>
</table>
<div id="anamnesisAllergyDrugEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
        var anamnesisAllergyDrugList = $("#anamnesisAllergyDrugList");
        var sels = anamnesisAllergyDrugList.datagrid("getSelections");
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
                url : "/anamnesis-allergy-drug-add"
            });
        }




    },'-',{
        // 编辑
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){

            var ids = TT.getSelectionsIds("#anamnesisAllergyDrugList");
            if(ids.length == 0){
                $.messager.alert('提示','必须选择一个内容才能编辑!');
                return ;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个内容!');
                return ;
            }



            $(".tree-title:contains('更新类型')").parent().click();
            var node = $("#contentCategoryTree").tree("getSelected");

            TT.createWindow({
                url : "/anamnesis-allergy-drug-edit",
                onLoad : function(){
                    var data = $("#anamnesisAllergyDrugList").datagrid("getSelections")[0];
                    $("#anamnesisAllergyDrugEditForm").form("load",data);



                    contentEditEditor.html(data.content);
                }
            });



        }
    },'-',{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中病史类型!');
                return ;
            }
            $.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
                if (r){
                    var id = {"id":ids};
                    $.post("/drug/allergy/delete",id, function(data){
                        if(data.status == 20000){
                            $.messager.alert('提示','删除病史类型成功!','info',function(){

                                $("#anamnesisAllergyDrugList").datagrid("reload");
                            });

                        }
                    });
                }
            });
        }
    }/*{
        text:'下架',
        iconCls:'icon-remove',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中商品!');
                return ;
            }
            $.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/rest/item/instock",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','下架商品成功!',undefined,function(){
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    },{
        text:'上架',
        iconCls:'icon-remove',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中商品!');
                return ;
            }
            $.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/rest/item/reshelf",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','上架商品成功!',undefined,function(){
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }*/];
</script>