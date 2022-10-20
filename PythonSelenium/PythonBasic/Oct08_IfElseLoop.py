
greeting = "Welcome, Thuong !"

# if else
if greeting == "Welcome, Thuong !":
    print("Passed !!!")
else:
    print("Failed !!!")

# for
obj = (3, 1988, "txthuong", "THUONG", 21.11, "abc")
for item in obj:
    print(item)

numbers = [21, 11, 14, 12, 10, 6]
for j in numbers:
    print(j*1.5)

summation = 0
for j in numbers:
    summation = summation + j
print(summation)

print("****************")
for i in range(1, 10, 2):
    print(i)


# While

num = 10
while num > -1:
    if num == 3:
        print("That's my number !")
        num = num - 1
        continue
    if num == 1:
        print("Too old for this shit !")
        break
    print("Regular number " + str(num))
    num = num - 1
