import os
import urllib2
from bs4 import BeautifulSoup
import string
import requests
import sqlalchemy
import json
from sqlalchemy import *
from sqlalchemy.orm import *
from sqlalchemy.ext.declarative import declarative_base

def geturl(city):
    url = "https://timesofindia.indiatimes.com/city/"
    url += city
    return url

city = "bangalore"
url = geturl(city)
page = urllib2.urlopen(url)
soup = BeautifulSoup(page,"html.parser")

file = open("news.txt","w")
soup = soup.find(attrs={'id': 'c_articlelist_stories_2'})
soup = soup.find('ul')
for news in soup.findAll('a'):
    news_t = news.text
    file.write(news_t.encode('utf-8')+'\n')
file.close()
