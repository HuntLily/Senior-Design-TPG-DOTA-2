# Setup from Source

1. Clone the git repository
2. Open a terminal window and cd into the cloned repository
3. Ensure that `gradlew.bat` has execute permissions
4. Run `gradlew shadowjar`
5. Start the application with `java -jar build\libs\server-1.0-SNAPSHOT-all.jar -conf conf.json`


Note: You must have Java JDK 8 to build the server. If you have multiple versions of java installed, it is possible that gradle won't use the right one. To fix this use the following command to specify the jdk to use when building:

`gradlew shadowjar -Dorg.gradle.java.home=/JDK_PATH`

# Run with Addon Source files

Once setup, launch dota 2 with workshop tools enabled.

1. Select `Breezy_Addon` as the addon to launch
2. Open vConsole
3. Use the following command to launch a custom game with the bot interface:
    `dota_launch_custom_game Breezy_Addon dota`
	
Ensure that your conf.json file has the following value set:

`"workshop_addon_id": "Breezy_Addon"`

You should now notice feature vectors arriving at the Breezy Server if you inspect its console window.

Navigate to: http://localhost:8085 to access the UI.

Note: It is important that the sever runs on port 8085. While the conf.json file allows you to change this, the front end ui has (as of October 30 2019) hardcoded links to http://localhost:8085. Removing these to allow for more customizability is on the todo list.

# Run with Steam Workshop Addon 

Navigate to:

https://steamcommunity.com/sharedfiles/filedetails/?id=1976046474

Click subscribe and wait for the addon to download.

Ensure that your conf.json file has the following value set:

`"workshop_addon_id": "1976046474"`

Start the server using the command `java -jar build\libs\server-1.0-SNAPSHOT-all.jar -conf conf.json`

Start a run through the an http POST request to http://localhost/run/ as described in the swagger file below:
https://app.swaggerhub.com/apis-docs/aianta/dota2-connector/0.0.1

Your agent should conform to the following interface:
https://app.swaggerhub.com/apis-docs/aianta/dota2-agent/0.0.1

