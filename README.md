<p align="center">
    <img alt="Yanagishima Logo" src="docs/images/yanagishima.png" width="25%" />
</p>
<p align="center">Yanagishima is an open-source Web application for Presto, Hive, Elasticsearch and Spark.</p>
<p align="center">Visit <a href="https://yanagishima.github.io/yanagishima">the official web site</a> for more information.</p>
<p align="center">
   <a href="https://github.com/yanagishima/yanagishima/actions?query=workflow%3ACI+event%3Apush+branch%3Amaster">
       <img src="https://github.com/yanagishima/yanagishima/workflows/CI/badge.svg" alt="CI" />
   </a>
   <a href="http://www.youtube.com/watch?v=SoneFYNCXJEr">
       <img src="https://img.shields.io/badge/YouTube-Video-FF0000" alt="YouTube Video" />
   </a>
</p>

# Build requirements

* Java 11
* Node.js

## Quick Start
```
git clone https://github.com/yanagishima/yanagishima.git
cd yanagishima
git checkout -b [version] refs/tags/[version]
./gradlew distZip
cd build/distributions
unzip yanagishima-[version].zip
cd yanagishima-[version]
vim config/application.yml
nohup bin/yanagishima-start.sh >y.log 2>&1 &
```
- ./gradlew build distTar -x test
see http://localhost:8080/

# Stop
```
bin/yanagishima-shutdown.sh
```

---
### 新知识点
- [项目中大量Lombok的@RequiredArgsConstructor注解使用进行自动注入的原理](https://www.yuque.com/xiaohuangya-tt4ln/og94sf/hp2pt8#KC8qs)
    - 在Spring4.x中增加了新的特性：如果类只提供了一个带参数的构造方法，则不需要对对其内部的属性写@Autowired注解，Spring会自动进行依赖注入;
    - 配合lombok的@RequiredArgsConstructor使用体验很好，@RequiredArgsConstructor自动生成一个带final修饰参数和@NotNull注解参数的构造方法，刚好满足Spring4.x中只有一个带参构造方法时无需写@Autowired也会自动注入的特性;
    - @RequiredArgsConstructor也可以通过@RequiredArgsConstructor(onConstructor = @__(@Autowired))的方式显式指定在自动生成的带参数构造方法上面加上@Autowired注解
