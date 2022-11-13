import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

service_obj = Service("D:\\Course\\Selenium\\Drivers\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)
driver.get("https://www.youtube.com/watch?v=B9VRvOKKwfs")

video_player = driver.find_element(By.ID, "movie_player")
video_player.click()

thread_count = 0
while True:
    time.sleep(5)
    player_status = driver.execute_script("return document.getElementById('movie_player').getPlayerState()")
    print(player_status)
    if player_status != 1:
        print("---> Video was stopped !!!")
        print("Retry: %s" % str(thread_count+1))
        video_player.click()
        thread_count = thread_count + 1
    else:
        print("---> Video is playing !!!")

    if thread_count >= 3:
        driver.quit()
        raise Exception("---> Problem: Video is not playing properly !!!")



