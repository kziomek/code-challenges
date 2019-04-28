package com.krzysztofziomek.fb.Q_5690255257108480;

import org.junit.Test;

import java.util.NavigableSet;

import static org.junit.Assert.*;


public class OverlappingProgramTest {

    @Test
    public void testOriginalSet() {
        OverlappingProgram.Program p1 = new OverlappingProgram.Program(10, 5);
        OverlappingProgram.Program p2 = new OverlappingProgram.Program(25, 15);
        OverlappingProgram.Program p3 = new OverlappingProgram.Program(18, 7);
        OverlappingProgram.Program p4 = new OverlappingProgram.Program(12, 10);

        OverlappingProgram.Program[] inputPrograms = new OverlappingProgram.Program[] {p1, p2, p3, p4};
        NavigableSet<OverlappingProgram.Program> programs = OverlappingProgram.addPrograms(inputPrograms);
        assert programs.size() == 3;
    }

    @Test
    public void testFirstNotOverlapping() {
        OverlappingProgram.Program p1 = new OverlappingProgram.Program(10, 5);
        OverlappingProgram.Program p2 = new OverlappingProgram.Program(25, 15);

        OverlappingProgram.Program p3 = new OverlappingProgram.Program(5, 5);

        OverlappingProgram.Program[] inputPrograms = new OverlappingProgram.Program[] {p1, p2, p3};
        NavigableSet<OverlappingProgram.Program> programs = OverlappingProgram.addPrograms(inputPrograms);
        assert programs.size() == 3;
    }

    @Test
    public void testFirstOverlapping() {
        OverlappingProgram.Program p1 = new OverlappingProgram.Program(10, 5);
        OverlappingProgram.Program p2 = new OverlappingProgram.Program(25, 15);

        OverlappingProgram.Program p3 = new OverlappingProgram.Program(5, 6);

        OverlappingProgram.Program[] inputPrograms = new OverlappingProgram.Program[] {p1, p2, p3};
        NavigableSet<OverlappingProgram.Program> programs = OverlappingProgram.addPrograms(inputPrograms);
        assert programs.size() == 2;
    }

    @Test
    public void testLastOverlapping() {
        OverlappingProgram.Program p1 = new OverlappingProgram.Program(10, 5);
        OverlappingProgram.Program p2 = new OverlappingProgram.Program(25, 15);

        OverlappingProgram.Program p3 = new OverlappingProgram.Program(39, 1);

        OverlappingProgram.Program[] inputPrograms = new OverlappingProgram.Program[] {p1, p2, p3};
        NavigableSet<OverlappingProgram.Program> programs = OverlappingProgram.addPrograms(inputPrograms);
        assert programs.size() == 2;
    }

    @Test
    public void testLastNotOverlapping() {
        OverlappingProgram.Program p1 = new OverlappingProgram.Program(10, 5);
        OverlappingProgram.Program p2 = new OverlappingProgram.Program(25, 15);

        OverlappingProgram.Program p3 = new OverlappingProgram.Program(40, 1);

        OverlappingProgram.Program[] inputPrograms = new OverlappingProgram.Program[] {p1, p2, p3};
        NavigableSet<OverlappingProgram.Program> programs = OverlappingProgram.addPrograms(inputPrograms);
        assert programs.size() == 3;
    }

    @Test
    public void testMiddleNotOverlapping() {
        OverlappingProgram.Program p1 = new OverlappingProgram.Program(10, 5);
        OverlappingProgram.Program p2 = new OverlappingProgram.Program(25, 15);

        OverlappingProgram.Program p3 = new OverlappingProgram.Program(15, 10);

        OverlappingProgram.Program[] inputPrograms = new OverlappingProgram.Program[] {p1, p2, p3};
        NavigableSet<OverlappingProgram.Program> programs = OverlappingProgram.addPrograms(inputPrograms);
        assert programs.size() == 3;
    }

    @Test
    public void testMiddleOverlappingWithLower() {
        OverlappingProgram.Program p1 = new OverlappingProgram.Program(10, 5);
        OverlappingProgram.Program p2 = new OverlappingProgram.Program(25, 15);

        OverlappingProgram.Program p3 = new OverlappingProgram.Program(14, 10);

        OverlappingProgram.Program[] inputPrograms = new OverlappingProgram.Program[] {p1, p2, p3};
        NavigableSet<OverlappingProgram.Program> programs = OverlappingProgram.addPrograms(inputPrograms);
        assert programs.size() == 2;
    }

    @Test
    public void testMiddleOverlappingWithGreater() {
        OverlappingProgram.Program p1 = new OverlappingProgram.Program(10, 5);
        OverlappingProgram.Program p2 = new OverlappingProgram.Program(25, 15);

        OverlappingProgram.Program p3 = new OverlappingProgram.Program(15, 11);

        OverlappingProgram.Program[] inputPrograms = new OverlappingProgram.Program[] {p1, p2, p3};
        NavigableSet<OverlappingProgram.Program> programs = OverlappingProgram.addPrograms(inputPrograms);
        assert programs.size() == 2;
    }

}