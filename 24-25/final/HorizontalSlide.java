package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * HorizontalSlide class provides encapsulated control for a single horizontal slide motor.
 */
public class HorizontalSlide {

    private DcMotor horizontalMotor; // The DcMotor instance for the horizontal slide

    /**
     * Constructor for the HorizontalSlide.
     * @param hmap The hardware map from the OpMode.
     * @param motorName The name of the horizontal slide motor in the hardware map configuration.
     */
    public HorizontalSlide(HardwareMap hmap, String motorName) {
        // Initialize the motor from the hardware map
        horizontalMotor = hmap.get(DcMotor.class, motorName);
        // Set the direction for the motor (adjust if your physical motor runs opposite)
        horizontalMotor.setDirection(DcMotor.Direction.FORWARD);

    }


    public void setPower(double power) {
        horizontalMotor.setPower(power);
    }

    public void stop() {
        horizontalMotor.setPower(0);
    }


    public double getCurrentPower() {
        return horizontalMotor.getPower();
    }
}
