import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument("--start-maximized")
chrome_options.add_argument("headless")
chrome_options.add_argument("--ignore-certificate-errors")
driver = webdriver.Chrome(service=service_obj, options=chrome_options)

driver.get("https://rahulshettyacademy.com/angularpractice/")

print(driver.title)

time.sleep(5)
driver.quit()
