<script>
  //core
  import CategoryCard from "../pieces/CategoryCardPiece.svelte";
  import { allCategoryCards } from "../models/CategoryItemModel";
  //local
  let leftOptions = allCategoryCards.slice(0, 3);
  let rightOptions = allCategoryCards.slice(3, 6);
</script>

<section class=" pb-40 relative w-full bg-gray-100">
  <div class="container mx-auto overflow-hidden pb-20">
    <div class="flex flex-wrap items-center ">
      <div class="w-full md:w-4/12 px-12 md:px-4 ml-auto mr-auto mt-48">
        <div
          class="text-level3blue-500 p-3 text-center inline-flex items-center justify-center w-16 h-16 mb-6 shadow-lg rounded-full bg-white"
        >
          <i class="fas fa-calculator text-2xl" />
        </div>
        <h3 class="text-3xl text-slate-600 mb-2 font-semibold leading-normal">
          Unit Converter
        </h3>
        <p
          class="text-lg font-light leading-relaxed mt-4 mb-4 text-level3blue-600"
        >
          Select a category to get started.
        </p>
      </div>
      <div class="w-full md:w-6/12 px-4 mr-auto ml-auto mt-32">
        <div class="justify-center flex flex-wrap relative">
          <div class="my-4 w-full lg:w-6/12 px-4">
            {#each leftOptions as categoryOption}
              <CategoryCard
                id={categoryOption.id}
                text={categoryOption.title}
                bgColor={categoryOption.colors[0]}
                activeColor={categoryOption.colors[1]}
                icon={categoryOption.icon}
              />
            {/each}
          </div>
          <div class="my-4 w-full lg:w-6/12 px-4 lg:mt-16">
            {#each rightOptions as categoryOption}
              <CategoryCard
                id={categoryOption.id}
                text={categoryOption.title}
                bgColor={categoryOption.colors[0]}
                activeColor={categoryOption.colors[1]}
                icon={categoryOption.icon}
              />
            {/each}
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
