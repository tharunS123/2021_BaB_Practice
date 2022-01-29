package team.gif.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class LimitSwitch extends SubsystemBase {
    private static LimitSwitch Instance = null;

    public static  LimitSwitch getInstance(){
        if (Instance == null){
            Instance = new LimitSwitch();
        }
        return Instance;
    }

    public DigitalInput _limilswitch = new DigitalInput(RobotMap.DEVICE_ID);

    public boolean getLimitSwitch(){
        return !_limilswitch.get();
    }
}
