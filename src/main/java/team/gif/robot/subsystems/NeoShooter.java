package team.gif.robot.subsystems;

import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANPIDController;

public class NeoShooter extends SubsystemBase {
    private static NeoShooter instance = null;

    // T.SBab Creating a getInstance for runNeoShooterVoltage.java
    public static NeoShooter getInstance() {
        if (instance == null) {
            instance = new NeoShooter();
        }
        return instance;
    }

    // T.SBab
    private static final CANSparkMax shooterMotor = new CANSparkMax(RobotMap.MOTOR_SPARKMAX_ONE, CANSparkMaxLowLevel.MotorType.kBrushless);
    private static final CANPIDController shooterPIDController = shooterMotor.getPIDController();

    // T.SBab public the setVoltage
    public void setVoltage(double voltage) {
        shooterMotor.setVoltage(voltage);
    }

    private NeoShooter(){
        super();
        shooterPIDController.setP(0.0004); //0.00007
        shooterPIDController.setFF(0.00028); // 0.00175
        shooterMotor.setSmartCurrentLimit(40,40);
    }

    public void setRPM(double setPoint){
        shooterPIDController.setReference(setPoint, ControlType.kVelocity);
    }
    public double getRPM(){
        return shooterMotor.getEncoder().getVelocity();
    }
}
