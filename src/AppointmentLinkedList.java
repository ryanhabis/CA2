import utils.Appointment;

public class AppointmentLinkedList {
    protected int numElements;
    protected LinkedList.Node first;
    protected LinkedList.Node last;

    public AppointmentLinkedList() {
        first = null;
        last = null;
    }
    protected static class Node {
        protected Appointment appointment;
        protected LinkedList.Node next;

        /**
         * Constructs a new node with the given data.
         *
         * @param a the Appointment data to be stored in the node.
         */
        public Node(Appointment a) {
            this.appointment = a;
            this.next = null;
        }
    }
}
