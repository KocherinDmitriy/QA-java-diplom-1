import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final Enum IngredientType;
    private final String name;

    public IngredientTypeTest(String name, Enum IngredientType) {
        this.name = name;
        this.IngredientType = IngredientType;
    }


    @Parameterized.Parameters(name = "{index} => name={0}, IngredientType={1}")

    public static Object[][] getData() {
        return new Object[][]{
                {"SAUCE", praktikum.IngredientType.SAUCE},
                {"FILLING", praktikum.IngredientType.FILLING},


        };
    }


    @Test

    public void returnIngredientSauceNameTest(){
        praktikum.IngredientType ingredientType= (praktikum.IngredientType) IngredientType;
        String e=ingredientType.toString();
        assertEquals(e,name);

    }

}
