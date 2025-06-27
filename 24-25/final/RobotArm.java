package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotArm {
    private Servo armServo;
    private Servo wristServo;
    private Position currentArmPosition;


    public enum Position {
        GRAB_FROM_WALL(0.75, 0.5),
        HANG_PREP(0, 0.3),
        HANG_SPECIMEN(0, 0.4);

        private double armPosition;
        private double wristPosition;

        Position(double armPosition, double wristPosition) {
            this.armPosition = armPosition;
            this.wristPosition = wristPosition;
        }

        public double getArmPosition() {
            return armPosition;
        }

        public double getWristPosition() {
            return wristPosition;
        }
    }

    /**
     Constructor for the RobotArm class.
     Initializes the arm and wrist servos.

     */
    public RobotArm(HardwareMap hmap) {
        armServo = hmap.servo.get("frontArmServo");
        wristServo = hmap.servo.get("wristServo");
        armServo.setDirection(Servo.Direction.REVERSE);
        setArmToPreset(Position.GRAB_FROM_WALL); // Set initial arm position
    }


    public void setArmToPreset(Position position) {
        setArmServoPosition(position.getArmPosition());
        setWristServoPosition(position.getWristPosition());
        currentArmPosition = position;
    }
    public Position getArmPreset() {
        return currentArmPosition;
    }

    public void setArmServoPosition(double position) {
        if (position >= 0 && position <= 1) {
            armServo.setPosition(position);
        }
    }


    public void setWristServoPosition(double position) {
        if (position >= 0 && position <= 1) {
            wristServo.setPosition(position);
        }
    }


    private int getIndexOfPreset(Position preset) {
        for (int i = 0; i < Position.values().length; i++) {
            if (Position.values()[i] == preset) return i;
        }
        return -1;
    }

    public void incrementArmPreset(int amount) {
        int currentPresetIndex = getIndexOfPreset(currentArmPosition);
        if (currentPresetIndex == -1) return;
        int newIndex = currentPresetIndex + amount;
        if (newIndex < 0) {
            newIndex = 0;
        } else if (newIndex >= Position.values().length) {
            newIndex = Position.values().length - 1; // Prevent going above the last preset
        }

        Position newPreset = Position.values()[newIndex];
        setArmToPreset(newPreset);
    }



    public String getArmTelemetry() {
        return String.format("Arm/Wrist: %s", getArmPreset());
    }
}