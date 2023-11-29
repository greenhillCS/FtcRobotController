package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;

public class ServoControllerGH {
    private Servo servo;
    private Gamepad gamepad;
    //private boolean isServoAt1 = false;

    public ServoControllerGH(Servo servo, Gamepad gamepad) {
        this.servo = servo;
        this.gamepad = gamepad;
        initializeServo(); // Initialize the servo position to 0
    }

    public void update() {
        if (gamepad.a) {
            servo.setPosition(.5); // Move to position 1.0 when "A" is pressed
            //isServoAt1 = true;
        } else if (gamepad.b) {
            servo.setPosition(0); // Move back to position 0.5 when "B" is pressed
            //isServoAt1 = false;
        } else if (gamepad.y) {
            servo.setPosition(0.7);
            //isServoAt1 = false;
        }
    }

    public void initializeServo() {
        servo.setPosition(1); // Initialize the servo position to 0.0
        //isServoAt1 = false;
    }
}
