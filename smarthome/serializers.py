from rest_framework import serializers


class LEDSerializer(serializers.Serializer):
    on = serializers.BooleanField(required=True)
