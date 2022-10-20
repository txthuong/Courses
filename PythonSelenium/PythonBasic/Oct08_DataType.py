print("Welcome !!! Thuong !!!")

name = "txthuong"
print(name + " !!!")

a, b, c = 5, 1.2, "Wonderful"
print(a+b)
print(c)
print("Sum: " + str(a+b))
print("Sum: %f" % (a+b))
print("Sum: {}".format(a+b))
print(type(c))

# Data type List
l1 = [21, 11, 14, 12, 10, 6]
l2 = ["thuong", 1, 3, "abc", 77.77]
print(l2[0])
print(l2[-1])
print(l2[1:3])
l2.insert(-1, "123")
l2.append("a1b2c3")
l2[0] = "THUONG"
print(l2)
del l2[1]
print(l2)

# Data type tuple - Same as LIST but immutable
tupleExample = (3, 1988, "txthuong", "THUONG", 21.11, "abc")
print(tupleExample[2])
print(tupleExample)

# Dictionary
dic = {1: "name", 2: "123", "age": 30, "text": "Welcome !"}
print(dic["age"])
print(dic["text"])
dic["text"] = "Hello !"
print(dic["text"])
dic["newText"] = "Great !"
print(dic["newText"])
