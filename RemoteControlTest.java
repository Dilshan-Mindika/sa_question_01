public class RemoteControlTest {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl(2);
        Light kitchenLight = new KitchenRoomLight();
        Light livingRoomLight = new LivingRoomLight();

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        LightDimCommand kitchenLightDim = new LightDimCommand(kitchenLight, 50);

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightDimCommand livingRoomLightDim = new LightDimCommand(livingRoomLight, 30);

        // Setting up commands for slots
        remoteControl.setCommand(0, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(1, livingRoomLightOn, livingRoomLightOff);

        remoteControl.onButtonWasPressed(0);    // Kitchen Room light is ON at full brightness.
        remoteControl.offButtonWasPressed(0);   // Kitchen Room light is OFF.
        remoteControl.undoButtonWasPressed();   // Kitchen Room light is ON at full brightness.
        remoteControl.onButtonWasPressed(1);    // Living Room light is ON at full brightness.
        remoteControl.offButtonWasPressed(1);   // Living Room light is OFF.
        remoteControl.undoButtonWasPressed();   // Living Room light is ON at full brightness.
        kitchenLightDim.execute();              // Kitchen Room light dimmed to 50%.
        kitchenLightDim.undo();                 // Kitchen Room light dimmed to 100%.
        livingRoomLightDim.execute();           // Living Room light dimmed to 30%.
        livingRoomLightDim.undo();              // Living Room light dimmed to 100%.
    }
}
