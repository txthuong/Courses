import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)
driver.get("https://rahulshettyacademy.com/AutomationPractice/")

targetCheckBox = "honda"

checkBoxList = driver.find_elements(By.CSS_SELECTOR, "div[id='checkbox-example'] fieldset label")

for checkBox in checkBoxList:
    if checkBox.get_attribute("for") == targetCheckBox:
        checkBox.find_element(By.TAG_NAME, "input").click()
        assert checkBox.find_element(By.TAG_NAME, "input").is_selected()
    else:
        assert not checkBox.find_element(By.TAG_NAME, "input").is_selected()


time.sleep(5)
driver.close()
