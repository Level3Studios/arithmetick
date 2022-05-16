<script lang="ts">
  import page from "page";

  import CategoryPage from "./lib/pages/CategoryPage.svelte";
  import ConverterPage from "./lib/pages/ConverterPage.svelte";

  import HeaderBar from "./lib/parts/HeaderBarPart.svelte";
  import FooterBar from "./lib/parts/FooterBarPart.svelte";

  //Nav setup
  let current = CategoryPage;
  page("/", () => (current = CategoryPage));
  page("/converter", () => (current = ConverterPage));
  page.start();
</script>

<HeaderBar />
<main>
  <svelte:component this={current} />
</main>
<FooterBar />
