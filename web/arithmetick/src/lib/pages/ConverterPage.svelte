<script>
  //scroll to top on load
  import { onMount } from "svelte";
  onMount(() => {
    window.scrollTo(0, 0);
  });
  //core
  import ConverterInputPart from "../parts/ConverterInputPart.svelte";
  import ConvertedListPart from "../parts/ConvertedListPart.svelte";
</script>

<section>
  <div class="elative w-full h-full py-20 min-h-screen bg-gray-100">
    <ConverterInputPart />
    <ConvertedListPart />
  </div>
</section>
