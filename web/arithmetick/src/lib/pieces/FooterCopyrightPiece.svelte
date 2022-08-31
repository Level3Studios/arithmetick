<script>
  //local
  let currentDate = new Date().getFullYear();
  let releaseDate = new Date("2022-09-01").getFullYear();
  var date = `${currentDate}`;
  if (releaseDate < currentDate) {
    date = `${releaseDate} - ${currentDate}`;
  }
</script>

<div class="flex flex-wrap items-center md:justify-between justify-center">
  <div class="w-full md:w-4/12 px-4 mx-auto text-center">
    <div class="text-sm text-slate-500 font-semibold py-1">
      Copyright © {date} Arithmetick by
      <a
        href="https://level3studios.net/"
        class="text-slate-500 hover:text-slate-800 hover:underline"
        target="_blank"
        rel="noopener noreferrer"
      >
        Level 3 Studios
      </a>
      .
    </div>
  </div>
</div>
