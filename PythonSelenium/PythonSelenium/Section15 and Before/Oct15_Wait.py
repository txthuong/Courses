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

searchChar = "be"
promoteCode = "rahulshettyacademy"

driver.find_element(By.CLASS_NAME, "search-keyword").send_keys(searchChar)
driver.find_element(By.CLASS_NAME, "search-button").click()
time.sleep(1)

foundProducts = driver.find_elements(By.CSS_SELECTOR, "div[class='products'] div[class='product']")

addedProductsName = []
for product in foundProducts:
    #print(product.find_element(By.CLASS_NAME, "product-name").text)
    product.find_element(By.CSS_SELECTOR, "div[class='product-action'] button").click()
    addedProductsName.append(product.find_element(By.CLASS_NAME, "product-name").text.split(' - ')[0])

driver.find_element(By.XPATH, "//div[@class='cart']/a[@class='cart-icon']").click()
driver.find_element(By.CSS_SELECTOR, "div[class='cart-preview active'] div button").click()

cartProducts = driver.find_elements(By.XPATH, "//table[@id='productCartTables']/tbody/tr")
cartProductsName = []
prices = 0
for product in cartProducts:
    cartProductsName.append(product.find_element(By.CLASS_NAME, "product-name").text.split(' - ')[0])
    # print(product.find_element(By.CLASS_NAME, "product-name").text)
    #print(product.find_elements(By.CLASS_NAME, "amount")[1].text)
    prices = prices + int(product.find_elements(By.CLASS_NAME, "amount")[1].text)

print(cartProductsName)
print(addedProductsName)
assert cartProductsName == addedProductsName

driver.find_element(By.CSS_SELECTOR, ".promoCode").send_keys(promoteCode)
driver.find_element(By.CSS_SELECTOR, ".promoBtn").click()
wait = WebDriverWait(driver, 10)
wait.until(expected_conditions.presence_of_element_located((By.CLASS_NAME, "promoInfo")))
# wait.until(expected_conditions.presence_of_element_located(driver.find_element(By.CLASS_NAME, "promoInfo")))
print(driver.find_element(By.CLASS_NAME, "promoInfo").text)

print("Total: " + str(prices))
amount = int(driver.find_element(By.CLASS_NAME, "totAmt").text)
discountAmount = float(driver.find_element(By.CLASS_NAME, "discountAmt").text)
discountPercent = int(driver.find_element(By.CLASS_NAME, "discountPerc").text.replace('%', ''))

assert amount == prices
assert discountAmount == (amount*(100-discountPercent)/100)

time.sleep(5)
driver.close()
