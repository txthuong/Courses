import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)
driver.get("https://rahulshettyacademy.com/AutomationPractice/")
driver.implicitly_wait(3)
driver.maximize_window()

action = ActionChains(driver)
action.move_to_element(driver.find_element(By.ID, "mousehover")).perform()
# action.context_click(driver.find_element(By.LINK_TEXT, "Top")).perform()
action.move_to_element(driver.find_element(By.LINK_TEXT, "Reload")).click().perform()

# action = ActionChains(driver)
action.move_to_element(driver.find_element(By.ID, "mousehover")).perform()
action.move_to_element(driver.find_element(By.LINK_TEXT, "Top")).click().perform()

time.sleep(3)
driver.close()
