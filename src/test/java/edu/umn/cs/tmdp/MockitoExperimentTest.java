package edu.umn.cs.tmdp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.Mockito;

public class MockitoExperimentTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp(){
        System.out.println("before");
    }



    @Test
    public void test1() {
        MockitoExperimentObject mock = Mockito.mock(MockitoExperimentObject.class);
        Mockito.doReturn(false, true, false).when(mock).add("test");
        Mockito.doReturn(true).when(mock).add("test");
        Mockito.when(mock.add("test")).thenReturn(false);
        Mockito.when(mock.add("test")).thenReturn(true);
        Mockito.when(mock.add("bar")).thenReturn(true);
        Mockito.when(mock.add("bar")).thenReturn(false);
        Mockito.doReturn(false).when(mock).add("lmz");
        boolean result = mock.add("test");
        result = mock.add("bob");
        Mockito.verify(mock, Mockito.times(1)).add("test");
        Mockito.doReturn(false).when(mock).add("test");
    }

    @Test
    public void test2() {
        MockitoExperimentObject meo = new MockitoExperimentObject();
        MockitoExperimentObject spy = Mockito.spy(meo);
        Mockito.when(spy.add("test")).thenReturn(false);
        Mockito.doReturn(true).when(spy).add("test");
        Mockito.doReturn(true).when(spy).add("test");
        Mockito.when(spy.add("test")).thenReturn(false);
        Mockito.when(spy.add("bar")).thenReturn(true);
        Mockito.when(spy.add("bar")).thenReturn(false);
        Mockito.doReturn(false).when(spy).add("lmz");
        boolean result = spy.add("test");
        result = spy.add("bob");
        Mockito.verify(spy, Mockito.times(1)).add("test");
        Mockito.doReturn(false).when(spy).add("test");
    }

    @After
    public void tearDown(){
        System.out.println("after");
    }
}
