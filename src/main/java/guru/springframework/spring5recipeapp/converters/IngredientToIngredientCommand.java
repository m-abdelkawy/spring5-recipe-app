package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commands.IngredientCommand;
import guru.springframework.spring5recipeapp.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomtoCommandConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomtoCommandConverter) {
        this.uomtoCommandConverter = uomtoCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null)
            return null;

        final IngredientCommand ingredientCommand = new IngredientCommand();

        ingredientCommand.setId(source.getId());
        if (source.getRecipe() != null)
            ingredientCommand.setRecipeId(source.getRecipe().getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUom(uomtoCommandConverter.convert(source.getUom()));

        return ingredientCommand;
    }
}
