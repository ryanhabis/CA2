import utils.Appointment;

public class PriorityQueue extends AppointmentLinkedList{

    public PriorityQueue() {
        super();

    }
    /**
     *
     * Adds a new task to the PriorityQueue.
     *
     * @param app, the Appointment to add to the PriorityQueue.
     *
     * @return true, if the Appointment was added otherwise false is returned.
     *
     */
    @Override
    public boolean add(Appointment app)  {
        Node newNode = new Node(app);
        if(isEmpty()){
            first = newNode;
            last = newNode;

        }else if(first.data.compareTo(app)<0){
            newNode.next = first;
            first = newNode;
        }else if(last.data.compareTo(app)>=0){
            last.next = newNode;
            last = newNode;
        }else{
            Node current = first.next;
            Node previous = first;

            while(current!=null && current.data.compareTo(app)>=0){

              if (current.data.equals(app)){
                  throw new DuplicateAppointmentException("Appointment already exits");
              }

                previous = current;
                current = current.next;
            }

            previous.next = newNode;
            newNode.next = current;
        }

        numElements++;
        return true;
    }

    @Override
    public Appointment get(int pos){
        throw new UnsupportedOperationException("This method is not available for the Priority Queue");
    }

}
