import pytest


@pytest.mark.smoke
def test_1stProgram():
    msg = "Hello World !!!"
    assert msg == "Hi", "Test failed because strings do not match"


def test_2ndProgram():
    a = 4
    b = 6
    assert a+2 == b, "Addition not match"


def test_1stCreditCard():
    a = 4
    b = 6
    assert a+2 == b, "Addition not match"