import re
import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)

driver.get("https://rahulshettyacademy.com/loginpagePractise/")
driver.implicitly_wait(3)

driver.find_element(By.CSS_SELECTOR, ".blinkingText").click()
windows = driver.window_handles
driver.switch_to.window(windows[1])
text = driver.find_element(By.XPATH, "//div[@class='col-md-8']/p[@class='im-para red']").text
email = re.search("Please email us at (\w+[@]\w+[.]com) with below template", text).group(1)
print(email)
driver.switch_to.window(windows[0])

driver.find_element(By.ID, "username").send_keys(email)
driver.find_element(By.ID, "password").send_keys("test123")
driver.find_element(By.ID, "signInBtn").click()

wait = WebDriverWait(driver, 10)
wait.until(expected_conditions.visibility_of_element_located((By.CSS_SELECTOR, ".alert-danger")))
print(driver.find_element(By.CSS_SELECTOR, ".alert-danger").text)

time.sleep(3)
driver.quit()



