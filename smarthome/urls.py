from django.conf.urls import url
from smarthome.views import CameraControlView, LEDView, TempView, HumView

urlpatterns = [
    url(r'^$', LEDView.as_view()),
    url(r'^temp/$', TempView.as_view()),
    url(r'^hum/$', HumView.as_view()),
    url(r'^(?P<direction>\w+)/$', CameraControlView.as_view()),
]
