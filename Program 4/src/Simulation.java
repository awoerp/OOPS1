/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SteveWoerpel
 */
public class Simulation
{
 private static final int MAX_CUSTOMER = 5; //capacity of the line
 private Queue<Customer> q = new Queue<>(MAX_CUSTOMER);
 private int clock;
 private Customer being_served = null; //the customer being served

 private int finished; //number of customer finished
 private int nowait; //number of customers that didn’t have to wait
 private int waited; //number of customers waited
 private int totalwait; //total wait time for customers that had waited in the queue

} 