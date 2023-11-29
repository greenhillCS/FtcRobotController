package org.firstinspires.ftc.teamcode.Arm;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Sensors.GreenhillHardware;
@TeleOp(name = "Arm: Claw", group = "Claw")
public class testClawOpMode extends LinearOpMode {
    clawMove claw1;
    boolean button;
    @Override
    public void runOpMode(){
        claw1 = new clawMove(hardwareMap.servo.get(GreenhillHardware.LEFT_SERVO));

        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("Working", "True");
            if (gamepad1.a) {
                telemetry.addData("GamePad", "Pressed A");
                if (!claw1.isOpen) {
                    claw1.open();
                    telemetry.addData("Claw", "Is Open");
                    telemetry.addData("ClawOpenWorking", claw1.openWorking);
                }
            }
            else if (gamepad1.b){
                if (claw1.isOpen){
                    claw1.close();
                    telemetry.addData("Claw", "Is Closed");
                    telemetry.addData("ClawCloseWorking", claw1.closeWorking);
                }
            }
            telemetry.update();
        }
    }
}
