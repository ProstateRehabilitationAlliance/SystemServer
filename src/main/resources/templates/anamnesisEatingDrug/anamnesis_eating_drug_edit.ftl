<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="drugEatEditForm" class="itemForm" method="post">
		<input type="hidden" name="id"/>
	    <table cellpadding="5">
	        <tr>
	            <td>名称:</td>
	            <td><input class="easyui-textbox" type="text" name="eatingDrugName" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>中文缩写:</td>
	            <td><input class="easyui-textbox" name="spellName" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
            <tr>
                <td>编号:</td>
                <td><input class="easyui-textbox" name="eatingDrugNumber" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
            </tr>
	        <tr>
	            <td>权重:</td>
	            <td><input class="easyui-numberbox" type="text" name="orderWeight" data-options="min:1,max:99999999,precision:2,required:true" />

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
		    alert(data.msg)
			if(data.status == 20000){
				$.messager.alert('提示','修改商品成功!','info',function(){
					$("#drugEatEditForm").window('close');
					$("#drugEatList").datagrid("reload");
				});
			}
		});


	}
</script>
