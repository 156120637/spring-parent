$(function(){
    $("#orderlist").datagrid({
        url:'/order/findAll',//查询所有用户信息  json  rows total
        fit:true,
        pagination:true,
        fitColumns:true,
        method:'GET',
        toolbar: [{
            iconCls: 'icon-download',
            text:'导出Excel',
            handler: excelExport,
        },{
            iconCls: 'icon-email',
            text:'发送到Email',
            handler: sendEmail,
        }],
        columns:[[
            {title:'订单ID',field:'orid',width:60,},
            {title:'订单号',field:'ornumber',width:60,},
            {title:'创建日期',field:'orcreate',width:100,},
            {title:'用户名',field:'usname',width:150,
                formatter: function(value,row,index){
                    if (row.user){
                        return row.user.usname;
                    } else {
                        return value;
                    }
                }
            },
            {title:'付款状态',field:'orpaystatus',width:150,
                formatter: function(value,row,index){
                    if (row.orpaystatus==0){
                        return '已付款';
                    } else {
                        return '未付款';
                    }
                }
            },
            {title:'收件人',field:'recname',width:150,
                formatter: function(value,row,index){
                    if (row.address){
                        return row.address.adrecname;
                    } else {
                        return value;
                    }
                }
            },
            {title:'地址',field:'addressid',width:100,
                formatter: function(value,row,index){
                    if (row.address){
                        return row.address.addressdetail;
                    } else {
                        return value;
                    }
                }
            },
            {title:'商品名',field:'goid',width:100,
                formatter: function(value,row,index){
                    if (row.goods){
                        return row.goods.goname;
                    } else {
                        return value;
                    }
                }
            },
            {title:'留言信息',field:'ormessage',width:100,},

        ]],
        onLoadSuccess:function(){
            $(".btn").linkbutton({plain:true});
        }
    });

});

function excelExport(){
    location.href='/excel/export';
    /*一定要记住Ajax 不能请求下载
    * 原因: ajax是以文本类型的请求与,数据只能存放在文本中]
    *       文件下载是以二进制的形式进行的  所以不能使用ajax请求下载
    * */
    /*$.ajax({
        url:'/excel/export',
        method:'GET',
        success:function(data){
            $.messager.show({
                title: '操作提示',
                msg: "操作成功",
                timeout:3000,
                showType:'slide'
            });
        }
    })*/
}
/*跳转到添加email*/
function sendEmail(){
    $("#toSendEmail").dialog({
        width: 350,
        height: 230,
        href: '/email/toAddEmail',
        title: '发送到Email',
        iconCls: 'icon-email',
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function(){
                $("#toSendEmail").dialog('close');// 关闭弹出框
            }
        },{
            text:'发送',
            iconCls:'icon-email',
            handler:sendToEmail,
        }]
    });
}
/*发送email*/
function sendToEmail(){
    $("#sendToMyEmail").form({
        url: "/email/sendMail",
        onSubmit: function () {
            return $("#sendToMyEmail").form('validate');
        },
        success: function (data) {
            $.messager.show({
                title: '操作提示',
                msg: '操作成功',
                timeout: 2000,
                showType: 'slide'
            });
            //关闭对话框
            $("#toSendEmail").dialog('close');
        }
    });
    //提交form
    $("#sendToMyEmail").form('submit');
}