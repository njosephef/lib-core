package com.pnv.storage;

import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;
import com.sleepycat.je.DatabaseEntry;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class Employee {

    /**
    * Method description
    *
    * @return
    */
    public String getDepartment()
    {
    return Department;
  }


    /**
    * Method description
    *
    * @param Department
    */
    public void setDepartment(String Department)
    {
        this.Department = Department;
    }


    /**
    * Method description
    *
    * @return
    */
    public String getEmail()
    {
        return Email;
    }


    /**
    * Method description
    *
    * @param Email
    */
    public void setEmail(String Email)
    {
    this.Email = Email;
  }


    /**
    * Method description
    *
    * @return
    */
    public String getName()
    {
    return Name;
  }


    /**
    * Method description
    *
    * @param Name
    */
    public void setName(String Name)
    {
    this.Name = Name;
  }


    /**
    * Constructor
    *
    * @param Name
    * @param Email
    * @param Department
    */
    public Employee(String Name, String Email, String Department)
    {
    this.Name = Name;
    this.Email = Email;
    this.Department = Department;
  }

  public Employee() {
  }

  // set name, email, dept
    /**
    * Method description
    *
    * @param Name
    * @param Email
    * @param Department
    */
    public void setEmployee(String Name, String Email, String Department)
    {
    this.Name = Name;
    this.Email = Email;
    this.Department = Department;
  }

  // display name, email, dept information
    /**
    * Method description
    *
    */
    public void Display()
    {

    System.out.println("Name...: " + Name);
    System.out.println("Email..: " + Email);
    System.out.println("Dept...: " + Department);
  }

  // convert object to entry
  public DatabaseEntry objectToEntry() {

    TupleOutput output = new TupleOutput();

    DatabaseEntry entry = new DatabaseEntry();

    // write name, email and department to tuple
    output.writeString(getName());
    output.writeString(getEmail());
    output.writeString(getDepartment());

    TupleBinding.outputToEntry(output, entry);

    return entry;
  }

  // convert entry to object
  public void entryToObject(DatabaseEntry entry) {

    TupleInput input = TupleBinding.entryToInput(entry);

    // set name, email and department
    setName(input.readString());
    setEmail(input.readString());
    setDepartment(input.readString());
  }

  private String Name;
  private String Email;
  private String Department;

}