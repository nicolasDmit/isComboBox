# isComboBox Add-on for Vaadin 7

IsComboBox is a UI component add-on for Vaadin 7.

### Importing project

Choose File > Import... > Existing Maven Projects

Note that Eclipse may give "Plugin execution not covered by lifecycle configuration" errors for pom.xml. Use "Permanently mark goal resources in pom.xml as ignored in Eclipse build" quick-fix to mark these errors as permanently ignored in your project. Do not worry, the project still works fine. 

### Debugging server-side

If you have not already compiled the widgetset, do it now by running vaadin:install Maven target for isComboBox-root project.

If you have a JRebel license, it makes on the fly code changes faster. Just add JRebel nature to your isComboBox-demo project by clicking project with right mouse button and choosing JRebel > Add JRebel Nature

To debug project and make code modifications on the fly in the server-side, right-click the isComboBox-demo project and choose Debug As > Debug on Server. Navigate to http://localhost:8080/isComboBox-demo/ to see the application.

### Debugging client-side

Debugging client side code in the isComboBox-demo project:
  - run "mvn vaadin:run-codeserver" on a separate console while the application is running
  - activate Super Dev Mode in the debug window of the application or by adding ?superdevmode to the URL
  - You can access Java-sources and set breakpoints inside Chrome if you enable source maps from inspector settings.

## License & Author

Add-on is distributed under MIT License.


