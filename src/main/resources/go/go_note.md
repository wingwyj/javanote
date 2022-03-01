## Go_Note
### 常用命令
  #### 初始化仓库
  * `git init` 初始化一个Git仓库(将文件夹和Git关联)。  
  * `git add <file>` 将文件交给Git管理。  
  * `git commit -m <message>` 将文件(修改)提交到本地Git仓库。  
  * `git status` 查看工作区文件状态(是否有修改)。
  * `git diff` 查看修改的内容。
  #### 版本管理
  * `git reset --hard <commit_id>` 版本之间切换。
  * `git log --pretty=oneline` 简化查看提交log。
  * `git reflog` 查看所有历史提交log。回退后也可以看到会退前的提交log。
  #### 核心概念
  * **工作区(Working Directory)** 项目所在目录(git init时所在文件夹)。
  * **版本库（Repository）** 工作区中有一个隐藏目录`.git`，这个目录不算工作区，是Git的版本库。Git的版本库里存了很多东西，其中最重要的就是称为stage（或者叫index）的暂存区，还有Git为我们自动创建的第一个分支master，以及指向master的一个指针叫HEAD。  
  
