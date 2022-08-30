<script lang="ts">
  //core
  import { selectedCategory, selectedUnit, inputValue } from "../helpers/store";
  import type { ConverterOption } from "../models/CategoryItemModel";
  import { allCategoryCards } from "../models/CategoryItemModel";
  import { Amount } from "uom";
  import { get } from "svelte/store";
  const selectedCategoryId = get(selectedCategory);
  var selectedUnitId = get(selectedUnit);

  //local
  const categoryCard = allCategoryCards.find(
    (value) => value.id == selectedCategoryId
  );
  var selectedOption: ConverterOption;
  var currentUnit: Amount.Amount<any>;

  function setup() {
    selectedOption = categoryCard.converterOptions.find(
      (value) => value.id == selectedUnitId
    );
    currentUnit = Amount.create(0, selectedOption.unit);
  }
  //store
  selectedUnit.subscribe((value) => {
    selectedUnitId = value;
    setup();
  });

  function enteredValue(input) {
    inputValue.set(input);
  }
</script>

<div
  class="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded-lg bg-gray-100 border-0"
>
  <div class="rounded-t bg-white mb-0 px-6 py-6">
    <div class="text-center flex justify-between">
      <h6 class="text-level3blue-700 text-xl font-bold">
        {categoryCard.title} Converter
      </h6>
    </div>
  </div>
  <div class="form-control flex-auto px-4 lg:px-10 py-10 pt-0">
    <form>
      <h6 class="text-slate-400 text-sm mt-3 mb-6 font-bold uppercase">
        Conversions will auto calculate
      </h6>
      <div class="flex flex-wrap">
        <div class="w-full lg:w-6/12 px-4">
          <div class="relative w-full mb-3">
            <label
              class="label uppercase text-slate-600 font-bold text-xs"
              for="converter-input"
            >
              <span class="label-text">{currentUnit.unit.name}</span>
            </label>
            <input
              id="converter-input"
              type="number"
              placeholder="0"
              class="input input-bordered w-full bg-white text-slate-600"
              on:input={(e) => enteredValue(e.target.value)}
            />
          </div>
        </div>
      </div>
    </form>
  </div>
</div>
