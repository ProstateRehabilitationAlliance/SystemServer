<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
    <form id="anamnesisEatingDrugForm" class="itemForm" method="post">
        <table cellpadding="5">
               <tr>
                   <td>药品名:</td>
                   <td><input class="easyui-textbox" type="text" name="eatingDrugName" data-options="required:true" style="width: 280px;"></input></td>
               </tr>
            <tr>
                <td>中文缩写:</td>
                <td><input class="easyui-textbox" type="text" name="spellName" data-options="min:1,max:99999999,precision:0,required:true" /></td>
            </tr>
               <tr>
                   <td>编号:</td>
                   <td><input class="easyui-numberbox" type="text" name="eatingDrugNumber" data-options="min:1,max:99999999,precision:0,required:true" /></td>
               </tr>

               <tr>
                   <td>权重:</td>
                   <td><input class="easyui-numberbox" type="text" name="orderWeight" data-options="min:1,max:99999999,precision:0,required:true" /></td>
               </tr>

        </table>
        <input type="hidden" name="itemParams"/>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton panel-tool-close btn btn-success" onclick="submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var itemAddEditor ;
    //页面初始化完毕后执行此方法
    $(function(){
        //创建富文本编辑器
        //itemAddEditor = P.createEditor("#anamnesisEatingDrugForm [name=anamnesisTypeName]");
        //初始化类目选择和图片上传器
        TT.init({fun:function(node){
            //根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
            //TAOTAO.changeItemParam(node, "itemAddForm");
        }});
    });
    //提交表单
    function submitForm(){
        //有效性验证
        if(!$('#anamnesisEatingDrugForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }

        $.post("/drug/eat/insert",$("#anamnesisEatingDrugForm").serialize(), function(data){
            if(data.status == 20000){
                $.messager.alert('提示','新增病史类型添加成功!');
                $("#anamnesisEatingDrugForm").window('close');
                $("#anamnesisTypeList").reload;
            }else if(data.status == 20001){
                $.messager.alert('提示','信息重复!');
            }else{
                $.messager.alert('提示','添加失败!');
            }
        });
    }

    function clearForm(){
        $('#anamnesisEatingDrugForm').form('reset');
        itemAddEditor.html('');
    }
</script>
