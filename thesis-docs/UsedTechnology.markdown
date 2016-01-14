#### Used technologies and tecnique

-	In this smarthome server and client application, there are some several technologies and chip which is used in small, midium and large applications which we use daily. Django, Django-Rest, Jodd or Raspberry pi e.g.
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
	-	Raspberry pi mini computer


-	Basic arhitecture of smarthome

![arch](https://raw.githubusercontent.com/semihokanpehlivan/smarthome/master/smarthome-arch.png)

##### Lets start to explain these technologies

>	Buradaki teknolojiler daha çok daha fazla baya bi fazla ayrıntılandırılabilir.

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

### 3.Django Framework

-	In fact, we are more interested with Django Rest Framework to use the web api, but, to integrate the django rest framework, django framework must be added to related application to use definitely. In addition, we use the just django framework to create the structure of application, structure that created with help of `django-admin` is consisted of folder so that we use the python and django easy. Well, in this part, i am going to show how to install django to current python environment and be generated in `setting.py` configurations

```
The `smarthome` key in the command line is the name of environment of python on the system to isolate from the system's environment
username $(smarthome) pip install django
username $(smarthome) pip install djangorestframework
```

-	Now, we can use the django framework in your environment which you want to use and control the django version by typing the code to command line directly as follows:

```
>>> import django
>>> print(django.get_version())
1.9
```

-	By using the django admin, create the application structure 

```
username $ django-admin startproject mysite
```

-	in the current directory, project will be started by django-admin and structure of folder of project is showed below:

```
mysite/
    manage.py
    mysite/
        __init__.py
        settings.py
        urls.py
        wsgi.py
```	

-	In the current project-smarthome- django and django-rest examples as follows:

```Python
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
        json = {'on': led_is_on}
        return Response(json, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = LEDSerializer(data=request.data)
        if serializer.is_valid():
            on = serializer.validated_data.get('on')
            print on
            json = {'info': 'okay'}
            return Response(json)
```

-	And important part of the `setting.py` is as follows:

```Python
# Application definition

INSTALLED_APPS = [
    'rest_framework',
    'smarthome.apps.SmarthomeConfig',
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
]
```

-	urls.py that is used to map the urls and `Views`(smarthome/urls.py)

```Python
from django.conf.urls import url
from smarthome import views

urlpatterns = [
    url(r'^$', views.LEDView.as_view()),
]
```

-	**AND**

-	urls.py in `/thesis` folder that is named main module that include the some congifuration like setting.py or wsgi.py(related to applicaiton server) as more different that other module(app) which is added to project afterward by using the command below:
```
# => uses the current dictionary
username $ django-admin manage.py startapp <module(app) name>
```

-   Structure of module(app) is like below:
```
module-name/
    __init__.py
    admin.py
    apps.py
    migrations/
        __init__.py
    models.py
    tests.py
    views.py
```

```
/thesis/urls.py
```

```Python
"""thesis URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.9/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Add an import:  from blog import urls as blog_urls
    2. Import the include() function: from django.conf.urls import url, include
    3. Add a URL to urlpatterns:  url(r'^blog/', include(blog_urls))
"""
from django.conf.urls import url, include

urlpatterns = [
    url(r'^temp', include('smarthome.urls')),
    url(r'^api', include('rest_framework.urls', namespace='rest_framework')),
]
```

>	Yes, we can get the temperature information about smarthome. Send the `/temp` request.

#### 3.1 Project vs App[Django]

-	What’s the difference between a project and an app? An app is a Web application that does something – e.g., a Weblog system, a database of public records or a simple poll app. A project is a collection of configuration and apps for a particular website. A project can contain multiple apps. An app can be in multiple projects.

-	Note: Django anlatılmak istenirse buraya daha ayrıntılı bir anlatım olabilir. Detaylandırılabilinir.
-	çünkü ileride buralarda web socket vs gibi kullanımlar devreye giricek. o yüzden daha ayrıntılı bir django anlatımı gerekicek. ORM tech gerek yok veri tabanı işlemleri devreye girerse o zaman veri tabanı işlemlerini anlatırım ama şuan görünürde ORM yok. İleride socket ile ilgili kısımlar devreye alınıcak o zaman ayrıntılı bir django ve jodd anlatımı gerekmektedir. Socket nedir onun üzerine çalışılacak.

-	Gradle ve jodd hakkında geniş bir araştırma yapacağım. Şimdilik sadece işime yarayan kısımları kullandım.

[Django](https://docs.djangoproject.com/en/1.9/intro/tutorial01/)















