import RPi.GPIO as GPIO
import dht11
import time
import datetime
import temp_and_hum as tah

# initialize GPIO
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()

# read data using pin 14
instance = dht11.DHT11(pin=4)

while True:
    result = instance.read()
    if result.is_valid():
        temp = [str(result.temperature), str(datetime.datetime.now())]
        hum = [str(result.humidity), str(datetime.datetime.now())]
        tah.insert_hum(hum)
        tah.insert_tem(temp)
        print("Last valid input: " + str(datetime.datetime.now()))
        print("Temperature: %d C" % result.temperature)
        print("Humidity: %d %%" % result.humidity)
