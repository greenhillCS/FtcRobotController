package org.firstinspires.ftc.teamcode.Arm;

import com.qualcomm.robotcore.hardware.Servo;

public class pixelRelease {
    public void open(Servo pixelServo){
        pixelServo.setPosition(0);
    }
    public void close(Servo pixelServo){
        pixelServo.setPosition(1);
    }
}
