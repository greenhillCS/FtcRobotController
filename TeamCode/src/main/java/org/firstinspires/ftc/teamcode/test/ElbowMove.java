package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Sensors.GreenhillHardware;
@TeleOp(name = "Arm: Elbow", group = "Elbow")
public class ElbowMove extends LinearOpMode {
    Servo elbow1;
    boolean button;
    @Override
    public void runOpMode(){
        elbow1 = hardwareMap.servo.get(GreenhillHardware.ELBOW_SERVO);

        waitForStart();
        while(opModeIsActive()){
            if (gamepad1.right_stick_y != 0) {
                elbow1.setPosition(elbow1.getPosition()+gamepad1.right_stick_y/1000);

                telemetry.addData("Elbow", "Moving");
            }else{
                telemetry.addData("Elbow", "NOt moving");
            }
            telemetry.update();

        }

    }
}
