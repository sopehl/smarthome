from rest_framework.views import APIView
from smarthome.models import Humidity
from django.utils import timezone
from rest_framework.response import Response
from rest_framework import status


class TestView(APIView):

    def get(self, request):
        h = Humidity(humidity=59, published_date= timezone.now())
        h.save()
        count = Humidity.objects.count()
        json = {'date:': h.published_date,
                'count': count}
        return Response(json, status=status.HTTP_200_OK)