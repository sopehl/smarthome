from rest_framework.views import APIView
from rest_framework.response import Response


class CameraControlView(APIView):

    def get(self, request, direction):
        if direction == 'left':
            # TODO turn left with GPIO program
            return Response(direction)
        elif direction == 'right':
            return Response(direction)
        else:
            return Response("Something is wrong")