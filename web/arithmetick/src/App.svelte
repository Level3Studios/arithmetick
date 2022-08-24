<script lang="ts">
  import { Router, Route, Link } from "svelte-navigator";
</script>

<Router>
  <header>
    <h1>Arithmetick</h1>
    <nav>
      <Link to="/">Home</Link>
      <Link to="converter">Converter</Link>
    </nav>
  </header>

  <main>
    <Route path="/">
      <h3>Category Page</h3>
    </Route>

    <Route path="converter">
      <h3>Converter View</h3>
    </Route>
  </main>
  <footer>
    <h6>Copyright 2022</h6>
  </footer>
</Router>
