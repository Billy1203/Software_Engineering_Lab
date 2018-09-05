'''
Name: 
StudentNo:
Creation data: 
'''

import matplotlib.pyplot as plt


# read the data file
def color():
	path = "test.txt"
	file = open(path, 'r', encoding = "utf-8")
	color = [[0, 0] for i in range(34)]
	while True:
		line = file.readline().strip()
		if line == "":
			break
			lst = line.split(";")
			color[int(lst[0])] = [float(lst[1]), float(lst[2])]
	file.close()

def code():
	file = open("Triangle.java", 'r')
	code = ["" for i in range(40)]
	for i in range(36):
		line = file.readline()
		code[i] = line
	file.close()

def draw():
	fig = plt.figure(figsize = (10, 10))
	ax = fig.add_subplot(111)
	plt.axis('off')
	counter = 0;
	for i in range(34):
		color_turple = (0, 0, 0)
		text = code[i]
		if color[i][0] != -1:
			value = color[i][0] *2
			if value > 1:
				color_turple = (1-value +1, 1, 0)
			else:
				color_turple = (1, value, 0)
				ax.text(0.05, 1-0.03 *counter, text, fontsize = 12, color = color_turple)
				counter +=1

def main():
	color()
	code()
	draw()
	plt.show()


if __name__ == '__main__':
	main()
