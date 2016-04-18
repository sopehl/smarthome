from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from smarthome.serializers import LEDSerializer


class LEDView(APIView):
    """
    List all snippets, or create a new snippet.
    """
    led_is_on = False

    def get(self, request, led_is_on=None):
        # getting the led pin is on or off
        led_is_on = False
        json = {'on': led_is_on}
        return Response(json, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = LEDSerializer(data=request.data)
        if serializer.is_valid():
            on = serializer.validated_data.get('on')
            print on
            json = {'info': 'okay'}
            return Response(json)

