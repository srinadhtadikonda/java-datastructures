class Node:
  def __init__(self, data):
    self.data = data
    self.next = None

class SinglyLinkedList:
  def __init__(self):
    self.head = None

  def insert_at_ending(self, data):
    ne = Node(data)
    temp = self.head
    while temp.next:
      temp = temp.next
    temp.next = ne

  def display(self):
    if self.head is None:
      print("List is Empty")
    else:
      temp = self.head
      while temp:
        print(temp.data, "-->", end="")
        temp = temp.next

L = SinglyLinkedList()
n = Node(10)
L.head = n
n1 = Node(20)
n.next = n1
n2 = Node(30)
n1.next = n2
n3 = Node(40)
n2.next = n3

L.display()
print("\n")
L.insert_at_ending(45)
L.display()
