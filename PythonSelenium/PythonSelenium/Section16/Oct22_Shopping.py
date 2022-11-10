import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument("--start-maximized")
driver = webdriver.Chrome(service=service_obj, options=chrome_options)
driver.implicitly_wait(2)

driver.get("https://rahulshettyacademy.com/angularpractice/")
# driver.find_element(By.LINK_TEXT, "Shop").click()
# driver.find_element(By.XPATH, "//a[contains(@href,'shop')]").click()
driver.find_element(By.CSS_SELECTOR, "a[href*='shop']").click()

buyProducts = ["iphone X", "Blackberry"]
countryChar = "in"
country = "India"

products = driver.find_elements(By.XPATH, "//div[@class='card h-100']")
for product in products:
    # print(product.find_element(By.XPATH, ".//div[@class='card-body']/h4/a").text)
    productName = product.find_element(By.CLASS_NAME, "card-title").text
    print(productName)
    if productName in buyProducts:
        product.find_element(By.XPATH, ".//button[@class='btn btn-info']").click()
        print(productName + " added !!!")

driver.find_element(By.XPATH, "//li/a[@class='nav-link btn btn-primary']").click()
driver.find_element(By.XPATH, "//button[@class='btn btn-success']").click()

driver.find_element(By.ID, "country").send_keys(countryChar)
wait = WebDriverWait(driver, 10)
wait.until(expected_conditions.presence_of_element_located((By.XPATH, "//div[@class='suggestions']/ul/li/a")))
listSuggestedCountry = driver.find_elements(By.XPATH, "//div[@class='suggestions']/ul/li/a")
for suggestCountry in listSuggestedCountry:
    if suggestCountry.text == country:
        suggestCountry.click()
        break

# driver.find_element(By.ID, "checkbox2").click()
driver.find_element(By.XPATH, "//div[@class='checkbox checkbox-primary']").click()
driver.find_element(By.XPATH, "//input[@class='btn btn-success btn-lg']").click()

alertMessage = driver.find_element(By.XPATH, "//div[@class='alert alert-success alert-dismissible']").text
if "Success" in alertMessage:
    print("---> Passed !!!")
else:
    print("---> Failed !!!")

time.sleep(3)
driver.quit()
