# API Documentation for /Locations End Point

## Show all locations

**URL :** /locations

**Method :** GET

**URL Params :** -

**Data Params :** -

**Success Response:** Code: 200, Content: 

    [
        {
            "id": 1,
            "name": "Dnipro",
            "country": {
                "id": 1,
                "name": "Ukraine"
            }
        },
        {
            "id": 2,
            "name": "Sofia",
            "country": {
                "id": 2,
                "name": "Hungary"
            }
        }
    ]

**Error Response :** Code: 401 Unauthorized

## Show all the groups, that belong to the specified location by location Id.

**URL :** /locations/{locationIds}/groups

**Method :** GET

**URL Params :** Required: `{locationIds}`(type: integer), example: `/locations/2/groups`

**Data Params :** -

**Success Response:** Code: 200, Content:

   [
       {
           "id": 2,
           "name": "SF-115",
           "teacher": {
               "id": 3,
               "firstName": "Lucas",
               "lastName": "Lukichich",
               "role": {
                   "id": 4,
                   "name": "coordinator",
                   "roleCategory": {
                       "id": 2,
                       "name": "itacademy"
                   }
               },
               "dateOfBirth": {
                   "year": 2017,
                   "month": "MARCH",
                   "dayOfMonth": 3,
                   "dayOfWeek": "FRIDAY",
                   "era": "CE",
                   "dayOfYear": 62,
                   "leapYear": false,
                   "monthValue": 3,
                   "chronology": {
                       "id": "ISO",
                       "calendarType": "iso8601"
                   }
               },
               "nickName": "LukasLukichich",
               "selfInfo": "coordinator in Sofia",
               "image": null,
               "location": {
                   "id": 2,
                   "name": "Sofia",
                   "country": {
                       "id": 2,
                       "name": "Hungary"
                   }
               },
               "emails": [
                   {
                       "id": 4,
                       "value": "lucalukis@gmail.com",
                       "primary": true
                   }
               ],
               "phones": [
                   {
                       "id": 3,
                       "value": "+344-04-252-66-32"
                   }
               ],
               "contactLinks": []
           },
           "location": {
               "id": 2,
               "name": "Sofia",
               "country": {
                   "id": 2,
                   "name": "Hungary"
               }
           },
           "startDate": {
               "year": 2017,
               "month": "APRIL",
               "dayOfMonth": 29,
               "dayOfWeek": "SATURDAY",
               "era": "CE",
               "dayOfYear": 119,
               "leapYear": false,
               "monthValue": 4,
               "chronology": {
                   "id": "ISO",
                   "calendarType": "iso8601"
               }
           },
           "finishDate": {
               "year": 2017,
               "month": "AUGUST",
               "dayOfMonth": 18,
               "dayOfWeek": "FRIDAY",
               "era": "CE",
               "dayOfYear": 230,
               "leapYear": false,
               "monthValue": 8,
               "chronology": {
                   "id": "ISO",
                   "calendarType": "iso8601"
               }
           },
           "status": {
               "id": 4,
               "name": "in-process",
               "statusCategory": {
                   "id": 2,
                   "name": "current"
               }
           },
           "specialization": {
               "id": 2,
               "name": "js_core"
           }
       }
   ]

**Error Response :** Code: 401 Unauthorized; Code: 404 Not Found 