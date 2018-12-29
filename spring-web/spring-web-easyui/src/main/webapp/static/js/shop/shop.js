
$(function(){
    /*初始化数据*/
    $("#shopDataGrid").datagrid({
        method:'GET',
        url:'/shop/findAll',//查询所有用户信息  json  rows total
        fit:true,
        pagination:true,
        fitColumns:true,
        columns:[[
            {title:'商铺ID',field:'shid',width:60,},
            {title:'商铺名称',field:'shname',width:60,},
            {title:'创建日期',field:'shcreate',width:100,},
            {title:'商铺图片',field:'shimage',width:150,},
            {title:'商铺描述',field:'shdescribes',width:100,},
            {title:'联系方式',field:'shcontact',width:100,},
            {title:'店铺等级',field:'shrole',width:80,},
            {title:'店铺地址',field:'shaddress',width:100,},

            {title:'操作',field:'xxx',width:150,
                formatter:function(value,row,index){
                    return "<a href='javascript:;' class='btn' onClick=\"delShopInfo('"+ row.shid +"');\"  data-options=\"iconCls:'icon-remove'\" >删除</a>&nbsp;&nbsp;"
                        +"<a data-options=\"iconCls:'icon-edit'\" onClick=\"openUpdateDialog('"+ row.shid +"');\" href='javascript:;' class='btn'>修改</a>";
                }
            },
        ]],
        toolbar: [{
            iconCls: 'icon-add',
            text:'添加商铺',
            handler: toAddShop,
        }],
        onLoadSuccess:function(){
            $(".btn").linkbutton({plain:true});
        }
    });

});

/*删除商铺*/
function delShopInfo(id){
    alert(id);
    $.messager.confirm('确认','确认删除？',function (r) {
        //URL请求路径，id是想要删除的店铺的id
        $.post("/shop/removeShop/"+id,{"id":id},function(result){
            //刷新datagrid
            $("#userDataGrid").datagrid('reload');
        });
    });
}


/*用来处理数据的更新*/
function openUpdateDialog(id){
    $("#shopda").dialog({
        width:600,
        height:300,
        title:'商铺信息修改',
        iconCls:'icon-man',
        href:'/shop/toUpdateShop/'+id,
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function(){
                //关闭对话框
                $("#shopda").dialog('close');
            }

        },{
            text:'保存',
            iconCls:'icon-tick',
            handler:updateShopInfo,
        }],

    });
}

/*商铺数据更新*/
function updateShopInfo(){
    $("#updateShop").form({
        url:"/shop/modifyShop",
        method:'POST',
        onSubmit: function(){
            return $("#updateShop").form('validate');
        },
        success:function(data){//data是一个json字符串 用时必须转为js对象
            //map json
            $.messager.show({
                title:'保存提示',
                msg:'修改成功',
                timeout:3000,
                showType:'slide'
            });
            //关闭对话框
            $("#shopda").dialog('close');
            $("#shopDataGrid").datagrid('reload');// 重新加载数据
        }
    });
    //提交form
    $("#updateShop").form('submit');
}


/*添加商铺跳转界面*/
function toAddShop(){
    $("#shopda").dialog({
        width:600,
        height:300,
        title:'添加商铺信息',
        iconCls:'icon-man',
        href:'/shop/toAddShop',
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function(){
                //关闭对话框
                $("#shopda").dialog('close');
            }
        },{
            text:'保存信息',
            iconCls:'icon-tick',
            handler:saveShop,
        }],

    });
}

/*添加商铺信息*/
function saveShop() {
    $("#saveShop").form({
        url: "/shop/addShop",
        method:'POST',
        onSubmit: function () {
            return $("#saveShop").form('validate');
        },
        success: function (data) {//data是一个json字符串 用时必须转为js对象
            //map json
            $.messager.show({
                title: '保存提示',
                msg: '信息已保存',
                timeout: 3000,
                showType: 'slide'
            });
            //关闭对话框
            $("#shopda").dialog('close');
            $("#shopDataGrid").datagrid('reload');
        }
    });
    //提交form
    $("#saveShop").form('submit');
}


