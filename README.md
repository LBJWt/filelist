## 功能
**输入文件夹路径，输出当前文件夹下的所有文件以及文件夹的大小,文件从大到小排序。**

## 打包
- 在项目上鼠标右键 --> Open Module Settings
- Artifacts --> + --> JAR --> From modules with dependencies...
- Main Class是你这个项目(脚本)的主方法,就是要运行的类,选一个
- 设置 META-INF/MANIFEST.MF 切记,不能用默认的，选择根目录下
-  Build Artifacts... --> XXX.jar --> Build

## 执行效果
```shell script
PS D:\software> java -jar .\filelist.jar
文件（文件夹）名称       文件（文件夹）大小
请输入文件路径（绝对路径）：
D:\software
文件夹名称： D:\software
文件（文件夹）名称                                                                                              文件（文件夹）大小
mysql-8.0.18-winx64                                                                                     1.14G
PD16.5                                                                                                  918.27M
PD16.5.zip                                                                                              647.28M
ideaIU-2019.1.3.exe                                                                                     561.67M
Shadowsocks-4.1.3.1                                                                                     424.95M
mysql-8.0.18-winx64.zip                                                                                 272.27M
jdk-8u231-windows-x64.exe                                                                               210.18M
```
