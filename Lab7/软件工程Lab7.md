#软件工程Lab7
######<p align="right">11510365 薛毅恒</p>
-
##Assignment 1
-	Write a report on comparing build management tools for Java, including Gradle, Maven and Ant.

`Gradle`, `Maven`, `Ant`这是三种不同的构建器，首先需要明确什么是java的构建。
>在编程的过程中，与编程无关的管理工作包括下载依赖、编译源码、单元测试、项目部署等操作，除了小型项目中的手动操作外，在大型项目中需要通过构建工具帮助我们实现一系列`项目管理`、`测试`和`部署`等操作。

最开始，只有**Make**一种构建工具，后来发展为**GNU Make**, Java的自动构建工具主要是通过`makefile`文件进行，其中包括了自动构建的指令。从`Ant`到`Maven`再到`Gradle`是不断更新、进步的。

-	**Ant**是2000年发布的，使用*Java*编写了核心，采用*XML*作为构建脚本，这样的好处是可以在任何环境下运行构建。缺点是*XML*定义构建脚本，导致脚本复杂、臃肿，`Ant`自身也没有为项目构建提供指导，导致每个build的脚本都不一样，所以在不同项目中都要去熟悉脚本内容，没有提供在`Ant`环境中的依赖管理工具。
>build.xml

-	**Maven**团队也意识到了`Ant`的这些缺陷，在2004年发布这个版本，采用了标准的项目布局、统一的生命周期采用约定由于配置的思想，减少构建脚本需要编写的内容，使用人数联系紧密所以有了活跃的社区，方便找到合适的插件，也有强大的依赖管理工具，`Ant`需要将所有task都列出来，而`Maven`可以依靠约定并提供现成的课调用的目标，可以从网络上自动下载依赖。缺点是使用*XML*作为构建脚本，采用了默认的结构和生命周期，限制过多，编写插件、扩展内容很麻烦。
>pom.xml

-	**Gradle**便结合了`Ant`和`Maven`的有点，程序员在使用过程中发现问题，不断更新。基于*Groovy*和*DSL(Domain Specific Languages)*，提供声明式的构建语言，采用标准的项目布局，但完全可配置、可修改，也有更多的插件，提供默认的构建生命周期，也可以自己定义任务，单独运行任务，定义任务间的依赖，强大的依赖管理工具，约定好、灵活性高，与`Maven`和`Ant`相结合、与Ant兼容，可以重用`Ant`的任务，多种实现插件的方式，强大的官方插件库，支持从`Ant`或者`Maven`的逐步迁移，也可以在多种平台上运行。
>build.gradle

`Ant`是最清晰直观的，*XML*文件中很详细、清晰的写了配置文件，可以理解它的作用，但是`Ant`文件很容易变得很复杂。`Gradle`有很多比合适的插件，就像是构建工具里的`Python`一样，不需要理解所有内容也可以使用的很顺利。

##Assignment 2
-	Complete this [tutorials](http://spring.io/guides/gs/gradle/)
>在`gradle`的一系列操作中，要在==complete==文件夹中进行，第6步一定要完成之后再进行最后一步的`run`操作，`build.gradle`文件及build后的`build`文件夹的路径是`gs-gradle/complete/`

1.	Install ant
![InstallAnt](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/1_ant_version.png)
2.	Install gradle
![InstallGradle](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/2_gradle_install.png)
3.	Gradle tasks
![GradleTasks](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/3_gradle_tasks.png)
4.	Gradle build
![GradleBuild](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/4_gradle_build.png)
5.	`./gradlew_build`
![./gradleBuild](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/5_gradlew_build.png)
6.	`jar tvf build/libs/gs-gradle-0.1.0.jar`
![JarTvf](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/6_jar_tvf.png)
7.	`./gradlew_run`
![GradlewRun](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/7_gradlew_run.png)
8.	文件夹内容
![Code1](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/8_Code1.png)
![Code2](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/9_Code2.png)

>##Assignment 3
-	Convert the Ant _build.xml_ of the tool used in Lab 6 to _Gradle_, and try to make it works for the same usability.
-	You **cannot** use any existed automatic tools to convert.

```xml
<project name="tarantula" default="compile" basedir=".">

<!-- patternset to decrease redundancy in the buildfile-->
   <patternset id="jars" >
      <include name="**/*.jar"/>
   </patternset>
  
<!-- Path attribute using the patternset-->
   <path id="jar.files"> 
      <fileset dir="lib">
         <patternset refid="jars"/>
      </fileset>
   </path>
   
<!-- Target to clean up -->
    <target name="clean" description="Clean">
        <delete dir="./bin"/>
    </target>

<!-- Target to initialize build -->
    <target name="init">
        <mkdir dir="./bin"/>
    </target>

<!-- Target to compile the project -->
    <target name="compile" depends="init" description="Compile">
        <javac includeantruntime="true" srcdir="src" destdir="bin" debug="yes" fork="no">
            <classpath refid="jar.files"/>
        </javac>
    </target>

<!-- Target to run the main-->
    <target name="run.tarantula" depends="compile">
        <java classname="tarantula.Main">
            <classpath>
               <path refid="jar.files"/>
               <pathelement location="bin"/>
            </classpath>
            <arg value="${arg0}"/>
            <arg value="${arg1}"/>
        </java>
    </target>
</project>
```
对**Ant**的`Build.xml`进行分析得到如下信息

-	Project
	-	工程名称：`tarantula`
	-	基准目录：`.`
	-	默认运行的target：`compile`（当ant命令没有制定target时，会运行这个target）
-	Patternset
	-	id唯一标识：`jars`（其他<patternset>元素通过refid指向该模式）
	-	内嵌要包含的模式：`**/*.jar`
-	Path
	-	id：`jar.files`
		-	fileset
			-	文件集合的根目录：`lib`
			-	模式集合的refid：`jars`
-	Target
	-	clean
		-	要删除的目录：`./bin/`
	-	init
		-	要创建的目录：`./bin/`
	-	compile
		-	依赖的target：`init`
		-	是否包含`ant`库路径：`True`
		-	源文件路径：`src`
		-	存放变异后class文件路径：`bin`
		-	编译时是否显示调试信息：`yes`
		-	`javac`的依赖库路径：`jar.files`
	-	run.tarantula
		-	依赖的target：`compile`
		-	java类名：`tarantula.Main`
		-	classpath中类路径指向改id对应的元素：`jar.files`
		-	单个文件或目录：`bin`
		-	`arg value`：**NOTSURE**
		
如下图所示通过`gradle build`
![GradleBuild](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/10_gradle_build.png)
`gradle -Darg0=/Users/xueyiheng/fault-localization/tacoco-compact-cov-matrix.json -Darg1=triangle.TestSuite run.tarantula`运行的出和`ant`的`build.xml`相同的结果，如下图所示。
<center>
<img src="/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/11_result.png" width="50%" height="50%" />

Figure 1. Lena
</center>
![Result](/Users/xueyiheng/Desktop/软件工程/Lab/Lab7/11_result.png)
>##Assignment 4
-	Deploy your project in Assignment 1 on Travis-Ci
-	==未完成==
