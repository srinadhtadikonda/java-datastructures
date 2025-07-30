#Doubly Linked List - Deletion -  Menu Driven
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None                          # pointer to previous node


class DoublyLinkedList:
    def __init__(self):
        self.head = None

    # ---------- utility helpers ----------
    def is_empty(self):
        return self.head is None

    def display(self):
        if self.is_empty():
            print("List is Empty\n")
            return
        temp = self.head
        while temp:
            print(temp.data, "<-->", end=" ")
            temp = temp.next
        print("None\n")

    # ---------- deletion operations ----------
    def delete_first(self):
        if self.is_empty():
            print("List is Empty, cannot delete\n")
            return
        temp = self.head
        self.head = temp.next
        if self.head:                             # list had ≥2 nodes
            self.head.prev = None
        print(f"Deleted first node ({temp.data})\n")

    def delete_last(self):
        if self.is_empty():
            print("List is Empty, cannot delete\n")
            return
        if self.head.next is None:                # single node
            print(f"Deleted last node ({self.head.data})\n")
            self.head = None
            return
        temp = self.head
        while temp.next:                          # travel to last node
            temp = temp.next
        print(f"Deleted last node ({temp.data})\n")
        temp.prev.next = None                     # unlink last node

    def delete_at_pos(self, pos):
        if self.is_empty():
            print("List is Empty, cannot delete\n")
            return
        if pos <= 0:
            print("Position must be positive\n")
            return
        if pos == 1:
            self.delete_first()
            return
        temp = self.head
        for _ in range(1, pos):                   # move to desired pos
            temp = temp.next
            if temp is None:
                print("Position out of bounds\n")
                return
        # temp now points to node to delete
        print(f"Deleted node at position {pos} ({temp.data})\n")
        if temp.next:                             # bridge next node
            temp.next.prev = temp.prev
        if temp.prev:                             # bridge prev node
            temp.prev.next = temp.next


# ---------- demo + menu ----------
if __name__ == "__main__":
    # build a starter list 10 <-> 20 <-> 30 <-> 40
    dll = DoublyLinkedList()
    for value in [10, 20, 30, 40]:
        new_node = Node(value)
        if dll.head is None:
            dll.head = new_node
        else:
            tail = dll.head
            while tail.next:
                tail = tail.next
            tail.next = new_node
            new_node.prev = tail

    while True:
        print("CURRENT LIST:")
        dll.display()
        print("MENU")
        print("1. Delete first node")
        print("2. Delete last node")
        print("3. Delete node at a specific position")
        print("4. Exit")
        choice = input("Enter your choice (1/2/3/4): ").strip()

        if choice == "1":
            dll.delete_first()
        elif choice == "2":
            dll.delete_last()
        elif choice == "3":
            try:
                pos = int(input("Enter position to delete: "))
                dll.delete_at_pos(pos)
            except ValueError:
                print("Invalid position. Please enter an integer.\n")
        elif choice == "4":
            print("Exiting program.")
            break
        else:
            print("Invalid choice. Please select 1, 2, 3, or 4.\n")
