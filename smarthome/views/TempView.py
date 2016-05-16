from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
import temp_and_hum as tah

class TempView(APIView):
	
	def get(self, request):
		temp = tah.select_temp()[1]
		json = {"temp" : temp}
		return Response(json, status=status.HTTP_200_OK)