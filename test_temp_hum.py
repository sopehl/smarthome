import temp_and_hum as tah
import random
import time as t
import datetime

while True:
    time = datetime.datetime.now().__str__()
    temp = [random.randint(19, 25), time]
    hum = [random.randint(40, 60), time]
    tah.insert_hum(hum)
    tah.insert_tem(temp)
    t.sleep(5)