import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)
driver.get("https://rahulshettyacademy.com/seleniumPractise/#/")
driver.implicitly_wait(2)

driver.find_element(By.LINK_TEXT, "Top Deals").click()

windows = driver.window_handles
driver.switch_to.window(windows[1])

print(driver.find_element(By.XPATH, "//div[@class='brand greenLogo']/div").text)

driver.find_element(By.XPATH, "//th[@role='columnheader'][1]").click()

time.sleep(3)
driver.quit()
