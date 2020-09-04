import urllib.request

url='https://www.naver.com/'

requests = urllib.request.urlopen(url).read()
print(type(requests))
print(requests.decode('utf-8'))
