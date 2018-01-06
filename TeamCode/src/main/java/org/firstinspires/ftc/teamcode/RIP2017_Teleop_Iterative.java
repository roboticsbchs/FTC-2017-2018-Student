/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import static java.lang.Math.abs;
import static java.lang.Math.round;

/**
 * This file provides basic Telop driving for a Pushbot robot.
 * The code is structured as an Iterative OpMode
 *
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 *
 * This particular OpMode executes a basic Tank Drive Teleop for a PushBot
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

/**
 * This file provides basic Telop driving for a 2017-2018 Robots In Paradise robot.
 * The code is structured as an Iterative OpMode
 *
 * This OpMode uses the common HardwareRIP class to define the devices on the robot.
 * All device access is managed through the HardwareRIP class.
 *
 * This particular OpMode executes a basic Mecanum Wheel Drive Teleop for our robot.
 * It drives forward and reverse using the Gamepad1 Y sticks vertical axis respectively.
 * gamepad1.left_stick_y gamepad.right_stick_y
 * It drives left and right using the Gamepad1 X sticks horizontal axis respectively.
 * gamepad1.left_stick_x gamepad1.right_stick_x
 * It raises and lowers the claw using the Gamepad2 Y and A button respectively.
 * gamepad2.y gamepad2.a
 * It opens and closes the claws slowly using the Gamepad2 dpad_up and dpad_down repectively.
 * gamepad2.dpad_up gamepad2.dpad_down
 *
 */

@TeleOp(name="RIP2017bot: Teleop", group="RIP2017bot")
//@Disabled
public class RIP2017_Teleop_Iterative extends OpMode{

    /* Declare OpMode members. */
    HardwareRIP robot       = new HardwareRIP(); // used to define a robot's hardware
    // could also use HardwareRIPMatrix class.

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        double BLeftNS;
        double BRightTrig;
        double BLeftTrig;

        double frontLeft;
        double frontRight;
        double rearLeft;
        double rearRight;

        double x;
        double y;
        double z;

        x = -gamepad1.left_stick_y;
        y = gamepad1.left_stick_x;
        z = gamepad1.right_stick_x;

        if (abs(x) < 0.1)
        {
            x = 0;
        }
        if (abs(y) < 0.1)
        {
            y = 0;
        }
        if (abs(z) < 0.1)
        {
            z = 0;
        }

        frontLeft = (x + y + z)/3;
        frontRight = (x - y - z)/3;
        rearLeft   = (x - y + z)/3;
        rearRight  = (x + y - z)/3;

        robot.leftFrontDrive.setPower(frontLeft);
        robot.rightFrontDrive.setPower(frontRight);
        robot.leftRearDrive.setPower(rearLeft);
        robot.rightRearDrive.setPower(rearRight);


        // Use gamepad2 dpad to lift/lower the lift

        BLeftNS = -gamepad2.left_stick_y;
        if (abs(BLeftNS) > 0.05) {
            robot.verticalLift.setPower(BLeftNS);}
        else {
            robot.verticalLift.setPower(0);}

        // Use gamepad2 triggers to close the claw
        BRightTrig = (gamepad2.right_trigger);
        if (BRightTrig > 0.05) {
            robot.botrightClaw.setPosition(robot.botrightClaw.getPosition() - BRightTrig);
            robot.botleftClaw.setPosition(robot.botleftClaw.getPosition() + BRightTrig);}

        BLeftTrig = (gamepad2.left_trigger);
        if (BLeftTrig > 0.05) {
            robot.toprightClaw.setPosition(robot.toprightClaw.getPosition() - BLeftTrig);
            robot.topleftClaw.setPosition(robot.topleftClaw.getPosition() + BLeftTrig);}

        // Open claws to start position with gamepad 2 bumpers
        if (gamepad2.right_bumper) {
            robot.botrightClaw.setPosition(1.0);
            robot.botleftClaw.setPosition(0.0); }
        if (gamepad2.left_bumper) {
            robot.toprightClaw.setPosition(1.0);
            robot.topleftClaw.setPosition(0.0);}
            // Send telemetry message to signify robot running;
        /*
        telemetry.addData("claw",  "Offset = %.2f", clawOffset);
         */
        telemetry.addData("leftRear",  "%.2f", robot.leftRearDrive.getPower());
        telemetry.addData("rightRear", "%.2f", robot.rightRearDrive.getPower());
        telemetry.addData("leftFront",  "%.2f", robot.leftFrontDrive.getPower());
        telemetry.addData("rightFront", "%.2f", robot.rightFrontDrive.getPower());
        telemetry.addData("botleftclaw", "%.2f",robot.botleftClaw.getPosition());
        telemetry.addData("botrightclaw", "%.2f",robot.botrightClaw.getPosition());
        telemetry.addData("topleftclaw", "%.2f",robot.topleftClaw.getPosition());
        telemetry.addData("toprightclaw", "%.2f",robot.toprightClaw.getPosition());
        telemetry.addData("verticalLift", "%.2f",robot.verticalLift.getPower());
        telemetry.addData("slider", "%.2f",robot.slider.getPosition());
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}
