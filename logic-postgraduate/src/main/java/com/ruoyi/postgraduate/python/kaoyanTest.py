# -*-coding:utf-8-*-
import json
import sys
from sqlalchemy import create_engine
import sklearn.cluster as sc
import pandas as pd
import numpy as np

attrs = sys.argv[1]
# userName = sys.argv[2]
# password = sys.argv[3]

def getyml():
    # username = sys.argv[2]
    # password = sys.argv[3]
    username = 'root'
    password = '1291757959'
    return username, password

# attrs = "山东,河北"

username, password = getyml()
engine = create_engine('mysql+pymysql://' + username + ':' + password + '@localhost:3306/db_postgraduate?charset=utf8')


school_infos = pd.read_sql("SELECT public_or_private,project_985,project_211,dfc FROM "
                         "university WHERE FIND_IN_SET(province , '"+attrs+"')", con=engine)
school_names = pd.read_sql("SELECT school_name FROM "
                         "university WHERE FIND_IN_SET(province , '"+attrs+"')", con=engine)

# school_infos
model = sc.KMeans(n_clusters=4)
model.fit(school_infos)
pred_y = model.labels_
a = []
b = []
for i in pred_y:
    a.append(int(i))
for i in school_names["school_name"]:
    b.append(i)

re = json.dumps({"schools": b, "labels": a})
print(re)
