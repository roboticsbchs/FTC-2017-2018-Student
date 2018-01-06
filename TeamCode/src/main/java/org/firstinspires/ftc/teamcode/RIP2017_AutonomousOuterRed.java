package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by cookja on 10/27/2017.
 */
@Autonomous(name="Autonomous Outer Red", group="RIP2017bot")
//@Disabled
public class RIP2017_AutonomousOuterRed extends LinearOpMode {

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
        botLeftClaw = hardwareMap.servo.get("bot_left_hand");

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

        leftFrontDrive.setPower(-0.3);
        leftRearDrive.setPower(-0.3);
        rightFrontDrive.setPower(-0.3);
        rightRearDrive.setPower(-0.3);
        sleep(1500);

        botLeftClaw.setPosition(0.0);
        botRightClaw.setPosition(1.0);
        leftFrontDrive.setPower(-0.30);
        leftRearDrive.setPower(-0.30);
        rightFrontDrive.setPower(0.30);
        rightRearDrive.setPower(0.30);
        sleep(600);

        leftFrontDrive.setPower(0.25);
        leftRearDrive.setPower(0.25);
        rightFrontDrive.setPower(-0.25);
        rightRearDrive.setPower(-0.25);
        sleep(150);

        leftFrontDrive.setPower(0);
        leftRearDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightRearDrive.setPower(0);
        idle();
    }
}