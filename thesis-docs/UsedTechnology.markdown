#### Used technologies and tecnique

-	In this smarthome server and clint application, there are some several technologies which is used in small, midium and large applications which we use daily. Django, Django-Rest, Jodd e.g.
-	As third-party libraries is as follows:
	-	Pip which can controll the python packages in current environment
	-	Django framework which is used for general web skills
	```
		username $ pip install django
		or
		username $ pip install djangorestframework
	```
	-	Django-rest framework which is powerfull and flexible for building the Web APIs
	-	Gradle as a build tool in Java platforms
	-	Jodd framework which is knows as micro-framework written in java and i used the jodd-http-client in **Android** application(that's for users)
		-	To insert the jodd dependency in Android applicaiton, type dependency to gradle.build file
		```
			compile("org.jodd:jodd-http:3.6.7")
		```
		-	with this code, jodd is added to our applications of external dependencies, and also you can google dependencies which you want to use in your application using `mvnrepository` keyword

	-	GPIO package that is written in python programming language for contolling the python input or output using really basic code scripts on raspberry pi small and pretty cute thing.