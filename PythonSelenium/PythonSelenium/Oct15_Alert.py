import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)
driver.get("https://rahulshettyacademy.com/AutomationPractice/")

name = "txthuong"

driver.find_element(By.CSS_SELECTOR, "#name").send_keys(name)
driver.find_element(By.ID, "alertbtn").click()
time.sleep(3)
alert = driver.switch_to.alert
print(alert.text)
if name in alert.text:
    print("Test Passed !!!")
else:
    print("Test Failed !!!")
alert.accept()

driver.find_element(By.ID, "confirmbtn").click()
driver.switch_to.alert.dismiss()
driver.find_element(By.XPATH, "//input[@id='name']").send_keys(name)
driver.find_element(By.ID, "confirmbtn").click()
alert = driver.switch_to.alert
if name in alert.text:
    print("Test Passed !!!")
else:
    print("Test Failed !!!")
alert.accept()

time.sleep(5)
driver.close()

