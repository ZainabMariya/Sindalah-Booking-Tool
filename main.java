 import java.io.*;
import java.util.*;
import java.util.Scanner;

class Node {
private int bookingID;
private int vID;
private int rID;
private int arrivalDate;
private int nNights;
private String vName;
private Node next;
public Node() {
}
public Node(int bookingID, int vID, int rID, int arrivalDate, int nNights, String vName) {
this.bookingID = bookingID;
this.vID = vID;
this.rID = rID;
this.arrivalDate = arrivalDate;
this.nNights = nNights;
this.vName = vName;
this.next = null;
}
public String toString() {
int date = arrivalDate;
String d= String.format("%08d", date);
return bookingID + " " + vID + " " + rID + " " + d + " " +
nNights + " " + vName; }
    
public void setBookingID(int bookingID) { 
    this.bookingID = bookingID;
}
public void setvID(int vID) { 
    this.vID = vID;
}
public void setrID(int rID) { 
    this.rID = rID;
}
 public void setArrivalDate(int arrivalDate) { 
     this.arrivalDate = arrivalDate;
}
public void setnNights(int nNights) { 
    this.nNights = nNights;
}
public void setvName(String vName) { 
    this.vName = vName;
}
public void setNext(Node next) { 
    this.next = next;
}
public int getBookingID() { 
    return bookingID;
}
public int getvID() { 
    return vID;
}
public int getrID() {
    return rID;
}
public int getArrivalDate() {
    return arrivalDate;
}
public int getnNights() { 
    return nNights;
}
public String getvName() { 
    return vName;
}
public Node getNext() { 
    return next;
}

 }
class SList {
Node head; Node tail;
int size;
public SList() {
    head = null; tail = null;
size = 0; }
public void insert(Node N) { 
    if (head == null) {
head = N;
tail = N;
size++;
return;
}
Node p = head;
while (p != null) {
if (N.getArrivalDate()< p.getArrivalDate()) { if (p == head) {
N.setNext(head); head = N; size++;
return;
}
Node prev = head;
while (prev.getNext()!= p) {
prev = prev.getNext();
}
prev.setNext(N);
N.setNext(p);
size++;
return;
}
else if (N.getArrivalDate()== p.getArrivalDate()) { if (N.getBookingID() == p.getBookingID()) { return;
}
if (N.getnNights() > p.getnNights() ) {
if (p == head) {

 N.setNext(head) ; head = N; size++;
return;
}
Node previous = head;
while (previous.getNext()!= p) { previous = previous.getNext();
}
previous.setNext(N);
N.setNext(p);
size++;
return;
}
}
p = p.getNext(); }
tail.setNext(N); tail = N; size++;
}
    
    
public void removeFirst(int vID) { if (head == null) {
return;
}
Node p = head;
while (p!= null) {
if (p.getvID() == vID) {
if (p == head) {
head = head.getNext();
size--;
return;
}
Node previous = head;
while (previous.getNext() != p) { previous = previous.getNext();
}
previous.setNext(p.getNext()) ; size--;
return;
}

 p = p.getNext(); }
if (tail.getvID() == vID) { 
    
    Node previous = head;
while (previous.getNext() != tail) { previous = previous.getNext();
}
tail = previous;
tail.setNext(null); size--;
return;
}
}
public void removeAll(int vID) { 
    if (head == null) {
return;
}
Node p = head;
while (p != null) {
if (p.getvID() == vID) {
if (p == head) {
head = head.getNext();
size--;
p = head;

}
Node previous = head;
while (previous.getNext() != p) {
    previous = previous.getNext();
}
previous.setNext(p.getNext()) ; 
    size--;
p= p.getNext(); 
    
}
p = p.getNext();
}
Node previous = head;
if (tail.getvID() == vID) {
while (previous.getNext() != null) {
    previous = previous.getNext();
}

 tail = previous; 
    tail.setNext(null); 
    size--;
return;
    
} }
public int cost(int bookingID) { 
    Node p = head;
int cost = 0;
while (p!= null) {
if (p.getBookingID() == bookingID) { 
    if (p.getrID() == 1) {
cost = p.getnNights() * 800;
return cost;
}
else if (p.getrID() == 2) {
    cost = p.getnNights()* 2000; 
    return cost;
}
else if (p.getrID() == 3)
{ cost = p.getnNights() * 1500; 
 return cost;
}
}
p = p.getNext();
}
return 0;
}
public int costAll(int vID) {
Node p = head;
int cost = 0;
while (p != null) {
if (p.getvID()== vID) {
if (p.getrID() == 1) {
cost += p.getnNights() * 800; }
else if (p.getrID() == 2) {
cost += p.getnNights() * 2000; }
else if (p.getrID() == 3) {
cost += p.getnNights() * 1500;

 }
}
p = p.getNext(); }
return cost;
}
public int calculateLoyalty(int vID) {
    Node p = head;
int total = 0;
while (p != null) {
if (p.getvID() == vID) {
if (p. getrID() == 1) {
  total += p.getnNights() * 200; }
else if (p.getrID() == 2) { 
    total += p.getnNights() * 500; }
else if (p.getrID() == 3) {
    total += p.getnNights() * 350; }
}
p = p.getNext();
}
return total;
}
public void print1(int vID) { Node p = head; int size = 0;
while (p!= null) {
if (p.getvID() == vID) { System.out.println(p.toString()); size++;
}
p = p.getNext();
}
if (size == 0) { System.out.println("0");
}
}
public void print2(int bookingID) { Node p = head;

 while (p != null) {
if (p.getBookingID() == bookingID) { System.out.println(p.toString()); return;
}
p= p.getNext();
}
System.out.println("0");
}
public void print3(int arrivalDate) { Node p= head;
int count = 0;
while (p != null) {
if (p.getArrivalDate() == arrivalDate) { System.out.println(p.toString()); count++;
}
p= p.getNext();
}
if (count == 0) { System.out.println("0"); }
}
}
public class Solution {
public static void main(String[] args) {
Scanner input = new Scanner(System.in); 
    SList l = new SList();
K:
while (input.hasNext()) {
int choice= input.nextInt(); switch (choice) {
case 1: {
int bookingID = input.nextInt();
int vID = input.nextInt();
int rID = input.nextInt();
int arrivalDate = input.nextInt();
int nNights = input.nextInt();
String vName = input.nextLine().trim();
Node n = new Node(bookingID, vID, rID, arrivalDate, nNights, vName);

 l.insert(n);
break; }
case 2: {
int vID = input.nextInt(); 
    l.removeFirst(vID); 
    break;
} case 3:
{
int vID = input.nextInt();
    l.removeAll(vID);
    break;
} case 4:
{
int bookingID = input.nextInt(); 
    System.out.println(l.cost(bookingID)); 
    break;
} case 5:
{
int vID = input.nextInt(); 
    System.out.println(l.costAll(vID)); break;
} case 6:
{
int vID = input.nextInt();
    System.out.println(l.calculateLoyalty(vID)); break;
} case 7:
{
int vID = input.nextInt(); 
    l.print1(vID);
break;
} case 8:
{
int bookingID = input.nextInt(); 
    l.print2(bookingID);
break;

} case 9:
{
int arrivalDate = input.nextInt(); 
    l.print3(arrivalDate);
break;
} default:
break K; }
} }
}
