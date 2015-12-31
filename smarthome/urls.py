from django.conf.urls import url
from smarthome import views

urlpatterns = [
    url(r'^$', views.LEDView.as_view()),
]
