$(function () {
    /**
     * 页面初始化 加载数据
     */
    $('#userdg').datagrid({
        url: '/user/findAll',// 请求与路径
        method: 'GET',
        fitColumns: true,
        fit: true,
        pagination: true,
        onLoadSuccess: function () {
            //数据表格加载完成
            $(".btn").linkbutton({
                plain: true,
            });
        },
        toolbar: [{ /*顶部功能栏*/
            iconCls: 'icon-add',
            text: '添加用户',
            handler: toAddUser
        }],
        columns: [[
            {field: 'usid', title: 'ID',align:'center', width: 15},
            {field: 'usname', title: '用户名',align:'center', width: 10},
            {field: 'uscreate', title: '创建时间',align:'center', width: 10,sortable:true,remoteSort: false,
                sorter:function(a,b){// 指定排序方法
                    a = a.split('-');
                    b = b.split('-');
                    if (a[2] == b[2]){
                        if (a[0] == b[0]){
                            return (a[1]>b[1]?1:-1);
                        } else {
                            return (a[0]>b[0]?1:-1);
                        }
                    } else {
                        return (a[2]>b[2]?1:-1);
                    }
                }

            },
            {field: 'usphone', title: '手机号',align:'center', width: 15},
            {
                field: 'xxx', title: '操作',align:'center', width: 50, formatter: function (value, row, index) {
                    return "<a href='javascript:;' class='btn' onClick=\"delUserInfo('" + row.usid + "');\"  data-options=\"iconCls:'icon-remove'\" >删除</a>" +
                        "&nbsp;&nbsp;<a onclick=\"toUpdateUser('" + row.usid + "');\" data-options=\"iconCls:'icon-edit'\" href='javascript:;' class='btn'>修改</a>" +
                        "&nbsp;&nbsp;<a onclick=\"selectUserCart('" + row.usid + "');\" data-options=\"iconCls:'icon-cart'\" href='javascript:;' class='btn'>查看购物车</a>" +
                        "&nbsp;&nbsp;<a onclick=\"selectUserComment('" + row.usid + "');\" data-options=\"iconCls:'icon-comment'\" href='javascript:;' class='btn'>查看评论</a>" +
                        "&nbsp;&nbsp;<a onclick=\"selectUserAddress('" + row.usid + "');\" data-options=\"iconCls:'icon-car'\" href='javascript:;' class='btn'>查看地址</a>" +
                        "&nbsp;&nbsp;<a onclick=\"selectUserInfo('" + row.usid + "');\" data-options=\"iconCls:'icon-information'\" href='javascript:;' class='btn'>用户信息</a>" +
                        "&nbsp;&nbsp;<a onclick=\"selectUserCollect('" + row.usid + "');\" data-options=\"iconCls:'icon-house'\" href='javascript:;' class='btn'>查看收藏</a> ";
                }
            }
        ]]
    });
});


//添加用户信息
function saveUserInfo() {
    $("#addUserInfo").form({
        url: "/user/addUser",
        onSubmit: function () {
            return $("#addUserInfo").form('validate');
        },
        success: function (data) {//data是一个json字符串 用时必须转为js对象
            //map json
            $.messager.show({
                title: '操作提示',
                msg: '操作成功',
                timeout: 2000,
                showType: 'slide'
            });
            //关闭对话框
            $("#userda").dialog('close');
            $("#userdg").datagrid('reload');//  重新加载数据
        }
    });
    //提交form
    $("#addUserInfo").form('submit');
}

// 添加用户
function toAddUser() {
    $("#userda").dialog({
        width: 350,
        height: 220,
        href: '/user/toAddUser',
        method:'GET',
        title: '添加用户',
        iconCls: 'icon-user',
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function(){
                $("#userda").dialog('close');// 关闭弹出框
            }
        },{
            text:'添加',
            iconCls:'icon-tick',
            handler:saveUserInfo,
        }]
    });
}

//删除用户的信息
function delUserInfo(id) {
    $.messager.confirm('提示', '确定删除用户,包含其所有数据?', function (r) {
        if (r) {
            //发送ajax请求删除数据
            $.get("/user/removeUser/"+id, null, function (result) {//原生ajaxjquery封装 获取的是js对象
                $.messager.show({
                    title: '操作提示',
                    msg: '操作成功',
                    timeout: 2000,
                    showType: 'slide'
                });
                //响应回来刷新刷新datagrid
                $('#userdg').datagrid('reload');
            });
        }
    })
}

//跳转到更新用户信息界面-- 添加js在updateuser界面中
function toUpdateUser(id) {
    $("#userda").dialog({
        width: 500,
        height: 300,
        title: '修改用户信息',
        iconCls: 'icon-man',
        href: 'toModifyUser/'+id,//相当于两张页面的源码包含
        method:'GET',
        buttons: [{
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                //关闭对话框
                $("#userda").dialog('close');
            }
        }, {
            text: '保存信息',
            iconCls: 'icon-tick',
            handler: updateUserInfo,// 更新信息
        }],
    });
    $('#userdg').datagrid('reload');// 重新加载数据
}

//保存用户信息
function updateUserInfo() {
    $("#updateUserInfo").form({
        url: "/user/modifyUser",
        method:'POST',
        onSubmit: function () {
            return $("#updateUserInfo").form('validate');
        },
        success: function (data) {//data是一个json字符串 用时必须转为js对象
            $.messager.show({
                title: '保存提示',
                msg: '修改成功',
                timeout: 3000,
                showType: 'slide'
            });
            //关闭对话框
            $("#userda").dialog('close');
            //响应回来刷新刷新datagrid
            $('#userdg').datagrid('reload');
        }
    });
    $("#updateUserInfo").form('submit');
}




//查看用户的购物车
function selectUserCart(id) {
    $("#userda").dialog({
        width: 400,
        height: 300,
        href: '/user/toUserCart/'+id,// 跳转到购物车部分
        method:'GET',
        title: '查看用户购物车',
        iconCls: 'icon-cart',
        buttons:[{
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                //关闭对话框
                $("#userda").dialog('close');
            }
        }]
    });
}


//查看用户的评论
function selectUserComment(id) {
    $("#userda").dialog({
        width: 530,
        height: 300,
        href: '/user/toUserComment/'+id,
        title: '查看用户评论',
        iconCls: 'icon-comment',
        buttons:[{
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                //关闭对话框
                $("#userda").dialog('close');
            }
        }]
    });

}

//查看用户的地址
function selectUserAddress(id) {
    $("#userda").dialog({
        width: 520,
        height: 300,
        href: '/user/toUserAddress/'+id,
        title: '查看用户地址',
        iconCls: 'icon-car',
        buttons:[{
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                //关闭对话框
                $("#userda").dialog('close');
            }
        }]
    });
}

//查看用户的信息
function selectUserInfo(id) {
    $("#userda").dialog({
        width: 500,
        height: 200,
        href: '/user/toUserInfo/'+id,
        method:'GET',
        title: '用户信息',
        iconCls: 'icon-information',
        buttons:[{
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                //关闭对话框
                $("#userda").dialog('close');
            }
        }]
    });
}

//查看用户的收藏
function selectUserCollect(id) {
    $("#userda").dialog({
        width: 330,
        height: 300,
        href: '/user/toUserCollect/'+id,
        title: '用户收藏',
        iconCls: 'icon-house',
        buttons:[{
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                //关闭对话框
                $("#userda").dialog('close');
            }
        }]
    });
}

