package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class FrontGrabber {
    private Servo frontGrabberServo;
    private double grabberClosePosition;
    private double grabberOpenPosition;
    private boolean isGrabberClosed;


    public FrontGrabber(HardwareMap hardwareMap, String servoName, double closePosition, double openPosition) {
        this.frontGrabberServo = hardwareMap.servo.get(servoName);
        this.grabberClosePosition = closePosition;
        this.grabberOpenPosition = openPosition;
        // Initialize the grabber to a closed state by default
        closeGrabber();
    }


    public void closeGrabber() {
        frontGrabberServo.setPosition(grabberClosePosition);
        isGrabberClosed = true;
    }


    public void openGrabber() {
        frontGrabberServo.setPosition(grabberOpenPosition);
        isGrabberClosed = false;
    }


    public boolean isGrabberClosed() {
        return isGrabberClosed;
    }
}