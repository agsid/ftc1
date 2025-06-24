package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Tutorial")
public class Main extends LinearOpMode {

private DcMotor leftHorizSlide;
public void runOpMode() {
    leftHorizSlide = hardwareMap.get(DcMotor.class, "leftHorizSlide");

    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        Code();//this is a funtion
      }
    }
  }
  
  public void Code(){//funtion Code
  //define varibles
  float slidepwr;
  if (opModeIsActive()) {//saying if the code has started then do following
      while (opModeIsActive()) {// this si saying while the code is on do the following
      //gamepad controls
   	   slidepwr = gamepad1.left_stick_y;
      //motor commands
       leftHorizSlide.setDirection(DcMotor.Direction.REVERSE);
       leftHorizSlide.setPower(slidepwr);//0 through 1
       
      //Telemetry commands
      telemetry.addLine("Left Horizontal Slide");
      telemetry.addData("Slide Power", slidepwr);
      telemetry.update();
 
  
  
  
			}
		}
	}
}