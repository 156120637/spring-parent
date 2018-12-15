
#### GIT 提交commit格式
```java
GIT 提交格式先暂定一下规则，实际开发中可以不用严格遵守，但是力求每次提交清晰知晓提交情况即可。在此基础上希望能严格遵守这些规则。
```

type（必需）、scope（可选）和subject（必需）。



> (1) type

- ```shell
  - type用于说明 commit 的类别，只允许使用下面8个标识。
  - br: 此项特别针对bug号，用于向测试反馈bug列表的bug修改情况
  - feat：新功能（feature）
  - fix：修补bug
  - docs：文档（documentation）
  - style： 格式（不影响代码运行的变动）
  - refactor：重构（即不是新增功能，也不是修改bug的代码变动）
  - test：增加测试
  - chore：构建过程或辅助工具的变动
  - revert: feat(pencil): add 'graphiteWidth' option (撤销之前的commit)
  
  ```


> (2)scope

```shell
 scope用于说明 commit 影响的范围，比如数据层、控制层、视图层等等，视项目不同而不同。
```

> (3)subject

```shell
 subject是 commit 目的的简短描述，不超过50个字符。
 以动词开头，使用第一人称现在时，比如change，而不是changed或changes
 第一个字母小写
 结尾不加句号（.）
```

> (4)Body 部分是对本次 commit 的详细描述，可以分成多行