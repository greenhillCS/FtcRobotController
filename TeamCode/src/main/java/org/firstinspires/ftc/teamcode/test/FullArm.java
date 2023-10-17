package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Sensors.GreenhillHardware;
@TeleOp(name = "Arm: Full Arm", group = "Full Arm")
public class FullArm extends LinearOpMode {
    Servo elbow1;
    Servo wrist1;
    Servo claw1;
    boolean button;

    public void ElbowFunction(){
        if (gamepad1.right_stick_y != 0) {
            elbow1.setPosition(elbow1.getPosition()+gamepad1.right_stick_y/1000);

            telemetry.addData("Elbow", "Moving");
        }else{
            telemetry.addData("Elbow", "NOt moving");
        }
        telemetry.update();
    }
    public void WristFunction(){
        if (gamepad1.left_stick_x != 0) {
            wrist1.setPosition(wrist1.getPosition()+gamepad1.left_stick_x/1000);

            telemetry.addData("Wrist", "Moving");
        }else{
            telemetry.addData("Wrist", "not moving");
        }
        telemetry.update();
    }
    public void ThumbFunction(){
        telemetry.addData("Working", "True");
        if (gamepad1.dpad_up) {
            telemetry.addData("GamePad", "Pressed A");
            claw1.setPosition(0);
            telemetry.addData("Claw", "Is Open");
            }
        if (gamepad1.dpad_down){
            claw1.setPosition(1);
            telemetry.addData("Claw", "Is Closed");
        }
    }


    @Override
    public void runOpMode(){
        elbow1 = hardwareMap.servo.get(GreenhillHardware.ELBOW_SERVO);
        wrist1 = hardwareMap.servo.get(GreenhillHardware.WRIST_SERVO);
        claw1  = hardwareMap.servo.get(GreenhillHardware.LEFT_SERVO);

        waitForStart();
        while(opModeIsActive()){
            ElbowFunction();
            WristFunction();
            ThumbFunction();

        }

    }
}
