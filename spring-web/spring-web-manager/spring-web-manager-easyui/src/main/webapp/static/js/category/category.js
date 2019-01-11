$(function () {
    $("#category_tb").datagrid({
        method:"GET",
        fit:true,
        remoteSort:false,
        pagination:true,
        fitColumns:true,//用来让现有datagrid中列根据表格的宽度自适应  根据列的宽度的一定比例进行分配
        url:'/category/findAll',
        toolbar: [{ /*顶部功能栏*/
            iconCls: 'icon-add',
            text: '添加分类',
            handler: toAddCategory /*跳转到添加接卖弄*/
        }],
        columns:[[
            {field:'caid',title:'ID',width:100,align:'center'},
            {field:'caname',title:'名称',width:100,sortable:true,align:'center',},
            {field:'cacreate',title:'添加时间',width:100,sortable:true,align:'center',},
            {field:'carole',title:'属性',width:100,align:'center',
                formatter:function (value,row,index) {
                    if(value==1)
                        return "资讯分类"
                    else
                        return "商品分类"
                }
            },
            {field:'xxx',title:'操作',width:100,align:'center',
                formatter:function (value,row,index) {
                    return "<a href='javascript:;' class='btn' onClick=\"deleteCategory('"+ row.caid +"');\"  data-options=\"iconCls:'icon-remove'\" >删除</a>&nbsp;&nbsp;<a data-options=\"iconCls:'icon-edit'\" href='javascript:;' class='btn' onClick=\"toUpdateCategory('"+ row.caid +"');\">修改</a>";
                }
            },
        ]],
        /*为了使更新删除按钮生效*/
        onLoadSuccess:function () {
            $(".btn").linkbutton()
        }
    })
})

/*弹出添加界面*/
function toAddCategory() {
    $("#update_category").dialog({
        width:300,
        height:200,
        title:'添加分类信息',
        iconCls:'icon-man',
        href:'/category/toAddCategory',
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function () {
                $("#update_category").dialog('close');
            }
        },{
            text:'提交',
            iconCls:'icon-tick',
            handler:addCategory,/*提交处理方法*/
        }],
    })
}
/*添加分类信息*/
function addCategory() {
    $("#categroy_add").form({
        url:"/category/addCategory",
        method:'POST',
        onSubmit: function(){
            //表单验证
            return $("#categroy_add").form('validate');
        },
        success:function(data){
            // var j = JSON.parse(data);
            $.messager.show({
                title: '保存提示',
                msg: "保存成功",
                timeout:3000,
                showType:'slide'
            });
            /*关闭新增窗口，并刷新页面*/
            $("#update_category").dialog('close');
            $("#category_tb").datagrid('reload');
        }
    });
    $("#categroy_add").form('submit');
}

/*打开更新窗口*/
function toUpdateCategory(id) {
    $("#update_category").dialog({
        width:300,
        height:200,
        title:'更新分类信息',
        iconCls:'icon-man',
        method:'GET',
        href:'/category/findById/'+id,
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function () {
                $("#update_category").dialog('close');
            }

        },{
            text:'提交',
            iconCls:'icon-tick',
            handler: updateCategory,/*处理方法*/
        }],
    })
}
/*修改分类信息*/
function updateCategory() {
    $("#category_update").form({
        url:"/category/modifyCategory",
        method:'POST',
        onSubmit: function(){
            //表单验证
            return $("#category_update").form('validate');
        },
        success:function(data){
            $.messager.show({
                title: '保存提示',
                msg: "保存成功",
                timeout:3000,
                showType:'slide'
            });
            /*关闭新增窗口，并刷新页面*/
            $("#update_category").dialog('close');
            $("#category_tb").datagrid('reload');
        }
    });
    $("#category_update").form('submit');
}


/*删除*/
function deleteCategory(id) {
    $.messager.confirm('确认对话框', '确认删除吗,包含其下所有数据？', function(r){
        if (r){
            $.ajax({
                type:"get",
                url:"/category/removeCategory/"+id,
                data:{"id":id},
                success:function (result) {
                    $.messager.show({
                        title: '保存提示',
                        msg: "保存成功",
                        timeout:3000,
                        showType:'slide'
                    });
                }
            });
        }
    });
}