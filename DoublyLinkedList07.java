class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None  # Pointer to the previous node

class DoublyLinkedList:
    def __init__(self):
        self.head = None

    def display(self):
        if self.head is None:
            print("List is Empty")
            return
        temp = self.head
        while temp:
            print(temp.data, "<-->", end="")
            temp = temp.next
        print("None")

    def del_spos(self, pos):
        if self.head is None:  # Check if the list is empty
            print("List is empty, nothing to delete.")
            return

        if pos == 1:  # Special case for deleting the head
            self.head = self.head.next
            if self.head:  # Update the previous pointer of the new head
                self.head.prev = None
            return

        temp = self.head
        for i in range(1, pos):  # Traverse to the node at the position
            if temp is None:  # Check if position is valid
                print("Position out of bounds.")
                return
            temp = temp.next

        if temp is None:  # If we reached the end without finding the position
            print("Position out of bounds.")
            return

        # Now 'temp' is the node to be deleted
        if temp.next:  # If it's not the last node
            temp.next.prev = temp.prev

        if temp.prev:  # If it's not the first node
            temp.prev.next = temp.next

# Example usage
L = DoublyLinkedList()
n = Node(10)
L.head = n

n1 = Node(20)
n.next = n1
n1.prev = n

n2 = Node(30)
n1.next = n2
n2.prev = n1

n3 = Node(40)
n2.next = n3
n3.prev = n2



L.display()  # Display the list
print("\nDeleting the node at position 3...")
L.del_spos(3)  # Delete the node at position 3
L.display()  # Display the list after deletion
