package edu.sru.thangiah.zeus.pvrp.pvrpcostfunctions;


import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.pvrp.PVRPDepot;
import edu.sru.thangiah.zeus.pvrp.PVRPDepotLinkedList;


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


public class PVRPDepotLLCostFunctions
		extends PVRPAbstractCostFunctions
		implements java.io.Serializable {


//GETTER
public double getTotalCost(Object o) {
	setTotalCost(o);

	return ((PVRPDepotLinkedList) o).getAttributes().getTotalCost();
}




//GETTER
public float getTotalDemand(Object o) {
	setTotalDemand(o);

	return (int) ((PVRPDepotLinkedList) o).getAttributes().getTotalDemand();
}




//GETTER
public double getTotalDistance(Object o) {
	setTotalDistance(o);

	return ((PVRPDepotLinkedList) o).getAttributes().getTotalDistance();
}




//SETTER
public void setTotalCost(Object o) {
	PVRPDepotLinkedList depotList = (PVRPDepotLinkedList) o;
	PVRPDepot theDepot = depotList.getHead();

	double cost = 0;


	while(theDepot != depotList.getTail()) {
		cost += ProblemInfo.depotLevelCostF.getTotalCost(theDepot);
		theDepot = theDepot.getNext();
	}

	depotList.getAttributes().setTotalCost(cost);
}




//SETTER
public void setTotalDemand(Object o) {
	PVRPDepotLinkedList depotList = (PVRPDepotLinkedList) o;
	PVRPDepot theDepot = depotList.getHead();

	depotList.getAttributes().setTotalDemand(0);


	while(theDepot.getNext() != depotList.getTail()) {
		theDepot = theDepot.getNext();
		depotList.getAttributes().setTotalDemand(
				depotList.getAttributes().getTotalDemand() + ProblemInfo.depotLevelCostF.getTotalDemand(theDepot));
	}
}




//SETTER
public void setTotalDistance(Object o) {
	PVRPDepotLinkedList depotList = (PVRPDepotLinkedList) o;
	PVRPDepot theDepot = depotList.getHead();

	depotList.getAttributes().setTotalDistance(0);


	while(theDepot != depotList.getTail()) {
		depotList.getAttributes()
				 .setTotalDistance(depotList.getAttributes().getTotalDistance() + (float) ProblemInfo.depotLevelCostF.
																															 getTotalDistance(
																																	 theDepot));
		theDepot = theDepot.getNext();
	}
}




//CONSTRUCTOR
public void calculateTotalsStats(Object o) {
	setTotalDemand(o);
	setTotalDistance(o);
	setTotalCost(o);
}
}
