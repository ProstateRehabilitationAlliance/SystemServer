
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前列腺联盟后台管理系统</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/pra.css" />

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
<body class="easyui-layout ">
	<div data-options="region:'north',split:true" style="height: 10%;background-color: #b7d2ff">
		<h1>          前列腺联盟后台管理系统</h1>
	</div>
    <div  data-options="region:'west',title:'管理列表',split:true" style="width:180px;">
    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
		<#--分割线-->
            <li>
                <span>病史管理</span>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">病史类型列表</li>
                </ul>

                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">正在服用药品列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">过敏药品列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">既往病史列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">疾病列表</li>
                </ul>
            </li>


            <li>
                <span>医生管理</span>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">医生信息(登录)列表</li>
                </ul>

                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">医生信息(详情)列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">医生职称列表</li>
                </ul>
            </li>


            <li>
                <span>患者管理</span>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">患者详情列表</li>
                </ul>

                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">患者+疾病列表</li>
                </ul>
            </li>

            <li>
                <span>医院管理</span>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">医院列表</li>
                </ul>

                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">医院类型列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">科室列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">医院+科室列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">科室+疾病列表</li>
                </ul>
            </li>






            <li>
                <span>题库以及答案管理</span>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">题库ipss列表</li>
                </ul>

                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">题库ipss答案列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">题库nih_cpsi列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">题库nih_cpsi答案列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">题库(综合)列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">题库(综合)答案列表</li>
                </ul>
            </li>


            <li>
                <span>基础信息管理</span>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">血型列表</li>
                </ul>

                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">城市列表</li>
                </ul>

                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">教育背景列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">职业列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">民族列表</li>
                </ul>


            </li>


            <li>
                <span>管理员管理</span>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">用户列表</li>
                </ul>

                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">角色列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">权限列表</li>
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