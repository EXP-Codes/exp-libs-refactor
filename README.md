# exp-libs-refactor

> 经验构件库（重构版）

------

## 运行环境

[![](https://img.shields.io/badge/JDK-1.8%2B-brightgreen.svg)](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) [![](https://img.shields.io/badge/Maven-3.2.5%2B-brightgreen.svg)](https://maven.apache.org/) [![](https://img.shields.io/badge/IDE-Idea-brightgreen.svg)](https://www.jetbrains.com/zh-cn/idea/) ![](https://img.shields.io/badge/Platform-windows|*nix-brightgreen.svg) 


## 简介

正在作业中，原项目基本已废弃：https://github.com/lyy289065406/exp-libs


## 使用

settings 仓库追加 sonatype 中央仓库配置（本项目发布到该中央仓库）：

```xml
<mirror>
    <id>mvnrepository</id>
    <mirrorOf>mvnrepository</mirrorOf>
    <url>http://mvnrepository.com/</url>
</mirror>

<mirror>
    <id>sonatype</id>
    <mirrorOf>sonatype</mirrorOf>
    <url>https://s01.oss.sonatype.org/</url>
</mirror>
```


## 发版指引

1. 从 master 检出 `[版本分支]`: `git checkout -b v${x.y.z}`
2. 修改 `pom.xml` 中的 `<version>`: 版本号 `+1`， 末尾增加 `-SNAPSHOT` 快照标识， push `[版本分支]` 到 Github
3. 从 `[版本分支]` 检出 `[特性分支]`: `git checkout -b feature-${x.y.z}`
4. 在 `[特性分支]` 修改代码（可以随时 push 到 Github）
5. 每完成一个需求修改后，在 Github 合并 `[特性分支]` 到 `[版本分支]`， 此时会触发流水线自动 deploy `SNAPSHOT` 版本到 Maven 中央仓库
6. 重复步骤 4 ~ 5， 直到一个版本需求完成，宣布封版
7. 在本地切换到 `[版本分支]`: `git checkout v${x.y.z}`
8. 拉取 `[版本分支]` 最新代码: `git pull`
9. 修改 `pom.xml` 中的 `<version>`: 移除末尾的 `-SNAPSHOT` 快照标识， push `[版本分支]` 到 Github
10. 在 Github 对 `[版本分支]` 发起 `Releases` 动作（会自动创建 `Tag`，名称和 `[版本分支]` 名一致）， 此时会触发流水线自动 deploy `Release` 版本到 Maven 中央仓库
11. 在 Github 合并 `[版本分支]` 到 master， 此时会触发流水线自动生成 javadoc
12. 重复步骤 1， 进入下一轮迭代
