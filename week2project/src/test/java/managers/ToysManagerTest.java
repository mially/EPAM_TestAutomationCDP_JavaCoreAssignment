package managers;

import factories.ToyFactory;
import models.Toy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(Parameterized.class)
public class ToysManagerTest {
    String name;
    String type;

    public ToysManagerTest(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {"Lego", "blocks"},
                {"Volleyball", "ball"},
                {"Tanya", "doll"},
        });
    }

    @Test
    public void toyFactoryTest(){
        System.out.println("\nParameterized test!");
        Toy newToy = ToyFactory.build(name, type);
        assertEquals(name, newToy.getName());
    }
}
