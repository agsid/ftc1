package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "SidWheel Peak", group = "Linear OpMode")
public class SidWheel extends LinearOpMode {

    private Drivetrain drivetrain;
    @Override
    public void runOpMode() {
        DcMotor lfMotor = hardwareMap.get(DcMotor.class, "left_front");
        DcMotor lbMotor = hardwareMap.get(DcMotor.class, "left_back");
        DcMotor rfMotor = hardwareMap.get(DcMotor.class, "right_front");
        DcMotor rbMotor = hardwareMap.get(DcMotor.class, "right_back");
        telemetry.addData("Status", "Robot Ready");
        telemetry.update();

        drivetrain = new Drivetrain(lfMotor, lbMotor, rfMotor, rbMotor);
        waitForStart();

        while (opModeIsActive()) {
            double drive = -gamepad1.right_trigger;
            double right_strafe = gamepad1.right_bumper ? 1.0 : 0.0;
            double left_strafe = gamepad1.left_bumper ? -1.0 : 0.0;
            double turn = gamepad1.left_stick_x;
            double strafe = right_strafe + left_strafe;

            drivetrain.setPower(drive,strafe,turn);

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
