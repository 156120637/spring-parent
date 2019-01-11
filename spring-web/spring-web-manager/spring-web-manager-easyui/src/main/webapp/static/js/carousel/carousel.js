// 初始化数据
$(function(){
    $('#carouselDg').datagrid({
        url:'/carousel/findAll',
        fitColumns:true,
        method:"GET",
        pagination:true,
        fit:true,
        onLoadSuccess:function(){
            //数据表格加载完成
            $(".btn").linkbutton({
                plain:true,
            });
        },
        toolbar: [{ /*顶部功能栏*/
            iconCls: 'icon-add',
            text: '添加轮播图',
            handler: toAddCarousel
        }],
        columns:[[
            {field:'caid',title:'ID',width:25 , align:'center'},
            {field:'caname',title:'商品名',width:25, align:'center'},
            {field:'cacreate',title:'创建时间',width:25, align:'center'},
            {field:'caimage',title:'图片信息',width:30,align:'center',
                formatter:function (value,row,index) {
                    return  "<img th:src='@{"+row.caimage+"}' />";
                }
            },
            {field:'option',title:'操作',width:50, align:'center',
                formatter:function (value,row,index) {
                    return  "<a href='javascript:;' class='btn' onClick=\"delCarousel('"+ row.caid +"');\"  data-options=\"iconCls:'icon-remove'\" >删除</a>" +
                        "&nbsp;&nbsp;<a onclick=\"toUpdateCarousel('"+ row.caid +"');\" data-options=\"iconCls:'icon-edit'\" href='javascript:;' class='btn'>修改</a>";
                }}
        ]]
    });
    $('#carouselDg').datagrid('reload');
})
//删除轮播图
function delCarousel(caid) {
    $.messager.confirm('提示', '确定要删除这条数据吗?', function(r){
        if (r){
            //发送ajax请求删除数据
            $.get("/carousel/removeCarousel/"+caid,{"caid":caid},function(result){//原生ajaxjquery封装 获取的是js对象
                //状态提示
                //响应回来刷新刷新datagrid
                $("#carouselDg").datagrid('reload');
            });
        }
    })
}
/*添加轮播图 界面*/
function toAddCarousel() {
    $("#imageDl").dialog({
        width: 400,
        height: 270,
        title: '添加图片信息',
        iconCls: 'icon-man',
        href: '/carousel/toAddCarousel',//相当于两张页面的源码包含
        buttons: [{
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                //关闭对话框
                $("#imageDl").dialog('close');
            }
        }, {
            text: '保存信息',
            iconCls: 'icon-tick',
            handler: saveCarousel,
        }],
    });
}

//保存轮播图
function saveCarousel(){
    $("#addCarousel").form({
        url:"/carousel/addCarousel",
        onSubmit: function(){
            return $("#imageCarousel").form('validate');
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
            $("#imageDl").dialog('close');
            $("#carouselDg").datagrid('reload');
        }
    });
    //提交form
    $("#addCarousel").form('submit');
}

/*修改轮播图*/
function toUpdateCarousel(caid) {
    $("#imageDl").dialog({
        width: 400,
        height: 300,
        title: '更新图片信息',
        iconCls: 'icon-man',
        href: '/carousel/findById/'+caid,//相当于两张页面的源码包含
        buttons: [{
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                //关闭对话框
                $("#imageDl").dialog('close');
            }
        }, {
            text: '保存',
            iconCls: 'icon-tick',
            handler: updateCarousel,
        }],
    });
}

/*更新轮播图*/
function updateCarousel(){
    $("#updateCarousel").form({
        url:"/carousel/modifyCarousel",
        onSubmit: function(){
            return $("#updateCarousel").form('validate');
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
            $("#imageDl").dialog('close');
            $("#carouselDg").datagrid('reload');
        }
    });
    //提交form
    $("#updateCarousel").form('submit');
}