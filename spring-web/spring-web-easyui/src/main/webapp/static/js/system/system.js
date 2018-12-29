$(function(){

    $("#systemmessage").datagrid({
        url:'/system/findAll',//查询所有用户信息  json  rows total
        fit:true,
        method:'GET',
        fitColumns:true,
        columns:[[
            {title:'关于我们',field:'coabout',width:60,},
            {title:'联系我们',field:'coconnect',width:100,},
            {title:'认证',field:'coidentification',width:150,},
            {title:'其他内容',field:'coother',width:100,},
            {title:'操作',field:'options',width:150,
                formatter:function(value,row,index){
                    return "<a data-options=\"iconCls:'icon-edit'\" onClick=\"openmessageUpdateDialog('"+ row.coid +"');\" href='javascript:;' class='btn'>修改</a>";
                }
            },
        ]],
        onLoadSuccess:function(){
            $(".btn").linkbutton({plain:true});
        }
    });

});

//用来处理数据的更新
function openmessageUpdateDialog(id){
    $("#da").dialog({
        width:550,
        height:250,
        title:'修改系统信息',
        iconCls:'icon-man',
        href:'/system/findById/'+id,//相当于两张页面的源码包含
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function(){
                //关闭对话框
                $("#da").dialog('close');
            }
        },{
            text:'保存信息',
            iconCls:'icon-tick',
            handler:updateSystem,
        }],

    });
}

//保存信息
function updateSystem(){
    $("#updateSystem").form({
        url:"/system/modifySystem",
        onSubmit: function(){
            return $("#updateSystem").form('validate');
        },
        success:function(data){//data是一个json字符串 用时必须转为js对象
            //map json
            $.messager.show({
                title:'保存提示',
                msg:'保存成功',
                timeout:3000,
                showType:'slide'
            });
            //关闭对话框
            $("#da").dialog('close');
            $("#systemmessage").datagrid('reload');
        }
    });
    //提交form
    $("#updateSystem").form('submit');
}