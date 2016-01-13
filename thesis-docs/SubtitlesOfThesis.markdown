Goal of Smarthome Application
======================================

-	The main goal of Smarthome application has a several vital context for users
	-	Getting the information from smarthome server-side application using JSON data formating or streams
	that's the acceptable way of getting information from server.
	-	The basic example of JSON data format is as follows and it is used for getting temperature information that
	represents the heat of place. Using the temperature sensor and this mechanism, we can control the all heat of systems,
	central heating systems, power on, off or adjust.

	```JSON
	# => when we request the `/temp` to server which we use the raspberry pi for application server
	# => we got JSON object like follows for rendering and passing some part of JSON to the client display
	{
		sensor: "temperature"
		info:	"heat of the place"
		temp:	23
		unity:  "celcius"
		symbol: "C"
	}
	```

	-	Other goal is to send data from client to server that we use to processing data which user sends.
	The request has necessary header like all http requests, in its body it has JSON object which serialized to specify the form of JSON object. The example of JSON which serialized as follows:

	```JSON
	# => we can post the JSON to server using some posting URLs like `/turn` to turn the servo motors that is used to adjust axis of camera that is taking video for what happen at home
	{
		sensor: "servo motor"
		aspect: "left"
		axis:	20
		info:	"turning axis of camera"
	}
	```

-	The action of URLs is assigned in module's url.py and views.py. Through these file, we can add some functions which we consider it is usefull.