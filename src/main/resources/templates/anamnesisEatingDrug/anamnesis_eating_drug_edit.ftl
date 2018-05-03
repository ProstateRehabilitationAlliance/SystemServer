<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px" class="row">
	<div style="height: 20%"></div>
    <div style="height: 60%">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="drugEatEditForm" class="itemForm" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">药品名</label>
                    <input type="text" class="form-control" name="eatingDrugName" >
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">中文缩写</label>
                    <input type="text" class="form-control" name="spellName" >
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">编号</label>
                    <input type="text" class="form-control" name="eatingDrugNumber" >
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">权重</label>
                    <input type="text" class="form-control" name="orderWeight" >
                </div>

                </table>
                <input type="hidden" name="itemParams"/>
                <input type="hidden" name="itemParamId"/>
            </form>
            <div style="padding:5px" class="text-center">
                <a href="javascript:void(0)" class="easyui-linkbutton btn btn-success" onclick="submitForm()">提交</a>
            </div>
		</div>
        <div class="col-md-4"></div>
    </div>
    <div style="height: 20%"></div>

</div>
<script type="text/javascript">
	var drugEatEditForm ;
	$(function(){
		//实例化编辑器
//		itemEditEditor = TAOTAO.createEditor("#itemeEditForm [name=desc]");
		alert(data.eatingDrugName+data.eatingDrugNumber);
	});

	function submitForm(){
		if(!$('#itemeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("/drug/eat/update",$("#drugEatEditForm").serialize(), function(data){

			if(data.status == 20000){
				$.messager.alert('提示','修改商品成功!','info',function(){
					$("#drugEatEditForm").window('close');
					$("#drugEatList").datagrid("reload");
				});
			}else {
                $.messager.alert('提示','修改失败,请检查信息!');
			}
		});


	}
</script>
