<script>
  import ConvertedListPart from "../parts/ConvertedListPart.svelte";
  import ConverterInputPart from "../parts/ConverterInputPart.svelte";
  //scroll to top on load
  import { onMount } from "svelte";
  onMount(() => {
    window.scrollTo(0, 0);
  });
</script>

<section>
  <div class="relative w-full h-full py-20 min-h-screen bg-gray-100">
    <ConverterInputPart />
    <ConvertedListPart />
  </div>
</section>
