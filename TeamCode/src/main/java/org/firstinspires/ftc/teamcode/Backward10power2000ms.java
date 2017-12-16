package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by cookja on 10/27/2017.
 */
@Autonomous(name="Backward Power50 Time2000ms", group="RIP2017bot")
@Disabled
public class Backward10power2000ms extends LinearOpMode {

    DcMotor leftFrontDrive;
    DcMotor rightFrontDrive;
    DcMotor leftRearDrive;
    DcMotor rightRearDrive;

    @Override
    public void runOpMode() throws InterruptedException {

        leftFrontDrive = hardwareMap.dcMotor.get("left_Front_drive");
        rightFrontDrive = hardwareMap.dcMotor.get("right_Front_drive");
        leftRearDrive = hardwareMap.dcMotor.get("left_Rear_drive");
        rightRearDrive = hardwareMap.dcMotor.get("right_Rear_drive");

        HardwareRIP robot = new HardwareRIP();

        waitForStart();

        leftFrontDrive.setPower(0.5);
        leftRearDrive.setPower(0.5);
        rightFrontDrive.setPower(-0.5);
        rightRearDrive.setPower(-0.5);
        sleep(2000);

        leftFrontDrive.setPower(0);
        leftRearDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightRearDrive.setPower(0);
        idle();
    }
}