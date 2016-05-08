import sqlite3

con = sqlite3.connect('/tmp/smart.db')

cur = con.cursor()


def insert_hum(item):
    cur.execute('INSERT INTO hum(hum, pub_date) VALUES (?,?)', item)
    con.commit()


def insert_tem(item):
    cur.execute('INSERT INTO temp(temp, pub_date) VALUES (?,?)', item)
    con.commit()