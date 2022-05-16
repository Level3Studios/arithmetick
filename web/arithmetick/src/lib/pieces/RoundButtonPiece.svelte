<script>
  //exports
  export let textColor = "text-cyan-500";
  export let icon = "fab fa-twitter";
  export let link = "";
</script>

<a href={link} target="_blank" rel="noopener noreferrer">
  <button
    class="bg-white {textColor} shadow-lg font-normal h-10 w-10 items-center justify-center align-center rounded-full outline-none focus:outline-none mr-2"
    type="button"
  >
    <i class={icon} />
  </button>
</a>
