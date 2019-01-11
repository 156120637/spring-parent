$(function(){

    $("#feedback").datagrid({
        url:'/feedback/findAll',//查询所有用户信息  json  rows total
        fit:true,
        pagination:true,
        fitColumns:true,
        method:'GET',
        columns:[[
            {title:'ID',field:'feid',width:60,},
            {title:'反馈内容',field:'fecontent',width:60,},
            {title:'反馈时间',field:'fecreate',width:100,},
            {title:'用户',field:'userid',width:150,
                formatter: function(value,row,index){
                    if (row.user){
                        return row.user.usname;
                    } else {
                        return value;
                    }
                }
            },
            {title:'用户系统环境',field:'usenvironment',width:100,},
        ]],
        onLoadSuccess:function(){
            $(".btn").linkbutton({plain:true});
        }
    });

});