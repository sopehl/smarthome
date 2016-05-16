from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
import temp_and_hum as tah


class HumView(APIView):
    def get(self, request):
        hum = tah.select_hum()[1]
        json = {"hum": hum}
        return Response(json, status=status.HTTP_200_OK)
