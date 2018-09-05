#软件工程Lab6
######<p align="right">11510365 薛毅恒</p>
-
##Assignment 1
-	Install `Maven`and `Ant`
-	Follow the instruction to install a `Tarantula`

######Install
![install](/Users/xueyiheng/Desktop/软件工程/Lab/Lab6/1_install.png)
######Mvn_test
![mvn_test](/Users/xueyiheng/Desktop/软件工程/Lab/Lab6/2_mvn_test.png)
######Mvn_install
![mvn_install](/Users/xueyiheng/Desktop/软件工程/Lab/Lab6/3_mvn_install.png)
######Mvn_compile
![mvn_compile](/Users/xueyiheng/Desktop/软件工程/Lab/Lab6/4_mvn_compile.png)
######Mvn\_clean_package
![mvn_clean_package](/Users/xueyiheng/Desktop/软件工程/Lab/Lab6/5_mvn_clean_package.png)
######Build\_and_run
![build_and_run](/Users/xueyiheng/Desktop/软件工程/Lab/Lab6/6_build_and_run.png)
######Clean\_tacoco_dir
![clean_tacoco_dir](/Users/xueyiheng/Desktop/软件工程/Lab/Lab6/7_clean_tacoco_dir.png)

##Assignment 2
-	Run a demo(Triangle test suite)
-	Write Python code to visualize the result

`ant -Darg0=/Users/xueyiheng/fault-localization/tacoco-compact-cov-matrix.json -Darg1=triangle.TestSuite run.tarantula`之后，在终端得到的数据存在txt文件中，在`Sublime text3`中，通过`Find All`对无关内容进行删除，得到整齐的数据如下图所示。

![test_txt](/Users/xueyiheng/Desktop/软件工程/Lab/Lab6/8_test_txt.png)
首先对`Triangle.java`文件进行读取，放入==code==中

```python
code_path = "Triangle.java"
file = open(code_path, 'r', encoding = "utf-8")
for i in range(35):
	line = file.readline()
	code[i] = line
file.close()
```

接下来对已经格式化处理过的`test.txt`文件进行读取，放入==color==中

```python
color_path = "test.txt"
file = open(color_path, 'r', encoding = "utf-8")
while True:
	line = file.readline().strip()
	lst = line.split(";")
	color[int(lst[0])] = [float(lst[1]), float(lst[2])]
file.close()
```

对color和code中进行匹配，`code[i]`与`color[i]`进行处理。

`color[i][0] * 2`之后，可以得到`(1, color[i][0]*2, 0)`的颜色信息，用这个信息给指定行数进行上色。

```python
x_text = 0.1;
y_text = 1-0.02*number;
ax.text(x_text, y_text, color_text, fontsize = 10, color = color_data)
```

得到结果如图所示。
![lab6_result](/Users/xueyiheng/Desktop/软件工程/Lab/Lab6/9_lab6_result.png)


>##Assignment 3
-	Change the code to compare at least 4(including the algorithm for Tarantula) different ranking algorithms in total
-	You will need to read the source code of the tool in Java not only Python code to visualize. You may need to change code in `src/tarantula/TarantulaSuspiciousnessCalculation.java`
-	==未完待续==