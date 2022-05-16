<script>
  //exports
  export let link = "";
  export let text = "Link Text";
</script>

<li>
  <a
    class="text-slate-500 hover:text-slate-800 font-semibold block pb-2 text-sm"
    href={link}
    target="_blank"
    rel="noopener noreferrer"
  >
    {text}
  </a>
</li>
