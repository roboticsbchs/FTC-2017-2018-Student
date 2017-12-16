package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by cookja on 10/27/2017.
 */
@Autonomous(name="Forward Power50 Time1333ms", group="RIP2017bot")
//@Disabled
public class Forward50power1333ms extends LinearOpMode {

    DcMotor leftFrontDrive;
    DcMotor rightFrontDrive;
    DcMotor leftRearDrive;
    DcMotor rightRearDrive;

    Servo botRightClaw;
    Servo botLeftClaw;

    DcMotor verticalLift;

    @Override
    public void runOpMode() throws InterruptedException {

        leftFrontDrive = hardwareMap.dcMotor.get("left_Front_drive");
        rightFrontDrive = hardwareMap.dcMotor.get("right_Front_drive");
        leftRearDrive = hardwareMap.dcMotor.get("left_Rear_drive");
        rightRearDrive = hardwareMap.dcMotor.get("right_Rear_drive");
        verticalLift    = hardwareMap.dcMotor.get("vertical_Lift");

        botRightClaw = hardwareMap.servo.get("bot_right_hand");
        botLeftClaw = hardwareMap.servo.get("bot_right_hand");

        HardwareRIP robot = new HardwareRIP();

        waitForStart();

        botLeftClaw.setPosition(1.0);
        botRightClaw.setPosition(0.0);
        verticalLift.setPower(0.5);
        sleep(500);
        verticalLift.setPower(0.0);

        leftFrontDrive.setPower(-0.5);
        leftRearDrive.setPower(-0.5);
        rightFrontDrive.setPower(0.5);
        rightRearDrive.setPower(0.5);
        sleep(1000);

        leftFrontDrive.setPower(-0.222);
        leftRearDrive.setPower(-0.222);
        rightFrontDrive.setPower(-0.222);
        rightRearDrive.setPower(-0.222);
        sleep(2000);

        botLeftClaw.setPosition(0.0);
        botRightClaw.setPosition(1.0);
        leftFrontDrive.setPower(-0.3);
        leftRearDrive.setPower(-0.3);
        rightFrontDrive.setPower(0.3);
        rightRearDrive.setPower(0.3);
        sleep(500);

        leftFrontDrive.setPower(0);
        leftRearDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightRearDrive.setPower(0);
        idle();
    }
}