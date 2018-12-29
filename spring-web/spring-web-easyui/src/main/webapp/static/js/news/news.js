$(function () {
    $("#news_tb").datagrid({
        method:"GET",
        fit:true,
        remoteSort:false,
        pagination:true,
        fitColumns:true,//用来让现有datagrid中列根据表格的宽度自适应  根据列的宽度的一定比例进行分配
        url:'/news/findAll',
        toolbar: [{
            iconCls: 'icon-add',
            text: '添加资讯',
            handler: toAddNews,
        }],
        columns:[[
            {field:'neid',title:'ID',width:60,sortable:true,align:'center'},
            {field:'netitle',title:'标题',width:80,sortable:true,align:'center'},
            {field:'necontent',title:'内容',width:80,sortable:true,align:'center'},/*可以不显示 太多了*/
            {field:'necreate',title:'创建时间',width:80,sortable:true,align:'center'},
            {field:'neimage',title:'封面',width:80,align:'center'},
            {field:'userid',title:'用户',width:50,sortable:true,align:'center',
                formatter: function(value,row,index){
                    return row.user.usname;
                }
            },
            {field:'categoryid',title:'分类',width:50,sortable:true,align:'center',
                formatter: function(value,row,index){
                    return row.category.caname;
                }
            },
            {field:'xxx',title:'操作',width:130,align:'center',
                formatter:function (value,row,index) {
                    return "<a href='javascript:;' class='btn' onClick=\"deleteNews('"+ row.neid +"');\"  data-options=\"iconCls:'icon-remove'\" >删除</a>&nbsp;&nbsp;" +
                        "<a data-options=\"iconCls:'icon-edit'\" href='javascript:;' class='btn' onClick=\"toUpdateNews('"+ row.neid +"');\">修改</a>" +
                        "&nbsp;&nbsp;<a data-options=\"iconCls:'icon-edit'\" href='javascript:;' class='btn' onClick=\"findComment('"+ row.neid +"');\">查看评论</a>";
                }
            },
        ]],
        /*为了使更新删除按钮生效*/
        onLoadSuccess:function () {
            $(".btn").linkbutton()
        }
    })
})




/*打开添加界面*/
function toAddNews() {
    $("#updateNews").dialog({
        width:540,
        height:300,
        title:'添加资讯信息',
        iconCls:'icon-man',
        href:'/news/toAddNews',
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function () {
                $("#updateNews").dialog('close');
                $("#news_tb").datagrid('reload');
            }
        },{
            text:'保存',
            iconCls:'icon-tick',
            handler:addNews,
        }],
    })
}

/*添加news*/
function addNews() {
    $("#news_add").form({
        url:"/news/addNews",
        onSubmit: function(){
            //表单验证
            return $("#news_add").form('validate');
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
            $("#updateNews").dialog('close');
            $("#news_tb").datagrid('reload');
        }
    });
    $("#news_add").form('submit');
}

/*打开更新窗口*/
function toUpdateNews(id) {
    $("#updateNews").dialog({
        width:600,
        height:300,
        title:'更新资讯信息',
        iconCls:'icon-man',
        href:'/news/findById/'+id,
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function () {
                $("#updateNews").dialog('close');
            }
        },{
            text:'保存',
            iconCls:'icon-tick',
            handler:updateNews,
        }],
    })
}
/*提交更新请求*/
function updateNews() {
    $("#news_update").form({
        url:"/news/modifyNews",
        method:'POST',
        onSubmit: function(){
            //表单验证
            return $("#news_update").form('validate');
        },
        success:function(data){
            // var j = JSON.parse(data);
            $.messager.show({
                title:'保存提示',
                msg:'操作成功',
                timeout:3000,
                showType:'slide'
            });
            /*关闭新增窗口，并刷新页面*/
            $("#updateNews").dialog('close');
            $("#news_tb").datagrid('reload');
        }
    });
    $("#news_update").form('submit');
}


/*删除*/
function deleteNews(id) {
    $.messager.confirm('确认对话框', '您确定删除这条记录吗？', function(r){
        if (r){
            $.ajax({
                type:"get",
                url:"/news/removeNews/"+id,
                success:function (result) {
                    $("#news_tb").datagrid('reload');
                }
            });
        }
    });
}

/*查看该资讯的评论*/
function findComment(id) {
    $("#comment_news").dialog({
        width:400,
        height:260,
        title:'评论详情',
        iconCls:'icon-add',
        method:'GET',
        href:'/news/findAllComment/'+id,
        buttons:[{
            text:'关闭',
            iconCls:'icon-cancel',
            handler:function () {
                $("#comment_news").dialog('close');
            }
        }],
    })
}

