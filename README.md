# KixsPrettierExplosions
Stunning realistic tnt &amp; explosion visuals. A visual overhaul to explosions with respect for fps, lag, and protection plugins.

Lets face it; vanilla Minecraft explosions are anticlimactic and pretty lackluster. This plugin adds a pretty explosion visual to tnt, creepers, exploding beds, and more that launches the blocks away from the explosion and then smashes them to bits when the land. Drops remain the same and the explosions themselves are not modified

[Showcase video of explosions](https://www.youtube.com/watch?v=rlUwBiCRnag)

## Compatibility
* Spigot, Paper, & CraftBukkit on versions **1.8.x - 1.16.x** (other server types may work but are not directly supported)
* Java 8 or newer

## Features
* **Plug and play**; just drop the plugin into your server, no need to spend time configuring things if you don't want to
* **Ultra customizable**; choose which types of explosions are affected, set a world whitelist/blacklist (or affect all worlds), and more
* **Mindful of lag**; the plugins visuals will cap themselves to prevent fps and server lag with from big explosions
* **Respects protection plugins**; the actual explosions remain up to your server to handle, the plugin just creates the pretty visuals. If another plugin blocks the explosion, KPE won't create any visuals


## Commands & Permissions
- **/prettierexplosions** (pe): base command for the plugin, shows version
- **/pe reload**: reload & update changes to the config file [permission: *prettierexplosions.reload*]


## Config
```yaml
prettify:
  tnt-explosions: true
  bed-explosions: true
  creeper-explosions: true
  other-explosions: true

visual-cap-in-blocks: 185

extra-visuals: true

list-type: whitelist
world-list:
  - "world"
  - "world_nether"
  - "world_the_end"
```

## Download
https://www.spigotmc.org/resources/92653/

## Compile
Requires Java 8 & Maven
```
1. git clone https://github.com/kixmc/KixsPrettierExplosions
2. mvn package
```
Compiled jar will be in the /target directory

## Support
If you have any questions, suggestions, or just want to say hi you can join my Discord server here: https://discord.com/invite/HKnDTRj

