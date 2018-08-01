
var prefix = "/base/city"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
                        id : 'id',
                        code : 'id',
                        parentCode : 'parentCityId',
                        type : "GET", // 请求数据的ajax类型
                        url : prefix + '/list', // 请求数据的ajax的url
                        ajaxParams : {offset:0,limit:100}, // 请求数据的ajax的data属性
                        expandColumn : '0', // 在哪一列上面显示展开按钮
                        striped : true, // 是否各行渐变色
                        bordered : true, // 是否显示边框
                        expandAll : false, // 是否全部展开
                        // toolbar : '#exampleToolbar',
						columns : [
								{
									checkbox : true
								},
																{
									field : 'id', 
									title : '' 
								},
																{
									field : 'parentCityId', 
									title : '上级城市ID' 
								},
																{
									field : 'cityName', 
									title : '城市名称' 
								},
																{
									field : 'cityType', 
									title : '城市类型' 
								},
																{
									field : 'orderWeight', 
									title : '排序' 
								},
																{
									field : 'createUser', 
									title : '创建人ID(后台管理员)' 
								},
																{
									field : 'createTime', 
									title : '创建时间' 
								},
																{
									field : 'cityWeight', 
									title : '权重' 
								},
																{
									field : 'updateUser', 
									title : '修改人ID(后台管理员)' 
								},
																{
									field : 'updateTime', 
									title : '修改时间' 
								},
																{
									field : 'deleteUser', 
									title : '删除人ID(后台管理员)' 
								},
																{
									field : 'deleteTime', 
									title : '删除时间' 
								},
																{
									field : 'delFlag', 
									title : '删除标记' 
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 20000) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}