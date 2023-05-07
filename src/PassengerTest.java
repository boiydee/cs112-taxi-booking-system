@Test
publicvoidtestCreation()
        {
        Locationpickup=newLocation(0,0);
        Locationdestination=newLocation(1,2);
        Passengerpassenger1=newPassenger(pickup,destination);
        assertEquals(destination,passenger1.getDestination());
        assertEquals(pickup,passenger1.getPickupLocation());
        }

@Test
publicvoidtestToString(){
        Locationpickup=newLocation(0,0);
        Locationdestination=newLocation(1,2);
        Passengerpassenger1=newPassenger(pickup,destination);
        assertEquals("Passengertravellingfromlocation0,0tolocation1,2",passenger1.toString());
        }