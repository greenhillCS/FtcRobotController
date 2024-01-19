package org.firstinspires.ftc.teamcode.Arm;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class fourBar {

    public void startPos(DcMotor barMotor){
        barMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        barMotor.setTargetPosition(0);
        barMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        barMotor.setPower(0.3);
    }
    public void wallPos(DcMotor barMotor){
        barMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        barMotor.setTargetPosition(2347);
        barMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        barMotor.setPower(0.3);
    }
    public void fullDown(DcMotor barMotor){
        barMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        barMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        barMotor.setPower(1.0f);
    }
    public void rest(DcMotor barMotor){
        barMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        barMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        barMotor.setPower(0);
    }
    public void forward(DcMotor barMotor){
        barMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        barMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        barMotor.setPower(1.0f);
    }
    public void back(DcMotor barMotor){
        barMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        barMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        barMotor.setPower(1.0f);
    }
}
