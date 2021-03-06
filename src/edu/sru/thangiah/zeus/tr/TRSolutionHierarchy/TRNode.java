package edu.sru.thangiah.zeus.tr.TRSolutionHierarchy;

//import the parent class


import edu.sru.thangiah.zeus.core.Nodes;
import edu.sru.thangiah.zeus.tr.TRAttributes;
import edu.sru.thangiah.zeus.tr.TRCoordinates;


public class TRNode
		extends Nodes
		implements java.io.Serializable, Cloneable, ObjectInList {

	private TRShipment theShipment = new TRShipment();
	private TRNode        next;
	private TRNode        previous;
	private TRAttributes  attributes = new TRAttributes();
	private TRCoordinates homeDepotCoordinates;




	public TRNode(final TRNode copyMe) {
		setShipment(new TRShipment(copyMe.getShipment()));
		setAttributes(new TRAttributes(copyMe.getAttributes()));
		setHomeDepotCoordinates(new TRCoordinates(copyMe.getHomeDepotCoordinates()));
		setHomeDepotCoordinates(new TRCoordinates(copyMe.getHomeDepotCoordinates()));
	}




	public TRCoordinates getHomeDepotCoordinates() {
		return homeDepotCoordinates;
	}



	public void setHomeDepotCoordinates(final TRCoordinates homeDepotCoordinates) {
		this.homeDepotCoordinates = homeDepotCoordinates;
	}




	public TRNode(final TRCoordinates homeDepotCoordinates) {
		setAttributes(new TRAttributes());
		//	set
		//	setHomeDepotCoordinates(homeDepotCoordinates);
	}




	public TRNode(final TRShipment theShipment) {
		setShipment(theShipment);
	}




	public TRNode() {
		setAttributes(new TRAttributes());
	}




	public TRCoordinates getCoordinates() {
		return this.getShipment().getCoordinates();
	}




	@Override
	public TRNodesList getSubList() {
		return null;
	}




	@Override
	public void setSubList(DoublyLinkedList subList) {
		//null
	}




	public TRAttributes getAttributes() {
		return this.attributes;
	}




	@Override
	public void setAttributes(final TRAttributes attributes) {
		this.attributes = attributes;
	}




	@Override
	public boolean insertAfterCurrent(final ObjectInList insertMe) {
		if(this.getNext() != null) {
			(insertMe).setPrevious(this);
			(insertMe).setNext(this.getNext());

			(this).setNext(insertMe);
			(insertMe).getNext().setPrevious(insertMe);
			return true;
		}
		return false;
	}




	public TRNode getNext() {
		return this.next;
	}




	@Override
	public void setNext(final ObjectInList next) {
		this.next = (TRNode) next;
	}




	@Override
	public void linkAsHeadTail(final ObjectInList linkTwo) {
		this.setNext(linkTwo);
		(linkTwo).setPrevious(this);
		this.setPrevious(null);    //nothing comes before the head
		(linkTwo).setNext(null);        //nothing comes after the tail
	}




	@Override
	public boolean removeThisObject() {
		if(this.getNext() != null || this.getPrevious() != null) {

			(this.getPrevious()).setNext(this.getNext());
			(this.getNext()).setPrevious(this.getPrevious());

			this.setPrevious(null);
			this.setNext((ObjectInList) null);
			return true;
		}
		return false;
	}




	@Override
	public ObjectInList getPrevious() {
		return this.previous;
	}




	@Override
	public void setPrevious(final ObjectInList previous) {
		this.previous = (TRNode) previous;
	}




	@Override
	public boolean isSubListEmpty() {
		return true;
	}




	@Override
	public double getDistanceTravelledMiles() {
		return 0;
	}




	//@Override
	public TRShipment getShipment() {
		return this.theShipment;
	}




	public void setShipment(final TRShipment theShipment) {
		this.theShipment = theShipment;
	}


}
