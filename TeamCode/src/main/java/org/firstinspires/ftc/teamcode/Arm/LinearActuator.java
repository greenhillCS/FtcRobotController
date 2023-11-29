package org.firstinspires.ftc.teamcode.Arm;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class LinearActuator {
    public void forward(DcMotor actuatorMotor){
        actuatorMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        actuatorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        actuatorMotor.setPower(1.0f);
    }
    public void stop(DcMotor actuatorMotor){
        actuatorMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        actuatorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        actuatorMotor.setPower(0);
    }
    public void reverse(DcMotor actuatorMotor){
        actuatorMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        actuatorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        actuatorMotor.setPower(1.0f);
    }
}
