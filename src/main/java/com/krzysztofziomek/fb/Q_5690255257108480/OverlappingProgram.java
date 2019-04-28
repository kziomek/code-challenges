package com.krzysztofziomek.fb.Q_5690255257108480;

import java.util.NavigableSet;
import java.util.TreeSet;

public class OverlappingProgram {

    static class Program {
        int startTime;
        int endTime;

        Program(int startTime, int duration){
            this.startTime = startTime;
            this.endTime = startTime + duration;
        }
    }

    static boolean isOverlapping(NavigableSet<Program> programs, Program program) {

        if (programs.isEmpty()) {
            return false;
        }

        //Test if ceiling is overlapping
        Program ceiling = programs.ceiling(program);
        if (ceiling != null) {
            // found ceiling - test if overlapping
            if (program.endTime > ceiling.startTime) {
                return true;
            }

            //2. Test if lower to ceiling is overlapping
            Program lower = programs.lower(ceiling);
            if (lower == null){
                return false;
            } else {
                return program.startTime < lower.endTime;
            }

        } else {// no ceiling means program.startTime > existing programs
            //test for overlapping with last element
            return program.startTime < programs.last().endTime;
        }
    }


    public static NavigableSet<Program> addPrograms(Program[] inputPrograms) {
        NavigableSet programs = new TreeSet<Program>((o1, o2) -> o1.startTime - o2.startTime);

        for (Program program : inputPrograms) {
            if (!isOverlapping(programs, program)){
                programs.add(program);
                System.out.println("Added program with start date " + program.startTime);
            } else {
                System.out.println("Overlapping program with start date " + program.startTime);
            }
        }
        return programs;
    }

    public static void main(String[] args) {
        Program p1 = new Program(10, 5);
        Program p2 = new Program(25, 15);
        Program p3 = new Program(18, 7);
        Program p4 = new Program(12, 10);

        Program[] inputPrograms = new Program[] {p1, p2, p3, p4};
        addPrograms(inputPrograms);
    }
}
