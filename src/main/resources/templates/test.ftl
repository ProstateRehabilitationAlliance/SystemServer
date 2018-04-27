<table id="dg">

</table>
<script type="text/javascript">
    $(function () {
//          $.ajax({
//                type: "GET",
//                url: "/index/GetOrder",
//                success: function (msg) {
//                    alert(msg);
//                }
//            });
        $("#dg").datagrid({
            height: 500,
            nowrap: true,
            striped: true,
            url: '/anamnesistype/findAll',
            columns: [[
                {
                    field:'id',
                    title:'编号',
                    width:50
                }
            ]],
            pagination: true,//分页控件
            rownumbers: true,//行号
            singleSelect:false,//是否单选
        });

        //设置分页控件
        var p = $('#dg').datagrid('getPager');
        $(p).pagination({
            pageSize: 20,//每页显示的记录条数，默认为10
            pageList: [10,20,30,40,50],//可以设置每页记录条数的列表
            beforePageText: '第',//页数文本框前显示的汉字
            afterPageText: '页    共 {pages} 页',
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        });
    });
</script>