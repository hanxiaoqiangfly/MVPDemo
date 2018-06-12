# MVPDemo
MVP的二次封装使用，减少m、v、p层代码的编写

项目中使用了本人自己封装的一个常用工具slibrary库，可以导入自己的项目中使用
特别注意：将slibrary库导入自己项目中时，一定要补上以下代码
         app模块下的 build.gradle添加
                  defaultConfig {
                            resValue "string", "au_provider_file_authorities", "你的包名.fileprovider"
                   }

        因为在该库中有个updataTool更新app版本工具类，其中使用了fileprovider，如不添加会出现项目无法安装的问题
        报错   Installation failed with message INSTALL_FAILED_CONFLICTING_PROVIDER.


终于等到你！！！