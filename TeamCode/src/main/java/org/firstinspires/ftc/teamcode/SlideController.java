package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class SlideController {
    private DcMotor slideMotor;
    private Gamepad gamepad;

    private static final double SLIDE_SPEED = 0.5; // Adjust this value for the desired slide speed

    public SlideController(DcMotor slideMotor, Gamepad gamepad) {
        this.slideMotor = slideMotor;
        this.gamepad = gamepad;
    }

    public void update() {
        double slidePower = 0;

        if (gamepad.right_trigger > 0) {
            // Move the linear slide up at the specified speed
            slidePower = SLIDE_SPEED;
        } else if (gamepad.left_trigger > 0) {
            // Move the linear slide down at the specified speed
            slidePower = -SLIDE_SPEED;
        }
        
        if (gamepad.dpad_left) {
            slidePower = 2 * -SLIDE_SPEED;
        }

        slideMotor.setPower(slidePower);
    }
}
