<script>
  //core
  import SeoPiece from "../pieces/SEOPiece.svelte";
  import LogoButtonPiece from "../pieces/LogoButtonPiece.svelte";
  //local
  let navbarOpen = false;
  function toggleNavbar() {
    navbarOpen = !navbarOpen;
  }
</script>

<SeoPiece />
<nav
  class="top-0 fixed z-50 w-full flex flex-wrap items-center justify-between px-2 py-3 navbar-expand-lg bg-white shadow"
>
  <div
    class="container px-4 mx-auto flex flex-wrap items-center justify-between"
  >
    <div
      class="w-full relative flex justify-between lg:w-auto lg:static lg:block lg:justify-start"
    >
      <LogoButtonPiece />
      <button
        class="text-slate-500 cursor-pointer text-xl leading-none px-3 py-1 border-transparent rounded bg-transparent block lg:hidden outline-none focus:outline-none"
        type="button"
        on:click={toggleNavbar}
      >
        <i class="fas fa-bars" />
      </button>
    </div>
    <div
      class="lg:flex flex-grow items-center {navbarOpen ? 'block' : 'hidden'}"
      id="example-navbar-warning"
    >
      <ul class="flex flex-col lg:flex-row list-none lg:ml-auto">
        <li class="flex items-center">
          <a
            href="https://github.com/Level3Studios/arithmetick"
            target="_blank"
            rel="noopener noreferrer"
          >
            <button
              class="btn btn-sm bg-level3yellow-600 hover:bg-level3yellow-800 text-white py-2 border-0 text-xs lg:mr-1 lg:mb-0 ml-3 mb-3 "
            >
              <i class="fa-brands fa-github px-2" /> Download
            </button>
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>
