<script>
  //core
  import { allCategoryCards } from "../models/CategoryItemModel";
  import { ConverterViewModel } from "../viewmodels/ConverterViewModel";
  import ConvertedValueCardPiece from "../pieces/ConvertedValueCardPiece.svelte";
  import { selectedCategory, selectedUnit, inputValue } from "../helpers/store";
  import { get } from "svelte/store";
  const selectedCategoryId = get(selectedCategory);
  var selectedUnitIndex = get(selectedUnit);
  var currentInput = get(inputValue);
  //local
  var categoryCard = allCategoryCards.find(
    (value) => value.id === selectedCategoryId
  );
  let viewModel = new ConverterViewModel(categoryCard, selectedUnitIndex);
  var convertedValues;
  function setup() {
    convertedValues = viewModel.getConvertedValues(currentInput.toString());
  }
  //store
  selectedUnit.subscribe((value) => {
    let option = viewModel.category.converterOptions.find(
      (item) => item.id === value
    );
    viewModel.selectedUnit = option;
    setup();
  });
  inputValue.subscribe((value) => {
    currentInput = value;
    setup();
  });
</script>

<div class="relative {categoryCard.colors[0]} md:pt-32 pb-32 pt-12">
  <div class="px-4 md:px-10 mx-auto w-full">
    <div>
      <div class="flex flex-wrap">
        {#each convertedValues as converted}
          <ConvertedValueCardPiece
            unitId={converted.option.id}
            unitName={converted.option.unit.name}
            unitValue={converted.value}
            unitColor={categoryCard.colors[0]}
            unitHoverColor={categoryCard.colors[2]}
          />
        {/each}
      </div>
    </div>
  </div>
</div>
