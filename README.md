[![Build Status](https://travis-ci.org/hzitoun/xebia-technical-test.svg?branch=master)](https://travis-ci.org/hzitoun/xebia-technical-test)
[![codecov](https://codecov.io/gh/hzitoun/xebia-technical-test/branch/master/graph/badge.svg)](https://codecov.io/gh/hzitoun/xebia-technical-test)
# Xebia-Technical-Test

 <img src="https://i.ebayimg.com/00/s/NDUwWDQzNw==/z/wzIAAOSwdGFYq24r/$_86.JPG" width="150" height="150"/>(Image credits: <a href="https://i.ebayimg.com/00/s/NDUwWDQzNw==/z/wzIAAOSwdGFYq24r/$_86.JPG">here</a>)

XTT - Xebia Technical Test
## Build 
To build the app and run the unit tests:
 ```console
 mvnw clean install
 ```
## Run
To execute the app run the following command after setting <PATH_TO_INPUT_FILE> (./docs/input.txt for example):
```console
java -jar target\xtt-by-hz.jar <PATH_TO_INPUT_FILE>
```

## Fan Of Docker?
Me too!
### Build the Docker image

```console
docker build -t hzitoun/xtt
```

### Run the container

```console
docker run -d hzitoun/xtt ./docs/input.txt
```

