package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "DcMotors")
public class DcMotors extends LinearOpMode {

  private DcMotor leftHorizSlide;
  private DcMotor leftSlide;
  private DcMotor rightSlide;
  private DcMotor left_back;
  private DcMotor left_front;
  private DcMotor right_back;
  private DcMotor right_front;

  /**
   * This code runs the horozontal Slides
   */
  @Override
  public void runOpMode() {
    leftHorizSlide = hardwareMap.get(DcMotor.class, "leftHorizSlide");
    leftSlide = hardwareMap.get(DcMotor.class, "leftSlide");
    rightSlide = hardwareMap.get(DcMotor.class, "rightSlide");
    left_back = hardwareMap.get(DcMotor.class, "left_back");
    left_front = hardwareMap.get(DcMotor.class, "left_front");
    right_back = hardwareMap.get(DcMotor.class, "right_back");
    right_front = hardwareMap.get(DcMotor.class, "right_front");

    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        Code();
      }
    }
  }

  /**
   * Describe this function...
   */
  private void Code() {
    double slidepwr;
    float wheelpwrside;
    float wheelpwr;
    float frontwheelpwr;
    double leftSlide2;

    leftHorizSlide.setDirection(DcMotor.Direction.REVERSE);
    leftSlide.setDirection(DcMotor.Direction.REVERSE);
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        leftSlide2 = gamepad1.left_stick_y * 0.6;
        rightSlide.setPower(leftSlide2);
        leftSlide.setPower(leftSlide2);
        telemetry.addLine("Veritcle Slides");
        telemetry.addData("Target Power", gamepad1.left_stick_y * 0.6);
        telemetry.addData("Current Power", slidepwr);
        slidepwr = gamepad1.right_stick_y * 0.6;
        leftHorizSlide.setPower(slidepwr);
        leftHorizSlide.setPower(slidepwr);
        telemetry.addLine("Horozontal Slides");
        telemetry.addData("Target Power", gamepad1.right_stick_y * 0.6);
        telemetry.addData("Current Power", slidepwr);
        // Left/Right COde
        left_back.setDirection(DcMotor.Direction.FORWARD);
        left_front.setDirection(DcMotor.Direction.FORWARD);
        right_back.setDirection(DcMotor.Direction.FORWARD);
        right_front.setDirection(DcMotor.Direction.FORWARD);
        wheelpwrside = gamepad1.left_stick_x;
        left_back.setPower(wheelpwrside);
        left_front.setPower(wheelpwrside);
        right_front.setPower(wheelpwrside);
        right_back.setPower(wheelpwrside);
        telemetry.addLine("Left/Right");
        telemetry.addData("Target Power", gamepad1.left_stick_x);
        telemetry.addData("Current Power", wheelpwrside);
        left_back.setDirection(DcMotor.Direction.FORWARD);
        left_front.setDirection(DcMotor.Direction.FORWARD);
        right_back.setDirection(DcMotor.Direction.REVERSE);
        right_front.setDirection(DcMotor.Direction.REVERSE);
        wheelpwr = gamepad1.left_trigger;
        left_back.setPower(wheelpwr);
        left_front.setPower(wheelpwr);
        right_front.setPower(wheelpwr);
        right_back.setPower(wheelpwr);
        telemetry.addLine("Back");
        telemetry.addData("Target Power", gamepad1.left_trigger);
        telemetry.addData("Current Power", wheelpwrside);
        left_back.setDirection(DcMotor.Direction.FORWARD);
        left_front.setDirection(DcMotor.Direction.FORWARD);
        right_back.setDirection(DcMotor.Direction.REVERSE);
        right_front.setDirection(DcMotor.Direction.REVERSE);
        frontwheelpwr = gamepad1.right_trigger * -1;
        left_back.setPower(frontwheelpwr * 0.75);
        left_front.setPower(frontwheelpwr * 0.75);
        right_front.setPower(frontwheelpwr * 0.75);
        right_back.setPower(frontwheelpwr * 0.75);
        telemetry.addLine("Front");
        telemetry.addData("Target Power", gamepad1.right_trigger);
        telemetry.addData("Current Power", frontwheelpwr);
        telemetry.update();
      }
    }
  }
}
