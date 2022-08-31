<script>
  //core
  import { selectedUnit } from "../helpers/store";
  //exports
  export let unitId = 0;
  export let unitName = "Label";
  export let unitValue = 1000;
  export let unitColor = "bg-red-500";
  export let unitHoverColor = "hover:bg-red-700";
  //store
  function didSelectUnit(value) {
    selectedUnit.set(value);
  }
</script>

<div class="w-full lg:w-6/12 xl:w-3/12 px-4 xl:pt-4">
  <div
    class="card flex flex-col min-w-0 break-words bg-white mb-6 xl:mb-0 shadow-lg"
  >
    <div class="flex-auto p-4">
      <div class="flex flex-wrap">
        <div class="card-body relative w-full pr-4 max-w-full flex-grow flex-1">
          <h5 class="card-title text-slate-400 uppercase font-bold text-sm">
            {unitName}
          </h5>
          <span class="font-semibold text-xl text-slate-700">
            {unitValue}
          </span>
          <div class="card-actions justify-end">
            <button
              on:click={() => didSelectUnit(unitId)}
              class="btn btn-sm gap-2 outline-none border-none border-transparent text-white {unitColor} {unitHoverColor} "
            >
              Switch
              <i class="fas fa-repeat text-white" />
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
