package edu.umn.cs.tmdp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class MainClassTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    MainClass mainClass;

    @Mock
    DatabaseDAO dependentClassOne;

    @Mock
    NetworkDAO dependentClassTwo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validateTest()
    {
        Mockito.when(mainClass.database.save("temp.txt")).thenReturn(true);
        boolean saved = mainClass.save("temp.txt");
        assertEquals(true, saved);
    }
}
