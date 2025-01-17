package demo.lambda;

/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
 
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Member {
   
    public enum Sex {
        MALE, FEMALE
    }
  
    String name; 
    Calendar birthday;
    Sex gender;
    String emailAddress;
  
    Member(String nameArg, Calendar birthdayArg, Sex genderArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
    }  

    public int getAge() {

    	Calendar today = GregorianCalendar.getInstance();
        int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
        
        if((birthday.get(Calendar.MONTH) > today.get(Calendar.MONTH)) || 
           (birthday.get(Calendar.MONTH) == today.get(Calendar.MONTH) && 
            birthday.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)))
        {
            age--;
        }
        return age;
    }

    public void printMember() {
      System.out.println(this);
    }
    
    public Sex getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }
        
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public String toString() {
        return name + ", " + this.getAge();
    }
}