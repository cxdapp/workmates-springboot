# workmates-springboot 团队管理网站
![image](https://github.com/lonkecxd/workmates-springboot/blob/master/src/main/resources/static/img/logo2.png)
## 描述

受启发于团队开发产品过程中的经验教训，比如人员组织不齐，项目进度容易拖拉、缺乏效率，角色分配引发争议等等问题。我们决定做一个“团队工作管理”网站。我们希望为用户，特别是工作团队提供一套全方位的“工作流程”监管平台。

## 功能概况

项目管理：新建项目、修改项目、删除项目；添加步骤；上传项目进度。

工作角色分配：加入成员；分配项目步骤；设置截止时间；上传步骤进度。

统计分析：图表分析。

## 界面示意图
![image](https://github.com/lonkecxd/workmates-springboot/blob/master/src/main/resources/static/img/workmates%E9%A1%B5%E9%9D%A2-%E5%9F%BA%E6%9C%AC%E6%A1%86%E6%9E%B6.png)
【页面-基本框架】
![image](https://github.com/lonkecxd/workmates-springboot/blob/master/src/main/resources/static/img/workmates%E9%A1%B5%E9%9D%A2-%E5%BB%BA%E7%AB%8B%E9%A1%B9%E7%9B%AE.png)
【页面-建立项目】
![image](https://github.com/lonkecxd/workmates-springboot/blob/master/src/main/resources/static/img/workmates%E9%A1%B5%E9%9D%A2-%E9%A1%B9%E7%9B%AE%E5%B1%95%E7%A4%BA.png)
【页面-项目展示】
![image](https://github.com/lonkecxd/workmates-springboot/blob/master/src/main/resources/static/img/workmates%E9%A1%B5%E9%9D%A2-%E9%A1%B9%E7%9B%AE%E4%B8%8B%E8%BD%BD.png)
【页面-项目下载】
![image](https://github.com/lonkecxd/workmates-springboot/blob/master/src/main/resources/static/img/workmates%E9%A1%B5%E9%9D%A2-%E9%A1%B9%E7%9B%AE%E5%AE%A1%E6%A0%B8.png)
【页面-项目审核】
![image](https://github.com/lonkecxd/workmates-springboot/blob/master/src/main/resources/static/img/workmates%E9%A1%B5%E9%9D%A2-%E7%BB%9F%E8%AE%A1%E9%A1%B5%E9%9D%A2.png)
【页面-统计页面】

## 系统功能设计

控制台主面板：

显示所有项目（分类：创建的、参与的）

个人中心：

用户基本信息

所得积分

好友列表

团队管理：

若为某项目组长，则赋予组长的功能：

组长功能：添加、删除成员；队内聊天；查看自己的任务；查看他人的完成进度;给队友发私信。

若为组员，则只能看项目相关资源以及自己的任务及进度

普通功能：队内聊天；查看自己的任务；给队友发私信。

项目管理（新建项目之后）：

在开发过程中，一个“项目”包涵若干个“任务”。

若为组长，则具有以下功能：

建立新的任务，分配给组员，设置Deadline。

审核组员的提交，并把确认信息反馈给组员。如果审核不通过，则拒绝提交，返回组员重做。

审核组员的退出（任务）申请，把任务分配给新的组员。

如果过了有效期，自动解除组员的任务分配，同样交给其他组员。

若为组员，则具有以下功能：

申请延期提交任务。

提交完成任务的相关文档。

提出放弃任务的申请。

查看自己的所有任务。

其他：

1.	待完善功能

	荣誉室：已经完成的项目（可以选择分享和编辑），点击编辑之后该项目出现在团队管理模块，荣誉室清除该项目

	联系管理员：为用户推荐组建项目团队合适的成员

	通知：系统推送的消息、有关项目的进展、其他用户对该用户已开源项目的点赞、评论等操作…

	搜索栏： 分为搜用户名、搜项目名等

## 积分规则：

分为个人积分和项目积分；

#### 一 个人积分

由提交的次数与文档质量，由后台自动判定。（ 若分完后组长得分低于组员最高分，组长得此最高分，其余组员扣除两次得分差/人数）

#### 二 项目计分

 （1）工程效率：代码量/（人数*完成周期）10%
 
 （2）规范性：文档齐全，项目分工进度清晰明确 20%
 
 （3）完成效果：
 
                功能性                    70%
                
                完善性                    20%
                
                使用技术的前沿性          10%
                
 （4）开源后下载量：每下载一次每名成员积1分，上限50
  
#### 三 扣分及加分 

1 自己中途退出项目：扣除其退出的项目的积分/人数

2 所创建的项目完成后，下载量+1则项目积分+5分；时间过去一个月后，下载量+1则项目积分+1分。即刚完成的项目在推广时获得较大优势。
