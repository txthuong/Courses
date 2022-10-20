import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)
driver.get("https://the-internet.herokuapp.com/")
driver.implicitly_wait(3)
driver.find_element(By.LINK_TEXT, "Multiple Windows").click()

driver.find_element(By.LINK_TEXT, "Click Here").click()
windowsOpened = driver.window_handles

driver.switch_to.window(windowsOpened[1])
print(driver.find_element(By.TAG_NAME, "h3").text)

driver.switch_to.window(windowsOpened[0])
print(driver.find_element(By.TAG_NAME, "h3").text)

time.sleep(3)
driver.close()
