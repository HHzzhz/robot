# robot
A magic robot can run cmd in server

通过对配置文件robot.yml中的path和cmd进行配置可以实现对server上path目录下相应脚本的调用。
不止于此，实际上可以运行几乎所有命令。

调用接口的大致形式是robotHost:port/robot/{cmd}
