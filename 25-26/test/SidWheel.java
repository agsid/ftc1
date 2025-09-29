adpackage org.firstinspires.ftc.teamcode;

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
            double accelerate = gamepad1.right_trigger;
            double brake = -gamepad1.left_trigger;

            double turn = gamepad1.left_stick_x;
            
            double right_strafe = gamepad1.right_bumper ? 1.0 : 0.0;
            double left_strafe = gamepad1.left_bumper ? -1.0 : 0.0;
            double strafe = right_strafe + left_strafe;

            double drive = accelerate - (brake*accelerate)
            double drive = Math.max(0.0, drive); 
            if (drive ==0 and gamepad1.left_trigger not pressed){
                   drive=0.1
            }

            drivetrain.setPower(drive,strafe,turn);

            telemetry.addData("LeftFront Power", drivetrain.getLeftFrontPower());
            telemetry.addData("LeftBack Power", drivetrain.getLeftBackPower());
            telemetry.addData("RightFront Power", drivetrain.getRightFrontPower());
            telemetry.addData("RightBack Power", drivetrain.getRightBackPower());
            telemetry.update();
        }
    }
}
