#软件工程Lab10
###*Mutation testing*
######<p align="right">11510365 薛毅恒</p>
-
>##Assignment 1
1.	Read the materials to understand how PIT works:
https://pitest.org/quickstart/basic_concepts/
https://pitest.org/quickstart/mutators/
2.	Run mutation testing on **ORIGINAL** `TestSuite.java` provided in Lab6.

-	文件夹结构如下所示

```
.
├── 201805262153
│   ├── index.html
│   ├── style.css
│   └── triangle
│       ├── Triangle.java.html
│       └── index.html
├── Lab10.pdf
├── Lab10.pptx
├── junit-4.10.jar
├── pitest-1.4.0.jar
├── pitest-command-line-1.4.0.jar
├── pitest-entry-1.4.0.jar
├── pitest-maven-1.4.0.jar
└── triangle
    ├── TestSuite.class
    ├── TestSuite.java
    ├── Triangle$Type.class
    ├── Triangle.class
    └── Triangle.java

3 directories, 16 files
```

-	通过*pitest*网站下载文件`pitest-1.4.0.jar`, `pitest-command-line-1.4.0.jar`, `pitest-entry-1.4.0.jar`, `pitest-maven-1.4.0.jar`四个**jar**文件。

-	引入文件`TestSuite.java`, `Triangle.java`两个文件。

-	通过如下指令对java文件进行编译。

```
javac -cp .:junit-4.10.jar triangle/TestSuite.java triangle/Triangle.java
```

-	命令行运行如下指令，找到已有错误。

```
java -cp .:junit-4.10.jar org.junit.runner.JUnitCore triangle.TestSuite
```

-	命令行运行如下指令，进行突变测试。

```
java -cp .:junit-4.10.jar:pitest-1.4.0.jar:pitest-command-line-1.4.0.jar:pitest-entry-1.4.0.jar\
org.pitest.mutationtest.commandline.MutationCoverageReport\
--reportDir .\
--targetClasses triangle.Triangle\
--targetTests triangle.TestSuite\
--sourceDirs .
```

得到结果如下图所示。
![Result](/Users/xueyiheng/Desktop/软件工程/Lab/Lab10/Result.png)
==得到html文件见附件。==


>##Assignment 2
-	Write a short essay to analyze Mutation Testing, at least 800 words.
-	Choose two or more from these keywords:
	-	current state, pros, cons, how to improve, compare to other technique

在遗传学中，突变指的是器官、病毒或者染色体外的其他遗传成分的核酸序列发成改变。基因突变大概率发生在DNA复制期间，可能由于外界的辐射、外伤、病毒或者其他恶劣环境因素的影响。

软件工程中的突变测试适用于衡量软件测试的质量，突变测试通常对程序的源代码或者目标代码做很微小的改动之后，预期会产生截然不同的错误行为，如果测试代码并未发现这个错误，就说明这个测试是有问题的。

IEEE(Std 610.12-1990)对突变测试定义如下：*Mutation test, a testing methodology in which two or more program mutations are executed using the same test cases to evaluate the ability of the test cases to detect differences in the mutations.*
即，突变测试是一种测试的方法，指对两个或两个以上程序的变体对比测试，采用相同测试用例和相同的输入，对产生的结果进行比较，重点关注由于错误是否产生误差，并对此进行分析。

-	**变异体选择优化**策略主要关注如何从生成的大量变异体中选择出典型的变异体。

-	**随机选择法**尝试从生成的大量的变异体中随机选择出部分变异体。首先通过执行变异算子生成大量变异体*M*，然后定义选择比例*x*，最后从变异体*M*中随机选择出|*M*·*x*%的变异体，剩余的被丢弃。

-	**聚类选择法**首先对被测程序p应用变速算子生成所有的一阶变异体，然后选择某一聚类算法根据测试用例的检测能力对所有变异体进行聚类分析，使得每个聚类内的变异体可以被相似测试用例检测到，最后从每个聚类中选择出典型的变异体，将其他的丢弃掉。

-	**变异算子选择法**在不影响变异评分的前提下，对变异算子进行约简来大规模缩小变异体数量，从而减小变异测试和分析开销，加快测试速度。

-	**高阶变异体优化法**基于以下推测

	-	执行一个k阶变体相当于一次执行k个一阶变异体；
	-	高阶变异体中等价变异体的出现概率较小。

	采用二阶变异体可以有效减小50%的测试开销，但不会明显降低测试的有效性。

变异测试仍有缺陷，存在大量问题被研究。等价变异体变异检测问题，在变异生成过程中避免等见变异体的生成；在变异测试分析优化中，，考虑将变异算子按照异体检测能力进行排序；关注变异体的生成技术，面向变异测试的测试用例生成研究；需要进一步提高测试工具的自动化程度，提高工具的鲁棒性。

**部分资料来源于CSDN网站及xiaoqiangyi的新浪博客*