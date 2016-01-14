#### Used technologies and tecnique

-	In this smarthome server and clint application, there are some several technologies which is used in small, midium and large applications which we use daily. Django, Django-Rest, Jodd e.g.
-	As third-party libraries is as follows:
	-	Pip which can controll the python packages in current environment
	-	Virtualenv and virtualenvwrapper
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

-	Basic arhitecture of smarthome

![arch](https://raw.githubusercontent.com/semihokanpehlivan/smarthome/master/smarthome-arch.png)

##### Lets start to explain these technologies

###	1.Pip

-   is a tool that we can control python packages
-   for installing, visit to [here](https://pip.pypa.io/en/stable/installing/, "pip")

### 2.Virtualenv and virtualenvwrapper

-	Virtualenv is a tool that we can isolate the all system python environments
-	Virtualwrapperenv is a tool that we can use virtualenv functions easy, but it is optional tool.
-	for installing and detail(both virtualenv and virtualenvwrapper), visit to [here](http://docs.python-guide.org/en/latest/dev/virtualenvs/, "virtualenv")

#### 2.1 Getting related to python package using requirements.txt file

-	isolate the python environments using virtualenv or virtualenvwrapper
-	instantly active it, you will see the your name of virtualenvs on command-line screen 
-	need to type command below

``$ pip install -r requirements.txt``

-	you can see all environments using pip current virtual-environment

``$ pip list`` or ``$ pip freeze``