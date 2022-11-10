import pytest

@pytest.mark.usefixtures("setup")
class TestExample:

    def test_fixtureDemo(self):
        print("Steps in fixtureDemo method")

    def test_fixtureDemo2(self):
        print("Hello1 !!!")

    def test_fixtureDemo3(self):
        print("Hello2!!!")

    def test_fixtureDemo4(self):
        print("Hello4 !!!")

    def test_fixtureDemo5(self):
        print("Hello5 !!!")
