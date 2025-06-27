package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Peak Sidcode", group = "Linear OpMode")
public class SidCode extends LinearOpMode {

    private Drivetrain drivetrain;
    private HorizontalSlide horizontalSlide;
    private VerticalSlide verticalSlide;
    private FrontGrabber frontGrabber;
    private RobotArm robotArm;
    @Override
    public void runOpMode() {
        DcMotor lfMotor = hardwareMap.get(DcMotor.class, "left_front");
        DcMotor lbMotor = hardwareMap.get(DcMotor.class, "left_back");
        DcMotor rfMotor = hardwareMap.get(DcMotor.class, "right_front");
        DcMotor rbMotor = hardwareMap.get(DcMotor.class, "right_back");
        telemetry.addData("Status", "Robot Ready");
        telemetry.update();

        // Initialize the Drivetrain instance by passing the individual DcMotor objects
        drivetrain = new Drivetrain(lfMotor, lbMotor, rfMotor, rbMotor);
        horizontalSlide = new HorizontalSlide(hardwareMap, "leftHorizSlide");
        verticalSlide = new VerticalSlide(hardwareMap, "leftSlide", "rightSlide");
        verticalSlide.init();
        frontGrabber = new FrontGrabber(hardwareMap, "frontGrabberServo", 0.70, 1.0);
        robotArm = new RobotArm(hardwareMap);


        waitForStart();

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            drivetrain.setPower(drive, strafe, turn);

            if (gamepad1.dpad_right) {
                horizontalSlide.setPower(0.5);

            } else if (gamepad1.dpad_left) {
                horizontalSlide.setPower(-0.5);
                gamepad1.rumble(0.2, 0.2, 50);
            } else {
                horizontalSlide.stop();
                gamepad1.rumble(0, 0, 0);
            }

           if (gamepad1.dpad_up) {
                verticalSlide.changeTargetPosition(-20);
            } else if (gamepad1.dpad_down) {
                verticalSlide.changeTargetPosition(20);
            } else {
                verticalSlide.holdPosition();
            }

            if (gamepad1.a) {
                if (frontGrabber.isGrabberClosed()) {
                    frontGrabber.openGrabber();
                } else {
                    frontGrabber.closeGrabber();
                }
                sleep(250);
            }

            if (gamepad1.right_trigger > 0.1) {
                robotArm.setArmToPreset(RobotArm.Position.HANG_SPECIMEN);
                gamepad1.rumble(0.2, 0.2, 50);
                sleep(200);
            } else if (gamepad1.left_trigger > 0.1) {
                robotArm.setArmToPreset(RobotArm.Position.GRAB_FROM_WALL);
                gamepad1.rumble(0.2, 0.2, 50);
                sleep(200);
            }

            if (gamepad1.y) {
                robotArm.setArmToPreset(RobotArm.Position.HANG_PREP);
                sleep(200);
            }

            telemetry.addData("LeftFront Power", drivetrain.getLeftFrontPower());
            telemetry.addData("LeftBack Power", drivetrain.getLeftBackPower());
            telemetry.addData("RightFront Power", drivetrain.getRightFrontPower());
            telemetry.addData("RightBack Power", drivetrain.getRightBackPower());
            telemetry.addData("Horizontal Slide Power", horizontalSlide.getCurrentPower());
            telemetry.addLine(frontGrabber.isGrabberClosed() ? "Grabber: CLOSED" : "Grabber: OPEN");
            telemetry.addLine(robotArm.getArmTelemetry());
            telemetry.update();
        }
    }
}
