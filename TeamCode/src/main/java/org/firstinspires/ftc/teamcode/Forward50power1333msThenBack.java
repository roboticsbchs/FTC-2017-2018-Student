package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by cookja on 10/27/2017.
 */
@Autonomous(name="Forward Power50 Time1333ms Back Red", group="RIP2017bot")
//@Disabled
public class Forward50power1333msThenBack extends LinearOpMode {

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

        leftFrontDrive.setPower(-0.5);
        leftRearDrive.setPower(-0.5);
        rightFrontDrive.setPower(0.5);
        rightRearDrive.setPower(0.5);
        sleep(1333);

        leftFrontDrive.setPower(0.5);
        leftRearDrive.setPower(0.5);
        rightFrontDrive.setPower(-0.15);
        rightRearDrive.setPower(-0.15);
        sleep(750);

        leftFrontDrive.setPower(0);
        leftRearDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightRearDrive.setPower(0);
        idle();
    }
}