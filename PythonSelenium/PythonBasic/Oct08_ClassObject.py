
class Calculator:
    num = 123

    def __init__(self, a, b):
        self.firstNumber = a
        self.secondNumber = b
        print("Automatically called first")

    def get_data(self):
        print("Hi !!!")

    def summary(self):
        # return self.firstNumber + self.secondNumber + Calculator.num
        return self.firstNumber + self.secondNumber + self.num


obj = Calculator(3, 7)
obj.get_data()
print(obj.num)
print(obj.summary())

