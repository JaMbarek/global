### 在原来mybatis的基础上添加插件拓展
- 1.添加分页生成插件 ``MySQLPaginationPlugin``
- 2.添加批量插入插件 ``BatchInsertPlugin``
- 3.添加逻辑删除插件 ````
- 4.添加mapper父类接口和泛型支持插件 ``MapperPlugin``
- 5.添加entity的父类继承插件
- 6.添加in查询数量控制
- 7.添加likeboth查询方法
- 8.添加entity lombok插件 ``LombokPlugin``
- 9.添加日期类型映射到java8的localdatetime类型上 ``CustomJavaTypeResolverDefaultImpl``
- 10.存在即更新方法 ``UpsertPlugin``
- 11.添加根据example查询一个的方法 ``SelectOneByExamplePlugin``