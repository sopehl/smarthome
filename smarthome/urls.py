from django.conf.urls import url
from smarthome.views import CameraControlView, LEDView

urlpatterns = [
    url(r'^$', LEDView.as_view()),
    url(r'^(?P<direction>\w+)/$', CameraControlView.as_view()),
]
