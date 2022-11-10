import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)

driver.get("https://rahulshettyacademy.com/angularpractice/")

# ID, xpath, CSSSelector, Classname, name, linkText
driver.find_element(By.NAME, "email").send_keys("txthuong@gmail.com")
driver.find_element(By.ID, "exampleInputPassword1").send_keys("password")
driver.find_element(By.ID, "exampleCheck1").click()
driver.find_element(By.CSS_SELECTOR, "input[name='name']").send_keys("thuong")

#   CSS_SELECTOR:  #id, .classname
driver.find_element(By.CSS_SELECTOR, "#inlineRadio1").click()

# static dropdown
dropdown = Select(driver.find_element(By.ID, "exampleFormControlSelect1"))
dropdown.select_by_index(1)
dropdown.select_by_visible_text("Female")


driver.find_element(By.XPATH, "//input[@type='submit']").click()
# s = driver.find_element(By.XPATH, "//div[@class='alert -success alert-dismissible']").text
s = driver.find_element(By.CLASS_NAME, "alert-dismissible").text
print(s)
assert("Success" in s)

driver.find_element(By.CSS_SELECTOR, ".ng-pristine").clear()

time.sleep(10)
driver.close()
