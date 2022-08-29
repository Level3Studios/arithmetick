<script lang="ts">
  import { Router, Route } from "svelte-navigator";
  import CategoryPage from "./lib/pages/CategoryPage.svelte";
  import ConverterPage from "./lib/pages/ConverterPage.svelte";
  import HeaderBarPart from "./lib/parts/HeaderBarPart.svelte";
</script>

<Router>
  <HeaderBarPart />

  <main>
    <Route component={CategoryPage} />
    <Route path="converter" component={ConverterPage} />
  </main>
  <footer>
    <h6>Copyright 2022</h6>
  </footer>
</Router>
