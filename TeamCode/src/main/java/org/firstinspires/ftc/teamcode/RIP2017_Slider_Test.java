package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Zach on 10/24/2017.
 */
@Autonomous(name="Slider Test", group="RIP2017bot")
//@Disabled
public class RIP2017_Slider_Test extends LinearOpMode {

    Servo slider;
    Servo topleftClaw;
    Servo toprightClaw;
    Servo botleftClaw;
    Servo botrightClaw;

    public void runOpMode() throws InterruptedException {

        slider = hardwareMap.servo.get("slider_gear");
        topleftClaw = hardwareMap.servo.get("top_left_hand");
        toprightClaw = hardwareMap.servo.get("top_right_hand");
        botleftClaw = hardwareMap.servo.get("bot_left_hand");
        botrightClaw = hardwareMap.servo.get("bot_right_hand");

        waitForStart();

        topleftClaw.setPosition(1.0);
        toprightClaw.setPosition(0.0);
        botleftClaw.setPosition(0.0);
        botrightClaw.setPosition(1.0);

        slider.setPosition(-1);
        sleep(1500);
        slider.setPosition(0);
        sleep(3000);
        slider.setPosition(1);
        sleep(1750);
        slider.setPosition(0);

        idle();
    }
}
