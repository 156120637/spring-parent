#### swagger使用方式
##### 访问方式
```java
http://ip:[port]/${server.context-path}/swagger-ui.html
```
##### 注解详解
```java
@Api(description = "组描述") 用于控制类
    表示标识这个类是swagger的资源 

@ApiOperation()用于方法
    表示一个http请求的操作
    value：用于方法描述 
    notes：用于提示内容 
    tags：可以重新分组（视情况而用）
@ApiParam()用于方法，参数，字段说明
    表示对参数的添加元数据（说明或是否必填等）
    name：参数名 
    value：参数说明 
    required：是否必填
    public void getUser(@ApiParam(name="id",value="用户id",required=true) Integer id)
@ApiModel()用于类 
    表示对类进行说明，用于参数用实体类接收 
    value：表示对象名 
    description：描述 都可省略 
@ApiModelProperty()用于方法，字段 
    表示对model属性的说明或者数据操作更改 
    value：字段说明 
    name：重写属性名字 
    dataType：重写属性类型 
    required：是否必填 
    example：举例说明 
    hidden：隐藏
    public class User {
         @ApiModelProperty(value="用户名",name="username",example="tianjiaqin")
         private String username;
    }     
@ApiIgnore()用于类，方法，方法参数 
    表示这个方法或者类被忽略 
@ApiImplicitParam() 用于方法 
    表示单独的请求参数
@ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam        
    
```

