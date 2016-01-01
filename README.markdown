## Requirements

-   pip
-   virturalenvs
-   virtualenvwrapper(optional)

#### Pip

-   is a tool that we can control python packages
-   for installing, visit to [here](https://pip.pypa.io/en/stable/installing/, "pip")

#### Virtualenv and virtualenvwrapper

-	Virtualenv is a tool that we can isolate the all system python environments
-	Virtualwrapperenv is a tool that we can use virtualenv functions easy, but it is optional tool.
-	for installing and detail(both virtualenv and virtualenvwrapper), visit to [here](http://docs.python-guide.org/en/latest/dev/virtualenvs/, "virtualenv")

#### Getting related to python package using requirements.txt file

-	isolate the python environments using virtualenv or virtualenvwrapper
-	instantly active it, you will see the your name of virtualenvs on command-line screen 
-	need to type command below

``$ pip install -r requirements.txt``

-	you can see all environments using pip current virtual-environment

``$ pip list`` or ``$ pip freeze``
