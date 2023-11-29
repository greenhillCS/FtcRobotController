package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Sensors.GreenhillHardware;
@TeleOp(name = "Intake: Test", group = "Intake")
public class ContinuousServo extends LinearOpMode {
    Servo intakeServo1;
    Servo intakeServo2;

    public void runOpMode(){
        intakeServo1 = hardwareMap.servo.get(GreenhillHardware.INTAKE_MOTOR);
        intakeServo2 = hardwareMap.servo.get(GreenhillHardware.ELBOW_SERVO);

        waitForStart();

        while (opModeIsActive()){
            intakeServo1.setPosition(0);
            intakeServo2.setPosition(1);
        }
    }
}
