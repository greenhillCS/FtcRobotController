package org.firstinspires.ftc.teamcode.Arm;

import com.qualcomm.robotcore.hardware.Servo;

import java.util.Timer;

public class clawMove {
    public boolean isOpen = true;
    private Servo clawservo;
    private double openDeg = 0;
    private double closeDeg = 1;
    private double clawPos;
    private long timeSince = 500;
    public boolean openWorking;
    public boolean closeWorking;
    private Timer time = new Timer();
    public clawMove(Servo s){this.clawservo = s;}
    public void open(){
        clawservo.setPosition(openDeg);
        isOpen = true;
    }
    public void close(){
        clawservo.setPosition(closeDeg);
        isOpen = false;
    }
    public void toggle(){
        // get now()
        // compare to timeSince
        if (timeSince - System.currentTimeMillis() >= 0.500){
            timeSince = System.currentTimeMillis();

            if (isOpen){
                openWorking = true;
                open();
            }
            else{
                closeWorking = true;
                close();
            }

        }
        else{
            timeSince = System.currentTimeMillis();
        }
    }
}
