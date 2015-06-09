#dManage
An open source software for managing academic activities.
#Initial ideas setting up
As of now we are planning to do a repository based on the JSP servlet. There are several issues associated with the same, but the idea behind remains a UI friendly interface preferably in JSP with functionalities embedded within the same, quite similar to  our DSS. There should be separate database mostly postgres for the work done.

Separate logins for students, faculties, staff and ultimately admin should be there. The students should be able to login check their marks, faculties should be able to enter the mark of students as __.csv__ files or __.xls__ files. The staff should be able to access the data of several students batch wise or individually and should be limited to certain aspects defined later. There is process of registration of students to preceding semesters and thus there is the process of mark entering, which is again defined by the faculty, usually 20, 20, 10 but the 100 marks can be defined by the faculty as it seems. I am just listing out the major requirements as they come to my mind. The basic structure will be evolving soon enough. First few pull requests might be having a lot of clutter and repetition, which will be clarified later on.

As of now the for students the process of detail entering the very first step in registering. After they have registered as users in the system, one or two days before the process of registration they will get a mail regarding the starting of process of registration. After that they are supposed to login to the system and select the courses they want. In the case of electives, every staff from all departments will be able to login and add a list of electives to the department page. On adding the electives the details of students who can choose the elective should be made available, details such as the semester they should belong, minimum cgpa etc. If the elective is first come first serve then that can be selected along or without the CGPA restriction. All these are decided before registration and on completion of this process the course will be visible to all eligble students who can apply for the same. Once they get the list of courses they might be able to select these only if they are eligible. If the course is overrun they will get a notification and won't be able to register. The course faculty can be specified at the time of creation of course, if more students request for the elective the faculty can login and add them. The eligiblity criteria for the course are mentioned in the __eligibility__ section.


##What all things can staff do?
This lists the duties that a staff can perform. Their power is somewhat limited and is mostly restricted to

* Adding courses to the department page.
* They cannot remove courses as at the time of adding course a faculty must be selected and only this faculty is able to remove the course. They can only deactivate the course. Deactivate means it will not be visible to all the logins it was used to be visible.
* On adding a faculty the course, faculty gets the notification he has been added as the course faculty and on login he gets the access to the course. He can at his will remove or add students who fail to satisfy the eligiblity criteria.
* There will be a faculty associated with every student and can remove him from any course as he pleases. This is usually the role of faculty advisor. Usually every faculty will have chance to select the students  to whom he/she will be the faculty advisor.
* The no due certificate from all the required departments is provided in such a way that a \textbf{csv with roll number with dues is uploaded on the day of registration and on remittance the staff in the respective department will remove their name from the list on producing necessary documents.
* Registration process for users is a three step, one step the user can fill in data and in the next steps verification takes place. I am a little doubtful here. We will clarify it later on.
* On remittance of late fee should be able to unlock the student account and let him do the process.

##What all things students can do?
Usually the thigns students can do include

* They can login and select the courses they can choose.
* They can view their results anytime.
* They get notifications when there is a pending activity which includes.
* Teacher Evaluvation.
* Fee payment details filling.
* Course registration.
* If they are delayed then the course registration automatically stops and they need remit some fee amount.
* The students will be notified via mail about this. After this their account will be locked.
* After registration with/without delay they will get a softcopy to their mail with all the details mentioend. They are supposed to take two copies of the same and give one to the faculty and keep one to themselves. This is a one time generated softcopy and will be given in print to the student at the time or registration along with signature of the staff. The FA has to keep it and the same with the student.

##What all things can faculties do?
This section list all the possible functions of faculties.

* They all have login and can start a course or staffs can start a course and add faculty to the course.
* On login they will be requested to take the course and if they accept they get to manage the course.
* Once they accept staff will loose power of the course and faculty will get all the power over the course.
* Faculty can also create a course and will have the same power.
* HOD of the department will also have a login, so that all course details can be viewed.
* Staffs can also watch all courses and can see the list of marks and all the associated documents as soon as the faculty upload them.
* Other faculties cannot see what one faculty does but if two faculties are added for asingle course he can see what the other faculty does.
* If a faculty change happens, one faculty can assign another and he will have monitoring status over the course. That is he can watch the course but cannot enter marks or delete/add students. He can also add a co-faculty who will have the same power as the main faculty but this time both can add marks. Individual editing of marks are possible only for one faculty at a time.
* At the time of registration he can add students to the course by searching mentioned in __eligibility__ section. Once the day for registration is over, the student has to pay an amount and only after that the faculty can add the student. Faculty should get notification when a student is added for the course by the other faculty. At the time of registration anyway these mailing wil be off. So that only a few mails are send. If he need a round the clock history he can turn on notifications so that he might get the a notification every time the registration process is complete.

##Registration Process
 This is somewhat the main process happening .

 * Usually the date of registration is put in by admin.
 * At the date staff with privilege level above a particular one will be able to login.
 * On login they will be given a login with option to start registration. All the student who are supposed to register should register on that day.
 * They will be given a data box where the roll number will be entered.
 * A page will appear with information regarding the student such as
 * Name rollnumber department  
 *  No due from place 1.
 * No due from place 2.
 * No due from place 3.
 * Fee remittance with details.
 * Fee2 remittance with details.
 * Semester registered.
 * From date-to date.
 * A unique hash.

After this a small strip of paper with from date-todate a hash (8-10 alphanumeric) semester UG branch will be generated. This is printed on to a sticker and pasted behind the id card. At the time of registration a paper with fee details and other essentialities are printed on to a paper and this is has got the same hash. A softcopy will be generated with the hash as file name  and will be kept in the folder mentioned earlier as well as one will be printed along with the sticker. The bottom part is the one tore off.

##Eligibility for Electives
This is usually a strict requirement for elective but most of the time some kind of a human judgement is needed for the same. Any student who is eligible will be able to select the elective, if it had not run out of its maximum participant limit. This is usually 80 or set at the time of creation of elective. There are certain cases such

* The maximum limit is over.
* The student has got no eligibility there, these conditions are listed below.
* Minimum CGPA.
* Minimum grade in any subject.
* A previous elective or course.

Faculties should be able to login and apply relaxations to any of the above criteria. On request of the student the faculty can login and add  a student in the system by selecting his department or simply typing the roll number or just a part of name and then selecting as student for a particular elective. Only the faculty can login and do this and staffs should not be permitted to this.

##On Course Completion
On course completion the faculty/staff will be able to check out the student from the system. For this student has to collect several no dues from all the labs and departments and then remit the dues get no dues from there and go to a staff who is able to grant all the no dues related with the student.

##Types of Staff
As mentioned above  there are two types of staff logins. The first type are the people who are in academic section. They can add courses and associate faculties with courses. The second type are those who can register/ deregister/check out students. They have the permission to register students for a particular course. They can complete registration for students based on no dues and all. There is a little doubt here. You can edit it accordingly so that the basic idea is conveyed. Usually there is a set of course related works that should be done by academic staff, which should not be done by purely academic staff. So a distinction of employees are needed. But the idea is more or less to have a two distinct set of staff, one with a previlege level for accessing and creating courses and one who can approve the students and register accordingly. We will have a problem over here.



#Tools used
Well as of now we have switched to java and tomcat as the servlet. The basic things to do are first setting up the servlet. Just download binary, put it somewhere and add to path. Then compile the __.java__ file you want to and copy the __.class__ file to the examples folder under webapp in the tomcat directory. After this make the appropriate changes in the web.xml file. These could be found in the tutorials point site, but I am just mentioning the facts here so that every body is on the same page. For database access we will be using jdbc and __araj, melvin__ can we use twitter bootstrap stylesheet. Please see how we could use it, and somebody study how jdbc can be used to write/read from the database(only jdbc) not through servlet( You can do that  through servlet if you are interested). 
