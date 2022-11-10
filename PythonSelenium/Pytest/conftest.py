import pytest


@pytest.fixture()
def setup():
    print("I will be run first")
    yield
    print("I will be run last")


@pytest.fixture()
def dataLoad():
    print("user profile data is being created")
    return ["txthuong", "Learning Automation"]


@pytest.fixture(params=[("chrome", "txthuong"), "Firefox", "IE"])
def crossBrowser(request):
    return request.param


