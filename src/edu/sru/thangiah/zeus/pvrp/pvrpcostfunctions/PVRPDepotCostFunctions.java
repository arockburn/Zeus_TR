package edu.sru.thangiah.zeus.pvrp.pvrpcostfunctions;


import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.pvrp.PVRPDepot;


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


public class PVRPDepotCostFunctions
		extends PVRPAbstractCostFunctions
		implements java.io.Serializable {


//GETTER
public double getTotalCost(Object o) {
	setTotalCost(o);

	return ((PVRPDepot) o).getAttributes().getTotalCost();
}




//GETTER
public float getTotalDemand(Object o) {
	setTotalDemand(o);

	return (int) ((PVRPDepot) o).getAttributes().getTotalDemand();
}




//GETTER
public double getTotalDistance(Object o) {
	setTotalDistance(o);

	return ((PVRPDepot) o).getAttributes().getTotalDistance();
}




//SETTER
public void setTotalCost(Object o) {
	PVRPDepot theDepot = (PVRPDepot) o;
	theDepot.getAttributes().setTotalCost(ProblemInfo.truckLLLevelCostF.getTotalCost(theDepot.getMainTrucks()));
}




//SETTER
public void setTotalDemand(Object o) {
	PVRPDepot theDepot = (PVRPDepot) o;
	((PVRPDepot) o).getAttributes()
				   .setTotalDemand((int) ProblemInfo.truckLLLevelCostF.getTotalDemand(theDepot.getMainTrucks()));
}




//SETTER
public void setTotalDistance(Object o) {
	PVRPDepot theDepot = (PVRPDepot) o;
	theDepot.getAttributes()
			.setTotalDistance((float) ProblemInfo.truckLLLevelCostF.getTotalDistance(theDepot.getMainTrucks()));
}




//CONSTRUCTOR
public void calculateTotalsStats(Object o) {
	setTotalDemand(o);
	setTotalDistance(o);
	setTotalCost(o);
}
}
