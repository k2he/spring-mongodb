db.createUser({
	user : "root",
	pwd : "root12345",
	roles : [ {
		role : "readWrite",
		db : "testDB"
	} ]
});

db.testDB.insertMany([ 
	{
		"name" : "John",
		"age" : 22,
		"role" : "Developer",
		"address" : {
			"zipCode" : {
				"zipCode" : "m2n4f5",
				"description" : "canadian postal code"
			},
			"street" : "1 front street",
			"city" : "toronto",
			"country" : "Canada"
		}
	}, 
	{
		"name" : "Smith",
		"age" : 35,
		"role" : "Admin",
		"address" : {
			"zipCode" : {
				"zipCode" : "m2n4f5",
				"description" : "canadian post code"
			},
			"street" : "100 dundas street",
			"city" : "toronto",
			"country" : "Canada"
		}
	} 
])