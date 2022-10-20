
numb = 3

if numb != 3:
    raise Exception("Wrong number !!!")

print("Test Passed !!!")

assert(numb == 3)

try:
    with open('file_invalid.txt', 'r') as reader:
        reader.read()

except Exception as e:
    print(e)
    print("It's fine. Just go ahead !")

print("test1")

#finally:
#    print("Finally !!!")


