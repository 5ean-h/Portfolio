/*
Name: Sean Hogan
Function: creating person class
Creation Date: 30/11/2022
*/


public class Person {

    //composition has-a relationship
    private Job job;
   
    public Person(){
        this.job = new Job();
        job.setSalary(1000L);
    }
    public long getSalary() {
        return job.getSalary();
    }

}