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