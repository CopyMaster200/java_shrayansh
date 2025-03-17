package test.datastructures;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinikedList linikedList = new LinikedList();
        linikedList.insert(10);
        linikedList.insert(20);
        linikedList.insert(30);
        linikedList.insert(40);
        linikedList.insert(50);
        linikedList.printList();

        System.out.println("Delete Head:");
        linikedList.delete(10);
        linikedList.printList();

        System.out.println("Delete Tail:");
        linikedList.delete(50);
        linikedList.printList();
    }
}
