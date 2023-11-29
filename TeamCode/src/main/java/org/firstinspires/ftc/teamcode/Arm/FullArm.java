package org.firstinspires.ftc.teamcode.Arm;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Sensors.GreenhillHardware;

@TeleOp(name = "Arm:Full", group = "Arm")
public class FullArm extends LinearOpMode{
    Servo elbow1;
    Servo wrist1;
    Servo claw1;
    DcMotor shoulder1;
    boolean button;

    private void ElbowFunction(double stickPos){
        if (stickPos != 0) {
            elbow1.setPosition(elbow1.getPosition()+stickPos/1000);
        }
    }
    private void WristFunction(double stickPos){
        if (stickPos != 0) {
            wrist1.setPosition(wrist1.getPosition()+stickPos/1000);
        }
    }
    private void ThumbOpen(){
        claw1.setPosition(0);
    }
    private void ThumbClose(){
        claw1.setPosition(1);
    }
    private void ShoulderA(){
        shoulder1.setTargetPosition(0);
        shoulder1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        shoulder1.setPower(1.0f);
    }
    private void ShoulderB(){
        shoulder1.setTargetPosition(45);
        shoulder1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        shoulder1.setPower(1.0f);
    }

    @Override
    public void runOpMode(){
        elbow1 = hardwareMap.servo.get(GreenhillHardware.ELBOW_SERVO);
        wrist1 = hardwareMap.servo.get(GreenhillHardware.WRIST_SERVO);
        claw1  = hardwareMap.servo.get(GreenhillHardware.LEFT_SERVO);
        shoulder1 = hardwareMap.dcMotor.get(GreenhillHardware.SHOULDER_MOTOR);
        shoulder1.setDirection(DcMotor.Direction.FORWARD);

        shoulder1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        shoulder1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shoulder1.setTargetPosition(0);
        // Turn On RUN_TO_POSITION
        shoulder1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        shoulder1.setPower(1.0f);

        waitForStart();
        while(opModeIsActive()) {
            ElbowFunction(gamepad1.left_stick_x);
            WristFunction(gamepad1.right_stick_x);
            if (gamepad1.dpad_up) {
                ThumbOpen();
            }
            if (gamepad1.dpad_down){
                ThumbClose();
            }
            if (gamepad1.a){
                ShoulderA();
            }
            if (gamepad1.b){
                ShoulderB();
            }

            telemetry.update();
        }
    }
}
