package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Zach on 12/14/2017.
 */

@Autonomous (name="Color Test", group="RIP2017bot")
//@Disabled
public class RIP2017_Color_Test extends LinearOpMode {

    ColorSensor colorSensor;

    @Override
    public void runOpMode() {

        colorSensor = hardwareMap.colorSensor.get("sensor_color");

        waitForStart();

        colorSensor.enableLed(true);

        telemetry.addData("red", colorSensor.red());
        telemetry.addData("blue", colorSensor.blue());
        telemetry.addData("green", colorSensor.green());
        telemetry.addData("alpha", colorSensor.alpha());
        telemetry.addData("argb", colorSensor.argb());

        sleep(10000);

        colorSensor.enableLed(false);

        idle();
    }
}