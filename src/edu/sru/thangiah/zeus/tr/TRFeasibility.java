package edu.sru.thangiah.zeus.tr;

//import the parent class


import edu.sru.thangiah.zeus.core.Feasibility;
import edu.sru.thangiah.zeus.tr.TRSolutionHierarchy.TRNodesList;


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


public class TRFeasibility
		extends Feasibility
		implements java.io.Serializable, Cloneable {


	//VARIABLES
	private TRNodesList thisRoute;




	//CONSTRUCTOR
	public TRFeasibility() {
	}

//CONSTRUCTOR
//ORIGINAL NOTE FROM Dr. Sam's VRP

	/**
	 * Constructor for the feasibilty, will send the constants as well as a
	 * pointer to the route that will be checked
	 *
	 * @param maxd      max duration
	 * @param maxq      max capacity
	 * @param thisRoute the route
	 */
	public TRFeasibility(final double maxd, final float maxq, final TRNodesList thisRoute) {
		maxDuration = maxd;
		maxCapacity = maxq;
		this.thisRoute = thisRoute;
	}//END CONSTRUCTOR *******************<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<




	public TRFeasibility(final TRFeasibility copyMe) {
		this.maxDuration = copyMe.maxDuration;
		this.maxDistance = copyMe.maxDistance;
		this.maxTravelTime = copyMe.maxTravelTime;
		this.maxCapacity = copyMe.maxCapacity;
		this.thisRoute = new TRNodesList(copyMe.thisRoute);

	}


//METHOD
//ORIGINAL NOTE


	/**
	 * This function checks the feasibility of the route.
	 *
	 * @return true if feasible, false if not.
	 */
	public boolean isFeasible() {
		double currentDistance;
		double currentDemand;

		if(thisRoute == null) {
			//if our root is empty
			System.exit(1);
			//ostrich algorithm
		}

		//todo check this commented out code. trying to clean up comments but return true is not commented out
		//for some reason the rest of the code is


		currentDistance = edu.sru.thangiah.zeus.pvrp.PVRPProblemInfo.nodesLLLevelCostF.getTotalDistance(thisRoute);
//	currentDemand = TRProblemInfo.nodesLLLevelCostF.getTotalDemand(thisRoute);		no total demand for TR


//	if((currentDistance <= maxDuration) /*&& (currentDemand <= maxCapacity)*/) {
		return true;
		//if our current distance and demand are NOT within the restraints
//	}
//	else {
		//else, our trucks are good
//		return false;
//	}
	}//END IS_FEASIBLE *******************<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<




	//METHOD
//sets the route to
	public void setRoute(final TRNodesList nodes) {
		this.thisRoute = nodes;
	}


}
