package org.firstinspires.ftc.teamcode.Arm;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Arm.Intake;
import org.firstinspires.ftc.teamcode.Sensors.GreenhillHardware;

@TeleOp(name = "Encoder Display", group = "Slides")
public class EncoderDisplay extends LinearOpMode {
    private DcMotor displayedMotor;
    @Override
    public void runOpMode(){
        displayedMotor  = hardwareMap.get(DcMotor.class, "SM");

        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("Position:", displayedMotor.getCurrentPosition());
            telemetry.update();
        }
    }
}