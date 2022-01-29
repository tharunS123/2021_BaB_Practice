package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

public class CIMshoot extends SubsystemBase {
    private static CIMshoot instance = null;

    // T.SBab: public getInstance
    public static CIMshoot getInstance(){
        if (instance == null){
            instance = new CIMshoot();
        }
        return instance;
    }

    // T.SBab: getting it in RobotMap.
    private static final TalonSRX CIMMotor = new TalonSRX(RobotMap.MOTOR_TALON_ONE);

    public CIMshoot(){
        CIMMotor.setNeutralMode(NeutralMode.Brake);
    }

    // T.SBab: setting speed
    public void setSpeed(double speed){
        CIMMotor.set(ControlMode.PercentOutput, speed);
    }
}
