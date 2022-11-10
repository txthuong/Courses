# Any pytesst file should start with test_ or end _test
# pytest method names should start with test
# Any code should be wrapped in method only
import pytest


@pytest.mark.smoke
@pytest.mark.skip
def test_firstProgram():
    print("Hello World !!!")


def test_secondProgram(setup):
    print("Today is halloween !!!")


@pytest.mark.xfail
def test_2ndCreditCard():
    print("Today is halloween !!!")


@pytest.fixture()
def setup():
    print("I will be run first")


def test_fixtureDemo(setup):
    print("Steps in fixtureDemo method")


def test_crossBrowser(crossBrowser):
    print(crossBrowser)