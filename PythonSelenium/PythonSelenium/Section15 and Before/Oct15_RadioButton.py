import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)
driver.get("https://rahulshettyacademy.com/AutomationPractice/")

targetRadioButton = "Radio3"

# radioButtons = driver.find_elements(By.CSS_SELECTOR, "input[class='radioButton']")
radioButtons = driver.find_elements(By.CSS_SELECTOR, "div[id='radio-btn-example'] fieldset label")

for radioButton in radioButtons:
    if radioButton.text == targetRadioButton:
        radioButton.find_element(By.TAG_NAME, "input").click()
        assert radioButton.find_element(By.TAG_NAME, "input").is_selected()
    else:
        assert not radioButton.find_element(By.TAG_NAME, "input").is_selected()
    print(radioButton.text)


assert driver.find_element(By.ID, "displayed-text").is_displayed()
driver.find_element(By.ID, "hide-textbox").click()
assert not driver.find_element(By.ID, "displayed-text").is_displayed()
driver.find_element(By.ID, "show-textbox").click()
assert driver.find_element(By.ID, "displayed-text").is_displayed()


time.sleep(5)
driver.close()
