<script>
  //core
  import { selectedCategory, selectedUnit, inputValue } from "../store";
  //exports
  export let id = 0;
  export let bgColor = "bg-red-500";
  export let activeColor = "active:bg-red-800";
  export let hoverColor = "hover:bg-red-800";
  export let icon = "fas fa-circle-question";
  export let text = "Card Name";
  //store
  /**
   * @param {number} value
   */
  function didSelectOption(value) {
    selectedCategory.set(value);
    selectedUnit.set(0);
    inputValue.set(0);
  }
</script>

<a href="/converter" on:click={() => didSelectOption(id)}>
  <div
    class="{bgColor} {activeColor} {hoverColor} shadow-lg card items-center text-center p-8 mt-8"
  >
    <div class="card-body">
      <i class="{icon} fa-2xl text-white" />
      <p class="card-title text-lg text-white mt-4 font-semibold">{text}</p>
    </div>
  </div>
</a>
