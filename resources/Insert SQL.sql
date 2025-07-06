INSERT INTO Seller (seller_id, name, address) 
	Values (1, "Taylor Aldridge", "1002 N Main St, Philidelphia PA, 19019"),
			(2, "Megan Worthy", "20880 W Westside Rd, Philidelphia PA, 19019:"),
			(3, "Joe Dirte", "100 S Main St, Philidelphia PA, 19019"),
			(4, "Jel Edonut", "10052 N 37th Ave, Phoenix AZ, 85051";
			
INSERT INTO Agent (agent_id, name, address, phone_number, number_of_homes)
	Values (1, "Sally Shoeshine", "3000 N Main St, Philidelphia PA, 19019", "515555555", 1),
			(2, "Jim Baker", "19024 E Shoreline Dr, Philidelphia PA, 19019", "515338989", 0),
			(3, "Tim Teetoler", "1084 S Wake St, Philidelphia PA, 19019", "5156541234", 2);
			
INSERT INTO Home (home_id, address, bedrroms, bathrooms, size_sqft, lot_size, property_type, price)
	Values (1, "1002 N Main St, Philidelphia PA, 19019", 3, 2, 1500, 2500, "single-family", 300000),
			(2, "20880 W Westside Rd, Philidelphia PA, 19019", 2, 2, 1100, 2100, "condo", 200000),
			(3, "100 S Main St, Philidelphia PA, 19019", 5, 4, 3000, 5000, "single-family", 5000000);

			
INSERT INTO Client (client_id, name, address, phone_number, pref_property_type, price_range, pref_bedrooms, pref_bathrooms)
	Values (1, "Joey Bosa", "2985 N Main St, Philidelphia PA, 19019", "5158318813", "singe-family", "350000", 3, 3),
			(2, "Jim Ursay", "5719 W Westside Rd, Philidelphia PA, 19019", "5158149841", "condo", "200000", 2, 2),
			(3, "Sarah Axelrod", "1313 S Main St, Philidelphia PA, 19019", "5151234563", "single-family", "1000000", 8, 4),
			(4, "Joshua Becker", "8587 E Shoreline Dr, Philidelphia PA, 19019", "5154568523", "single-family", "500000", 5, 5),
			(5, "Julie Bloom", "15719 W Bell Rd, Surpise AZ, 85391", "6027894561", "single-family", 350000, 3, 2);
			
INSERT INTO Viewing (viewing_id, listing_id, client_id, view_date)
	Values (1, 2, 2, "12-JUL-2025"),
			(2, 2, 5, "13-JUL-2025"),
			(3, 1, 1, "20-JUL-2025"),
			(4, 1, 4, "20-JUL-2025"),
			(5, 1, 5, "20-JUL-2025"),
			(6, 3, 3, "30-JUN-2025");
			