
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前列腺联盟后台管理系统</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/layer.css" />
<link rel="stylesheet" type="text/css" href="css/pra.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/layer.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<#--<script type="text/javascript" src="js/app.js"></script>-->
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout ">
 <#--head部分-->
	<div data-options="region:'north'" style="height:12%" class="bg-primary">
        <div class="text-center"><h1>前列腺联盟后台管理系统</h1></div>
        <div class="row">
            <div class="col-md-9"></div>
            <div class="col-md-1" class="text-right"><h5>当前用户:zhangsan</h5></div>
            <div class="col-md-1 text-right">
                <button type="button" id="logout"class="btn btn-success btn-sm" onclick="logout()">退出</button>
            </div>
            <div class="col-md-1">
                <button type="button" id="userinfo"class="btn btn-info btn-sm" onclick="userinfo()">个人中心</button>
            </div>
        </div>
	</div>
 <#--body之左边列表部分-->
    <div  id = "menu01" data-options="region:'west',title:'管理列表' " class="text-left bg-info" style="width:14%">

 <ul id="menu" class="easyui-tree"style="margin-top: 10px;margin-left: 5px;">
            <li>
                <span>病史管理</span>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-type-list'}">病史类型列表</li>
                </ul>

                <ul>
                    <li data-options="attributes:{'url':'anamnesis_eating_drug_list'}">正在服用药品列表</li>
                </ul>
                <ul>
                    <li data-options="attributes:{'url':'anamnesis-allergy-drug-list'}">过敏药品列表</li>
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
                    <li data-options="attributes:{'url':'citylist'}">城市列表</li>
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

<#--body主体-->
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">
		        	
		    </div>
		</div>
    </div>
 <#--页脚部分-->
 <div data-options="region:'south'" style="height:8%" class="bg-primary text-center">
     <h3>这是页脚,可有可无</h3>
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
function logout() {
    $.messager.confirm('确认','确定退出吗?',function(r){
        if (r){
//            $.post("/drug/eat/delete",params, function(data){
//                if(data.status == 20000){
//                    $.messager.alert('提示','删除商品成功!',undefined,function(){
//                        $("#drugEatList").datagrid("reload");
//                    });
//                }
//            });
            alert("跳转登录界面,发送退出请求")
        }else {
            //alert("关闭当前界面")
        }
    });
}

</script>
</body>
</html>