<table class="easyui-datagrid " id="drugEatList" title="正在服用的药品"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/drug/eat/list',method:'get',pageSize:10,toolbar:toolbar"
        style="width: 100%">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <#--<th data-options="field:'id',width:60">ID</th>-->
        <th data-options="field:'eatingDrugName',width:200">药品名称</th>
        <th data-options="field:'spellName',width:100">药品缩写</th>
        <th data-options="field:'eatingDrugNumber',width:100">药品编号</th>
        <th data-options="field:'orderWeight',width:85">权重</th>
        <th data-options="field:'createName',width:225">创建者</th>
        <th data-options="field:'createTime',width:90">创建时间</th>
        <th data-options="field:'updateName',width:225">修改者</th>
        <th data-options="field:'updateTime',width:90">修改时间</th>
        <th data-options="field:'deleteName',width:225">删除者</th>
        <th data-options="field:'deleteTime',width:90">删除时间</th>
        <th data-options="field:'delFlag',width:80">删除标记</th>
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


	];
</script>