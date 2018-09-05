import re
import matplotlib.pyplot as plt

code_path = "Triangle.java"
file = open(code_path, 'r', encoding = "utf-8")
code = ["" for i in range(35)]
for i in range(35):
	code[i] = file.readline()
file.close()

color_path = "test.txt"
file = open(color_path, 'r', encoding = "utf-8")
color = [[0, 0] for i in range(35)]
while True:
	line = file.readline().strip()
	if line == '':
		break
	lst = line.split(";")
	color[int(lst[0])] = [float(lst[1]), float(lst[2])]
file.close()

fig = plt.figure(figsize = (8, 8))
ax = fig.add_subplot(111)
plt.axis('off')
number = 0;
for i in range(35):
	color_data = (0, 0, 0)
	color_text = code[i]
	if color[i][0] != -1:
		value = color[i][0]*2
		if value > 1:
			color_data = (1 - value + 1, 1, 0)
		else:
			color_data = (1, value, 0)
	x_text = 0.1;
	y_text = 1-0.02*number;
	ax.text(x_text, y_text, color_text, fontsize = 10, color = color_data)
	number += 1
plt.show("test.png")