package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class VerticalSlide {

    private final DcMotor leftSlideMotor;  // The left DcMotor  for the vertical slide
    private final DcMotor rightSlideMotor; // The right DcMotor  for the vertical slide

    private static final double SLIDE_HOLDING_POWER = -0.15;
    public VerticalSlide(HardwareMap hmap, String leftMotorName, String rightMotorName) {

        leftSlideMotor = hmap.get(DcMotor.class, leftMotorName);
        rightSlideMotor = hmap.get(DcMotor.class, rightMotorName);





    }
    public void init() {
        leftSlideMotor.setTargetPosition(0);
        rightSlideMotor.setTargetPosition(0);
        leftSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftSlideMotor.setDirection(DcMotor.Direction.REVERSE);
        rightSlideMotor.setDirection(DcMotor.Direction.FORWARD);
    }
    public void changeTargetPosition(int delta){
        int newPos = getCurrentPosition() + delta;
        int max = 2000;
        if (newPos >= max){
            setTargetPosition(max);
        }
        else if (newPos < 0){
            setTargetPosition(0);
        }
        else {
            setTargetPosition(newPos);
        }
    }

    public void setTargetPosition(int target){
        leftSlideMotor.setTargetPosition(target);
        rightSlideMotor.setTargetPosition(target);
    }
    public int getCurrentPosition(){
        return leftSlideMotor.getCurrentPosition();
    }

    public void setPower(double power) {
        leftSlideMotor.setPower(power);
        rightSlideMotor.setPower(power);
    }


    public void holdPosition() {
        setPower(SLIDE_HOLDING_POWER);
    }

}
