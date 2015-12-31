class Data:
    def __init__(self, data):
        self.data = data

    def increase(self):
        self.data = + 1
        return self.data

d = Data(20)
print(d.increase())
