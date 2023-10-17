package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Sensors.GreenhillHardware;
@TeleOp(name = "Arm: Wrist", group = "Wrist")
public class WristMove extends LinearOpMode {
    Servo wrist1;
    boolean button;
    @Override
    public void runOpMode(){
        wrist1 = hardwareMap.servo.get(GreenhillHardware.WRIST_SERVO);

        waitForStart();
        while(opModeIsActive()){
            if (gamepad1.left_stick_x != 0) {
                wrist1.setPosition(wrist1.getPosition()+gamepad1.left_stick_x);

                telemetry.addData("Wrist", "Moving");
            }else{
                    telemetry.addData("Wrist", "not moving");
            }
            telemetry.update();
        }

    }
}
