<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>




<div style="padding:10px 10px 10px 10px">
    <div style="height: 20%"></div>
    <div style="height: 60%">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="anamnesisEatingDrugForm" class="itemForm" method="post" >
            <div class="form-group">
                <label for="exampleInputEmail1">药品名</label>
                <input type="text" class="form-control" name="eatingDrugName" placeholder="drugEatingName">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">中文缩写</label>
                <input type="text" class="form-control" name="spellName" placeholder="spellName">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">编号</label>
                <input type="text" class="form-control" name="eatingDrugNumber" placeholder="例如:1000">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">权重</label>
                <input type="text" class="form-control" name="orderWeight" placeholder="例如:999">
            </div>

            <input type="hidden" name="itemParams"/>
        </form>
            <div style="padding:5px " class="text-center">
        <a href="javascript:void(0)" class="easyui-linkbutton panel-tool-close btn btn-success " onclick="submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton btn btn-info" onclick="clearForm()">重置</a>
    </div>
        </div>
        <div class="col-md-4"></div>
    </div>
    <div style="height: 20%"></div>
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
                $.messager.alert('提示','新增成功!');
                $("#anamnesisEatingDrugForm").window('close');
                $("#drugEatList").datagrid("reload");
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
