package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Basic: Omni Linear OpMode", group="Linear OpMode")
public class BasicOmniOpMode_Linear extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;
    private DcMotor linearSlideMotor = null;
    private DcMotor intakeMotor = null;// Include the name of your linear slide motor here
    private Servo servo = null;  // Change to SC
    private DcMotor actuatorMotor = null;

    // Constants for acceleration and maximum speed
    private static final double ACCELERATION = 0.03;
    private static final double MAX_SPEED = 0.78; // Adjust this value for your desired speed

    private double leftFrontPower = 0;
    private double rightFrontPower = 0;
    private double leftBackPower = 0;
    private double rightBackPower = 0;

    @Override
    public void runOpMode() {

        leftFrontDrive  = hardwareMap.get(DcMotor.class, "FL");
        leftBackDrive  = hardwareMap.get(DcMotor.class, "BL");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FR");
        rightBackDrive = hardwareMap.get(DcMotor.class, "BR");
        linearSlideMotor = hardwareMap.get(DcMotor.class, "SM");  // Replace "YourLinearSlideMotorName" with the actual name of your linear slide motor
        intakeMotor = hardwareMap.get(DcMotor.class, "IM");
        servo = hardwareMap.get(Servo.class, "SC");  // Change to "SC"
        actuatorMotor = hardwareMap.get(DcMotor.class, "AM");

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();


        SlideController slideController = new SlideController(linearSlideMotor, gamepad2);
        ServoControllerGH servoController = new ServoControllerGH(servo, gamepad2);
        Intake intakeSystem = new Intake();
        LinearActuator actuatorSystem = new LinearActuator();
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            double max;

            double axial   = -gamepad1.left_stick_y;
            double lateral =  gamepad1.left_stick_x;
            double yaw     =  gamepad1.right_stick_x;

            // Calculate the target powers for each wheel
            double targetLeftFrontPower  = axial + lateral + yaw;
            double targetRightFrontPower = axial - lateral - yaw;
            double targetLeftBackPower   = axial - lateral + yaw;
            double targetRightBackPower  = axial + lateral - yaw;

            // Apply acceleration to the wheel powers
            leftFrontPower = accelerate(leftFrontPower, targetLeftFrontPower, ACCELERATION);
            rightFrontPower = accelerate(rightFrontPower, targetRightFrontPower, ACCELERATION);
            leftBackPower = accelerate(leftBackPower, targetLeftBackPower, ACCELERATION);
            rightBackPower = accelerate(rightBackPower, targetRightBackPower, ACCELERATION);

            // Normalize the values so no wheel power exceeds 100%
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));

            if (max > 1.0) {
                leftFrontPower  /= max;
                rightFrontPower /= max;
                leftBackPower   /= max;
                rightBackPower  /= max;
            }

            // Set motor powers with the reduced and accelerated values
            leftFrontDrive.setPower(leftFrontPower * MAX_SPEED);
            rightFrontDrive.setPower(rightFrontPower * MAX_SPEED);
            leftBackDrive.setPower(leftBackPower * MAX_SPEED);
            rightBackDrive.setPower(rightBackPower * MAX_SPEED);

            slideController.update(); // Control the slide motor
            servoController.update();

            if (gamepad2.right_bumper){
                intakeSystem.forward(intakeMotor);
            }
            else if (gamepad2.left_bumper){
                intakeSystem.reverse(intakeMotor);
            }
            else{
                intakeSystem.stop(intakeMotor);
            }
            if (gamepad2.dpad_up){
                actuatorSystem.forward(actuatorMotor);
            }
            else if (gamepad2.dpad_down){
                actuatorSystem.reverse(actuatorMotor);
            }
            else{
                actuatorSystem.stop(actuatorMotor);
            }


            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.update();
        }
    }

    // Helper function to apply acceleration
    private double accelerate(double currentPower, double targetPower, double acceleration) {
        if (currentPower < targetPower) {
            return Math.min(currentPower + acceleration, targetPower);
        } else if (currentPower > targetPower) {
            return Math.max(currentPower - acceleration, targetPower);
        }
        return targetPower;
    }
}
