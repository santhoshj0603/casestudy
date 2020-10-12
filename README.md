checkout casestudy project and do a maven build.

There are 2 API's available.
1. /public/v1/user/save 
	It is a public one and can be accessed by anyone.
	
	Sample Request:
	
	{
    "firstName": "Santhosh",
    "lastName": "Jagadeeswaran",
    "phoneNumber": 1234567890,
    "address":{
        "city": "dallas",
        "state": "texas",
        "zip": 75229
    	}
	}
	
2. /private/v1/user/all 
	It is a private one and can be accessed only by admin.
	To access this api use below credentials
	UserName: admin
	Password: password


	