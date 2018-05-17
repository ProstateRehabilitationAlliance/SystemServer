$().ready(function() {
	validateRule();
	loadType();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function loadType() {
    var hospitalTypeId = $("#typeId").val();
    //alert(hospitalTypeId);
    if(hospitalTypeId!=null){
        $.get("/base/hospitalType/getById",{
            id : hospitalTypeId  //传递省份ID到后台
        }, function(data) {
        	if (data !== null){
                $("#typeId").empty();
                var name = data.hospitalTypeName;
                var id = data.id;
                var str = '<option>'+name+'</option>';
                $("#typeId").append(str);
			}
        });
    }
}
function loadAllType() {
    $.get("/base/hospitalType/list",{
        offset : 0,
        limit:1000
    }, function(data) {
        if (data !== null){
            var rows = data.rows;
            alert(rows);
            alert("123");
            $("#typeId").empty();
            for(var i = 0;i<rows.length;i++){
                var type = rows[i];
                var str = '<option id="'+type.id+'" value="'+type.id+'">'+type.hospitalTypeName+'</option>';
                $("#typeId").append(str);
            }
        }
    });
}
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/base/hospital/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 20000) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}