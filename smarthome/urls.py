from django.conf.urls import url
from smarthome.views import CameraControlView, LEDView
from smarthome.views.TestView import TestView

urlpatterns = [
    url(r'^$', LEDView.as_view()),
    url(r'^test$', TestView.as_view()),
    url(r'^(?P<direction>\w+)/$', CameraControlView.as_view()),
]
