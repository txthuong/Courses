import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)

email = "demo@gmail.com"
password = "123456"

driver.get("https://rahulshettyacademy.com/client/")
driver.maximize_window()

driver.find_element(By.LINK_TEXT, "Forgot password?").click()

driver.find_element(By.XPATH, "//form/div[1]/input").send_keys(email)
driver.find_element(By.XPATH, "//input[@placeholder='Passsword']").send_keys(password)
driver.find_element(By.XPATH, "//input[@placeholder='Confirm Passsword']").send_keys(password)
driver.find_element(By.CSS_SELECTOR, "form div:nth-child(4) button").click()

time.sleep(10)
driver.close()
