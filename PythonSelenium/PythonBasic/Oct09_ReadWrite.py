file = open('text.txt')

# Read file content
print(file.read())

# Read byte
file = open('text.txt')
print(file.read(3))

# Read line
file = open('text.txt')
print(file.readline())
print(file.readline())

# print line by line
file = open('text.txt')
line = file.readline()
while line != "":
    print(line)
    line = file.readline()

file = open('text.txt')
lines = file.readlines()
print(lines)
for line in lines:
    print(line)


file.close()

# Read the file and store all the lines
# reverse the list
# write the list back
with open('text.txt', 'r') as reader:
    content = reader.readlines()
    reversed(content)
    with open('text.txt', 'w') as writer:
        for line in reversed(content):
            writer.write(line)
