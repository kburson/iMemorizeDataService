iMemorizeServices
=================

Data Web Services for iMemorize app suite


*http headers fields:*
User-Agent:
* Mozilla/5.0
* curl/7.24.0

(Content-Type)[http://en.wikipedia.org/wiki/MIME_type]:
* application/json
* application/xml
* application/javascript



To use RestClient:

action: POST
url:  http://localhost:9150/iMemorizeDataService/fact
headers:
    Content-Type: application/json
    User-Agent: Mozilla/5.0
Data:
    {
     "question":"Who is alive?",
     "answer":"Number 5 is alive."
    }
--------
results:
--------
Status: 201 Created
headers:
    Date: Mon, 16 Sep 2013 20:24:42 GMT
    Server: Apache-Coyote/1.1
    Transfer-Encoding: chunked
    Content-Type: application/json;charset=UTF-8
Data:
    {"class":"me.burson.imemorizedataservice.domain.Fact","id":"402880bc4127e6e50141287251f20003","answer":"Number 5 is alive.","question":"Who is alive?"}
====================================================================

action: GET
url:  http://localhost:9150/iMemorizeDataService/fact
headers:
    Content-Type: application/json
    User-Agent: Mozilla/5.0
--------
results:
--------
Status: 200 OK

headers:
    Date: Mon, 16 Sep 2013 20:28:24 GMT
    Server: Apache-Coyote/1.1
    Transfer-Encoding: chunked
    Content-Type: application/json;charset=UTF-8

data:
    [
        {
            "class":"me.burson.imemorizedataservice.domain.Fact",
            "id":"402880bc4127e6e5014127e6f50c0000",
            "answer":"Cogito Ergo Sum.",
            "question":"Am I alive?"
        },
        {
            "class":"me.burson.imemorizedataservice.domain.Fact",
            "id":"402880bc4127e6e50141287251f20003",
            "answer":"Number 5 is alive.",
            "question":"Who is alive?"
        },
          ...
    ]

====================================================================

action: PUT
url:  http://localhost:9150/iMemorizeDataService/fact/402880bc4127e6e50141287251f20003
headers:
    Content-Type: application/json
    User-Agent: Mozilla/5.0
Data:
    {
     "answer":"Number 5 is alive!"
    }

--------
results:
--------
Status: 200 OK

headers:
    Date: Mon, 16 Sep 2013 20:35:39 GMT
    Server: Apache-Coyote/1.1
    Transfer-Encoding: chunked
    Content-Type: application/json;charset=UTF-8

data:
    {
        "class":"me.burson.imemorizedataservice.domain.Fact",
        "id":"402880bc4127e6e50141287251f20003",
        "answer":"Number 5 is alive!",
        "question":"Who is alive?"
    }

====================================================================

action: DELETE
url:  http://localhost:9150/iMemorizeDataService/fact/402880bc4127e6e50141287251f20003
headers:
    Content-Type: application/json
    User-Agent: Mozilla/5.0
--------
results:
--------
Status: 204 No Content

headers:
    Date: Mon, 16 Sep 2013 20:37:12 GMT
    Server: Apache-Coyote/1.1

====================================================================

action: GET
url:  http://localhost:9150/iMemorizeDataService/fact/402880bc4127e6e50141287251f20003
headers:
    Content-Type: application/json
    User-Agent: curl/7.24.0
--------
results:
--------
Status: 404 Not Found

headers:
    Date: Mon, 16 Sep 2013 20:40:01 GMT
    Content-Length: 0
    Server: Apache-Coyote/1.1