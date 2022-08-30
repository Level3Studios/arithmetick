<script>
  //core
  import RoundButtonPiece from "../pieces/RoundButtonPiece.svelte";
  import FooterLinkPiece from "../pieces/FooterLinkPiece.svelte";
  import FooterListHeaderPiece from "../pieces/FooterListHeaderPiece.svelte";
  import FooterCopyrightPiece from "../pieces/FooterCopyrightPiece.svelte";
</script>

<footer class="relative bg-level3blue-200 pt-8 pb-6">
  <div
    class="bottom-auto top-0 left-0 right-0 w-full absolute pointer-events-none overflow-hidden -mt-20 h-20"
    style="transform: translateZ(0);"
  >
    <svg
      class="absolute bottom-0 overflow-hidden"
      xmlns="http://www.w3.org/2000/svg"
      preserveAspectRatio="none"
      version="1.1"
      viewBox="0 0 2560 100"
      x="0"
      y="0"
    >
      <polygon
        class="text-level3blue-200 fill-current"
        points="2560 0 2560 100 0 100"
      />
    </svg>
  </div>
  <div class="container mx-auto px-4">
    <div class="flex flex-wrap text-center lg:text-left">
      <div class="w-full lg:w-6/12 px-4">
        <h4 class="text-slate-600 text-3xl font-semibold">
          Made with a modern stack
        </h4>
        <h5 class="text-lg mt-0 mb-2 text-slate-500">
          Find out more about the primary frameworks used in this web app.
        </h5>
        <div class="mt-6 lg:mb-0 mb-6">
          <RoundButtonPiece
            textColor="text-purple-600"
            icon="fas fa-bolt"
            link="https://vitejs.dev/"
          />
          <RoundButtonPiece
            textColor="text-red-400"
            icon="fas fa-brain"
            link="https://svelte.dev/"
          />
          <RoundButtonPiece
            textColor="text-cyan-500"
            icon="fas fa-wind"
            link="https://tailwindcss.com/"
          />
          <RoundButtonPiece
            textColor="text-blue-600"
            icon="fas fa-scroll"
            link="https://www.typescriptlang.org/"
          />
        </div>
      </div>
      <div class="w-full lg:w-6/12 px-4">
        <div class="flex flex-wrap items-top mb-6">
          <div class="w-full lg:w-4/12 px-4 ml-auto">
            <FooterListHeaderPiece title="JS Frameworks" />
            <ul class="list-unstyled">
              <FooterLinkPiece
                text="uom"
                link="https://github.com/dividab/uom"
              />
              <FooterLinkPiece
                text="reliable-round"
                link="https://github.com/codeandcats/reliable-round"
              />
            </ul>
          </div>
          <div class="w-full lg:w-4/12 px-4">
            <FooterListHeaderPiece title="UI Frameworks" />
            <ul class="list-unstyled">
              <FooterLinkPiece
                text="Notus Svelte"
                link="https://www.creative-tim.com/product/notus-svelte"
              />
              <FooterLinkPiece text="DaisyUI" link="https://daisyui.com" />
              <FooterLinkPiece
                text="Font Awesome"
                link="https://fontawesome.com/"
              />
            </ul>
          </div>
        </div>
      </div>
    </div>
    <hr class="my-6 border-slate-200" />
    <FooterCopyrightPiece />
  </div>
</footer>
