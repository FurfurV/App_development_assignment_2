# Assignment 2 Brief

I am part of MTU's REACH programme which aims to establish meaningful 
relationships between students and academic staff.  

I have been assigned students (mentees). I need a system to allow me to make notes 
about mentees. These notes must be date stamped so I can view the history of my 
interactions with the student. 

Other users also need access to the service, for example, the Head of Department 
and REACH coordinators who wish to ensure that I am fulfilling my role. They should 
be given read but not write access to the system. 

You are required to create a web-based, secure application that allows me to make 
notes about, and keep track of, my mentees.  

### Once authenticated, I should be able to 
1.   Add a student 
2.   Search for a student by student id and view their information and notes including date of creation 
3.   Add a note about a student 
4.   List those students who are not active in the REACH programme i.e. who have no notes. 

Once authenticated, a reviewer should be able to 
1.   Search for a student by student id and view their information and note(s) 2.   some statistics 
1.   number of mentees 
2.   average number of notes per mentee 
3.   View students who have more than 4 notes and are therefore taking up a 
lot of my time 

This system should only work for one mentor at present - me - so don't worry about 
creating complicated relationships here. The database will consist of a table for users 
(me plus some reviewers with read-only access), a table of students/mentees and a 
table of notes. You must establish relationships between the students and their notes. 

![students](https://user-images.githubusercontent.com/44726497/155116748-5e3509a6-bdd3-4d16-a4f2-3c0a6f8d993d.PNG)
![note](https://user-images.githubusercontent.com/44726497/155116933-51763979-a331-4e58-8c90-6b20604c8b85.PNG)

