import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.text.DecimalFormat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger = new Burger();
    private Bun bun = new Bun("Вкусная булочка", 11f);
    private Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sadd", 10.0f);
    private Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "111", 11.0f);

    @Test
    public void addIngredient() {

        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Assert.assertEquals(burger.ingredients.size(), 1);

    }

    @Test
    public void removeIngredient() {

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.setBuns(bun);
        Assert.assertEquals(burger.ingredients.size(), 2);
        burger.removeIngredient(1);
        Assert.assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void moveIngredient() {

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        Assert.assertEquals(burger.ingredients.get(0).getType(), IngredientType.SAUCE);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(burger.ingredients.get(0).getType(), IngredientType.FILLING);
        Assert.assertEquals(burger.ingredients.get(1).getType(), IngredientType.SAUCE);
    }

    @Test
    public void getPrice() {
        Bun bun = mock(Bun.class);
        Ingredient ingredient = mock(Ingredient.class);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getPrice()).thenReturn(2.0f);
        when(ingredient.getPrice()).thenReturn(10.0f);
        Assert.assertEquals(burger.getPrice(), 14.0f, 0);
    }

    @Test
    public void getReceipt() {

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient);
        String formattedBurgerPrice = String.format("%.6f", burger.getPrice());
        Assert.assertTrue(burger.getReceipt().contains("(==== " + bun.name + " ====)"));
        Assert.assertTrue(burger.getReceipt().contains("= " + (ingredient1.getType().toString().toLowerCase()) + " " + ingredient1.getName() + " ="));
        Assert.assertTrue(burger.getReceipt().contains("= " + (ingredient.getType().toString().toLowerCase()) + " " + ingredient.getName() + " ="));
        Assert.assertTrue(burger.getReceipt().contains("Price: " + formattedBurgerPrice));


    }
}