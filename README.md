# boot2
spring boot 2.x
                 
####boot2-redis
    名称：boot2-redis
    描述：simple spring boot 2 + redis
    http端口：17100
                   
####boot2-shiro
    名称：boot2-shiro
    描述：simple spring boot 2 + shiro
    http端口：17101
                    
####boot2-ehcache
    名称：boot2-ehcache
    描述：simple spring boot 2 + ehcache
    http端口：17103
               
####boot2-jasypt
    名称：boot2-jasypt
    描述：使用jasypt加密数据库密码。
        demo中密钥写在配置文件中，别人拿到了一样可以解密。可以使用其他方式：
        1、启动参数
            java -jar xxx.jar --jasypt.encryptor.password=xxx
        2、设置环境变量
            vim /etc/profile
            export JASYPT_PASSWORD = xxx
            java -jar xxx.jar --jasypt.encryptor.password=${JASYPT_PASSWORD}
    http端口：17104
                   
####boot2-quartz
    名称：boot2-quartz
    描述：simple spring boot 2 + quartz
    http端口：17105
          