
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前列腺联盟后台管理系统</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />

<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true" style="height: 10%;background-color: #b7d2ff">
		<h1>          前列腺联盟后台管理系统</h1>
	</div>
    <div data-options="region:'west',title:'管理列表',split:true" style="width:180px;">
    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
		<#--分割线-->
            <li>
                <span>病史类型管理</span>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">查询病史</li>
                </ul>
            </li>

			<#--分割线-->
         	<li>
         		<span>城市管理</span>
         		<ul>


	         		<#--<li data-options="attributes:{'url':'item-add'}">新增商品


					</li>-->


	         		<li data-options="attributes:{'url':'item-list'}">查询商品</li>
	         	</ul>
         	</li>
         	<li>
         		<span>网站内容管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'content-category'}">内容分类管理</li>
	         		<li data-options="attributes:{'url':'content'}">内容管理</li>
	         	</ul>
         	</li>
         	<li>
         		<span>索引库管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'import-index'}">导入索引库</li>
	         	</ul>
         	</li>
         </ul>
    </div>
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">
		        	
		    </div>
		</div>
    </div>
    
<script type="text/javascript">

$(function(){
    $(document).bind('contextmenu',function(e){
        e.preventDefault();
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY
        });
    });

	$('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
});
</script>
</body>
</html>