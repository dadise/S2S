package com.exempel.student2student.student2student;

import android.provider.BaseColumns;

/**
 * Created by דדי on 13/01/2015.
 */
public class DBColumns implements BaseColumns
{
    public static final String STUDENTS_TABLE_NAME = "students";
    public static final String FIRST_NAME = "first";
    public static final String LAST_NAME = "last";
    public static final String USER_NAME = "user";
    public static final String E_MAIL = "mail";
    public static final String ID = "id";
    public static final String LINE_OF_BUSINESS = "lineOfBusiness";

    public static final String COURSES_TABLE_NAME = "courses";
    public static final String COURSE_NUMBER = "courseNumber";
    public static final String COURSE_NAME = "courseName";
    public static final String COURSE_OCCUPATION = "courseOccupation";

    public static final String TEACHERS_TABLE_NAME = "teachers";
    public static final String TEACHER_ID = "tid";
    public static final String TEACHER_COURSE_OCCUPATION = "tco";
    public static final String COURSE_ID = "cNum";

    public static final String SEEKERS_TABLE_NAME = "seekers";
    public static final String SEEKER_ID = "sid";
    public static final String SEEKER_COURSE_OCCUPATION = "sco";

    public static final String MATCHING_TABLE_NAME = "matches";
    public static final String STATUS = "status";
//    public static final String TEACHER_ID = "tid";
//    public static final String SEEKER_ID = "sid";
//    public static final String COURSE_ID = "cNum";

}
