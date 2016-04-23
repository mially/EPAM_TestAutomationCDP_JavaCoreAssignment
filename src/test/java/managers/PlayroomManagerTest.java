package com.epam.cdpWeek2project.managers;

import com.epam.cdpWeek2project.exceptions.NoPlayroomException;
import com.epam.cdpWeek2project.models.Playroom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class PlayroomManagerTest {
    PlayroomsManager playroomsManager;
    List<Playroom> playrooms;

    @Before
    public void start(){
        playroomsManager = new PlayroomsManager();
        playrooms = playroomsManager.getListOfPlayrooms();
        System.out.println("Before test");
    }

    @Test
    public void addPlayroomTest() throws NoPlayroomException{
        System.out.println("test1");
        String name = "playroom1";
        playroomsManager.addPlayroom(name);
        assertFalse(playrooms.isEmpty());
    }

    @Test
    public void getActivePlayroomTest() {
        System.out.println("test2");
        String name = "playroom2";
        Playroom playroom2 = playroomsManager.addPlayroom(name);
        assertEquals(playroom2, playroomsManager.getActivePlayroom());
    }

    @Test
    public void setActivePlayroomTest() {
        System.out.println("test3");
        String name1 = "playroom3";
        String name2 = "playroom4";
        Playroom newPlayroom = playroomsManager.addPlayroom(name1);
        playroomsManager.addPlayroom(name2);
        playroomsManager.setActivePlayroom(newPlayroom);
        assertTrue(playroomsManager.getActivePlayroom().equals(newPlayroom));
    }

    @Test
    public void NoPlayroomExceptionTest() {
        try{
            System.out.println("test4");
            playroomsManager.getPlayroomByName("nosuchplayroom");
            fail("No NoPlayroomException was thrown");
        } catch (NoPlayroomException e) {
        }
    }

    @Test
    public void GeneratePlayroomNameTest(){
        System.out.println("test5");
        String generatedName = playroomsManager.generatePlayroomName();
        assertEquals("playroom1", generatedName);
    }

    @After
    public void cleanup(){
        if (!playrooms.isEmpty()) {
            playroomsManager.destroyAllPlayrooms();
        } else {
            System.out.println("No playrooms to destroy");
        }
    }


}
