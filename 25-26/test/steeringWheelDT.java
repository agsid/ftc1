package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap; // Keep HardwareMap import if other classes in package use it

public class Drivetrain {

    private DcMotor left_back;
    private DcMotor left_front;
    private DcMotor right_back;
    private DcMotor right_front;

    // Modified constructor to accept DcMotor objects directly
    public Drivetrain(DcMotor lfMotor, DcMotor lbMotor, DcMotor rfMotor, DcMotor rbMotor) {
        this.left_front = lfMotor;
        this.left_back = lbMotor;
        this.right_front = rfMotor;
        this.right_back = rbMotor;

        left_back.setDirection(DcMotor.Direction.REVERSE);
        left_front.setDirection(DcMotor.Direction.REVERSE);
        right_back.setDirection(DcMotor.Direction.FORWARD);
        right_front.setDirection(DcMotor.Direction.FORWARD);

        left_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setPower(double drive, double strafe, double turn) {
        double leftFrontPower = drive + turn + strafe;
        double leftBackPower = drive + turn - strafe;
        double rightFrontPower = drive - turn - strafe;
        double rightBackPower = drive - turn + strafe;

        left_front.setPower(leftFrontPower);
        left_back.setPower(leftBackPower);
        right_front.setPower(rightFrontPower);
        right_back.setPower(rightBackPower);
    }

    public double getLeftFrontPower() {
        return left_front.getPower();
    }

    public double getLeftBackPower() {
        return left_back.getPower();
    }

    public double getRightFrontPower() {
        return right_front.getPower();
    }

    public double getRightBackPower() {
        return right_back.getPower();
    }
}
