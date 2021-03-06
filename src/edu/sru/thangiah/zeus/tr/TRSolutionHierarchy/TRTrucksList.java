package edu.sru.thangiah.zeus.tr.TRSolutionHierarchy;

//import the parent class


import edu.sru.thangiah.zeus.core.TruckLinkedList;
import edu.sru.thangiah.zeus.tr.TRAttributes;
import edu.sru.thangiah.zeus.tr.TRProblemInfo;


public class TRTrucksList
		extends TruckLinkedList
		implements java.io.Serializable, Cloneable, DoublyLinkedList {

	private TRAttributes  attributes = new TRAttributes();
	private TRTruck      head;
	private TRTruck      tail;




	//CONSTRUCTOR
	public TRTrucksList() {
		setUpHeadTail();
		setAttributes(new TRAttributes());
	}//END CONSTRUCTOR *******************<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<




	@Override
	public void setUpHeadTail() {
		this.head = new TRTruck();
		this.tail = new TRTruck();
		//	setHead((ObjectInList) new TRTruck());
		//	setTail((ObjectInList) new TRTruck());
		linkHeadTail();
	}




	//GETTER
	public TRTruck getHead() {
		return this.head;
	}




	//GETTER
	public TRTruck getTail() {
		return this.tail;
	}




	//METHOD
//link the head and the tail together
	public void linkHeadTail() {
		getHead().linkAsHeadTail(getTail());
	}//END LINK_HEAD_TAIL *********<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<




	public int getSize() {
		TRTruck theTruck = getHead();
		int sizeCounter = 0;

		if(!isValidHeadTail()) {
			return -1;
		}

		while(theTruck.getNext() != getTail()) {
			theTruck = theTruck.getNext();
			sizeCounter++;
		}

		return sizeCounter;
	}




	@Override
	public TRAttributes getAttributes() {
		return this.attributes;
	}




	//SETTER
	@Override
	public void setAttributes(final TRAttributes attributes) {
		this.attributes = attributes;
	}




	@Override
	public boolean setHead(final ObjectInList head) {
		//	return getHead().replaceThisWith((TRTruck) head);
		if(head != null) {
			head.setPrevious(getTail().getPrevious());
			head.getPrevious().setNext(head);
			getHead().setPrevious(null);
			getHead().setNext((ObjectInList) null);
			this.head = (TRTruck) head;
			return true;
		}
		return false;
	}




	@Override
	public TRTruck getFirst() {
		if(isEmpty() || !isValidHeadTail()) {
			System.out.println("ERROR: getFirst() is null/invalid");
			return null;
		}
		return getHead().getNext();
	}




	@Override
	public boolean insertAfterLastIndex(final ObjectInList theObject) {
		if(!isValidHeadTail()) {
			return false;
		}

		if(isEmpty()) {
			return getHead().insertAfterCurrent(theObject);
		}
		//otherwise we already got stuff in here
		return getLast().insertAfterCurrent(theObject);
	}




	@Override
	public TRTruck getLast() {
		if(isEmpty() || !isValidHeadTail()) {
			return null;
		}
		return (TRTruck) getTail().getPrevious();
	}




	@Override
	public boolean removeLast() {
		if(!isEmpty() && isValidHeadTail()) {
			return getTail().getPrevious().removeThisObject();
		}
		return false;
	}




	@Override
	public boolean removeFirst() {
		if(!isEmpty() && isValidHeadTail()) {
			return getHead().getNext().removeThisObject();
		}
		return false;
	}




	@Override
	public int getIndexOfObject(final ObjectInList findMe) {
		int counter = -1;
		TRTruck theDay = this.getHead();

		if(!isEmpty() && isValidHeadTail()) {
			while(theDay != findMe) {
				theDay = theDay.getNext();
				counter++;
				if(theDay == tail) {
					return -1;
				}
			}
			return counter;
		}
		return -1;
	}




	@Override
	public boolean setTail(final ObjectInList tail) {
		//	return getTail().replaceThisWith((TRTruck) tail);
		if(tail != null) {
			tail.setPrevious(getTail().getPrevious());
			tail.getPrevious().setNext(tail);
			getTail().setPrevious(null);
			getTail().setNext((ObjectInList) null);
			this.tail = (TRTruck) tail;
			return true;
		}
		return false;

	}




	@Override
	public boolean isValidHeadTail() {
		if(getHead() == null || getHead().getNext() == null || getHead().getPrevious() != null ||
				getTail().getPrevious() == null || getTail() == null || getTail().getNext() != null) {
			return false;
		}
		return true;
	}




	@Override
	public boolean insertShipment(final TRShipment theShipment) {
		boolean status = false;

		TRTruck theTruck = this.getFirst();

		while(theTruck != this.getTail()) {
			if(theTruck.insertShipment(theShipment)) {
				return true;
			}
			theTruck = theTruck.getNext();
		}
		return false;
	}




	@Override
	public boolean removeByIndex(final int index) {
		int counter = -1;
		TRTruck theDay = this.getHead();

		while(index >= 0 && index < getSize() && isValidHeadTail()) {
			theDay = theDay.getNext();
			counter++;
			if(counter == index) {
				return theDay.removeThisObject();
			}
		}
		return false;
	}




	@Override
	public int getSizeWithHeadTail() {
		if(isValidHeadTail()) {
			return getSize() + 2;
		}
		return -1;
	}




	public boolean isEmpty() {
		if(getSize() == 0) {
			return true;
		}
		return false;
	}




	@Override
	public boolean removeByObject(final ObjectInList findMe) {
		TRTruck theTruck = getHead();
		while(theTruck.getNext() != getTail() && isValidHeadTail()) {
			theTruck = theTruck.getNext();
			if(theTruck == findMe) {
				theTruck.removeThisObject();
				return true;
			}
		}
		return false;
	}




	@Override
	public boolean insertAfterIndex(final ObjectInList insertMe, final int index) {
		int counter = -1;
		TRTruck theTruck = getHead();

		while(index >= 0 && index < getSize() && !isEmpty() && isValidHeadTail()) {
			theTruck = theTruck.getNext();
			counter++;
			if(counter == index) {
				theTruck.insertAfterCurrent(insertMe);
				return true;
			}
		}
		return false;
	}




	@Override
	public ObjectInList getAtIndex(final int index) {
		int counter = -1;
		TRTruck theTruck = getHead();

		while(index >= 0 && index < getSize() && !isEmpty() && isValidHeadTail()) {
			theTruck = theTruck.getNext();
			counter++;
			if(counter == index) {
				return theTruck;
			}
		}
		return null;
	}




	@Override
	public boolean insertAfterObject(final ObjectInList insertMe, final ObjectInList insertAfter) {
		TRTruck theTruck = head;
		while(!isEmpty() && isValidHeadTail()) {
			theTruck = theTruck.getNext();
			if(theTruck == insertAfter) {
				return insertAfter.insertAfterCurrent(insertMe);
				//			return true;
			}
		}
		return false;
	}




	@Override
	public double getDistanceTravelledMiles() {
		return 0;
	}




	@Override
	public boolean setHeadNext(final ObjectInList nextHead) {
		if(this.getHead().getNext() == this.getTail()) {
			return false;
		}
		this.getHead().setNext(nextHead);
		return true;

	}




	@Override
	public boolean setTailPrevious(final ObjectInList nextTail) {
		if(this.getTail().getPrevious() == this.getHead()) {
			return false;
		}
		this.getTail().setPrevious(nextTail);
		return true;

	}




	@Override
	public void setUpHeadTail(final ObjectInList head, final ObjectInList tail) {
		this.head = (TRTruck) head;
		this.tail = (TRTruck) tail;
		//	setHead(head);
		//	setTail(tail);
		linkHeadTail();
	}



	public TRTrucksList(final TRTrucksList copyMe) {
		setHead((ObjectInList) new TRTruck(copyMe.getHead()));
		setTail((ObjectInList) new TRTruck(copyMe.getTail()));
		setAttributes(new TRAttributes(copyMe.getAttributes()));

		TRTruck theCopyMeDepot = copyMe.getHead();
		TRTruck newDepot = getHead();
		while(theCopyMeDepot.getNext() != copyMe.getTail()) {
			theCopyMeDepot = theCopyMeDepot.getNext();
			newDepot.insertAfterCurrent(new TRTruck(theCopyMeDepot));
			newDepot = newDepot.getNext();
		}
	}




	//METHOD
//used by the gui to show problem information
	public String getSolutionString() {
		return "Trucks Used = " + TRProblemInfo.noOfVehs + " | " + this.attributes.toDetailedString();
	}

}
