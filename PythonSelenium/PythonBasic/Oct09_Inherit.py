from Oct08_ClassObject import Calculator


class ChildImplement(Calculator):
    num2 = 200

    def __init__(self):
        Calculator.__init__(self, 2, 9)

    def get_complete_data(self):
        return self.num2 + self.num + self.summary()


obj = ChildImplement()
print(obj.get_complete_data())
