package org.firstinspires.ftc.teamcode.Arm;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Sensors.GreenhillHardware;

@TeleOp(name = "IntakeTest", group = "Intake")
public class intakeOpMode extends LinearOpMode {
    Intake intakeSystem = new Intake();
    DcMotor intakeMotor;
    @Override
    public void runOpMode(){
        intakeMotor = hardwareMap.dcMotor.get(GreenhillHardware.INTAKE_MOTOR);

        waitForStart();
        while(opModeIsActive()){
            if (gamepad1.right_bumper){
                intakeSystem.forward(intakeMotor);
            }
            else if (gamepad1.left_bumper){
                intakeSystem.reverse(intakeMotor);
            }
            else{
                intakeSystem.stop(intakeMotor);
            }
        }
    }
}
