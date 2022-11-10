from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.firefox.service import Service
from selenium.webdriver.edge.service import Service


# service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
# driver = webdriver.Chrome(service=service_obj)

# service_obj = Service("D:\\Course\\Selenium\\Drivers\\geckodriver.exe")
# driver = webdriver.Firefox(service=service_obj)

service_obj = Service("D:\\Course\\Selenium\\Drivers\\msedgedriver.exe")
driver = webdriver.Edge(service=service_obj)

driver.maximize_window()
driver.get("https://rahulshettyacademy.com/")
print(driver.title)
print(driver.current_url)
driver.get("https://rahulshettyacademy.com/loginpagePractise/")
driver.minimize_window()
print(driver.current_url)

driver.back()
print(driver.current_url)

driver.forward()
print(driver.current_url)

driver.refresh()
print(driver.current_url)
#driver.close()
