# API Documentation for End Point "/schedule"

<a name="table-of-content"></a>
## Table of Content

- [Show events](#events)
    - [URL](#events-url)
    - [Method](#events-method)
    - [URL Params](#events-url-params)
    - [Data Params](#events-data-params)
    - [Success Response](#events-success-response)
    - [Error Response](#events-error-response)
- [Show event](#event)
    - [URL](#event-url)
    - [Method](#event-method)
    - [URL Params](#event-url-params)
    - [Data Params](#event-data-params)
    - [Success Response](#event-success-response)
    - [Error Response](#event-error-response)
- [Show events for several groups](#event-filter)
    - [URL](#event-filter-url)
    - [Method](#event-filter-method)
    - [URL Params](#event-filter-url-params)
    - [Data Params](#event-filter-data-params)
    - [Data Type](#event-filter-data-type)
    - [Success Response](#event-filter-success-response)
    - [Error Response](#event-filter-error-response)
- [Show key events](#key-events)
    - [URL](#key-events-url)
    - [Method](#key-events-method)
    - [URL Params](#key-events-url-params)
    - [Data Params](#key-events-data-params)
    - [Success Response](#key-events-success-response)
    - [Error Response](#key-events-error-response)
- [Show key events for several groups](#key-event-filter)
    - [URL](#key-event-filter-url)
    - [Method](#key-event-filter-method)
    - [URL Params](#key-event-filter-url-params)
    - [Data Params](#key-event-filter-data-params)
    - [Data Type](#key-event-filter-data-type)
    - [Success Response](#key-event-filter-success-response)
    - [Error Response](#key-event-filter-error-response)
- [Add key events](#add-key-events)
    - [URL](#add-key-events-url)
    - [Method](#add-key-events-method)
    - [URL Params](#add-key-events-url-params)
    - [Data Params](#add-key-events-data-params)
    - [Data Type](#add-key-events-data-type)
    - [Success Response](#add-key-events-success-response)
    - [Error Response](#add-key-events-error-response)
- [Make copyPasteSchedule](#copyPasteSchedule)
    - [URL](#copyPasteSchedule-url)
    - [Method](#copyPasteSchedule-method)
    - [URL Params](#copyPasteSchedule-url-params)
    - [Data Params](#copyPasteSchedule-data-params)
    - [Data Type](#copyPasteSchedule-data-type)
    - [Success Response](#copyPasteSchedule-success-response)
    - [Error Response](#copyPasteSchedule-error-response)
- [Show events for last week](#lastWeekEvents)
    - [URL](#lastWeekEvents-url)
    - [Method](#lastWeekEvents-method)
    - [URL Params](#lastWeekEvents-url-params)
    - [Data Params](#lastWeekEvents-data-params)
    - [Data Type](#lastWeekEvents-data-type)
    - [Success Response](#lastWeekEvents-success-response)
    - [Error Response](#lastWeekEvents-error-response)
- [Add events](#add-events)
    - [URL](#add-events-url)
    - [Method](#add-events-method)
    - [URL Params](#add-events-url-params)
    - [Data Params](#add-events-data-params)
    - [Data Type](#add-events-data-type)
    - [Success Response](#add-events-success-response)
    - [Error Response](#add-events-error-response)
- [Edit events](#edit-events)
    - [URL](#edit-events-url)
    - [Method](#edit-events-method)
    - [URL Params](#edit-events-url-params)
    - [Data Params](#edit-events-data-params)
    - [Data Type](#edit-events-data-type)
    - [Success Response](#edit-events-success-response)
    - [Error Response](#edit-events-error-response)

<a name="events"></a>
## Show schedule

<a name="events-url"></a>
### URL :
/events

<a name="events-method"></a>
### Method :
GET

<a name="events-url-params"></a>
### URL Params :
**Optional** `groupid=[integer], start=[iso-date], end=[iso-date]`

Example: `groupid=2, start=2017-01-01, end=2018-01-01`

<a name="events-data-params"></a>
### Data Params :
None

<a name="events-success-response"></a>
### Success Response:
**Code:** 200 OK

  **Content:**

      [
          {
              "eventId": 1,
              "dateTime": "2017-07-24 18:00",
              "duration": 120,
              "links": [
                  {
                      "rel": "self",
                      "href": "http://localhost:8080/events/1"
                  },
                  {
                      "rel": "event",
                      "href": "http://localhost:8080/events/1"
                  },
                  {
                      "rel": "group",
                      "href": "http://localhost:8080/groups/1"
                  },
                  {
                      "rel": "eventType",
                      "href": "http://localhost:8080/eventTypes/2"
                  },
                  {
                      "rel": "room",
                      "href": "http://localhost:8080/rooms/1"
                  }
              ]
          },
          {
              "eventId": 2,
              "dateTime": "2017-07-25 18:00",
              "duration": 120,
              "links": [
                  {
                      "rel": "self",
                      "href": "http://localhost:8080/events/2"
                  },
                  {
                      "rel": "event",
                      "href": "http://localhost:8080/events/2"
                  },
                  {
                      "rel": "group",
                      "href": "http://localhost:8080/groups/1"
                  },
                  {
                      "rel": "eventType",
                      "href": "http://localhost:8080/eventTypes/1"
                  },
                  {
                      "rel": "room",
                      "href": "http://localhost:8080/rooms/1"
                  }
              ]
          } etc
      ]


  **Content:** (with Optional parameter groupid=2)

    [
        {
            "eventId": 3,
            "dateTime": "2017-07-24 18:00",
            "duration": 120,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/events/3"
                },
                {
                    "rel": "event",
                    "href": "http://localhost:8080/events/3"
                },
                {
                    "rel": "group",
                    "href": "http://localhost:8080/groups/2"
                },
                {
                    "rel": "eventType",
                    "href": "http://localhost:8080/eventTypes/2"
                },
                {
                    "rel": "room",
                    "href": "http://localhost:8080/rooms/1"
                }
            ]
        },
        {
            "eventId": 4,
            "dateTime": "2017-07-25 18:00",
            "duration": 120,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/events/4"
                },
                {
                    "rel": "event",
                    "href": "http://localhost:8080/events/4"
                },
                {
                    "rel": "group",
                    "href": "http://localhost:8080/groups/2"
                },
                {
                    "rel": "eventType",
                    "href": "http://localhost:8080/eventTypes/1"
                },
                {
                    "rel": "room",
                    "href": "http://localhost:8080/rooms/1"
                }
            ]
        }
    ]

<a name="events-error-response"></a>
### Error Response :

**Code:** 400 Bad Request

**Content:**

    {
        "message": ""Bad request"
    }

**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/events"
    }

[Table of content](#table-of-content)

<a name="event"></a>
## Show event

<a name="event-url"></a>
### URL :
/events/{id}

<a name="event-method"></a>
### Method :
GET

<a name="event-url-params"></a>
### URL Params :
None

<a name="event-data-params"></a>
### Data Params :
None

<a name="event-success-response"></a>
### Success Response:
**Code:** 200 OK

**Content:**

    {
        "eventId": 1,
        "dateTime": "2017-07-24 18:00",
        "duration": 120,
        "_links": {
            "self": {
                "href": "http://localhost:8080/events/1"
            },
            "event": {
                "href": "http://localhost:8080/events/1"
            },
            "group": {
                "href": "http://localhost:8080/groups/1"
            },
            "eventType": {
                "href": "http://localhost:8080/eventTypes/2"
            },
            "room": {
                "href": "http://localhost:8080/rooms/1"
            }
        }
    }

### Error Response :
**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/events/1"
    }

**Code:** 404 Not Found

**Content:**

    {
        "message": "Not Found"
    }

[Table of content](#table-of-content)

<a name="event-filter"></a>
## Show events for several groups

<a name="event-filter-url"></a>
### URL :
/events/filter

<a name="event-filter-method"></a>
### Method :
POST

<a name="event-filter-url-params"></a>
### URL Params :
None

<a name="event-filter-data-params"></a>
### Data Params :
**Required:**

    {
        "groups": [integer array],
        "startDate":"yyyy-MM-dd",
        "endDate":"yyyy-MM-dd"
    }

Example:

    {
        "groups": [1,2],
        "startDate":"2017-01-01",
        "endDate":"2018-01-01"
    }

<a name="event-filter-data-type"></a>
### Data type :
application/json

<a name="key-event-filter-success-response"></a>
### Success Response:
**Code:** 200 OK

**Content:**

    [
        {
            "eventId": 1,
            "dateTime": "2017-06-08 00:00",
            "duration": 0,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/events/1"
                },
                {
                    "rel": "event",
                    "href": "http://localhost:8080/events/1"
                },
                {
                    "rel": "group",
                    "href": "http://localhost:8080/groups/1"
                },
                {
                    "rel": "eventType",
                    "href": "http://localhost:8080/eventTypes/2"
                }
            ]
        },
        {
            "eventId": 2,
            "dateTime": "2017-05-15 00:00",
            "duration": 0,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/events/2"
                },
                {
                    "rel": "event",
                    "href": "http://localhost:8080/events/2"
                },
                {
                    "rel": "group",
                    "href": "http://localhost:8080/groups/1"
                },
                {
                    "rel": "eventType",
                    "href": "http://localhost:8080/eventTypes/1"
                }
            ]
        }, etc
    ]


### Error Response :
**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/events/filter"
    }

**Code:** 404 Not Found

**Content:**

    {
        "message": "Not Found"
    }

[Table of content](#table-of-content)

<a name="key-events"></a>
## Show Key Dates

<a name="key-events-url"></a>
### URL :
/events/demo

<a name="key-events-method"></a>
### Method :
GET

<a name="events-url-params"></a>
### URL Params :
**Optional** `groupid=[integer]`

Example: `groupid=2`

<a name="events-data-params"></a>
### Data Params :
None

<a name="events-success-response"></a>
### Success Response:
**Code:** 200 OK

  **Content:**
All key events

      [
          {
              "eventId": 1,
              "dateTime": "2017-07-24 18:00",
              "duration": 120,
              "links": [
                  {
                      "rel": "self",
                      "href": "http://localhost:8080/events/1"
                  },
                  {
                      "rel": "event",
                      "href": "http://localhost:8080/events/1"
                  },
                  {
                      "rel": "group",
                      "href": "http://localhost:8080/groups/1"
                  },
                  {
                      "rel": "eventType",
                      "href": "http://localhost:8080/eventTypes/2"
                  },
                  {
                      "rel": "room",
                      "href": "http://localhost:8080/rooms/1"
                  }
              ]
          } etc
      ]


  **Content:** (with Optional parameter groupid=2)

    [
        {
            "eventId": 3,
            "dateTime": "2017-07-24 18:00",
            "duration": 120,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/events/3"
                },
                {
                    "rel": "event",
                    "href": "http://localhost:8080/events/3"
                },
                {
                    "rel": "group",
                    "href": "http://localhost:8080/groups/2"
                },
                {
                    "rel": "eventType",
                    "href": "http://localhost:8080/eventTypes/2"
                },
                {
                    "rel": "room",
                    "href": "http://localhost:8080/rooms/1"
                }
            ]
        },
        {
            "eventId": 4,
            "dateTime": "2017-07-25 18:00",
            "duration": 120,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/events/4"
                },
                {
                    "rel": "event",
                    "href": "http://localhost:8080/events/4"
                },
                {
                    "rel": "group",
                    "href": "http://localhost:8080/groups/2"
                },
                {
                    "rel": "eventType",
                    "href": "http://localhost:8080/eventTypes/1"
                },
                {
                    "rel": "room",
                    "href": "http://localhost:8080/rooms/1"
                }
            ]
        }
    ]

<a name="events-error-response"></a>
### Error Response :

**Code:** 400 Bad Request

**Content:**

    {
        "message": ""Bad request"
    }

**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/events/demo"
    }

[Table of content](#table-of-content)

<a name="key-event-filter"></a>
## Show key events for several groups

<a name="key-event-filter-url"></a>
### URL :
/events/demo/filter

<a name="key-event-filter-method"></a>
### Method :
POST

<a name="key-event-filter-url-params"></a>
### URL Params :
None

<a name="key-event-filter-data-params"></a>
### Data Params :
**Required:**

    {
        "groups": [integer array]
    }

**Optional:**

    {
        "groups": [integer array],
        "startDate":"yyyy-MM-dd",
        "endDate":"yyyy-MM-dd"
    }

Example:

    {
        "groups": [1,2],
        "startDate":"2017-01-01",
        "endDate":"2018-01-01"
    }

<a name="key-event-filter-success-response"></a>
### Data type :
application/json

### Success Response:
**Code:** 200 OK

**Content:**

    [
        {
            "eventId": 2,
            "dateTime": "2017-05-15 00:00",
            "duration": 0,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/events/2"
                },
                {
                    "rel": "event",
                    "href": "http://localhost:8080/events/2"
                },
                {
                    "rel": "group",
                    "href": "http://localhost:8080/groups/1"
                },
                {
                    "rel": "eventType",
                    "href": "http://localhost:8080/eventTypes/1"
                }
            ]
        } etc.
    ]


### Error Response :
**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/events/demo/filter"
    }

**Code:** 404 Not Found

**Content:**

    {
        "message": "Not Found"
    }

[Table of content](#table-of-content)

<a name="add-key-events"></a>
## Add key event/events

<a name="add-key-events-url"></a>
### URL :
/events/demo

<a name="add-key-events-method"></a>
### Method :
POST

<a name="add-key-events-url-params"></a>
### URL Params :
None

<a name="add-key-events-data-params"></a>
### Data Params :
**Required:**

        [
            {
                "group":{
                    "id":integer
                },
                "eventType":{
                    "id":integer
                },
                "date":"yyyy-MM-dd"
            }
        ]

Example:

    [
        {
            "group":{
                "id":1
            },
            "eventType":{
                "id":1
            },
            "date":"2017-05-15"
        },
          {
            "group":{
                "id":1
            },
            "eventType":{
                "id":2
            },
            "date":"2017-06-09"
        },
        {
            "eventType":{
                 "id":2
            },
            "date":"2017-06-08"
        },
        {
            "group":{
                  "id":1
            },
            "eventType":{
                    "id":7
            },
            "date":"2017-06-08"
        }
    ]

<a name="add-key-events-data-type"></a>
### Data type :
application/json

<a name="add-key-events-success-response"></a>
### Success Response:
**Code:** 200 OK

**Content:**

    {
        "succeed": [
            {
                "eventId": 2,
                "start": "2017-05-15 00:00",
                "end": "2017-05-15 00:00",
                "links": [
                    {
                        "rel": "self",
                        "href": "http://localhost:8080/events/2"
                    },
                    {
                        "rel": "event",
                        "href": "http://localhost:8080/events/2"
                    },
                    {
                        "rel": "group",
                        "href": "http://localhost:8080/groups/1"
                    },
                    {
                        "rel": "eventType",
                        "href": "http://localhost:8080/eventTypes/1"
                    }
                ]
            }
        ],
        "invalid": [
            {
                "groupId": null,
                "eventTypeId": 2,
                "date": "2017-06-08",
                "errorMessage": "Group is not specified"
            },
            {
                "groupId": 1,
                "eventTypeId": 7,
                "date": "2017-06-08",
                "errorMessage": "Incorrect Event Type"
            },
            {
                "groupId": 1,
                "eventTypeId": 2,
                "date": "2017-06-15",
                "errorMessage": "Wrong date specified"
            }
        ]
    }


<a name="add-key-events-error-response"></a>
### Error Response :
**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/events/demo"
    }

**Code:** 400 Bad Request

**Content:** None

[Table of content](#table-of-content)

<a name="copyPasteSchedule"></a>
## Show copyPasteSchedule

<a name="copyPasteSchedule-url"></a>
### URL :
/events/copypaste

<a name="copyPasteSchedule-method"></a>
### Method :
POST

<a name="copyPasteSchedule-url-params"></a>
### URL Params :
None

<a name="copyPasteSchedule-data-params"></a>
### Data Params :
**Required:**

    {
      "group":{
        "id":[Integer]
        
      },
      "copyWeekDate":"[yyyy-mm-dd]",
      "pasteWeekDate":"[yyyy-mm-dd]"
    }
    
**Or**
    
    {
      "group":{
        "id":[Integer]
         
      },
      "copyWeekDate":"[yyyy-mm-dd]",
      "pasteFillDate":"[yyyy-mm-dd]"
    }
    
Example:   
    
    {
       "group":{
         "id":1
            
       },
       "copyWeekDate":"2017-07-24",
       "pasteWeekDate":"2017-08-14"
    }
    
    {
        "group":{
          "id":1
             
        },
        "copyWeekDate":"2017-07-24",
        "pasteFillDate":"2017-08-17"
    }
 
<a name="copyPasteSchedule-data-type"></a>
### Data type :
application/json
    
<a name="copyPasteSchedule-success-response"></a>
### Success Response:
**Code:** 200 OK

  **Content:**
    
    {
        "group": "DP-115",
        "copyWeekDate": "2017-07-24",
        "pasteWeekDate":"2017-08-14",
        "pasteFillDate": null,
        "conflicts": [
            {
                "dateTime": "2017-08-17 18:00",
                "duration": 120,
                "room": "705",
                "eventType": "work with expert"
            }
        ]
    }
  
  **Or**
       
    {
        "group": "DP-115",
        "copyWeekDate": "2017-07-24",
        "pasteWeekDate": null,
        "pasteFillDate": "2017-08-17",
        "conflicts": [
             {
                 "dateTime": "2017-08-17 18:00",
                 "duration": 120,
                 "room": "705",
                 "eventType": "work with expert"
             }
        ]
    }

<a name="copyPasteSchedule-error-response"></a>
### Error Response :

**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/events/copypaste"
    }
    
**Code:** 403 Forbidden
 
**Content:**
 
    {
        "message": "Access Denied"
    }   
    
**Code:** 400 Bad Request

**Content:** 

    {
         "message": "Bad request: {validationErrors={[ERRORS]}"
    }
     
     
[Table of content](#table-of-content)

<a name="lastWeekEvents"></a>
## Show lastWeekEvents

<a name="lastWeekEvents-url"></a>
### URL :
/events/lastweek

<a name="lastWeekEvents-method"></a>
### Method :
GET

<a name="lastWeekEvents-url-params"></a>
### URL Params :
**Required** `groupid=[integer]`

Example: `groupid=1`

<a name="lastWeekEvents-data-params"></a>
### Data Params :
None
 
<a name="lastWeekEvents-data-type"></a>
### Data type :
application/json
    
<a name="lastWeekEvents-success-response"></a>
### Success Response:
**Code:** 200 OK

  **Content:**
    
    [
        {
            "eventId": 13,
            "dateTime": "2017-08-14 18:00",
            "duration": 120,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/events/13"
                },
                {
                    "rel": "event",
                    "href": "http://localhost:8080/events/13"
                },
                {
                    "rel": "group",
                    "href": "http://localhost:8080/groups/1"
                },
                {
                    "rel": "eventType",
                    "href": "http://localhost:8080/eventTypes/5"
                },
                {
                    "rel": "room",
                    "href": "http://localhost:8080/rooms/1"
                }
            ]
        },
        {
            "eventId": 14,
            "dateTime": "2017-08-15 18:00",
            "duration": 120,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/events/14"
                },
                {
                    "rel": "event",
                    "href": "http://localhost:8080/events/14"
                },
                {
                    "rel": "group",
                    "href": "http://localhost:8080/groups/1"
                },
                {
                    "rel": "eventType",
                    "href": "http://localhost:8080/eventTypes/7"
                },
                {
                    "rel": "room",
                    "href": "http://localhost:8080/rooms/1"
                }
            ]
        }
    ]   

<a name="lastWeekEvents-error-response"></a>
### Error Response :

**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "events/lastweek"
    }
    
**Code:** 403 Forbidden
 
**Content:**
 
    {
        "message": "Access Denied"
    }   
    
**Code:** 400 Bad Request
    
    {
            "message": "[Error]"
    } 

     
[Table of content](#table-of-content)

<a name="add-events"></a>
## Add event/events

<a name="add-events-url"></a>
### URL :
/events

<a name="add-events-method"></a>
### Method :
POST

<a name="add-events-url-params"></a>
### URL Params :
**Required** `groupid=[integer]`

Example: `groupid=8`

<a name="add-events-data-params"></a>
### Data Params :
**Required:**

    [
        {
                "start": [yyyy-mm-dd mm:ss],
                "end": [yyyy-mm-dd mm:ss],
                "eventType":{
                  "id":[integer]
                },
                "room":{
                  "id":[integer]
                }
        }
    ]

Example:

    [
    {
            "start": "2019-07-25 15:00",
            "end": "2019-07-25 15:50",
            "eventType":{
              "id":9
            },
            "room":{
              "id":1
            }
    },{
            "start": "2019-07-26 16:00",
            "end": "2019-07-26 16:50",
            "eventType":{
              "id":9
            },
            "room":{
              "id":1
            }
    }
    ]

<a name="add-events-data-type"></a>
### Data type :
application/json

<a name="add-events-success-response"></a>
### Success Response:
**Code:** 200 OK

**Content:**

     {
     "succeed": [
            {
                "eventId": 41,
                "start": "2019-07-25 15:00",
                "end": "2019-07-25 15:50",
                "links": [
                    {
                        "rel": "self",
                        "href": "http://localhost:8080/events/41"
                    },
                    {
                        "rel": "event",
                        "href": "http://localhost:8080/events/41"
                    },
                    {
                        "rel": "group",
                        "href": "http://localhost:8080/groups/8"
                    },
                    {
                        "rel": "eventType",
                        "href": "http://localhost:8080/eventTypes/9"
                    },
                    {
                        "rel": "room",
                        "href": "http://localhost:8080/rooms/1"
                    }
                ]
            }
            ],
     "invalid": [
            {
            "start": "2019-07-26 16:00",
            "end": "2019-07-26 16:50",
            "room": "1",
            "eventType": "practice",
            "message": "The room has already been taken for another event on:2019-07-26 16:00"
             }
            ]
     }

<a name="add-events-error-response"></a>
### Error Response :
**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/events?groupid=8"
    }

**Code:** 400 Bad Request

**Content:** None

[Table of content](#table-of-content)

<a name="edit-events"></a>
## Edit event/events

<a name="edit-events-url"></a>
### URL :
/events

<a name="edit-events-method"></a>
### Method :
PUT

<a name="edit-events-url-params"></a>
### URL Params :
None

<a name="edit-events-data-params"></a>
### Data Params :
**Required:**

    [{
    	"id":[integer],
      "start": [yyyy-mm-dd mm:ss],
      "end": [yyyy-mm-dd mm:ss],
      "eventType":{
       "id":[integer]
        }

    }]

Example:

    [{
        	"id":12,
          "start": "2017-07-27 23:00",
          "end": "2017-07-27 23:22",
          "eventType":{
           "id":9
            }

    }]

<a name="edit-events-data-type"></a>
### Data type :
application/json

<a name="edit-events-success-response"></a>
### Success Response:
**Code:** 200 OK

**Content:**

     {
     "succeed": [
             {
                 "eventId": 12,
                 "start": "2017-07-27 23:00",
                 "end": "2017-07-27 23:22",
                 "links": [
                     {
                         "rel": "self",
                         "href": "http://localhost:8080/events/12"
                     },
                     {
                         "rel": "event",
                         "href": "http://localhost:8080/events/12"
                     },
                     {
                         "rel": "group",
                         "href": "http://localhost:8080/groups/1"
                     },
                     {
                         "rel": "eventType",
                         "href": "http://localhost:8080/eventTypes/9"
                     },
                     {
                         "rel": "room",
                         "href": "http://localhost:8080/rooms/1"
                     }
                 ]
             }
         ],
         "invalid": []
     }

<a name="edit-events-error-response"></a>
### Error Response :
**Code:** 401 Unauthorized

**Content:**

    {
        "timestamp": 1500674037140,
        "status": 401,
        "error": "Unauthorized",
        "message": "Unauthorized",
        "path": "/events"
    }

**Code:** 400 Bad Request

**Content:** None

[Table of content](#table-of-content)