package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * FrontGrabber class encapsulates the functionality of the front grabber servo.
 * It manages the servo's open/close positions and its current state.
 */
public class FrontGrabber {
    private Servo frontGrabberServo;
    private double grabberClosePosition;
    private double grabberOpenPosition;
    private boolean isGrabberClosed;

    /**
     * Constructor for the FrontGrabber class.
     * Initializes the servo with the given hardware map and sets its open/close positions.
     *
     * @param hardwareMap The hardware map from the LinearOpMode.
     * @param servoName The name of the servo in the hardware map (e.g., "frontGrabberServo").
     * @param closePosition The servo position when the grabber is closed.
     * @param openPosition The servo position when the grabber is open.
     */
    public FrontGrabber(HardwareMap hardwareMap, String servoName, double closePosition, double openPosition) {
        this.frontGrabberServo = hardwareMap.servo.get(servoName);
        this.grabberClosePosition = closePosition;
        this.grabberOpenPosition = openPosition;
        // Initialize the grabber to a closed state by default
        closeGrabber();
    }

    /**
     * Closes the grabber by setting the servo to the predefined close position.
     */
    public void closeGrabber() {
        frontGrabberServo.setPosition(grabberClosePosition);
        isGrabberClosed = true;
    }

    /**
     * Opens the grabber by setting the servo to the predefined open position.
     */
    public void openGrabber() {
        frontGrabberServo.setPosition(grabberOpenPosition);
        isGrabberClosed = false;
    }

    /**
     * Checks if the grabber is currently in the closed state.
     *
     * @return true if the grabber is closed, false otherwise.
     */
    public boolean isGrabberClosed() {
        return isGrabberClosed;
    }
}
