package edu.sru.thangiah.zeus.pvrp;

//import the parent class


import edu.sru.thangiah.zeus.core.TruckType;


/**
 * PVRP (Periodic Vehicle Routing)
 * Routes vehicles to various nodes over a given number of days
 * <p/>
 * Version 1.0
 * <p/>
 * 10/17/14
 * <p/>
 * AUTHORS
 * Aaron Rockburn and Joshua Sarver
 * Slippery Rock University of Pa
 * CPSC 464 - Fall 2014
 * <p/>
 * COPYLEFT
 * Attribution-ShareAlike 4.0 International
 * <p/>
 * BASED ON
 * Dr. Sam R. Thangiah's work at Slippery Rock University of Pa
 * A Heuristic for the Periodic Vehicle Routing Problem by M. Gaudioso, G. Paletta
 * Chou
 * The Periodic Vehicle Routing Problem by S. Coene, A. Arnout and F. Spieksma
 * A Variable Neighborhood Search Heuristic for Periodic Routing Problems by Vera C. Hemmelmayr, Karl F. Doerner§,
 * Richard F. Hartl
 * <p/>
 * Methods are generally sorted by breadth-first order
 */

public class PVRPTruckType
		extends TruckType
		implements java.io.Serializable, java.lang.Cloneable {


public PVRPTruckType(){}
//CONSTRUCTOR
public PVRPTruckType(int typeNumber, float maxDistance, float maxCapacity, String typeCustomers) {
	setTruckNo(typeNumber);
	setServiceType(typeCustomers);

	if(maxDistance == 0) {
		//if the maximum distance is zero
		//then set it to a maximum value

		setMaxDuration(Integer.MAX_VALUE);
	}
	else {
		setMaxDuration(maxDistance);
		//if we have a real value
		//set max distance to this
		//maxDistance == maxDuration
	}

	if(maxCapacity == 0) {
		//if the maximum distance is zero
		//then set it to a maximum value

		setMaxCapacity(Integer.MAX_VALUE);
	}
	else {
		setMaxCapacity(maxCapacity);
		//if we have a real value
		//set max distance to this
		//maxDistance == maxDuration
	}

	setFixedCost(getMaxCapacity());
	setVariableCost((double) getMaxCapacity() / 1000);
}//END CONSTRUCTOR *******************<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

}
