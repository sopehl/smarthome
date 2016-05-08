from django.db import models
'''
This classes for Temperature and Humidity data model.
'''


class Temperature(models.Model):
    degree = models.IntegerField(default=0)
    published_date = models.DateTimeField('published')


class Humidity(models.Model):
    humidity = models.IntegerField(default=0)
    published_date = models.DateTimeField('published')
