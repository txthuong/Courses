import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)
driver.get("https://rahulshettyacademy.com/dropdownsPractise/")

findChar = "vi"
targetCountry = "Vietnam"


dynamicDropdownElement = driver.find_element(By.ID, "autosuggest")
dynamicDropdownElement.send_keys(findChar)
time.sleep(2)
countries = driver.find_elements(By.XPATH, "//li[@class='ui-menu-item']/a")
print(len(countries))

for country in countries:
    if country.text == targetCountry:
        print("Target country found !!!")
        country.click()
        break

assert dynamicDropdownElement.get_attribute("value") == targetCountry


time.sleep(5)
driver.close()
