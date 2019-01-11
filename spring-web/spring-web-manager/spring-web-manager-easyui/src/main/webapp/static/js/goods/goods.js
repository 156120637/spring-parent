$(function () {
    $("#goods_tb").datagrid({
        method:"GET",
        fit:true,
        fitColumns:true,//用来让现有datagrid中列根据表格的宽度自适应  根据列的宽度的一定比例进行分配
        url:'/goods/findAll',
        toolbar: [{
            iconCls: 'icon-add',
            text: '添加商品',
            handler: toAddGoods,
        }],
        columns:[[
            {field:'goid',title:'ID',width:40, align:'center'},
            {field:'goname',title:'名称',width:40,sortable:true, align:'center'},
            {field:'goprice',title:'原价',width:40,sortable:true, align:'center'},
            {field:'goshuprice',title:'现价',width:40,sortable:true, align:'center'},
            {field:'gosalescount',title:'销售量',width:40,sortable:true, align:'center'},
            {field:'goimage',title:'图片',width:40, align:'center'},
            {field:'gostock',title:'存货',width:40,sortable:true, align:'center'},
            {field:'goviewcount',title:'浏览量',width:40,sortable:true, align:'center'},
            {field:'gonumber',title:'货号',width:40, align:'center'},
            {field:'goaddress',title:'产地',width:40,sortable:true, align:'center'},
            {field:'gosize',title:'尺寸',width:40, align:'center'},
            {field:'godescript',title:'商品参数',width:40, align:'center'},
            {field:'categoryid',title:'分类',width:40,sortable:true, align:'center',
                formatter: function(value,row,index){
                    if (row.category){
                        return row.category.caname;
                    } else {
                        return value;
                    }
                }
            },
            {field:'shopid',title:'所属商铺',width:40, align:'center',
                formatter: function(value,row,index){
                    if (row.shop){
                        return row.shop.shname;
                    } else {
                        return value;
                    }
                }
            },
            {field:'xxx',title:'操作',width:130, align:'center',
                formatter:function (value,row,index) {
                    return "<a href='javascript:;' class='btn' onClick=\"deleteGoods('"+ row.goid +"');\"  data-options=\"iconCls:'icon-remove'\" >删除</a>&nbsp;&nbsp;<a data-options=\"iconCls:'icon-edit'\" href='javascript:;' class='btn' onClick=\"toUpdateGoods('"+ row.goid +"');\">修改</a>"+
                        "&nbsp;&nbsp;<a data-options=\"iconCls:'icon-edit'\" href='javascript:;' class='btn' onClick=\"findComment('"+ row.goid +"');\">查看评论</a>";
                }
            },
        ]],
        pagination:true,//使用分页效果   //当前页page    每页显示的条数 rows   后台定义 Integer page Integer rows   page=1&rows=10
        pageNumber:1,//初始时的页码  默认  第1页
        /*为了使更新删除按钮生效*/
        onLoadSuccess:function () {
            $(".btn").linkbutton()
        }
    })
});

/*查看该商品的评论*/
function findComment(id) {
    $("#comment").dialog({
        width:400,
        height:300,
        title:'评论详情',
        iconCls:'icon-man',
        href:'/goods/findAllComment/'+id,
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function () {
                $("#comment").dialog('close');
            }
        }],
    })
}

/*跳转添加窗口*/
function toAddGoods() {
    $("#update_goods").dialog({
        width:600,
        height:400,
        title:'添加商品信息',
        iconCls:'icon-man',
        href:'/goods/toGoodsAdd',
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function () {
                $("#update_goods").dialog('close');
            }
        },{
            text:'提交',
            iconCls:'icon-tick',
            handler:addGoods,
        }],
    })
}

/*添加商品信息*/
function addGoods() {
    $("#goodsadd").form({
        method:'POST',
        url:"/goods/addGoods",
        onSubmit: function(){
            //表单验证
            return $("#goodsadd").form('validate');
        },
        success:function(data){
            $.messager.show({
                title:'保存提示',
                msg:"保存成功",
                timeout:3000,
                showType:'slide'
            });
            /*关闭新增窗口，并刷新页面*/
            $("#update_goods").dialog('close');
            $("#goods_tb").datagrid('reload');
        }
    });
    $("#goodsadd").form('submit');
}

/*打开更新窗口*/
function toUpdateGoods(id) {
    $("#update_goods").dialog({
        width:600,
        height:400,
        title:'更新商品信息',
        iconCls:'icon-man',
        href:'/goods/findById/'+id,
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function () {
                $("#update_goods").dialog('close');
            }
        },{
            text:'提交',
            iconCls:'icon-tick',
            handler:updateGoods,
        }],
    })
}
/*提交更新请求*/
function updateGoods() {
    $("#goods_update").form({
        url:"/goods/modifyGoods",
        method:'POST',
        onSubmit: function(){
            //表单验证
            return $("#goods_update").form('validate');
        },
        success:function(data){
            $.messager.show({
                title:'保存提示',
                msg:'操作成功',
                timeout:3000,
                showType:'slide'
            });
            /*关闭新增窗口，并刷新页面*/
            $("#update_goods").dialog('close');
            $("#goods_tb").datagrid('reload');
        }
    });
    $("#goods_update").form('submit');
}

/*删除*/
function deleteGoods(id) {
    $.messager.confirm('确认对话框', '您确定删除这条记录吗？', function(r){
        if (r){
            $.ajax({
                type:"get",
                url:"/goods/removeGoods/"+id,
                data:{"id":id},
                success:function (result) {
                    $.messager.show({
                        title:'提示信息',
                        msg:'操作成功',
                        showType:'show'
                    });
                    $("#goods_tb").datagrid('reload');
                }
            });
        }
    });
}