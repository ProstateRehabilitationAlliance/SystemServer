
<link href="../js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="../js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="anamnesisAllergyDrugEditForm" class="itemForm" method="post">
        <input type="hidden" name="id"/>
        <table cellpadding="5">
            <tr>
                <td>过敏药物名称:</td>
                <td><input class="easyui-textbox" type="text" name="allergyDrugName" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>过敏药物中文缩写:</td>
                <td><input class="easyui-textbox" type="text" name="spellName" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>过敏药物编号:</td>
                <td><input class="easyui-numberbox" type="text" name="allergyDrugNumber" data-options="min:1,max:99999999,precision:0,required:true" /></td>
            </tr>

            <tr>
                <td>权重:</td>
                <td><input class="easyui-numberbox" type="text" name="orderWeight" data-options="min:1,max:99999999,precision:0,required:true" /></td>
            </tr>
        </table>
        <input type="hidden" name="itemParams"/>
        <input type="hidden" name="itemParamId"/>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
    </div>
</div>
<script type="text/javascript">
    var anamnesisAllergyDrugEditEditor ;
    $(function(){

    });

    function submitForm(){
        if(!$('#anamnesisAllergyDrugEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }

        $.post("/drug/allergy/update",$("#anamnesisAllergyDrugEditForm").serialize(), function(data){
            if(data.status == 20000){
                $.messager.alert('提示','修改商品成功!','info',function(){
                    $("#anamnesisAllergyDrugList").datagrid("reload");
                    TT.closeCurrentWindow();
                });
            }
        });
    }
</script>
