import urllib.request
api='https://search.naver.com/search.naver?'

values={
    'sm':'top_hty',
    'fbm':'1',
    'ie':'utf8',
    'query':'태풍 10호 하이선'
}
params = urllib.parse.urlencode(values)
print(params)

url= api + params
data = urllib.request.urlopen(url).read()
print(data.decode('utf-8'))